package com.scierie_application.scierie.fournisseur;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scierie_application.scierie.ville.VilleRepository;
import com.scierie_application.scierie.handler.exeption.FournisseurNotFoundException;
import com.scierie_application.scierie.handler.exeption.VilleNotFoundException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FournisseurService {



    @Autowired
    private FournisseurRepository fr ; 

    @Autowired
    private VilleRepository vr ; 


    public FournisseurDTO1 create(FournisseurDTO1 f){
       var v =  this.vr.findByNom_Ville(f.getNom_ville()).orElseThrow(()-> new VilleNotFoundException("ville not found "+f.toString() ));

       this.fr.save(
            Fournisseur.builder()
            .adresse_fournisseur(f.getAdresse_fournisseur())
            .email_fournisseur(f.getEmail_fournisseur())
            .fax_fournisseur(f.getFax_fournisseur())
            .ville(v)
            .nom_fournisseur(f.getNom_fournisseur())
            .telephone_fournisseur(f.getTelephone_fournisseur())
            .taxe_abbatage(f.getTaxe_abbatage())
            .build()
       )  ;
       f.setId_ville(v.getId_ville());  
       
       return f ; 
    }

    public List<FournisseurDTO1> getAllFournisseur(){
        return this.fr.findAll().stream().map(
            x ->
            FournisseurDTO1.builder()
            .id_fournisseur( x.getId_fournisseur())
            .adresse_fournisseur( x.getAdresse_fournisseur())
            .email_fournisseur( x.getEmail_fournisseur())
            .fax_fournisseur( x.getFax_fournisseur())
            .id_ville(x.getVille().getId_ville())
            .nom_ville(x.getVille().getNom_ville())
            .telephone_fournisseur(x.getTelephone_fournisseur())
            .taxe_abbatage(x.getTaxe_abbatage())
            .nom_fournisseur( x.getNom_fournisseur())
            .build()
        ).collect( Collectors.toList());
    }


    public List<FournisseurDTO1> Search(String keyword){
        return this.fr.search(keyword).stream().map(
            x ->
            FournisseurDTO1.builder()
            .id_fournisseur( x.getId_fournisseur())
            .adresse_fournisseur( x.getAdresse_fournisseur())
            .email_fournisseur( x.getEmail_fournisseur())
            .fax_fournisseur( x.getFax_fournisseur())
            .id_ville(x.getVille().getId_ville())
            .nom_ville(x.getVille().getNom_ville())
            .telephone_fournisseur(x.getTelephone_fournisseur())
            .taxe_abbatage(x.getTaxe_abbatage())
            .nom_fournisseur( x.getNom_fournisseur())
            .build()
        ).collect( Collectors.toList());
    }

    public FournisseurDTO1 update(FournisseurDTO1 f){
        if(!this.fr.existsById(f.getId_fournisseur())) throw new FournisseurNotFoundException( "fournisseur not found");
        var v =  this.vr.findByNom_Ville(f.getNom_ville()).orElseThrow(()-> new VilleNotFoundException("ville not found"));
 
        this.fr.save(
             Fournisseur.builder()
             .id_fournisseur(f.getId_fournisseur())
             .adresse_fournisseur( f.getAdresse_fournisseur())
             .email_fournisseur( f.getEmail_fournisseur())
             .fax_fournisseur( f.getFax_fournisseur())
             .ville(v)
             .nom_fournisseur( f.getNom_fournisseur())
             .telephone_fournisseur(f.getTelephone_fournisseur())
             .taxe_abbatage(f.getTaxe_abbatage())
             .build()
        );
    

        
        return f ; 
    }


    public boolean delete(Long id_fournisseur){
        if(!this.fr.existsById(id_fournisseur)) throw new FournisseurNotFoundException( "fournisseur not found");
        this.fr.deleteById(id_fournisseur);
        return true ; 
    }

    public Float taxeMoyenneFournisseur(){
        return  this.fr.taxeMoyenneFournisseur();
    }


    public FournisseurDTO2 dataForChart(){
        List<String> list_nom = this.fr.getAllNameFournisseur() ;
        List<Float> list_taxe = this.fr.getAllTaxeFournisseur() ;

        return FournisseurDTO2.builder()
                .nom_fournisseurs(list_nom)
                .taxe_abbatages(list_taxe)
                .build();
    }




}
