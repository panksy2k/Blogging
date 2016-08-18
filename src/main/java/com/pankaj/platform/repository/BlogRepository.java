package com.pankaj.platform.repository;

import com.pankaj.platform.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pankajpardasani on 17/07/2016.
 */
public interface BlogRepository extends JpaRepository<BlogEntity, Long> {

}
