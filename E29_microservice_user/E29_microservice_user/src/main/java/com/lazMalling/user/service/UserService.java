package com.lazMalling.user.service;

import com.lazMalling.user.model.User;
import com.lazMalling.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }
    public User getUserById(Long userId) {
        return userRepository.findById(userId).get();
    }
    public User update(Long userId, User user) {
        user.setUserId(userId);
        return userRepository.save(user);
    }


    public List<User> getAllUser() { return this.userRepository.findAll();
    }
}


//import com.lazMalling.user.model.Role;
//import com.lazMalling.user.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserService {
//
//    @Autowired
//    private final UserRepository userRepository;
//
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public String postUser(String firstName,String lastName,String email,String password,String mobile,String role){
//        User user= new User();
//        user.setFirstName(firstName);
//        user.setLastName(lastName);
//        user.setEmail(email);
//        user.setPassword(password);
//        user.setMobile(mobile);
//        user.setRole(Role.valueOf(role));
//
//        System.out.println(userRepository.save(user));
//
//        return "saved";
//    }
//
//    public List<User> getAllUser(){
//        return userRepository.findAll();
//    }
//
//    public Optional<User> getUserById(long id){
//        return  userRepository.findById(id);
//    }
//
//    public User updateUserById(long id,User user){
//        user.setId(id);
//        return userRepository.save(user);
//    }
//
//    public void deleteUserById(long id){
//        userRepository.deleteById(id);
//    }
//
//
//}
