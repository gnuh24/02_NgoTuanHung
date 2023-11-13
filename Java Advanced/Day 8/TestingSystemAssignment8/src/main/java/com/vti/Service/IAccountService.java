package com.vti.Service;

import com.vti.Entity.Account;
import com.vti.Filler.AccountFillerForm;
import com.vti.Form.CreatingAccountForm;
import com.vti.Form.UpdateAccountForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAccountService {
    public Page<Account> getAllAccounts(Pageable pageable, String search, AccountFillerForm form) throws Exception;

    public Account findByUsername(String username);

    public Account findById(int id);

    public void createAccount(CreatingAccountForm form);

    public void updateAccount(UpdateAccountForm form);

}
