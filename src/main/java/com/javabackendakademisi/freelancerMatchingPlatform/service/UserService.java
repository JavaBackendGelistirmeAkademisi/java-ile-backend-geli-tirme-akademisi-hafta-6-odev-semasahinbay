package com.javabackendakademisi.freelancerMatchingPlatform.service;

import com.javabackendakademisi.freelancerMatchingPlatform.entity.User;
import com.javabackendakademisi.freelancerMatchingPlatform.repository.UserRepository;
import com.javabackendakademisi.freelancerMatchingPlatform.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setUserType(userDetails.getUserType());

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        userRepository.delete(user);
    }
}
