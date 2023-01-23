package com.tweteroo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.models.Tweet;
import com.tweteroo.api.repositories.TweetRepository;

@Service
public class TweetService {

    @Autowired
    private TweetRepository repository;

    public void create(Tweet tweet) {
        repository.save(tweet);
    }

    public List<Tweet> findAll() {
        return repository.findAll();
    }
}
