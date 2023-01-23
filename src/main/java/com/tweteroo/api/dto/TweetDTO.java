package com.tweteroo.api.dto;

import jakarta.validation.constraints.NotBlank;

public record TweetDTO(

    @NotBlank(message = "Username is mandatory.")
    String username,

    @NotBlank(message = "Tweet is mandatory.")
    String tweet
) {
    
}
