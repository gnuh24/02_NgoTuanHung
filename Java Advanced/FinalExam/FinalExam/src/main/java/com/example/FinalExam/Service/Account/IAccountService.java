package com.example.FinalExam.Service.Account;

import com.example.FinalExam.Entity.Account.Account;
import com.example.FinalExam.Form.Account.AccountFillerForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAccountService {

    public Page<Account> getAllAccount(Pageable pageable, String search, AccountFillerForm form);


    }
