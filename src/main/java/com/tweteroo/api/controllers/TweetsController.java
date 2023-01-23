package com.tweteroo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.models.Tweet;
import com.tweteroo.api.models.User;
import com.tweteroo.api.services.TweetService;
import com.tweteroo.api.services.UserService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tweets")
public class TweetsController {

    @Autowired
    private UserService userService;

    @Autowired
    private TweetService tweetService;
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<String> addTweet(@RequestBody @Valid TweetDTO body) {

        User user = userService.findUserOrFail(body.username());

        tweetService.create(new Tweet(body, user.getAvatar()));
        return ResponseEntity.created(null).body("OK");
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<Tweet>> listAll(@PageableDefault(page = 0, size = 5) Pageable page) {
        List<Tweet> tweets = tweetService.findAll(page).getContent();

        return ResponseEntity.ok().body(tweets);
    }

    @GetMapping("/{username}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<Tweet>> listByUsername(@PathVariable String username) {
        List<Tweet> tweets = tweetService.findByUsername(username);

        return ResponseEntity.ok().body(tweets);
    }
}
