package org.launchcode.tattoo_finder.controllers;

import org.launchcode.tattoo_finder.models.Artist;
import org.launchcode.tattoo_finder.models.ArtistInfo;
import org.launchcode.tattoo_finder.models.data.ArtistRepository;
import org.launchcode.tattoo_finder.models.data.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Optional;

@Controller
public class HomeController {

        @Autowired
        private ArtistRepository artistRepository;

        @Autowired
        private StyleRepository styleRepository;


        static HashMap<String, String> columnChoices = new HashMap<>();

        public HomeController() {

            columnChoices.put("all", "All Artists");
            columnChoices.put("name", "Name");
            columnChoices.put("style", "Style");
            columnChoices.put("location", "Location");

        }

        @RequestMapping("")
        public String list(Model model) {

            model.addAttribute("artists", artistRepository.findAll());
            model.addAttribute("styles", styleRepository.findAll());

            return "index";
        }

        @RequestMapping(value = "artists")
        public String listArtistsByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
            Iterable<Artist> artists;
            if (column.toLowerCase().equals("all")){
                artists = artistRepository.findAll();
                model.addAttribute("title", "All Artists");
            } else {
                artists = ArtistInfo.findByColumnAndValue(column, value, artistRepository.findAll());
                model.addAttribute("title", "Artists with " + columnChoices.get(column) + ": " + value);
            }
            model.addAttribute("artists", artists);

            return "list-artists";
        }

    @GetMapping("add")
    public String displayAddArtistForm(Model model) {
        model.addAttribute(new Artist());
        model.addAttribute("styles", styleRepository.findAll());
        return "add";
    }

    @PostMapping("add")
    public String processAddArtistForm(@ModelAttribute @Valid Artist newArtist,
                                    Errors errors) {

        if (errors.hasErrors()) {
            return "add";
        }

        artistRepository.save(newArtist);
        return "redirect:";
    }

    @GetMapping("view/{artistId}")
    public String displayViewArtist(Model model, @PathVariable int artistId) {

        Optional optArtist = artistRepository.findById(artistId);
        if (!optArtist.isEmpty()) {
            Artist artist = (Artist) optArtist.get();
            model.addAttribute("artist", artist);
            return "view";
        } else {
            return "redirect:/";
        }
    }
}
