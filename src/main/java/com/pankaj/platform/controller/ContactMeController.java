package com.pankaj.platform.controller;

import com.pankaj.platform.domain.ContactMe;
import com.pankaj.platform.service.ContactService;
import com.pankaj.platform.validation.ContactmeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

import static com.pankaj.platform.dto.APIOptions.APIOptionsBuilder;

/**
 * Created by pankajpardasani on 21/08/2016.
 */

@Controller
@SessionAttributes(types = ContactMe.class)
public class ContactMeController {

    @Autowired
    private ContactService contactService;


    @RequestMapping(value = "/contact/form", method = RequestMethod.GET)
    public String initCreationForm(Model model) {
        ContactMe contact = new ContactMe();
        model.addAttribute("contact", contact);
        model.addAttribute("freeze", false);

        return "contactMe";
    }

    @RequestMapping(value = "/contact/form", method = RequestMethod.POST)
    public String doGatherContactDetails(@Valid ContactMe contact, BindingResult result, ModelMap model, SessionStatus status) {

        if (result.hasErrors()) {
            model.addAttribute("contact", contact);
            model.addAttribute("freeze", false);
            return "contactMe";
        }
        else {
            contactService.accountContactDetails(new APIOptionsBuilder().withContactDetails(contact).build());
            status.setComplete();
            model.addAttribute("freeze", true).addAttribute("submitMessage", String.format("Thanks %s for getting in touch with me. I shall get back to you very soon!", contact.getFullName()));

            return "contactMe";
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.initDirectFieldAccess();
        binder.setValidator(new ContactmeValidator());
    }
}
