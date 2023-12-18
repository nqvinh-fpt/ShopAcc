package Group3.ShopAcc.Repository;

import Group3.ShopAcc.Entity.Account;
import Group3.ShopAcc.Entity.AccountGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AccountGameRepository extends JpaRepository<AccountGame,Integer> {
}
