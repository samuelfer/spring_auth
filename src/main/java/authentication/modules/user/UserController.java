package authentication.modules.user;

import authentication.modules.user.dto.CreateUserRoleDTO;
import authentication.modules.user.services.CreateRoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import authentication.modules.user.entities.User;
import authentication.modules.user.services.CreateUserService;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  CreateUserService createUserService;
  @Autowired
  CreateRoleUserService createRoleUserService;

  @PostMapping("/create")
  public User create(@RequestBody User user) {
    return createUserService.create(user);
  }

  @PostMapping("/role")
  public User createUserRole(@RequestBody CreateUserRoleDTO createUserRoleDTO) {
    return createRoleUserService.create(createUserRoleDTO);
  }

}
