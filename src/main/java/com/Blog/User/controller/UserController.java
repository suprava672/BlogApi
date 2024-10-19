package com.Blog.User.controller;

import com.Blog.User.entity.User;
import com.Blog.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController{
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser = userService.createUser(user);
        return new ResponseEntity(user , HttpStatus.CREATED);

    }
    @GetMapping
    public List<User> getAllUser(){
        List<User> userList = userService.getAllUser();
        return userList;


    }
    @GetMapping("/{id}")
public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
        //changes done

}
@DeleteMapping("/{id}")
public String deleteUserById(@PathVariable Long id){
    String s = userService.deleteUserById(id);
return s;
}
@PutMapping("/{id}")
public User updateUser(@RequestBody User user,@PathVariable Long id){
    User newUser = userService.updateUser(user,id);
    return newUser;

}

}
