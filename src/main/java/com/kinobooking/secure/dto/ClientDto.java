package com.kinobooking.secure.dto;

import com.kinobooking.secure.validator.PasswordMatches;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by Екатерина on 17.08.2017.
 */
@PasswordMatches
public class ClientDto {

    @NotNull
    @NotEmpty

    private String password;
    @NotNull
    @NotEmpty

    private String firstName;
    @NotNull
    @NotEmpty

    private String lastName;
    //@ValidEmail
    @Email
    @NotNull
    @NotEmpty
    private String email;
    @NotNull
    @NotEmpty
    private String confirmPass;

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }

    public ClientDto( String password, String firstName, String lastName, String email, String confirmPass) {

        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.confirmPass = confirmPass;
    }




    public ClientDto() {

    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                 " password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", confirmPass='" + confirmPass + '\'' +
                '}';
    }
}

