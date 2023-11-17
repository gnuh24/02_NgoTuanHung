package com.example.FinalExam.Repository;

import com.example.FinalExam.Entity.Account.Account;
import com.example.FinalExam.Entity.Lego.Lego;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface ILegoRepository extends JpaRepository<Lego, Integer>, JpaSpecificationExecutor<Lego> {
    public Page<Lego> findAll(Pageable pageable);

}
