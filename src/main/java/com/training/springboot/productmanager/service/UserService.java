package com.training.springboot.productmanager.service;

import com.training.springboot.productmanager.config.CustomUserDetails;
import com.training.springboot.productmanager.entity.User;
import org.hibernate.service.NullServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = findUserByName(userName);
        if (user == null) {
            throw new UsernameNotFoundException(userName);
        }
        return new CustomUserDetails(user);
    }

    public static List<User> users() {
        List<User> users = new ArrayList<>();
        User user = new User((long) 1, "datlb", "123456");
        User user1 = new User((long) 1, "datlb1", "123456");
        User user2 = new User((long) 1, "datlb2", "123456");
        User user3 = new User((long) 1, "datlb3", "123456");
        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        return users;
    }

    public static User findUserByName(String userName) {
        for (User u : users()) {
            if (u.getUsername().equals(userName)) {
                return u;
            } else {
                return null;
            }
        }
        return null;
    }
}
