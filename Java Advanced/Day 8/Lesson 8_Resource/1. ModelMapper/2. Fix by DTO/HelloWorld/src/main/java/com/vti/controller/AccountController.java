package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.AccountDTO;
import com.vti.entity.Account;
import com.vti.service.IAccountService;

@RestController
@RequestMapping(value = "api/v1/accounts")
public class AccountController {

	@Autowired
	private IAccountService service;

	@GetMapping()
	public List<AccountDTO> getAllAccounts() {

		List<Account> entities = service.getAllAccounts();

		// convert entities --> dtos
		List<AccountDTO> dtos = new ArrayList<>();
		for (Account entity : entities) {
			AccountDTO dto = new AccountDTO(entity.getUsername(), entity.getDepartment().getName());
			dtos.add(dto);
		}

		return dtos;
	}

	@GetMapping(value = "/{id}")
	public AccountDTO getAccountByID(@PathVariable(name = "id") int id) {

		Account entity = service.getAccountByID(id);

		// convert entity to dto
		AccountDTO dto = new AccountDTO(entity.getUsername(), entity.getDepartment().getName());

		return dto;
	}

}
