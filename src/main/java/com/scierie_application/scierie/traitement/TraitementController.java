package com.scierie_application.scierie.traitement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/auth/scierie/traitement")
@CrossOrigin("*")
public class TraitementController {


    @Autowired
    private TraitementService ts ;


    @PostMapping(value = "/create", produces = "application/json" , consumes = "application/json")
    public TraitementDTO1 create(@RequestBody TraitementDTO1 t){
        return this.ts.create(t);
    }


    @GetMapping("/all")
    public List<TraitementDTO1> getAllTraitement(){
        return this.ts.getAllTraitement();
    }


    @PutMapping(value = "/edit", produces = "application/json" , consumes = "application/json")
    public TraitementDTO1 edit(@RequestBody TraitementDTO1 t){
        return this.ts.edit(t);
    }


    @DeleteMapping("/delete/{t}")
    public boolean delete(@PathVariable Long t){
        return this.ts.delete(t);
    }

    @GetMapping("/search/{keyword}")
    public List<TraitementDTO1>search(@PathVariable String keyword){
            return this.ts.search(keyword);
    }


}
