package Group3.ShopAcc.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Role")
public class Role {
    @Id
    private int roleID;

    @Column(name = "roleName")
    private String roleName;
}
