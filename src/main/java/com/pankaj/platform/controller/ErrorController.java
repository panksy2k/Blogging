package com.pankaj.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by pardasap on 07/10/2016.
 */
@Controller
public class ErrorController {

    @RequestMapping(value="/error", params={"access"}, method = RequestMethod.GET)
    public String getErrorPageForAccessDenial(ModelMap modelMap) {
        modelMap.addAttribute("title", "Access Denied")
                .addAttribute("error", "Access is denied to the service")
                .addAttribute("status", "401")
                .addAttribute("message", "You do not have enough permissions to access the service. Please contact admin pankaj.d.p@gmail.com for more details!");

        return "error";
    }
}
