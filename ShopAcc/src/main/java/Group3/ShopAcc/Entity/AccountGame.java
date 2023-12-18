package Group3.ShopAcc.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Entity
@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Account_Game")
public class AccountGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccountGameID")
    private int AccountGameID;
    @Column(name = "userName")
    private String userName;
    @Column(name = "password")
    private String password;
}
