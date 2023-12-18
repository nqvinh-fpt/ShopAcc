package Group3.ShopAcc.Repository;

import Group3.ShopAcc.Dto.AccountDto;
import Group3.ShopAcc.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Account,Integer> {
}
