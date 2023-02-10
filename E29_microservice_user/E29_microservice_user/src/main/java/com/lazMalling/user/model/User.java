package com.lazMalling.user.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;

}


//import jakarta.persistence.*;
//import lombok.*;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "user")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "first_name")
//    private String firstName;
//
//    @Column(name = "last_name")
//    private String lastName;
//
//    @Column(name = "email")
//    private String email;
//
//    @Column(name="password")
//    private String password;
//
//    @Column(name = "mobile")
//    private String mobile;
//
//    @Enumerated(EnumType.STRING)
//    private Role role;
//
//}
