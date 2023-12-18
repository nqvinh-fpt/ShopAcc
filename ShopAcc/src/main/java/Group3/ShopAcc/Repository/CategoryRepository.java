package Group3.ShopAcc.Repository;

import Group3.ShopAcc.Entity.Account;
import Group3.ShopAcc.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
