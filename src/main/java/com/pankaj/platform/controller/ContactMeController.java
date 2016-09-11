package com.pankaj.platform.controller;

import com.pankaj.platform.domain.ContactMe;
import com.pankaj.platform.exception.BloggingBusinessException;
import com.pankaj.platform.service.ContactService;
import com.pankaj.platform.validation.ContactmeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

import static com.pankaj.platform.dto.APIOptions.APIOptionsBuilder;

/**
 * Created by pankajpardasani on 21/08/2016.
 */

@Controller
public class ContactMeController {
    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/contact/form", method = RequestMethod.GET)
    @ModelAttribute
    public ModelAndView register() {
        return new ModelAndView("contactMe", "contact", new ContactMe());
    }

    @RequestMapping(value = "/contact/submit", method = {RequestMethod.POST, RequestMethod.PUT})
    public String doGatherContactDetails(@ModelAttribute @Valid ContactMe contact, BindingResult result, ModelMap model) {
        model.addAttribute("contact", contact);

        if(result.hasErrors()) {
            return "contactMe";
        }

        try {
            contactService.accountContactDetails(new APIOptionsBuilder().withContactDetails(contact).build());
        }
        catch(BloggingBusinessException e) {
            model.addAttribute("submitMessage", "Due to some technical error, could not save your information!");
            return "/home";
        }

        model.addAttribute("submitMessage", String.format("Thanks %s for getting the details across to me and I shall get back to you at the earliest!", contact.getFullName()));
        return "contactMe";
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.initDirectFieldAccess();
        binder.setValidator(new ContactmeValidator());
    }
}
