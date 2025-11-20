package tubes.controllers;

import java.util.List;

import tubes.models.User;
import tubes.utils.UtilHashing;

public class AdminController {
    private UserController userController;
    
    public AdminController() {
        this.userController = new UserController();
    }
    
    public User loginVerification(String email, String password) {
        List<User> users = userController.getUserAcc();
        for (User user : users) {
            // Seharusnya getAdminID
            if (user.getEmail().equals(email)) {
                String salt = UtilHashing.generateSalt();
                if(UtilHashing.verifyPassword(password, salt, user.getPassword())) {
                    return user;
                }
            }
        }
        return null;
    }
}
