package tubes.controllers;

import tubes.models.User;
import tubes.repositories.UserRepository;

public class UserController {
    private User user;
    private UserRepository userRepository;

    public UserController(User user) {
        this.user = user;
        this.userRepository = new UserRepository();
    }

    public User getUserLogin(String adminID, String password) {
        return userRepository.getUserLogin(adminID, password);
    }
}