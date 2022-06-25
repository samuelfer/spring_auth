package authentication.modules.user.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import authentication.modules.user.entities.User;

public interface UserRepository extends JpaRepository<User, UUID> {

  User findByUsername(String username);

}
