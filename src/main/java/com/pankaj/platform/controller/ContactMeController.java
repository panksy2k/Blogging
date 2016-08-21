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

    @RequestMapping(value = "/contact.html", method = RequestMethod.GET)
    public ModelAndView showContactMe() {
        return new ModelAndView("/contactMe", "contact", new ContactMe());
    }

    @RequestMapping(value = "/contact/submit", method = RequestMethod.POST)
    public String doGatherContactDetails(@ModelAttribute ContactMe contact, BindingResult result, ModelMap model) {
        /*if(result.hasErrors()) {
            return "error";
        }*/

        System.out.println(contact.getFullName());

        model.addAttribute("message", String.format("Thanks %s for getting the details across to me. I shall get back to you at the earliest", contact.getFullName()));
        return "messageAccepted";
    }
}
