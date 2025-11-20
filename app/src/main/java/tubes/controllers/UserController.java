package tubes.controllers;

import java.util.List;

import tubes.models.User;
import tubes.repositories.UserRepository;
import tubes.utils.UtilHashing;

public class UserController {
    private User user;
    private UserRepository userRepository;

    public UserController() {
        // this.user = user;
        this.userRepository = new UserRepository();
    }

    public List<User> getUserAcc() {
        return userRepository.getUser();
    }
}