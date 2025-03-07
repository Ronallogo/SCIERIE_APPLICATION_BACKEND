package com.scierie_application.scierie.tarif;



import com.scierie_application.scierie.traitement.TraitementDTO2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/auth/scierie/tarif")
@CrossOrigin("*")
public class TarifController {
    @Autowired
    private TarifService ts ;

    @PostMapping(value = "/create" , produces = "application/json" , consumes = "application/json")
    public TarifDTO1 createPort(@RequestBody TarifDTO1 t){
        return this.ts.create(t);
    }

    @GetMapping("/all")
    public List<TarifDTO1> getAll( ){
        return this.ts.getAll();
    }

    @DeleteMapping("/delete/{t}")
    public boolean delete(@PathVariable Long t){
        return this.ts.delete(t);
    }

    @GetMapping("/search/{keyword}")
    public List<TarifDTO1>search(@PathVariable String keyword){
        return this.ts.search(keyword);
    }


    @GetMapping("/monnaieMostTarif")
    public TarifDTO2 EssenceWithMostProcess(){
        return this.ts.MonnaieWithMostTarif() ;
    }



}
