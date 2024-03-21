package com.example.kafkabatch.model.entity;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("customer")
@Getter
public class Customer {
    @Id
    private String id;
    @Indexed(unique = true)
    private String firsName;
    private String lastName;
    private int age;
    private String email;
    private String phoneNumber;

    public Customer() {}

    public Customer(String firsName, String lastName, int age, String email, String phoneNumber) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", firsName='" + firsName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
