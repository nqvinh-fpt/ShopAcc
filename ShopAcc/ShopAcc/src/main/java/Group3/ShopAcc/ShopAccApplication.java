package Group3.ShopAcc;


import Group3.ShopAcc.Entity.Product;
import Group3.ShopAcc.Repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class ShopAccApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopAccApplication.class, args);
	}

}
