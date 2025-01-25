package com.scierie_application.scierie.grume;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
import com.scierie_application.scierie.essence.EssenceRepository;
import com.scierie_application.scierie.handler.exeption.EssenceNotFoundException;
import com.scierie_application.scierie.handler.exeption.GrumeNotFoundException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class GrumeService {

    @Autowired
    private GrumeRepository gr;
    @Autowired
    private EssenceRepository er ; 


    public GrumeDTO1 create(GrumeDTO1 g){

        var e = this.er.findById(g.getId_essence()).orElseThrow(()-> new EssenceNotFoundException("Essence not found"));


        String code = this.generateUUID() ;
        this.gr.save(
            Grume.builder()
            .diam_moy(g.getDiam_moy())
            .longueur_moy(g.getLongueur_moy())
            .poids_moy(g.getPoids_moy())
            .code_lots(code)
            .cubage_moy(g.getCubage_moy())
            .qualite( g.getQualite())
            .quantite(g.getQuantite())
            .essence(e)
            .localisaton(g.getLocalisaton())
            .build()
        );
        g.setCode_lots(code);
        return g ; 
    }

    public  String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public List<GrumeDTO1> getAllGrume(){

        return this.gr.findAll().stream().map(x->
        GrumeDTO1.builder()
        .nom_essence(x.getEssence().getLibelle())
        .code_lots(x.getCode_lots())
        .cubage_moy(x.getCubage_moy())
        .diam_moy(x.getDiam_moy())
        .longueur_moy(x.getLongueur_moy())
        .poids_moy(x.getPoids_moy())
        .localisaton(x.getLocalisaton())
        .quantite(x.getQuantite())
        .qualite(x.getQualite())
        .id_essence(x.getEssence().getId_essence())
        .build() 
        ).collect(Collectors.toList());   
        
    }

    public GrumeDTO1 edit(GrumeDTO1 g){
        var e = this.er.findById(g.getId_essence()).orElseThrow(()-> new EssenceNotFoundException("Essence not found"));
        if(!this.gr.existsById(g.getId_grume()))  throw new GrumeNotFoundException("Grume not found!!");

        this.gr.save(
            Grume.builder()
            .id_grume(g.getId_grume())
            .diam_moy(g.getDiam_moy())
            .longueur_moy(g.getLongueur_moy())
            .poids_moy(g.getPoids_moy())
            .code_lots(g.getCode_lots())
            .cubage_moy(g.getCubage_moy())
            .qualite( g.getQualite())
            .quantite(g.getQuantite())
            .essence(e)
            .localisaton(g.getLocalisaton())
            .build()
        );
        return g ; 
    }

    public boolean delete(Long id_grume){
        if(!this.gr.existsById(id_grume)) throw new GrumeNotFoundException( "Grume not found");
        this.gr.deleteById(id_grume);
        return true ; 
    }
}
