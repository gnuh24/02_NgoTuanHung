package com.example.FinalExam.Controller;

import com.example.FinalExam.Entity.Lego.Lego;
import com.example.FinalExam.Service.Lego.ILegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/lego")
public class LegoController {
    @Autowired
    private ILegoService service;

    @GetMapping()
    public Page<Lego> getAllLego(Pageable pageable){
        return service.getAllLego(pageable);

    }
}
