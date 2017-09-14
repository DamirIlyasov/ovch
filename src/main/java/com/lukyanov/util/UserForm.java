package com.lukyanov.util;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;


public class UserForm {

    private static final String BLANK_MESSAGE = "This field is mandatory";

    @NotBlank(message = BLANK_MESSAGE)
    @Email
    private String email;

    @NotBlank(message = BLANK_MESSAGE)
    @Size(min = 10, max = 20, message = "Phone should be from 10 to 20 symbols")
    private String phone;

    @NotBlank(message = BLANK_MESSAGE)
    @Size(min = 7, max = 20, message = "Password should be from 7 to 20 symbols")
    private String password;

    @NotBlank(message = BLANK_MESSAGE)
    @Size(max = 30 , min = 2, message = "Firstname should be from 2 to 30 symbols")
    private String firstName;

    @NotBlank(message = BLANK_MESSAGE)
    @Size(max = 30 , min = 2, message = "Lastname should be from 2 to 30 symbols")
    private String lastName;

    private int age;

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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



}
