package Group3.ShopAcc.Service;

import Group3.ShopAcc.Dto.AccountDto;
import Group3.ShopAcc.Dto.AccountGameDto;
import Group3.ShopAcc.Dto.CategoryDto;
import Group3.ShopAcc.Entity.*;
import Group3.ShopAcc.Repository.*;
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

    @Autowired
    CategoryRepository categoryRepository;

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
    public List<AccountGameDto> listAllAccountGame() {
        List<AccountGame> accountGameList = accountGameRepository.findAll();
        List<AccountGameDto> accountDtoList=new ArrayList<>();
        for (AccountGame accountGame : accountGameList) {
            AccountGameDto accountGameDto = new AccountGameDto(accountGame.getAccountGameID(),
                    accountGame.getUserName(),
                    accountGame.getPassword());

            accountDtoList.add(accountGameDto);

        }

        return accountDtoList;
    }

    @Override
    public List<CategoryDto> listAllCategory() {
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryDto> categoryDtoList=new ArrayList<>();
        for (Category category : categoryList) {
            CategoryDto categoryDto = new CategoryDto(category.getCategoryID(),
                    category.getCategoryName());

            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }
}
