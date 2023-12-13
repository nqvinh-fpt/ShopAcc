package Group3.ShopAcc.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "Account")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int AccountID;
    @Column(name = "username")
    private String username;
    @ColumnTransformer(write = "SHA2(?, 256)")
    private String password;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "currency")
    private String currency;
    @Column(name = "status")
    private String status;
    @Column(name = "roleID")
    private int roleID;
}
