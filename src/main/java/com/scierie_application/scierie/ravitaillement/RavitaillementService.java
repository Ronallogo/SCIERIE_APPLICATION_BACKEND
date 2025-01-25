package com.scierie_application.scierie.ravitaillement;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.scierie_application.scierie.fournisseur.FournisseurRepository;
import com.scierie_application.scierie.handler.exeption.FournisseurNotFoundException;
import com.scierie_application.scierie.handler.exeption.RavitaillementNotFoundException;

import jakarta.transaction.Transactional;
 

@Service
@Transactional
public class RavitaillementService {

    @Autowired
    private RavitaillementRepository rav ;

    @Autowired
    private FournisseurRepository fr ;
    
    
    public RavitaillementDTO1 create(RavitaillementDTO1 r){
        var f = this.fr.findById(r.getId_fourniseur()).orElseThrow(()->  new FournisseurNotFoundException("Fournisseur not found"));

        String code_rav = this.generateUUID() ; 

        r.setCode_rav(code_rav);
        
        this.rav.save(
            Ravitaillement
            .builder()
            .prix_rav(r.getPrix_rav())
            .code_rav( code_rav)
            .date_rav(r.getDate_rav())
            .fournisseur(f)
            .build()
            
        );
        return r ; 
    }

    public List<RavitaillementDTO1> getAllRavitaillement(){
        return this.rav.findAll().stream().map(x->
        RavitaillementDTO1.builder()
        .code_rav(x.getCode_rav())
        .date_rav(x.getDate_rav())
        .id_fourniseur(x.getFournisseur().getId_fournisseur())
        .nom_fournisseur(x.getFournisseur().getNom_fournisseur())
        .prix_rav(x.getPrix_rav())
        .build() 
        ).collect(Collectors.toList());   
        
    }


    public RavitaillementDTO1 edit(RavitaillementDTO1 r){
        var f = this.fr.findById(r.getId_fourniseur()).orElseThrow(()->  new FournisseurNotFoundException("Fournisseur not found"));
        if(!this.rav.existsById(r.getId_rav()))  throw new RavitaillementNotFoundException("Ravitaillement not found!!");

        this.rav.save(
            Ravitaillement
            .builder()
            .id_rav(r.getId_rav())
            .prix_rav(r.getPrix_rav())
            .code_rav(r.getCode_rav())
            .date_rav(r.getDate_rav())
            .fournisseur(f)
            .build()
            
        );
        return r ;  
    } 
    
    


    public boolean delete(Long id_rav){
        if(!this.rav.existsById(id_rav)) throw new RavitaillementNotFoundException( "Ravitaillement not found");
        this.rav.deleteById(id_rav);
        return true ; 
    }


    public    String generateUUID() {
        return UUID.randomUUID().toString();
    }

}
