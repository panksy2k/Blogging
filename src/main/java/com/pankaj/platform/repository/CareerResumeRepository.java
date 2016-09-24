package com.pankaj.platform.repository;

import com.pankaj.platform.domain.CareerResume;
import com.pankaj.platform.domain.ContactMe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pankajpardasani on 10/09/2016.
 */
@Repository
public interface CareerResumeRepository extends MongoRepository <CareerResume, String> {
}
