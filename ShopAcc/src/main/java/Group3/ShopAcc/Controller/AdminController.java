package Group3.ShopAcc.Controller;

import Group3.ShopAcc.Dto.*;
import Group3.ShopAcc.Entity.Account;
import Group3.ShopAcc.Entity.AccountGame;
import Group3.ShopAcc.Entity.Product;
import Group3.ShopAcc.Entity.Role;
import Group3.ShopAcc.Service.AdminServiceImpl;
import Group3.ShopAcc.Service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin-page")
public class AdminController {
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
}
