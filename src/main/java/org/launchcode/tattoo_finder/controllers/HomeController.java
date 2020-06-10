package org.launchcode.tattoo_finder.controllers;

import org.launchcode.tattoo_finder.models.Artist;
import org.launchcode.tattoo_finder.models.ArtistInfo;
import org.launchcode.tattoo_finder.models.data.ArtistRepository;
import org.launchcode.tattoo_finder.models.data.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

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
                model.addAttribute("title", "All Jobs");
            } else {
                artists = ArtistInfo.findByColumnAndValue(column, value, artistRepository.findAll());
                model.addAttribute("title", "Jobs with " + columnChoices.get(column) + ": " + value);
            }
            model.addAttribute("artists", artists);

            return "index-artists";
        }
}
