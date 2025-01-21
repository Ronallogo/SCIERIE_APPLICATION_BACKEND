package com.scierie_application.scierie.societe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

 

@RestController
@RequestMapping(value = "/api/auth/scierie/societe")
@CrossOrigin("*")
public class SocieteController {
    @Autowired
    private SocieteService societeService;




    @PostMapping(value = "/create" , produces = "application/json" , consumes = "application/json")
    public SocieteDTO1 create(@RequestBody SocieteDTO1 s) {
        return this.societeService.create(s);

    }


    @GetMapping("/all")
    public List<SocieteDTO1> getAllSociete( ) {
        return  this.societeService.readAll();
    }

    @PutMapping("/path")
    public SocieteDTO1 putMethodName(@RequestBody SocieteDTO1 entity) {
        return this.societeService.edit(entity);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return this.societeService.delete(id);
    }
    

}
