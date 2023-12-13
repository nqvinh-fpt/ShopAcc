package Group3.ShopAcc.Service;

import Group3.ShopAcc.Dto.AccountDto;
import Group3.ShopAcc.Entity.Account;
import Group3.ShopAcc.Entity.AccountGame;

import java.util.List;

public interface AdminService {
    List<AccountDto> listAllUse();
    List<AccountGame> listAllAccountGame();
}
