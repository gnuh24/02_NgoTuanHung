package com.example.FinalExam.Service.Lego;

import com.example.FinalExam.Entity.Lego.Lego;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ILegoService {
    public Page<Lego> getAllLego(Pageable pageable);

}
