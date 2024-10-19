package com.Blog.User.service;

import com.Blog.User.entity.User;
import com.Blog.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);

    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserById(Long id){
       return userRepository.findById(id).orElseThrow(()->new RuntimeException("resource not get"));


    }
    public String deleteUserById(Long id) {
        User valueNotGet = userRepository.findById(id).orElseThrow(() -> new RuntimeException("value not get"));

userRepository.delete(valueNotGet);
return " user deleted succefully";
    }
    public User updateUser(User user,Long id){
        User valueGet = userRepository.findById(id).orElseThrow(() -> new RuntimeException("value get"));
        valueGet.setName(user.getName());
        User savsave1 = userRepository.save(valueGet);

        return savsave1;

    }


}
