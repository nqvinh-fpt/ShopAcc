package Group3.ShopAcc.Repository;

import Group3.ShopAcc.Entity.Account;
import Group3.ShopAcc.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    @Query("SELECT r.roleID FROM Role r")
    Integer findAllRoleIDs();
}
