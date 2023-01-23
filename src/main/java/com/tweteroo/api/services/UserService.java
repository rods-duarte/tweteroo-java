package com.tweteroo.api.services;

import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.exceptions.InvalidUserAvatarException;
import com.tweteroo.api.models.User;
import com.tweteroo.api.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    
    public void create(User user) {

        validateAvatarOrFail(user.getAvatar());

        repository.save(user);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    private void validateAvatarOrFail(String avatar) {
        try {
            URL url = new URL(avatar);
            url.openConnection();
        } catch (Exception e) {
            System.out.println(e);
            throw new InvalidUserAvatarException("avatar should be a valid url.");
        }
    }
}
