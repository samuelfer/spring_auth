package authentication.modules.user;

import authentication.modules.user.dto.CreateUserRoleDTO;
import authentication.modules.user.services.CreateRoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import authentication.modules.user.entities.User;
import authentication.modules.user.services.CreateUserService;

import java.util.Arrays;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  CreateUserService createUserService;
  @Autowired
  CreateRoleUserService createRoleUserService;

  @PostMapping("/create")
  public ResponseEntity<User> create(@RequestBody User user) {
    try {
      return createUserService.create(user);
    } catch (Exception e) {
      return new ResponseEntity(Arrays.asList(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping("/role/create")
  public ResponseEntity<User> createUserRole(@RequestBody CreateUserRoleDTO createUserRoleDTO) {
    try {
      return createRoleUserService.create(createUserRoleDTO);
    } catch (Exception e) {
      return new ResponseEntity(Arrays.asList(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
  }

}
