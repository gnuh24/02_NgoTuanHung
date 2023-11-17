package com.example.FinalExam.Service.Lego;

import com.example.FinalExam.Entity.Lego.Lego;
import com.example.FinalExam.Form.Lego.LegoFillerForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ILegoService {
    public Page<Lego> getAllLego(Pageable pageable, String search, LegoFillerForm form);



}
