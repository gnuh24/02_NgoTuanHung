package com.vti.Service;

import com.vti.Entity.Account;
import com.vti.Filler.AccountFillerForm;
import com.vti.Form.CreatingAccountForm;
import com.vti.Form.CreatingDepartmentForm;
import com.vti.Form.UpdateAccountForm;
import com.vti.Repository.IAccountRepository;
import com.vti.Specification.AccountSpecification;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService implements IAccountService{
    @Autowired
    private IAccountRepository repository;

    @Autowired
    private ModelMapper modelMapper;


    public Page<Account> getAllAccounts(Pageable pageable, String search, AccountFillerForm form) throws Exception{
        if (isValidPageable(pageable)){
            Specification<Account> where = AccountSpecification.buildWhere(search, form);

            return repository.findAll(where, pageable);
        }
        else {
            throw new Exception("Bạn phải để size và pageNumber hợp lệ !!");
        }

    }

    public Account findByUsername(String username){
        return repository.findByUsername(username);
    }

    public Account findById(int id){
        return repository.findById(id).get();
    }

    public void createAccount(CreatingAccountForm form){
        TypeMap<CreatingAccountForm, Account> typeMap = modelMapper.getTypeMap(CreatingAccountForm.class, Account.class);
        if (typeMap == null){
            modelMapper.addMappings(new PropertyMap<CreatingAccountForm, Account>() {
                @Override
                protected void configure(){
                    skip(destination.getId());
                }
            });
        }
        Account account = modelMapper.map(form, Account.class);
        repository.save(account);
    }

    public void updateAccount(UpdateAccountForm form){
        TypeMap<UpdateAccountForm, Account> typeMap = modelMapper.getTypeMap(UpdateAccountForm.class, Account.class);
        if (typeMap == null){
            modelMapper.addMappings(new PropertyMap<CreatingAccountForm, Account>() {
                @Override
                protected void configure(){
                    skip(destination.getId());
                }
            });
        }
        Account account = modelMapper.map(form, Account.class);
        repository.save(account);
    }



    private boolean isValidPageable(Pageable pageable){
        if (pageable.getPageNumber() < 1){
            return false;
        }

        if (5 > pageable.getPageSize() || pageable.getPageSize() > 20){
            return false;
        }
        return true;
    }


}
