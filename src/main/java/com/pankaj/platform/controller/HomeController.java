package com.pankaj.platform.controller;

import com.pankaj.platform.domain.ContactMe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by pankajpardasani on 10/09/2016.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHomePage(Model model) {
        model.addAttribute("contact", new ContactMe());
        return "index";
    }
}
