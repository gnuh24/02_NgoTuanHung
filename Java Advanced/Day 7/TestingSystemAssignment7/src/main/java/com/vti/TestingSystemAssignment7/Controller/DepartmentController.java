package com.vti.TestingSystemAssignment7.Controll;

import com.vti.TestingSystemAssignment7.Entity.Department;
import com.vti.TestingSystemAssignment7.Form.DepartmentForm;
import com.vti.TestingSystemAssignment7.Service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "api/v1/departments")
public class DepartmentControll {

    @Autowired
    private IDepartmentService service;


    @GetMapping()
    public List<Department> getAllDepartment(){

        return  service.getAllDepartment();
    }

    @GetMapping(value = "/{id}")
    public Department getDepartmentByID(@PathVariable(name = "id") short id){
        return service.getDepartmentByID(id);
    }

    @GetMapping(value = "name/{name}")
    public Department getDertpartByName (@PathVariable(name = "name") String name){
        return service.getDertpartByName(name);
    }

    @PostMapping()

    public void createDepartment (@RequestBody DepartmentForm department){
        service.createDepartment(department.toEntity());
    }

    @PutMapping("/{id}")
    public void updateDepartment (@PathVariable(name = "id") short id, @RequestBody DepartmentForm department){
        service.updateDepartment(department.toEntity());
    }

//    public void updateDepartment(short id, String name){
//        Department department = new Department();
//        department.setId(id);
//        department.setName(name);
//        repository.save(department);
//    }
    @DeleteMapping(value = "/{id}")
    public void deleteDepartment(@PathVariable(name = "id") short id)
    {
        service.deleteDepartment(id);

    }


    public boolean isDepartmentExistsByID(short id){
        return  service.isDepartmentExistsByID(id);
    }

    public boolean isDepartmentExistsByName(String name){
        return service.isDepartmentExistsByName(name);
    }



}
