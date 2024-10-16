package com.mywebapp.familyfinance.service;

import com.mywebapp.familyfinance.model.User;
import com.mywebapp.familyfinance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User updateUser(Long id,User newUser){
        return userRepository.findById(id).map(user -> {
            user.setUsername(newUser.getUsername());
            user.setPassword(newUser.getPassword());
            user.setAge(newUser.getAge());
            user.setGender(newUser.getGender());
            user.setBirthDate(newUser.getBirthDate());
            user.setHeight(newUser.getHeight());
            user.setWeight(newUser.getWeight());
            return userRepository.save(user);
        }).orElseGet(() -> {
            newUser.setId(id);
            return userRepository.save(newUser);
        });
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    // 用户登录功能
    public User login(String username,String password){
        User user = userRepository.findByUsername(username);
        if(user != null && user.getPassword().equals(password)){
            return user;
        }else{
            throw new RuntimeException("用户名或密码错误");
        }
    }
}
