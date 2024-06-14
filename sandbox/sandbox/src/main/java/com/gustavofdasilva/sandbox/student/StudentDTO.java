package com.gustavofdasilva.sandbox.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record StudentDTO(
    @NotEmpty(message="First name must not be empty") String firstName,
    @NotEmpty(message="Last name must not be empty") String lastName, 
    @NotEmpty(message="Email must not be empty") @Email String email,
    @Positive(message="School id must be a valid id") Integer school_id
) {

}
