package com.pankaj.platform.controller;

import com.pankaj.platform.domain.CareerResume;
import com.pankaj.platform.service.CareerResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by pankajpardasani on 24/09/2016.
 */
@Controller
public class CareerProfileController {

    @Autowired
    private CareerResumeService careerResumeService;

    @RequestMapping(value = "/profile/edit", method = RequestMethod.GET)
    public ModelAndView getCareerProfile(final CareerResume careerProfile) {
        return new ModelAndView("careerProfile", "careerProfile", careerProfile);
    }

    @RequestMapping(value = "/profile/edit", params = {"saveCareerProfile"}, method = RequestMethod.POST)
    public String updateCareerProfileDetails(final CareerResume careerProfile, BindingResult result, SessionStatus sessionStatus) {
        if(!result.hasErrors()) {
            careerResumeService.putProfileDetails(careerProfile);
            sessionStatus.setComplete();

            return "redirect:/home";
        }
        else {
            return "careerProfile";
        }
    }

    @RequestMapping(value="/profile/edit", params={"addSummary"}, method = RequestMethod.POST)
    public String addCareerSummary(final CareerResume careerProfile, ModelMap modelMap, final BindingResult bindingResult) {
        careerProfile.getSummary().getSummaryInfo().add(new String());
        modelMap.addAttribute("careerProfile", careerProfile);

        return "careerProfile";
    }

    @RequestMapping(value="/profile/edit", params={"removeSummary"})
    public String removeCareerSummary(final CareerResume careerResume, final BindingResult bindingResult, final HttpServletRequest req) {
        final Integer rowId = Integer.valueOf(req.getParameter("removeSummary"));
        careerResume.getSummary().getSummaryInfo().remove(rowId.intValue());

        return "careerProfile";
    }
}
