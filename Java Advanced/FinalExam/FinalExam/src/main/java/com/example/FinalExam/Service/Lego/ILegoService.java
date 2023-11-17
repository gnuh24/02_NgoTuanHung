package com.example.FinalExam.Service.Lego;

import com.example.FinalExam.Entity.Lego.Lego;
import com.example.FinalExam.Form.Lego.LegoCreateForm;
import com.example.FinalExam.Form.Lego.LegoFillerForm;
import com.example.FinalExam.Form.Lego.LegoUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ILegoService {
    public Page<Lego> getAllLego(Pageable pageable, String search, LegoFillerForm form);

    public void createLego(LegoCreateForm form);

    public void updateLego(LegoUpdateForm form);

    public void deleteLego(int id);


    }
