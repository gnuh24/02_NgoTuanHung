package com.vti.Controller;

import com.vti.DTO.AccountDTO;
import com.vti.DTO.DepartmentDTO;
import com.vti.Entity.Department;
import com.vti.Filler.DepartmentFillerForm;
import com.vti.Form.CreatingDepartmentForm;
import com.vti.Form.UpdateDepartmentForm;
import com.vti.Service.IDepartmentService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "api/v1/departments")
@Validated
public class DepartmentController {
    @Autowired
    private IDepartmentService service;

    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    private MessageSource messageSource;

    @GetMapping()

    public Page<DepartmentDTO> getAllDepartments(Pageable pageable,
                                                 @RequestParam(value = "search", required = false) String search,
                                                 DepartmentFillerForm form){

        Page<Department> dpm = service.getAllDepartments(pageable, search, form);

        List<DepartmentDTO> dpmDTO = modelMapper.map(
                dpm.getContent(),
                new TypeToken<List<DepartmentDTO>>() {}.getType() );

        for (DepartmentDTO dto: dpmDTO){
            for (AccountDTO accountDTO : dto.getListOfAccounts()){
                accountDTO.add(linkTo(methodOn(AccountController.class).getAccountById(accountDTO.getId())).withSelfRel());
            }
            dto.add(linkTo(methodOn(DepartmentController.class).findById(dto.getId())).withSelfRel());
        }

        Page<DepartmentDTO> dpmDTOPage = new PageImpl<>(dpmDTO, pageable, dpm.getTotalElements());

        return dpmDTOPage;
    }

    @GetMapping(value = "/name/{name}")
    public Department findByUsername(@PathVariable(name = "name") String username){
        return service.getDepartmentByName(username);
    }

    @GetMapping(value = "/{id}")
    public DepartmentDTO findById(@PathVariable(name = "id") int id){
        Department entities = service.getDepartmentById(id);
        DepartmentDTO dto = modelMapper.map(entities, DepartmentDTO.class);

        dto.add(linkTo(methodOn(DepartmentController.class).findById(id)).withSelfRel());

        return dto ;
    }

    @PostMapping()
    public void createDepartment(@RequestBody @Valid CreatingDepartmentForm form){
        service.createDepartment(form);
    }

    @PutMapping(value = "{id}")
    public void updateDepartment(@PathVariable (name = "id") int id,
                                 @RequestBody @Valid UpdateDepartmentForm form){
        form.setId(id);
        service.updateDepartment(form);
    }

}
