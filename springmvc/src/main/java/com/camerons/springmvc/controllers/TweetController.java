package com.camerons.springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.camerons.springmvc.models.Tweet;
import com.camerons.springmvc.services.TweetService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/tweet")
public class TweetController {
	@Autowired
	private TweetService tService;
	
	@GetMapping("")
	public String index(@ModelAttribute("newTweet")Tweet newTweet,Model viewmodel) {
		viewmodel.addAttribute("allTheThings", this.tService.getAll());
		return "index.jsp";
	}
	
	@PostMapping("/create")
	public String createTweet(@Valid @ModelAttribute("newTweet")Tweet newTweet, BindingResult result, Model viewmodel) {
		if(result.hasErrors()) {
			viewmodel.addAttribute("allTheThings", this.tService.getAll());
			return "index.jsp";
		}
		System.out.println(newTweet);
		this.tService.create(newTweet);
		return "redirect:/tweet";
	}
	@GetMapping("/edit/{tweetId}")
	public String editRender(Model viewmodel, @PathVariable("tweetId")Long idToEdit) {
		viewmodel.addAttribute("tweetToEdit", this.tService.getById(idToEdit));
		return "edit.jsp";
	}
	
	@PutMapping("/update/{id}")
	public String updateValues(@Valid @ModelAttribute("tweetToEdit")Tweet editedTweet,
			BindingResult result,
			Model viewmodel) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		System.out.println(editedTweet);
		this.tService.update(editedTweet);
		return "redirect:/tweet";
	}
	
	@DeleteMapping("/delete/{tweetId}")
	public String deleteMe(@PathVariable("tweetId")Long tweetId) {
		System.out.println(tweetId);
		this.tService.delete(tweetId);
		return "redirect:/tweet";
	}
	
	
	
	
	
	
}
