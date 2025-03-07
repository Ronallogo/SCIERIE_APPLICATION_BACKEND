package com.scierie_application.scierie.monnaie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/auth/scierie/monnaie")
public class MonnaieController {

    @Autowired
    private MonnaieService monnaieService ;



    @PostMapping(value = "/create",
            consumes = "application/json",
            produces = "application/json")

    public MonnaieDTO1 create(@RequestBody MonnaieDTO1 m){
        return this.monnaieService.create(m);
    }



    @PutMapping("/edit")
    public MonnaieDTO1 edit(@RequestBody  MonnaieDTO1 m){
        return this.monnaieService.edit(m);
    }

    @GetMapping("/all")
    public List<MonnaieDTO1> getMethodName() {
        return  this.monnaieService.getAllMonnaie() ;
    }
    

    @DeleteMapping("/delete/{id_monnaie}")
    public boolean delete(@PathVariable  Long id_monnaie){
        return this.monnaieService.delete(id_monnaie);
    }


}
