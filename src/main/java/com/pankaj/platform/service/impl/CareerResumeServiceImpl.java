package com.pankaj.platform.service.impl;

import com.pankaj.platform.domain.CareerResume;
import com.pankaj.platform.repository.CareerResumeRepository;
import com.pankaj.platform.service.CareerResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
        CareerResume pankajResume = new CareerResume();
        pankajResume.setCandidateName("Pankaj Pardasani");

        return Optional.of(careerResumeRepository.findOne(Example.of(pankajResume))).orElseGet(CareerResume::new);
    }

    @Override
    public boolean putProfileDetails(CareerResume resume) {
        return Optional.of(careerResumeRepository.save(resume)).isPresent();
    }
}
