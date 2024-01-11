package jobapplication.service;

import jobapplication.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    User createUser(String username, String password, User.UserType userType);

    User updateUser(Long id, String username, String password, User.UserType userType);

    User deleteUser(Long id);

    // Add additional methods as needed
}
