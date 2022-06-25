package authentication.modules.user.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import authentication.modules.user.dto.CreateUserRoleDTO;
import authentication.modules.user.entities.Role;
import authentication.modules.user.entities.User;
import authentication.modules.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateRoleUserService {

  @Autowired
  UserRepository userRepository;

  public ResponseEntity<User> create(CreateUserRoleDTO createUserRoleDTO) {

    Optional<User> userExists = userRepository.findById(createUserRoleDTO.getUserId());
    List<Role> roles = new ArrayList<>();

    if (userExists.isEmpty()) {
      throw new Error("User does not exists!");
    }

    roles = createUserRoleDTO.getRolesIds().stream().map(role -> {
      return new Role(role);
    }).collect(Collectors.toList());

    User user = userExists.get();

    user.setRoles(roles);

    return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);

  }
}
