package com.mobile.demo.controller;

import com.mobile.demo.dao.UserEntityRepository;
import com.mobile.demo.model.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Controller
public class UserController {

    UserEntityRepository userEntityRepository;

    public UserController(UserEntityRepository userEntityRepository){
        this.userEntityRepository = userEntityRepository;
    }

    @GetMapping("/user")
    @ResponseBody
    public ArrayList<UserEntity> findAllUsers(){
        return (ArrayList<UserEntity>) userEntityRepository.findAll();
    }

    //url: http://localhost:8080/user/1
    @GetMapping("/user/id/{id}")
    @ResponseBody
    public UserEntity findUserEntityById(@PathVariable int id){
        return userEntityRepository.findUserEntityByUserId(id);
    }

    @GetMapping("/user/name/{username}")
    @ResponseBody
    public UserEntity findUserByName(@PathVariable String username){
        return userEntityRepository.findUserEntityByUsername(username);
    }

    @PostMapping("/user")
    @ResponseBody
    public UserEntity addUser(@RequestBody UserEntity userEntity){
        userEntityRepository.save(userEntity);
        return userEntityRepository.findUserEntityByUsername(userEntity.getUsername());
    }

    @DeleteMapping("/user/delete/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable int id) {
        userEntityRepository.deleteById(id);
        return "success";
    }
}
