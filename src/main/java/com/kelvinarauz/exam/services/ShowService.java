package com.kelvinarauz.exam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelvinarauz.exam.models.Review;
import com.kelvinarauz.exam.models.Show;
import com.kelvinarauz.exam.repositories.ReviewRepository;
import com.kelvinarauz.exam.repositories.ShowRepository;

@Service
public class ShowService {
	
	@Autowired
	private ShowRepository showRepo;
	
	@Autowired
	private ReviewRepository reviewRepo;
	
	//CREATE A SHOW
	public Show create(Show show) {
		return showRepo.save(show);
	}
	//UPDATE A SHOW
	public Show update(Show show) {
		return showRepo.save(show);
	}
	//FIND ALL SHOWS
	public List<Show> findAllShows() {
		return showRepo.findAll();
	}
	//FIND SHOW BY ID
	public Show findshowById(Long id) {
		Optional<Show> show = showRepo.findById(id);
		return show.isPresent() ? show.get() : null;
	}
	//DELETE THE SHOW
	public void delete(Long id) {
		showRepo.deleteById(id);
	}
	//CREATE A REVIEW
	public Review createReview(Review review) {
		return reviewRepo.save(review);
	}
}
