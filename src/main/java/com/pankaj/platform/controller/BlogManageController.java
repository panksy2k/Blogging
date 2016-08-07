package com.pankaj.platform.controller;

import com.pankaj.platform.domain.Blog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pankajpardasani on 17/07/2016.
 */
@Controller
@RequestMapping("/blog")
public class BlogManageController {
    @RequestMapping(value = "/form")
    public ModelAndView createBlogPage() {
        return new ModelAndView("blog_create", "blogCreate", new Blog());
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNewBlog(@ModelAttribute("blogForm") @Valid Blog blogForm, BindingResult result) {
        return null;
    }

    @RequestMapping(value = "/retrive", method = RequestMethod.GET)
    public ModelAndView getAllBlogs() {
        Blog b1 = new Blog();
        b1.setId(1L);
        b1.setCreationDate(org.joda.time.LocalDate.now());
        b1.setContent("Sample Blog 1 for Spring MVC under Spring Boot with Java 1.7");
        b1.setTitle("Spring MVC -- Part 1");

        Blog b2 = new Blog();
        b2.setId(2L);
        b2.setCreationDate(org.joda.time.LocalDate.now());
        b2.setContent("Spring Mvc ith REST page");
        b2.setTitle("Spring MVC -- Part 2");

        List<Blog> allBlogs = Arrays.asList(b1, b2);
        ModelMap blogData = new ModelMap("blogList", allBlogs);

        return new ModelAndView("showAllBlogs", blogData);
    }
}
