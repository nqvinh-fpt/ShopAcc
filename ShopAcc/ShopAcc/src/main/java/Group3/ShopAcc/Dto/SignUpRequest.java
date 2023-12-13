package Group3.ShopAcc.Dto;

import Group3.ShopAcc.Entity.RoleName;
import lombok.Data;

@Data
public class SignUpRequest {
    private String username;
    private String password;
    private RoleName roleName;
}
