package com.kelvinarauz.exam.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kelvinarauz.exam.models.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long>{

}