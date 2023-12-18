package Group3.ShopAcc.Controller;

import Group3.ShopAcc.Dto.*;
import Group3.ShopAcc.Entity.*;
import Group3.ShopAcc.Repository.*;
import Group3.ShopAcc.Service.AdminServiceImpl;
import Group3.ShopAcc.Service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {
    @Autowired
    ProductRepository productRepository ;
    @Autowired
    AdminRepository adminRepository ;
    @Autowired
    RoleRepository roleRepository ;

    @Autowired
    AccountGameRepository accountGameRepository ;
    @Autowired
    CategoryRepository categoryRepository ;
    public final AdminServiceImpl adminService;
    public final ProductServiceImpl productService;
    @GetMapping("/list-user")
    public ResponseEntity<List<AccountDto>> getAllUse(){
        assert adminService != null;
        final List<AccountDto> listAccount = adminService.listAllUse();
        return ResponseEntity.status(HttpStatus.OK).body(listAccount);
    }
    @GetMapping("/list-account-game")
    public ResponseEntity<List<AccountGameDto>> getAllAccountGame(){
        assert adminService != null;
        final List<AccountGameDto> listAccountGame = adminService.listAllAccountGame();
        return ResponseEntity.status(HttpStatus.OK).body(listAccountGame);
    }
    @GetMapping("/list-category")
    public ResponseEntity<List<CategoryDto>> getAllCategory(){
        assert adminService != null;
        final List<CategoryDto> listCategory = adminService.listAllCategory();
        return ResponseEntity.status(HttpStatus.OK).body(listCategory);
    }
    @GetMapping("/list-role-account")
    public ResponseEntity<List<Role>> getAllRole(){
        assert adminService != null;
        final List<Role> listRole = adminService.listAllRole();
        return ResponseEntity.status(HttpStatus.OK).body(listRole);
    }

    @GetMapping("/list-product")
    public ResponseEntity<List<ProductDto>> getAllProduct(){
        assert productService != null;
        final List<ProductDto> listProduct = productService.listAllProduct();
        return ResponseEntity.status(HttpStatus.OK).body(listProduct);
    }

    @PostMapping("/add-product")
    public ResponseEntity<?> addProduct(@RequestBody Product productRequest){
        productRepository.save(productRequest);
        return ResponseEntity.status(HttpStatus.OK).body(productRequest);
    }
    @PostMapping("/add-category")
    public ResponseEntity<?> addCategory(@RequestBody Category categoryRequest){
        categoryRepository.save(categoryRequest);
        return ResponseEntity.status(HttpStatus.OK).body(categoryRequest);
    }

    @PostMapping("/add-account-game")
    public ResponseEntity<?> addAccountGame(@RequestBody AccountGame categoryRequest){
        accountGameRepository.save(categoryRequest);
        return ResponseEntity.status(HttpStatus.OK).body(categoryRequest);
    }

    @PostMapping("/update-product")
    public ResponseEntity<?> updateAccountGame(@RequestBody Product productRequest){
        productRepository.save(productRequest);
        return ResponseEntity.status(HttpStatus.OK).body(productRequest);
    }
    @PostMapping("/update-category")
    public ResponseEntity<?> updateCategory(@RequestBody Category categoryRequest){
        categoryRepository.save(categoryRequest);
        return ResponseEntity.status(HttpStatus.OK).body(categoryRequest);
    }
    @PostMapping("/update-account-game")
    public ResponseEntity<?> updateAccountGame(@RequestBody AccountGame accountGameRequest){
        accountGameRepository.save(accountGameRequest);
        return ResponseEntity.status(HttpStatus.OK).body(accountGameRequest);
    }



}
