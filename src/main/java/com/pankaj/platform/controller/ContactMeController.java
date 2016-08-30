package com.pankaj.platform.controller;

import com.pankaj.platform.domain.ContactMe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by pankajpardasani on 21/08/2016.
 */

@Controller
public class ContactMeController {
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public ModelAndView showContactMe() {
        return new ModelAndView("/home", "contact", new ContactMe());
    }

    @RequestMapping(value = "/contact/submit", method = RequestMethod.POST)
    public String doGatherContactDetails(@ModelAttribute ContactMe contact, BindingResult result, ModelMap model) {
        if(result.hasErrors()) {
            return "error";
        }

        model.addAttribute("submitMessage", String.format("Thanks %s for getting the details across to me and I shall get back to you at the earliest!", contact.getFullName()));
        model.addAttribute("contact", contact);

        return "/home";
    }
}
