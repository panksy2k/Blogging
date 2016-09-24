package com.pankaj.platform.controller;

import com.pankaj.platform.domain.CareerResume;
import com.pankaj.platform.service.CareerResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by pankajpardasani on 24/09/2016.
 */
@Controller(value = "/career")
public class CareerProfileController {

    @Autowired
    private CareerResumeService careerResumeService;

    @RequestMapping(value = "/profile/edit", method = RequestMethod.GET)
    public ModelAndView getCareerProfile() {
        ModelAndView modelView = new ModelAndView("careerProfile", "career", careerResumeService.getCareerExperienceDetails());
        return modelView;
    }

    @RequestMapping(value = "/profile/edit", method = RequestMethod.POST)
    public String updateCareerProfileDetails(@Valid @ModelAttribute CareerResume careerResume, BindingResult result, SessionStatus sessionStatus) {
        if(!result.hasErrors()) {
            careerResumeService.putProfileDetails(careerResume);
            sessionStatus.setComplete();

            return "/home";
        }
        else {
            return "redirect:/career/profile/edit";
        }
    }
}
