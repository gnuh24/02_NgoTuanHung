package com.example.FinalExam.Controller;

import com.example.FinalExam.Entity.Lego.Lego;
import com.example.FinalExam.Form.Lego.LegoCreateForm;
import com.example.FinalExam.Form.Lego.LegoFillerForm;
import com.example.FinalExam.Form.Lego.LegoUpdateForm;
import com.example.FinalExam.Service.Lego.ILegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "api/v1/lego")
@Validated
@CrossOrigin(origins = "*")

public class LegoController {
    @Autowired
    private ILegoService service;

    @GetMapping()
    public Page<Lego> getAllLego(
            Pageable pageable,
            @RequestParam (value = "search", required = false) String search,
            LegoFillerForm form){
        return service.getAllLego(pageable, search, form);

    }

    @PostMapping()
    public void createLego(@RequestBody @Valid LegoCreateForm form){
        service.createLego(form);
    }

    @PutMapping("/{id}")
    public void updateLego(@PathVariable (name = "id") int id
            , @RequestBody @Valid LegoUpdateForm form){
        form.setId(id);
        service.updateLego(form);
    }

    @DeleteMapping("/{id}")
    public void deleteLego(@PathVariable (name = "id") int id){
        service.deleteLego(id);
    }
}
