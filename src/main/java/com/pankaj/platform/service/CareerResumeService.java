package com.pankaj.platform.service;

import com.pankaj.platform.domain.CareerResume;
import org.springframework.stereotype.Service;

/**
 * Created by pankajpardasani on 24/09/2016.
 */
@Service
public interface CareerResumeService {
    CareerResume getCareerExperienceDetails();
    boolean putProfileDetails(CareerResume resume);
}
