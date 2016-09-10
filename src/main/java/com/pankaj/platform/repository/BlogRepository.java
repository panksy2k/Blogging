package com.pankaj.platform.repository;

import com.pankaj.platform.domain.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by pankajpardasani on 17/07/2016.
 */
public interface BlogRepository extends MongoRepository<Blog, Long> {

}
