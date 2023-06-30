package com.camerons.springmvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camerons.springmvc.models.Tweet;
import com.camerons.springmvc.repositories.TweetRepo;

@Service
public class TweetService {
//	private final <<Repo_Name>> <<variableName>>;
//	public ServiceName(<<Repo_Name>> <<paramVariableName>>){
//	    this.<<variableName>> = <<paramVariableName>>;
//	}
//	private final TweetRepo tRepo;
//	public TweetService(TweetRepo tRepo){
//	    this.tRepo = tRepo;
//	}
	@Autowired
	private TweetRepo tRepo;
	
//	Create
	public Tweet create(Tweet newTweet) {
		return this.tRepo.save(newTweet);
	}
//	Read All
	public List<Tweet> getAll(){
		return this.tRepo.findAll();
	}
//	Read One
//    public Book findBook(Long id) {
//        Optional<Book> optionalBook = tRepo.findById(id);
//        if(optionalBook.isPresent()) {
//            return optionalBook.get();
//        } else {
//            return null;
//        }
//    }
	public Tweet getById(Long id) {
		return tRepo.findById(id).orElse(null);
	}
//	Delete
	public void delete(Long id) {
		this.tRepo.deleteById(id);
	}
//	Update
	public Tweet update(Tweet newTweet) {
		return this.tRepo.save(newTweet);
	}
}
