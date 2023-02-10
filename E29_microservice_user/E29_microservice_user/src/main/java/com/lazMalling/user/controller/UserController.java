package com.lazMalling.user.controller;


import com.lazMalling.user.model.User;
import com.lazMalling.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping ("/registerUser")
    public ResponseEntity<User> registerUser(@RequestBody User User){
        User registerUser = userService.registerUser(User);
        return new ResponseEntity<>(registerUser, HttpStatus.CREATED);
    }
    @GetMapping ("/getUser/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        User User = userService.getUserById(id);
        return ResponseEntity.ok(User);
    }
    @DeleteMapping("/deleteUser/{id}")
    public void delete(@PathVariable Long id){
        userService.deleteById(id);
    }

    @PutMapping("/updateUser/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User User){
        User.setUserId(id);
        return userService.update(id, User);
    }
    @GetMapping({"/getAllUser"})
    @ResponseBody
    public List<User> getAllUser() {
        return this.userService.getAllUser();
    }
}



//import com.lazMalling.user.model.User;
//import com.lazMalling.user.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api")
//public class UserController {
//
//    @Autowired
//    private final UserService userService;
//
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @PostMapping("/users")
//    public @ResponseBody String postUser(@RequestParam String firstName,
//                                         @RequestParam String lastName,
//                                         @RequestParam String email,
//                                         @RequestParam String password,
//                                         @RequestParam String mobile,
//                                         @RequestParam String role){
//        return userService.postUser(firstName,lastName,email,password,mobile,role);
//    }
//    @GetMapping("/users")
//    public List<User> getAllUser(){
//        return userService.getAllUser();
//    }
//    @GetMapping("/users/{id}")
//    public Optional<User> getUserById(@PathVariable long id){
//        return userService.getUserById(id);
//    }
//    @PutMapping("/users/{id}")
//    public User updateUserById(@PathVariable long id, @RequestBody User user){
//        return userService.updateUserById(id,user);
//    }
//
//    @DeleteMapping("/users/{id}")
//    public void deleteUserById(@PathVariable long id){
//        userService.deleteUserById(id);
//    }
//
//}
