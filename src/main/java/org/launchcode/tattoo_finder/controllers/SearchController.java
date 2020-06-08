package org.launchcode.tattoo_finder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchController {


    @RequestMapping("search")
    public String search(Model model) {
        return "search";
    }
}
