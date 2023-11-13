package com.vti.Repository;

import com.vti.Entity.Account;
import com.vti.Entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Integer> {
    public Account findByUsername(String username);

    Page<Account> findAll(Specification<Account> specification, Pageable pageable);
}
