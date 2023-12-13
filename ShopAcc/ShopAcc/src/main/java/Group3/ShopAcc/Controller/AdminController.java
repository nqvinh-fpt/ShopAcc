package Group3.ShopAcc.Controller;

import Group3.ShopAcc.Dto.AccountDto;
import Group3.ShopAcc.Entity.Account;
import Group3.ShopAcc.Entity.AccountGame;
import Group3.ShopAcc.Entity.Product;
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
@RequestMapping("api/v1/admin")
public class AdminController {
    public final AdminServiceImpl adminService;
    @GetMapping("/list-user")
    public ResponseEntity<List<AccountDto>> getAllUse(){
        assert adminService != null;
        final List<AccountDto> listAccount = adminService.listAllUse();
        return ResponseEntity.status(HttpStatus.OK).body(listAccount);
    }
    @GetMapping("/list-account-game")
    public ResponseEntity<List<AccountGame>> getAllAccountGame(){
        assert adminService != null;
        final List<AccountGame> listAccountGame = adminService.listAllAccountGame();
        return ResponseEntity.status(HttpStatus.OK).body(listAccountGame);
    }
}
