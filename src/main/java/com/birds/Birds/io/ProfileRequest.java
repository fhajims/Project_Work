package com.birds.Birds.io;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileRequest {

    @NotBlank(message = "Name is required")
    @Size(min = 3, message = "Name should be at least 3 characters")
    private String name;

    @NotNull(message = "Email is required")
    @Email(message = "Provide valid email address")
    private String email;

    @NotNull(message = "Password is required")
    @Size(min = 5, message = "Password should be at least 5 characters")
    private String password;



}
