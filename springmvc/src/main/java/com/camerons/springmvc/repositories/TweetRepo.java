package com.camerons.springmvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.camerons.springmvc.models.Tweet;
//@Repository
public interface TweetRepo extends CrudRepository<Tweet, Long>{
    // this method retrieves all the tweets from the database
    List<Tweet> findAll();

}
