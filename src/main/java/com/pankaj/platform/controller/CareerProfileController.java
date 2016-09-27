package com.pankaj.platform.controller;

import com.pankaj.platform.domain.CareerResume;
import com.pankaj.platform.service.CareerResumeService;
import com.pankaj.platform.util.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by pankajpardasani on 24/09/2016.
 */
@Controller
@SessionAttributes(types = CareerResume.class)
public class CareerProfileController {

    @Autowired
    private CareerResumeService careerResumeService;

    @RequestMapping(value = "/profile/edit", method = RequestMethod.GET)
    public ModelAndView getCareerProfile() {
        return new ModelAndView("careerProfile", "careerProfile", careerResumeService.getCareerExperienceDetails());
    }

    @RequestMapping(value = "/profile/edit", params = {"saveCareerProfile"}, method = RequestMethod.POST)
    public String updateCareerProfileDetails(final CareerResume careerProfile, BindingResult result, SessionStatus sessionStatus) {
        if(!result.hasErrors()) {
            careerResumeService.putProfileDetails(careerProfile);
            sessionStatus.setComplete();

            return "redirect:/profile/edit";
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

    @RequestMapping(value="/profile/edit", params={"addProject"}, method = RequestMethod.POST)
    public String addCareerProjectDetails(final CareerResume careerProfile, ModelMap modelMap, final BindingResult bindingResult) {
        careerProfile.getExperience().add(new CareerResume.ProjectSpecification());
        modelMap.addAttribute("careerProfile", careerProfile);

        return "careerProfile";
    }

    @RequestMapping(value="/profile/edit", params={"removeSummary"})
    public String removeCareerSummary(final CareerResume careerResume, final BindingResult bindingResult, final HttpServletRequest req) {
        final Integer rowId = Integer.valueOf(req.getParameter("removeSummary"));

        if(ObjectUtil.checkIfNotNull(careerResume) && ObjectUtil.checkIfNotEmpty(careerResume.getSummary().getSummaryInfo())) {
            careerResume.getSummary().getSummaryInfo().remove(rowId.intValue());
        }

        return "careerProfile";
    }

    @RequestMapping(value="/profile/edit", params={"removeProject"})
    public String removeCareerProject(final CareerResume careerResume, ModelMap careerModel, final BindingResult bindingResult, final HttpServletRequest req) {
        final Integer rowId = Integer.valueOf(req.getParameter("removeProject"));

        if(ObjectUtil.checkIfNotEmpty(careerResume.getExperience())) {
            careerResume.getExperience().remove(rowId.intValue());

        }

        careerModel.put("careerProfile", careerResume);
        return "careerProfile";
    }
}
