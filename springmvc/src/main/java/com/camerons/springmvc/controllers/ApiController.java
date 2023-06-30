package com.camerons.springmvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.camerons.springmvc.models.Tweet;
import com.camerons.springmvc.services.TweetService;

@RestController
@RequestMapping("/api")
public class ApiController {
	@Autowired
	private TweetService tService;
	
//	Find All
	@GetMapping("")
	public List<Tweet> getAll(){
		return this.tService.getAll();
	}
	
//	Create
	@RequestMapping("/create")
	public Tweet createObject(
			@RequestParam("tweetContent")String content,
			@RequestParam("imaginaryIntAtt")Integer imaginaryInt) {
//		does requestparam need "value =" ?
		Tweet newTweet = new Tweet(content,imaginaryInt);
		System.out.println(content);
		System.out.println(imaginaryInt);
		return this.tService.create(newTweet);
	}
	
//	Find By ID
	@GetMapping("/{tweetId}")
	public Tweet getOne(@PathVariable("tweetId")Long id){
		return this.tService.getById(id);
	}
	
//	Edit By ID
	@PutMapping("/update/{tweetId}")
	public void updateObject(
			@RequestParam(value="tweetContent", required=false)String content,
			@RequestParam(value="imaginaryIntAtt", required=false)Integer imaginaryInt,
			@PathVariable("tweetId") Long idToUpdate) {
		Tweet tweetToUpdate = tService.getById(idToUpdate);
//		System.out.println(tweetToUpdate.getId());
//		tweetToUpdate.setTweetContent(content);
		tweetToUpdate.setTweetContent(content != null? content: tweetToUpdate.getTweetContent());
		tweetToUpdate.setImaginaryIntAtt(imaginaryInt != null? imaginaryInt: tweetToUpdate.getImaginaryIntAtt());
		System.out.println(this.tService.update(tweetToUpdate));
	}
	
//	Delete By ID
	@DeleteMapping("/delete/{tweetId}")
	public void deleteObject(@PathVariable("tweetId") Long idToDelete) {
//		System.out.println(idToUpdate);
		this.tService.delete(idToDelete);
	}
}
