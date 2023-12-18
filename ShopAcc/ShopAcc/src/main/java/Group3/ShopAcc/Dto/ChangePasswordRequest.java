package Group3.ShopAcc.Dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ChangePasswordRequest {
    private String currentPassword;
    private String newPassword;
    private String confirmPassword;
}
