package Group3.ShopAcc.Service;

import Group3.ShopAcc.Dto.AccountDto;
import Group3.ShopAcc.Dto.ProductDto;
import Group3.ShopAcc.Entity.*;
import Group3.ShopAcc.Repository.AccountGameRepository;
import Group3.ShopAcc.Repository.CategoryRepository;
import Group3.ShopAcc.Repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Component
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository ;
    @Autowired
    CategoryRepository categoryRepository ;

    @Autowired
    AccountGameRepository accountGameRepository ;

    @Override
    public List<ProductDto> listAllProduct() {
        List<Product> productList = productRepository.findAll();
        List<Category> categoriList = categoryRepository.findAll();
        List<AccountGame> accountGames = accountGameRepository.findAll();
        List<ProductDto> productDtoList=new ArrayList<>();
        for (Product product : productList) {
            String categoriName = null;
            for (Category category : categoriList) {
                if (product.getCategoryID() == category.getCategoryID()) {
                    categoriName = category.getCategoryName();
                }
            }
            String accountGameName = null;
            String accountPassword = null;
            for(AccountGame accountGame:accountGames){
                if (product.getAccountGameID() == accountGame.getAccountGameID()) {
                    accountGameName = accountGame.getUserName();
                    accountPassword = accountGame.getPassword();
                }
            }
            ProductDto productDto = new ProductDto(product.getProductID(),
                    product.getImg(),
                    product.getRank(),
                    product.getSkin(),
                    product.getLegend(),
                    product.getSpiritAnimal(),
                    product.getArena(),
                    product.getPrice(),
                    product.getStatus(),
                    product.getCategoryID(),
                    product.getAccountGameID(),
                    product.getAccountID(),
                    categoriName,
                    accountGameName,
                    accountPassword);

            productDtoList.add(productDto);

        }
        return productDtoList;
    }

    @Override
    public List<ProductDto> listAllProductByID(int productID) {
        Product product = productRepository.findById(productID)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with ID: " + productID));

        Category category = categoryRepository.findById(product.getCategoryID())
                .orElseThrow(() -> new EntityNotFoundException("Category not found with ID: " + product.getCategoryID()));

        AccountGame accountGame = accountGameRepository.findById(product.getAccountGameID())
                .orElseThrow(() -> new EntityNotFoundException("AccountGame not found with ID: " + product.getAccountGameID()));
        List<ProductDto> productDetail=new ArrayList<>();
        ProductDto productDto = new ProductDto(
                product.getProductID(),
                product.getImg(),
                product.getRank(),
                product.getSkin(),
                product.getLegend(),
                product.getSpiritAnimal(),
                product.getArena(),
                product.getPrice(),
                product.getStatus(),
                product.getCategoryID(),
                product.getAccountGameID(),
                product.getAccountID(),
                category.getCategoryName(),
                accountGame.getUserName(),
                accountGame.getPassword()
        );
        productDetail.add(productDto);
        return productDetail;
    }




}
