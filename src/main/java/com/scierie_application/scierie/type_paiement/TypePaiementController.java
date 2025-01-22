package com.scierie_application.scierie.type_paiement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
 
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping(value = "/api/auth/scierie/type_paiement")
@CrossOrigin("*")   
public class TypePaiementController {

    @Autowired
    private TypePaiementService typePaiementService;


    @PostMapping(value = "/create" , produces = "application/json" , consumes = "application/json")
    public Type_paiementDTO1 create(Type_paiementDTO1 entity) {
        return this.typePaiementService.create(entity);
        
    }

    @GetMapping("/all")
    public List<Type_paiementDTO1> getAllTypePaiement( ) {
        return this.typePaiementService.getAll();
    }

    @PutMapping("/edit")
    public Type_paiementDTO1 putMethodName(  @RequestBody Type_paiementDTO1 entity) {
        return this.typePaiementService.edit(entity);
    }

    @DeleteMapping("/delete/{id_type_paiement}")
    public boolean delete(@PathVariable Long id_type_paiement){
        return this.typePaiementService.delete(id_type_paiement);
    }
    

}
