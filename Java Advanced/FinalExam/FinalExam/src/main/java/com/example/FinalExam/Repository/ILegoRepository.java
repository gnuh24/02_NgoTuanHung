package com.example.FinalExam.Repository;

import com.example.FinalExam.Entity.Lego.Lego;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ILegoRepository extends JpaRepository<Lego, Integer> {
    public Page<Lego> findAll(Pageable pageable);

}
