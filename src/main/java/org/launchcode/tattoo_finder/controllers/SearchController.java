package org.launchcode.tattoo_finder.controllers;

import org.launchcode.tattoo_finder.models.Artist;
import org.launchcode.tattoo_finder.models.ArtistInfo;
import org.launchcode.tattoo_finder.models.User;
import org.launchcode.tattoo_finder.models.data.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.launchcode.tattoo_finder.controllers.HomeController.columnChoices;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    AuthenticationController authenticationController;

    @RequestMapping("")
    public String search(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        model.addAttribute("role", user.getRole());
        model.addAttribute("isLoggedIn", (user != null));

        model.addAttribute("columns", columnChoices);
        return "search";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
        Iterable<Artist> artists;
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
            artists = artistRepository.findAll();
        } else {
            artists = ArtistInfo.findByColumnAndValue(searchType, searchTerm, artistRepository.findAll());
        }
        model.addAttribute("columns", columnChoices);
        model.addAttribute("title", "Tattoo Artists Searched by " + columnChoices.get(searchType) + ": " + searchTerm);
        model.addAttribute("artists", artists);

        return "search";
    }
}
