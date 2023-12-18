package Group3.ShopAcc.Repository;

import Group3.ShopAcc.Entity.Account;
import Group3.ShopAcc.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Modifying
    @Query(value = "SELECT * FROM shopacc.product;",nativeQuery = true)
    List<Product> listAllProduct();
}
