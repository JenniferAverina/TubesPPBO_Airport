package tubes.controllers;

import java.util.List;

import tubes.models.User;
import tubes.repositories.UserRepository;
import tubes.utils.UtilHashing;

public class UserController {
    private User user;
    private UserRepository userRepository;

    public UserController(User user) {
        this.user = user;
        this.userRepository = new UserRepository();
    }

    public List<User> getUserAcc() {
        return userRepository.getUser();
    }

    public User loginVerification(String adminID, String password) {
        List<User> users = getUserAcc();
        for (User user : users) {
            // Seharusnya getAdminID
            if (user.getNik().equals(adminID)) {
                String salt = UtilHashing.generateSalt();
                if(UtilHashing.verifyPassword(password, salt, user.getPassword())) {
                    return user;
                }
            }
        }
        return null;
    }
}