package org.launchcode.tattoo_finder.controllers;

import org.launchcode.tattoo_finder.models.Style;
import org.launchcode.tattoo_finder.models.data.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("styles")
public class StyleController {

    @Autowired
    StyleRepository styleRepository;

    @GetMapping
    public String displayAllStyles(Model model) {
        model.addAttribute("styles", styleRepository.findAll());
        return "styles/index";
    }


    @GetMapping("add")
    public String displayAddStyleForm(Model model) {
        model.addAttribute(new Style());
        return "styles/add";
    }

    @PostMapping("add")
    public String processAddStyleForm(@ModelAttribute @Valid Style newStyle,
                                      Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "styles/add";
        }
        styleRepository.save(newStyle);
        return "redirect:";
    }

    @GetMapping("view/{styleId}")
    public String displayViewStyle(Model model, @PathVariable int styleId) {

        Optional optSkill = styleRepository.findById(styleId);
        if (optSkill.isPresent()) {
            Style style = (Style) optSkill.get();
            model.addAttribute("style", style);
            return "styles/view";
        }
        else {
            return "redirect:../";
        }
    }
}
