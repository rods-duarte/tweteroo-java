package com.tweteroo.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;


public record UserDTO(

@NotBlank(message = "Username is mandatory.")
String username, 

@NotBlank(message = "Avatar image url is mandatory.")
String avatar
) {
    
}
