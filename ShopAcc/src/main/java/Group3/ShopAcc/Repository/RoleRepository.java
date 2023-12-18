package Group3.ShopAcc.Repository;

import Group3.ShopAcc.Entity.Account;
import Group3.ShopAcc.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
