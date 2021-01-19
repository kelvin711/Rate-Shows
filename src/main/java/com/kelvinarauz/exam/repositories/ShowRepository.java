package com.kelvinarauz.exam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kelvinarauz.exam.models.Show;

@Repository
public interface ShowRepository extends CrudRepository<Show, Long>{
	
	List<Show> findAll();
}