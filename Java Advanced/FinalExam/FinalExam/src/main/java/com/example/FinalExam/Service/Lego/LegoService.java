package com.example.FinalExam.Service.Lego;

import com.example.FinalExam.Entity.Lego.Lego;
import com.example.FinalExam.Form.Lego.LegoFillerForm;
import com.example.FinalExam.Repository.ILegoRepository;
import com.example.FinalExam.Specification.Lego.LegoSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class LegoService implements ILegoService {
    @Autowired
    private ILegoRepository repository;
    public Page<Lego> getAllLego(Pageable pageable, String search, LegoFillerForm form){
        Specification<Lego> where = LegoSpecification.buildWhere(search, form);

        return repository.findAll(where, pageable);
    }

}
