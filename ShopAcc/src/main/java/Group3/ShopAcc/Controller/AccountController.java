//package Group3.ShopAcc.Controller;
//
//import Group3.ShopAcc.Config.UserAuthProvider;
//import Group3.ShopAcc.Dto.AccountDto;
//import Group3.ShopAcc.Dto.CredientalDto;
//import Group3.ShopAcc.Entity.Account;
//import Group3.ShopAcc.Repository.AccountRepository;
//import Group3.ShopAcc.Service.AccountService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/test")
//public class AccountController {
//
//    private final AccountService accountService;
//    private final UserAuthProvider userAuthProvider;
//    @Autowired
//    private AccountRepository accountRepository;
//
//    public AccountController(AccountService accountService, UserAuthProvider userAuthProvider, AccountRepository accountRepository) {
//        this.accountService = accountService;
//        this.userAuthProvider = userAuthProvider;
//        this.accountRepository = accountRepository;
//    }
//
//
//    @PostMapping("/login")
//    public ResponseEntity<AccountDto> login(@RequestBody CredientalDto credientalDto){
//            AccountDto accountDto = accountService.login(credientalDto);
//        return ResponseEntity.ok(accountDto);
//    }
//
//    @GetMapping("")
//    public ModelAndView listAccount(Model model){
//        Iterable<Account> accounts = accountRepository.findAll();
//        model.addAttribute("accountList", accounts);
//        return new ModelAndView("list");
//    }
//    @GetMapping("/accounts")
//    public List<Account> getAllAccount(){
//        return accountRepository.findAll();
//    }
//}
