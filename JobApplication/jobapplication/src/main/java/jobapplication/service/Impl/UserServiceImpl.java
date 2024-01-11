package jobapplication.service.Impl;

import jobapplication.model.User;
import jobapplication.repository.UserRepository;
import jobapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(String username, String password, User.UserType userType) {
        User user = new User();
        String encodedPassword = passwordEncoder.encode(password);
        user.setUsername(username);
        user.setPassword(encodedPassword);
        user.setUserType(userType);

        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, String username, String password, User.UserType userType) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            String encodedPassword = passwordEncoder.encode(password);
            user.setUsername(username);
            user.setPassword(encodedPassword);
            user.setUserType(userType);

            return userRepository.save(user);
        }

        return null; // or throw an exception if needed
    }

    @Override
    public User deleteUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            userRepository.delete(user);
            return user;
        }

        return null; // or throw an exception if needed
    }

    // Add additional methods or override methods from the interface as needed
}
