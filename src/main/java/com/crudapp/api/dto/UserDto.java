package com.crudapp.api.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDto {
        private Long id;
        @NotEmpty
        @Size(min = 4, message = "firstname must be min of 4 characters")
        private String firstName;
        @NotEmpty
        @Size(min = 4, message = "lastname must be min of 4 characters")
        private String lastName;
        @Size(min = 4, message = "email must be min of 4 characters")
        @Email(message = "Email address is not valid!!")
        private String email;
        @NotEmpty
        @Size(min = 4, max = 12, message = "password must be min of 3 chars and max of 10 char!! ")
        private String username;
        @NotEmpty
        @Size(min = 4, max = 10, message = "password must be min of 3 chars and max of 10 char!! ")
        private String password;
}
