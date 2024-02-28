package com.newsfeed.demo.service;

import com.newsfeed.demo.domain.User;
import com.newsfeed.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


    public List<Long> findSubscribedSchoolIdsForCurrentUser() {
        return userRepository.findSubscribedSchoolIdsForCurrentUser();
    }


    public Long subscribeToSchool(Long userId, Long schoolId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return user.getSchoolId();
        } else {
            return null;
        }
    }

    public Long unsubscribeFromSchool(Long userId, Long schoolId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return user.getSchoolId();
        } else {
            return null;
        }
    }
}
