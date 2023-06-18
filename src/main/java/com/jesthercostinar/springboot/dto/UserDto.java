package com.jesthercostinar.springboot.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    @NotEmpty
    @Size(min = 2, message = "Name is too short")
    private String firstName;
    @NotEmpty
    private String lastName;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Must be valid email address")
    private String email;

    @NotEmpty
    private String password;
}
