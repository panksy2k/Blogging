package com.pankaj.platform.service.impl;

import com.pankaj.platform.constant.BloggingBusinessConstant;
import com.pankaj.platform.domain.CareerResume;
import com.pankaj.platform.repository.CareerResumeRepository;
import com.pankaj.platform.service.CareerResumeService;
import com.pankaj.platform.util.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by pankajpardasani on 24/09/2016.
 */
@Service
public class CareerResumeServiceImpl implements CareerResumeService {

    @Autowired
    private CareerResumeRepository careerResumeRepository;


    @Override
    public CareerResume getCareerExperienceDetails() {
        CareerResume careerResume = Optional.ofNullable(careerResumeRepository.findByCandidateName(BloggingBusinessConstant.CANDIDATE_NAME)).orElseGet(CareerResume::new);
        return careerResume;
    }

    @Override
    public boolean putProfileDetails(CareerResume resume) {
        CareerResume careerResume = Optional.ofNullable(careerResumeRepository.findByCandidateName(BloggingBusinessConstant.CANDIDATE_NAME)).orElseGet(CareerResume::new);
        resume.setCandidateName(BloggingBusinessConstant.CANDIDATE_NAME);

        if(ObjectUtil.checkIfNotNull(careerResume.getId())) {
            resume.setId(careerResume.getId());
        }

        return Optional.of(careerResumeRepository.save(resume)).isPresent();
    }
}
