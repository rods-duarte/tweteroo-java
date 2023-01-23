package com.tweteroo.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;


public record UserDTO(

@Valid
@NotBlank(message = "Username is mandatory.")
String username, 

@Valid
@NotBlank(message = "Avatar image url is mandatory.")
String avatar
) {
    
}
