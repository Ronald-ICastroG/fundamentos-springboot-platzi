package com.fundamentosplatzi.springboot.demo.service;

import com.fundamentosplatzi.springboot.demo.entity.User;
import com.fundamentosplatzi.springboot.demo.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final Log LOG= LogFactory.getLog(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

public void saveTransactional(List<User> users){
        users.stream()
                .peek(user->LOG.info("Usuario insertado "+user))
                .forEach(userRepository::save);

}


public List<User> getAllUsers(){
        return userRepository.findAll();
}

}
