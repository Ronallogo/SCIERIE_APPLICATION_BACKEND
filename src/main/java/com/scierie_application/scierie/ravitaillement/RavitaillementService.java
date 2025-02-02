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
        System.out.print(r.getId_fournisseur());
        var f = this.fr.findById(r.getId_fournisseur()).orElseThrow(()->  new FournisseurNotFoundException("Fournisseur not found"));

        String code_rav = this.generateUUID() ; 

        r.setCode_rav(code_rav);
        if(code_rav == null) throw new RuntimeException("id null");
        
        this.rav.save(
            Ravitaillement
            .builder()
            .prix_rav(r.getPrix_rav())
            .code_rav(code_rav)
            .date_rav(r.getDate_rav())
            .fournisseur(f)
            .effectuer(r.getEffectuer())
            .qtBois(r.getQtBois())
            .effectuer(false)
            .build()
            
        );
        return r ; 
    }

    public List<RavitaillementDTO1> getAllRavitaillement(){
        return this.rav.findAll().stream().map(x->
        RavitaillementDTO1.builder()
        .code_rav(x.getCode_rav())
        .date_rav(x.getDate_rav())
        .id_fournisseur(x.getFournisseur().getId_fournisseur())
        .nom_fournisseur(x.getFournisseur().getNom_fournisseur())
        .prix_rav(x.getPrix_rav())
        .qtBois(x.getQtBois())
        .effectuer( x.getEffectuer())
        .build() 
        ).collect(Collectors.toList());   
        
    }


    public RavitaillementDTO1 edit(RavitaillementDTO1 r){
        var f = this.fr.findById(r.getId_fournisseur()).orElseThrow(()->  new FournisseurNotFoundException("Fournisseur not found"));
        var rav  = this.rav.findById(r.getCode_rav()).orElseThrow(()-> new RavitaillementNotFoundException("Ravitaillement not found!!"));
        var qtBois = r.getQtBois() > rav.getQtBois() ? r.getQtBois()  : rav.getQtBois() ;
        this.rav.save(
            Ravitaillement
            .builder()
            .prix_rav(r.getPrix_rav())
            .code_rav(r.getCode_rav())
            .date_rav(r.getDate_rav())
            .fournisseur(f)
            .effectuer(r.getEffectuer())
            .qtBois(qtBois)
            
            .build()
            
        );
        return r ;  
    } 
    
    


    public boolean delete(String id_rav){
        if(!this.rav.existsById(id_rav)) throw new RavitaillementNotFoundException( "Ravitaillement not found");
        this.rav.deleteById(id_rav);
        return true ; 
    }


    public    String generateUUID() {
        return UUID.randomUUID().toString().substring(0, 10);
    }


    public List<RavitaillementDTO1>search(String keyword){
        return this.rav.search(keyword).stream().map(x->
        RavitaillementDTO1.builder()
        .code_rav(x.getCode_rav())
        .date_rav(x.getDate_rav())
        .id_fournisseur(x.getFournisseur().getId_fournisseur())
        .nom_fournisseur(x.getFournisseur().getNom_fournisseur())
        .prix_rav(x.getPrix_rav())
        .qtBois(x.getQtBois())
        .effectuer( x.getEffectuer())
        .build() 
        ).collect(Collectors.toList());   
    }

}
