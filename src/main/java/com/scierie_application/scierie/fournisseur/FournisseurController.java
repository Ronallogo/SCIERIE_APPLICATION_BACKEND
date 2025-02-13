package com.scierie_application.scierie.fournisseur;

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
@RequestMapping(value = "/api/auth/scierie/fournisseur")
public class FournisseurController {

    @Autowired
    private FournisseurService fs ; 

    @PostMapping("/create")
    public FournisseurDTO1 create(@RequestBody FournisseurDTO1 f) { 
        return this.fs.create(f);
    }

    @PutMapping("/edit")
    public FournisseurDTO1 edit(  @RequestBody FournisseurDTO1 f) {
        return this.fs.update(f);
    }

    @GetMapping("/all")
    public List<FournisseurDTO1>  getMethodName( ) {
        return this.fs.getAllFournisseur();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return this.fs.delete(id);
    }

    @GetMapping("/taxe_moy")
    public Float taxeMoy(){
        return this.fs.taxeMoyenneFournisseur();
    }


    @GetMapping("/search/{keyword}")
    public List<FournisseurDTO1> search(@PathVariable String keyword){
       return  this.fs.Search(keyword);
    }

    @GetMapping("/dataChart")
    public FournisseurDTO2 getDataChart(){
        return  this.fs.dataForChart() ;
    }


    
    

}
