package com.ngatdo.validateexHandleexample.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
@Data // lombok annotation for auto-generate getter/setter/constructor
@Table(name = "users", schema = "test2", catalog = "")
public class UserEnt implements Serializable {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "userid")
    @NotBlank
    private String userid;

    @Basic
    @Column(name = "password")
    @Size(min = 6, max = 20)
    private String password;

    @Basic
    @Column(name = "email")
    @Email(message = "email should be a valid email")
    private String email;

    @Basic
    @Column(name = "phone")
    @Pattern(regexp = "[0-9]{10}")
    private String phone;

    @Basic
    @Column(name = "firstName")
    @NotBlank(message = "first name must not be blank")
    private String firstName;

    @Basic
    @Column(name = "lastName")
    @NotBlank(message = "last name must not be blank")
    private String lastName;

    @Basic
    @Column(name = "expired")
    private int expired;

    @Basic
    @Column(name = "disabled")
    private int disabled;

    @Basic
    @Column(name = "age")
    @Min(13)
    @Max(99)
    private int age;

}
