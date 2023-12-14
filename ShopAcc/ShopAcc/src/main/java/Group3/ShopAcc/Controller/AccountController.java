package Group3.ShopAcc.Controller;

import Group3.ShopAcc.Entity.Account;
import Group3.ShopAcc.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;
    @GetMapping("/accounts")
    public List<Account> getAllAccount(){
        return accountRepository.findAll();
    }
}
