// UserService.java
package com.newsfeed.demo.service;

import com.newsfeed.demo.domain.User;
import com.newsfeed.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long subscribeToSchool(Long Id, Long schoolId) {
        Optional<User> optionalUser = userRepository.findById(Id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            // 여기서 새로운 구독 ID를 반환하거나 적절한 처리를 수행합니다.
            return user.getSchoolId(); // 임시로 사용자의 학교 ID를 반환하도록 수정했습니다.
        }
        return null;
    }

    public boolean unsubscribeFromSchool(Long Id, Long schoolId) {
        Optional<User> optionalUser = userRepository.findById(Id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getSchoolId() != null && user.getSchoolId().equals(schoolId)) {
                user.setSchoolId(null);
                userRepository.save(user);
                return true;
            }
        }
        return false;
    }
}
