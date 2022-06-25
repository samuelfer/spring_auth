package authentication.modules.user;

import authentication.modules.user.dto.CreateUserRoleDTO;
import authentication.modules.user.services.RoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import authentication.modules.user.entities.User;
import authentication.modules.user.services.UserService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  UserService userService;
  @Autowired
  RoleUserService roleUserService;

  @GetMapping
  public List<User> listAll() {
    return userService.listAll();
  }

  @PostMapping("/create")
  public ResponseEntity<User> save(@RequestBody User user) {
    try {
      return userService.save(user);
    } catch (Exception e) {
      return new ResponseEntity(Arrays.asList(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping("/role/create")
  public ResponseEntity<User> saveUserRole(@RequestBody CreateUserRoleDTO createUserRoleDTO) {
    try {
      return roleUserService.save(createUserRoleDTO);
    } catch (Exception e) {
      return new ResponseEntity(Arrays.asList(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
  }

}
