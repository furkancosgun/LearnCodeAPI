package com.furkancosgun.LearnCode.Service;

import com.furkancosgun.LearnCode.Model.Request.UserRequest;
import com.furkancosgun.LearnCode.Model.Response.UserResponse;
import com.furkancosgun.LearnCode.Model.User;
import com.furkancosgun.LearnCode.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserResponse saveUser(User user){
        return new UserResponse(userRepository.save(user));
    }

    public UserResponse getUserByUsernameAndPassword(UserRequest user){
        return new UserResponse(userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword()));
    }

    public UserResponse getUserById(long id){
        return new UserResponse(userRepository.findById(id).orElseThrow());
    }

    public List<UserResponse> getAllUsers(){
        return userRepository.findAll().stream().map(UserResponse::new).collect(Collectors.toList());
    }

}
