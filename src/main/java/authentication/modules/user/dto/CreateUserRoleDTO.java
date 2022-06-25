package authentication.modules.user.dto;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class CreateUserRoleDTO {

  private UUID userId;

  private List<UUID> RolesIds;

}
