//package com.myproj.JobCrud.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.myproj.JobCrud.model.User;
//import com.myproj.JobCrud.repository.UserRepository;
//
//@Service
//public class UserService {
//   @Autowired
//   private UserRepository userRepository;
//
//   @Autowired
//   private PasswordEncoder passwordEncoder;
//
//   public User registerUser(User user) {
//      user.setPassword(passwordEncoder.encode(user.getPassword()));
//      return userRepository.save(user);
//   }
//
//   public User findByEmail(String email) {
//      return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
//   }
//}


package com.myproj.JobCrud.service;


import com.myproj.JobCrud.model.User;
import com.myproj.JobCrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Register a new user
    public void registerUser(User user) {
        // Encrypt the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    // Load user by username (for authentication)
    public User loadUserByUsername(String username) {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
