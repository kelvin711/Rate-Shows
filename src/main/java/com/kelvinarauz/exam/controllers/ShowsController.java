package com.kelvinarauz.exam.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kelvinarauz.exam.models.Review;
import com.kelvinarauz.exam.models.Show;
import com.kelvinarauz.exam.models.User;
import com.kelvinarauz.exam.services.ShowService;
import com.kelvinarauz.exam.services.UserService;

@Controller
public class ShowsController {
	
	@Autowired
	private ShowService showServ;
	
	@Autowired
	private UserService userServ;

//-------------------------------------------- dashboard
	
	@GetMapping("/shows")
	public String dashboard(Model model, HttpSession session) {
		Long loggedUser = (Long) session.getAttribute("userIdSession");
		if(loggedUser == null) {
			return "redirect:/";
		}
		User sessionUser = userServ.findUserById(loggedUser);//finding user in session
		List<Show> shows = showServ.findAllShows();
		model.addAttribute("user", sessionUser);
		model.addAttribute("shows", shows);
		return "ShowsSite/dashboard.jsp";
	}
	
//-------------------------------------------- dashboard
	
//-------------------------------------------- create new show page and proccess 
	
	@GetMapping("/shows/new")
	public String addShowPage(@ModelAttribute("showObj") Show emptyShow,Model model,
			HttpSession session) {
		Long loggedUser = (Long) session.getAttribute("userIdSession");
		if(loggedUser == null) {
			return "redirect:/";
		}
		User sessionUser = userServ.findUserById(loggedUser);//finding user in session
		model.addAttribute("user", sessionUser);
		return "ShowsSite/addShow.jsp";
	}
	
	@PostMapping("/shows/create")
	public String createShow(@Valid @ModelAttribute("showObj") Show filledShow,BindingResult result,
			HttpSession session) {
		System.out.println("you are starting to create");
		if(result.hasErrors()) {
			System.out.println("you made an error");
			return "ShowsSite/addShow.jsp";
		} else {
			System.out.println("creating....");
			showServ.create(filledShow);
			return "redirect:/shows";
		}
		
	}
	
//-------------------------------------------- create new show page and proccess 
//-------------------------------------------- show page and rate
	@RequestMapping("/shows/{id}")
	public String detailsPage(@ModelAttribute("ratingObj") Review emptyReview,@PathVariable("id") Long id,
			HttpSession session, Model model) {
		Long loggedUser = (Long) session.getAttribute("userIdSession");
		if(loggedUser == null) {
			return "redirect:/";
		}
		User sessionUser = userServ.findUserById(loggedUser);//finding user in session
		model.addAttribute("user", sessionUser);
		model.addAttribute("show", showServ.findshowById(id));
		return "ShowsSite/details.jsp";
	}
	@PostMapping("/shows/{id}/review")
	public String addRating(@Valid @ModelAttribute("ratingObj") Review filledReview, BindingResult result,
			Model model, HttpSession session) {
		showServ.createReview(filledReview);
		Long showId = filledReview.getShow().getId();
		return "redirect:/shows/" + showId;
	}
	
//-------------------------------------------- show page and rate
//-------------------------------------------- edit page
	@GetMapping("/shows/{id}/edit")
	public String editPage(@PathVariable("id") Long id, Model model,HttpSession session) {
		Long loggedUser = (Long) session.getAttribute("userIdSession");
		if(loggedUser == null) {
			return "redirect:/";
		}
		User sessionUser = userServ.findUserById(loggedUser);//finding user in session
		model.addAttribute("user", sessionUser);
		model.addAttribute("show", showServ.findshowById(id));

		return "ShowsSite/edit.jsp";
	}
	
	@PutMapping("/shows/{id}/update")
	public String updateShow(@Valid @ModelAttribute("show") Show updateShow,
			BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			
			return "ShowsSite/edit.jsp";
		} else {
			Long loggedUser = (Long) session.getAttribute("userIdSession");
			User sessionUser = userServ.findUserById(loggedUser);
			updateShow.setShowCreator(sessionUser);
			showServ.update(updateShow);
			return "redirect:/shows/" + updateShow.getId();
		}
	}
	
//-------------------------------------------- edit page 
	@GetMapping("/shows/{id}/delete")
	public String deleteShow(@PathVariable("id") Long id) {
		showServ.delete(id);
		return "redirect:/shows";
	}
}
