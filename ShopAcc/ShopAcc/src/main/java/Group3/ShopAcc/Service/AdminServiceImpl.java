package Group3.ShopAcc.Service;

import Group3.ShopAcc.Dto.AccountDto;
import Group3.ShopAcc.Entity.Account;
import Group3.ShopAcc.Entity.AccountGame;
import Group3.ShopAcc.Entity.Role;
import Group3.ShopAcc.Entity.RoleName;
import Group3.ShopAcc.Repository.AccountGameRepository;
import Group3.ShopAcc.Repository.AccountRepository;
import Group3.ShopAcc.Repository.AdminRepository;
import Group3.ShopAcc.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Component
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository ;
    @Autowired
    AccountGameRepository accountGameRepository;
    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<AccountDto> listAllUse() {
        List<Account> accountList = adminRepository.findAll();
        List<Role> roleList = roleRepository.findAll();
        List<AccountDto> accountDtoList=new ArrayList<>();
        for (Account account : accountList) {
            String roleName = null;
            for (Role role : roleList) {
                int roleID = account.getRoleID() == RoleName.USER ? 0 : 1;
                if (roleID == role.getRoleID()) {
                    roleName = role.getRoleName();
                }
            }
            AccountDto accountDto = new AccountDto(account.getAccountID(),
                    account.getUsername(),
                    account.getPassword(),
                    account.getPhone(),
                    account.getEmail(),
                    account.getCurrency(),
                    account.getStatus(),
                    roleName);

            accountDtoList.add(accountDto);

        }
        return accountDtoList;
    }

    public List<Role>listAllRole(){
        return roleRepository.findAll();
    }
    @Override
    public List<AccountGame> listAllAccountGame() {
        return accountGameRepository.findAll();
    }
}