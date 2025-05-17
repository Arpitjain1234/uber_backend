package com.example.uber.services;
import com.example.uber.entity.User;
import com.example.uber.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userRegistration")
public class UserRegistrationServiceImpl implements RegistrationService<User> {

    private  final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserRegistrationServiceImpl(UserRepository userRepository,BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(User user, String password) {
        String hashedPassword = passwordEncoder.encode(password);
        user.setPassword(hashedPassword);
        userRepository.save(user);
    }
}

