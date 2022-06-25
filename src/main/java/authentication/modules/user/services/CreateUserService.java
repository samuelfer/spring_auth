package authentication.modules.user.services;

import authentication.modules.user.entities.User;
import authentication.modules.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {

  @Autowired
  UserRepository userRepository;

  public User create(User user) {

    User existsUser = userRepository.findByUsername(user.getUsername());

    if (existsUser != null) {
      throw new Error("User already exists!");
    }

    User createdUser = userRepository.save(user);

    return createdUser;
  }

}
