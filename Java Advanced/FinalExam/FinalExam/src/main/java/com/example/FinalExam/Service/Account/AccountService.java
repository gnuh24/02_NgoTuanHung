package com.example.FinalExam.Service.Account;

import com.example.FinalExam.Entity.Account.Account;
import com.example.FinalExam.Form.Account.AccountFillerForm;
import com.example.FinalExam.Repository.IAccountRepository;
import com.example.FinalExam.Specification.Account.AccountSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepository repository;

    public Page<Account> getAllAccount(Pageable pageable, String search, AccountFillerForm form){

        Specification<Account> where = AccountSpecification.buildWhere(search, form);
        return repository.findAll(where , pageable);
    }

}
