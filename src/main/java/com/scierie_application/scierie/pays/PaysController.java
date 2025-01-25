package com.scierie_application.scierie.pays;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
 




@RestController
@RequestMapping(value = "/api/auth/scierie/pays")
@CrossOrigin("*")
public class PaysController {
    @Autowired
    private PaysService paysService;




    @PostMapping(value = "/create" , produces = "application/json" , consumes = "application/json")
    public PaysDTO1 create(@RequestBody PaysDTO1 p) {
        return this.paysService.createPays(p);
    }


    @PutMapping("/edit")
    public PaysDTO1 edit(@RequestBody PaysDTO1 entity) {
        return this.paysService.updatePays(entity);
        
    }
    @GetMapping("/all")
    public List<PaysDTO1> getAllPays() {
        return this.paysService.findAllPays();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return this.paysService.deletePays(id);
    }    

}
