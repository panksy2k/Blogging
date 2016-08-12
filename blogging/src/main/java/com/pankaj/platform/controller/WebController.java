package com.pankaj.platform.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by pankajpardasani on 27/07/2016.
 */
@Controller
public class WebController {

    private static Logger logger = LoggerFactory.getLogger(WebController.class);

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String home() {
        return "home";
    }
}
