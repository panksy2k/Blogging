package com.pankaj.platform.controller;

import com.pankaj.platform.domain.Blog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pankajpardasani on 17/07/2016.
 */
@Controller
@RequestMapping("/blog")
public class BlogManageController {

    @RequestMapping(value = "/admin/search", method = RequestMethod.GET)
    public String getAllBlogs(Model blogModel) {
        Blog b1 = new Blog();

        b1.setCreationDate(LocalDate.now());
        b1.setContent("Sample Blog 1 for Spring MVC under Spring Boot with Java 1.7");
        b1.setTitle("Spring MVC -- Part 1");
        b1.setUpdateDate(LocalDate.now());


        Blog b2 = new Blog();

        b2.setCreationDate(LocalDate.now());
        b2.setContent("Spring Mvc ith REST page");
        b2.setTitle("Spring MVC -- Part 2");
        b2.setUpdateDate(LocalDate.now());

        List<Blog> listOfBlog = Arrays.asList(b1, b2);
        blogModel.addAttribute("blogList", listOfBlog);

        return "showAllBlogs";
    }

    @RequestMapping(value = "/admin/create", method = RequestMethod.GET)
    public String createBlog(Model blogModel) {
        blogModel.addAttribute("blog", new Blog());

        return "blogCreate";
    }

    @RequestMapping(value = "/admin/submit", method = RequestMethod.POST)
    public String addNewBlog(@ModelAttribute("blogForm") @Valid Blog blogForm, BindingResult result) {
        return null;
    }
}
