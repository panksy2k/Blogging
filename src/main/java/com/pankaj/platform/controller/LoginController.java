package com.pankaj.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by pankajpardasani on 14/08/2016.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String handleLogin(@RequestParam String userName, @RequestParam String password, RedirectAttributes redirect) {
        try {
            checkForUserCredentials(userName, password);
            return "redirect:/index.html";
        }
        catch(Exception e) {
            redirect.addFlashAttribute("exception", e);
            return "redirect:/login";
        }
    }

    private void checkForUserCredentials(String userName, String password) {
        if(userName.equals("pankaj") && !password.equals("pankaj")) throw new RuntimeException("Invalid credentials");
    }
}
