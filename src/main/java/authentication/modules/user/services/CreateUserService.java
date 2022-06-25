package authentication.modules.user.services;

import authentication.modules.user.entities.User;
import authentication.modules.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateUserService {

  @Autowired
  UserRepository userRepository;

  private BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  public ResponseEntity<User> create(User user) {

    User existsUser = userRepository.findByUsername(user.getUsername());

    if (existsUser != null) {
      throw new RuntimeException("User already exists!");
    }

    user.setPassword(passwordEncoder().encode(user.getPassword()));

    return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
  }

}
