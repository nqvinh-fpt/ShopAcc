package Group3.ShopAcc.Dto;

import jakarta.persistence.Column;
import lombok.*;
import org.hibernate.annotations.ColumnTransformer;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private int AccountID;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String currency;
    private String status;
    private String roleID;
}
