package com.kelvinarauz.exam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kelvinarauz.exam.models.User;
import com.kelvinarauz.exam.services.UserService;
import com.kelvinarauz.exam.validators.UserValidator;

@Controller
public class UserController {
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	private UserValidator userValidator;
	
	
	@GetMapping("/")
	public String loginRegistrationPage(@ModelAttribute("user") User emptyUser, Model model) {
		return "loginRegistration/loginReg.jsp";
	}
	
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User filledUser, BindingResult result,
			HttpSession session, Model model) {
		userValidator.validate(filledUser, result);
		if(result.hasErrors()) {
			return "loginRegistration/loginReg.jsp";
		} else {
			User newUser = userServ.registerUser(filledUser);
			session.setAttribute("userIdSession", newUser.getId());
			return "redirect:/shows";
		}
	}
	
	@PostMapping("/login")
	public String processLogin(@RequestParam("loginEmail") String postEmail,
			@RequestParam("loginPassword") String postPassword,
			RedirectAttributes redirectAttributes,HttpSession session) {
//		System.out.println(postEmail);
//		System.out.println(postPassword);
		//if email is not found or password does not match
		if( !userServ.authenticateUser(postEmail, postPassword)) {
			redirectAttributes.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/";
		}
		//find user from DB and set user id in session
		User loggedUser = userServ.findByEmail(postEmail);		
		session.setAttribute("userIdSession", loggedUser.getId());
		return "redirect:/shows";	
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userIdSession");
		return "redirect:/";
	}
}
