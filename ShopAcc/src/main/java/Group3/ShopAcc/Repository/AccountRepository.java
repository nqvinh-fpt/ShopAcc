package Group3.ShopAcc.Repository;

import Group3.ShopAcc.Entity.AccountGame;
import org.springframework.data.jpa.repository.JpaRepository;
import Group3.ShopAcc.Entity.Account;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    Optional<Account> findByUsername(String username);
}
