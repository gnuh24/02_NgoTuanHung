package com.example.FinalExam.Service.Lego;

import com.example.FinalExam.Entity.Lego.Lego;
import com.example.FinalExam.Repository.ILegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LegoService implements ILegoService {
    @Autowired
    private ILegoRepository repository;
    public Page<Lego> getAllLego(Pageable pageable){
        return repository.findAll(pageable);
    }

}
