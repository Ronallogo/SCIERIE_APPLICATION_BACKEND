package com.scierie_application.scierie.traitement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.transaction.Transactional;

@Service
@Transactional
@RequestMapping("/api/auth/scierie/traitement")
@CrossOrigin("*")
public class TraitementController {


    @Autowired
    private TraitementService ts ;


    @PostMapping(value = "/create", produces = "application/json" , consumes = "application/json")
    public TraitementDTO1 create(TraitementDTO1 t){
        return this.ts.create(t);
    }


    @GetMapping("/all")
    public List<TraitementDTO1> getAllTraitement(){
        return this.ts.getAllTraitement();
    }


    @PutMapping(value = "/edit", produces = "application/json" , consumes = "application/json")
    public TraitementDTO1 edit(TraitementDTO1 t){
        return this.ts.edit(t);
    }


    @DeleteMapping("/delete/{t}")
    public boolean delete(@PathVariable Long t){
        return this.ts.delete(t);
    }


}
