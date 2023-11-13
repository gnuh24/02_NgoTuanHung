package com.vti.Controller;

import com.vti.DTO.AccountDTO;
import com.vti.Entity.Account;
import com.vti.Filler.AccountFillerForm;
import com.vti.Form.CreatingAccountForm;
import com.vti.Form.UpdateAccountForm;
import com.vti.Service.IAccountService;
import org.modelmapper.TypeToken;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "api/v1/accounts")
@Validated
public class AccountController {
    @Autowired
    private IAccountService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    public Page<AccountDTO> getAllAccounts(Pageable pageable,
                                           @RequestParam(value = "search", required = false) String search,
                                           AccountFillerForm form) throws Exception{

        Page<Account> entities = service.getAllAccounts(pageable, search, form);

        // convert entities --> dtos
        List<AccountDTO> dtos = modelMapper.map(
                entities.getContent(),
                new TypeToken<List<AccountDTO>>() {}.getType());

        Page<AccountDTO> dtosPage = new PageImpl<>(dtos, pageable, entities.getTotalElements());


        return dtosPage;
    }

    @GetMapping(value = "/username/{username}")
    public Account findByUsername( @PathVariable(name = "username") String username){
        return service.findByUsername(username);
    }

    @GetMapping(value = "/{id}")
    public AccountDTO getAccountById(@PathVariable(name = "id") int id){

        Account entities = service.findById(id);
        AccountDTO dto = modelMapper.map(entities, AccountDTO.class);

        dto.add(linkTo(methodOn(AccountController.class).getAccountById(id)).withSelfRel());

        return dto;
    }

    @PostMapping()
    public void createAccount(@RequestBody CreatingAccountForm form){
        service.createAccount(form);
    }

    @PutMapping(value = "/{id}")
    public void updateAccount(@PathVariable (name = "id") int id,
                              @RequestBody UpdateAccountForm form){
        form.setId(id);
        service.updateAccount(form);
    }


}
