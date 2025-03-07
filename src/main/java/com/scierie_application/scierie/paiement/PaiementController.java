package com.scierie_application.scierie.paiement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/auth/scierie/paiement")
public class PaiementController {
    @Autowired
    private PaiementSerivce ps ;


    @PostMapping("/create")
    public String makePaiement(PaiementDTO1 p){
        return this.ps.makePaiement(p);
    }

    @DeleteMapping("/delete/{code}")
    public boolean delete(@PathVariable String code){
        return  this.delete(code);
    }


}
