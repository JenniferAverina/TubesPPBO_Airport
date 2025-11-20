package tubes.controllers;

import java.util.List;

import tubes.models.User;
import tubes.repositories.UserRepository;

public class UserController {
    private UserRepository userRepository;

    public UserController() {
        this.userRepository = new UserRepository();
    }

    public List<User> getUserAcc() {
        return userRepository.getUser();
    }
}