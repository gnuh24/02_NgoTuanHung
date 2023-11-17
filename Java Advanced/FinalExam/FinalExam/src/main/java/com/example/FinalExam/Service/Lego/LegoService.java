package com.example.FinalExam.Service.Lego;

import com.example.FinalExam.Entity.Lego.Lego;
import com.example.FinalExam.Form.Lego.LegoCreateForm;
import com.example.FinalExam.Form.Lego.LegoFillerForm;
import com.example.FinalExam.Form.Lego.LegoUpdateForm;
import com.example.FinalExam.Repository.ILegoRepository;
import com.example.FinalExam.Specification.Lego.LegoSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LegoService implements ILegoService {
    @Autowired
    private ILegoRepository repository;

    @Autowired
    private ModelMapper modelMapper;


    public Page<Lego> getAllLego(Pageable pageable, String search, LegoFillerForm form){
        Specification<Lego> where = LegoSpecification.buildWhere(search, form);

        return repository.findAll(where, pageable);
    }

    @Transactional
    public void createLego(LegoCreateForm form){
        Lego lego = modelMapper.map(form, Lego.class);
        repository.save(lego);

    }

    @Transactional
    public void updateLego(LegoUpdateForm form){
        Lego lego = modelMapper.map(form, Lego.class);
        lego.setCreateDate(repository.findById(form.getId()).get().getCreateDate());
        repository.save(lego);
    }

    @Transactional
    public void deleteLego(int id){
        repository.deleteById(id);
    }



}
