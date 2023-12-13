package Group3.ShopAcc.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleID;
    @Column(name = "roleName")
    private String roleName;

    public Role() {
    }

}
