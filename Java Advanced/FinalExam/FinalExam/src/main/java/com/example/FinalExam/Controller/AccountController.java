package com.example.FinalExam.Controller;

import com.example.FinalExam.Entity.Account.Account;
import com.example.FinalExam.Form.Account.AccountFillerForm;
import com.example.FinalExam.Service.Account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/accounts")
public class AccountController {
    @Autowired
    private IAccountService service;
    @GetMapping()
    public Page<Account> getAllAccount(
            Pageable pageable,
            @RequestParam(value = "search", required = false)  String search,
            AccountFillerForm form){

        return service.getAllAccount(pageable, search, form);
    }
}
