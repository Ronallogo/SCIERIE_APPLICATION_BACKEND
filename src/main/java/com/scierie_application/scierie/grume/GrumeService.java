package com.scierie_application.scierie.grume;
 
import java.util.List;
 
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scierie_application.scierie.essence.EssenceRepository;
import com.scierie_application.scierie.handler.exeption.EssenceNotFoundException;
import com.scierie_application.scierie.handler.exeption.GrumeNotFoundException;
 
import com.scierie_application.scierie.ravitaillement.RavitaillementRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class GrumeService {

    @Autowired
    private GrumeRepository gr;

    @Autowired
    private EssenceRepository er ; 

    @Autowired
    private GrumeTraiteRepository gtr ; 

    @Autowired
    private RavitaillementRepository r ; 


    
    public GrumeTraiterDTO1 create_gt(GrumeTraiterDTO1 g){
        var e = this.gr.findByCodeLots(g.getCode_grume()).orElseThrow(()-> new GrumeNotFoundException("Grume not found"));
        this.gtr.save(
            GrumeTraiter.builder()
            .grume(e)
            .date_traitement(g.getDate_traitement())

            .build()
        );
        return g ;

    }

    public List<GrumeTraiterDTO1> getAllGrumeTraiter(){
        return this.gtr.findAll().stream().map(
            x ->
            GrumeTraiterDTO1.builder()
            .id_operation( x.getId_operation())
            .code_grume(x.getGrume().getCode_rav().getCode_rav())
            .date_traitement( x.getDate_traitement())
            .bois_associe( x.getTraitement().getBois_a_traiter())
            .id_traitement( x.getTraitement().getId_traitement())
            .nom_traitement( x.getTraitement().getNom_traitement())
            .build()

        ).collect(Collectors.toList());
    } 

    public boolean deleteGtr(Long id_gtr){
        this.gtr.deleteById(id_gtr);
        return !this.gtr.existsById(id_gtr);
    }

    public GrumeDTO1 create(GrumeDTO1 g){

        var e = this.er.findByLibelle(g.getNom_essence()).orElseThrow(()-> new EssenceNotFoundException("Essence not found"));
        var rav = this.r.findByCode(g.getCode_lots()).orElseThrow(()-> new RuntimeException("ravitaillement not found"));

        Float cubage = (float) (Math.PI * Math.pow((g.getDiam_moy()/ 2) , 2)) * g.getLongueur_moy();
        var grume =  this.gr.save(
            Grume.builder()
            .diam_moy(g.getDiam_moy())
            .longueur_moy(g.getLongueur_moy())
            .poids_moy(g.getPoids_moy())
            .code_rav(rav)
            .cubage_moy(cubage)
            .qualite( g.getQualite())
            .quantite(g.getQuantite())
            .essence(e)
            .entree(rav.getDate_rav())
            .poids_lots_grume(g.getQuantite() * g.getPoids_moy())

            .build()
        );

        g.setId_grume(grume.getId_grume());
        return g ; 
    }



    public List<GrumeDTO1> getAllGrume(){

        return this.gr.findAll().stream().map(x->
        GrumeDTO1.builder()
        .nom_essence(x.getEssence().getLibelle())
        .code_lots(x.getCode_rav().getCode_rav())
        .cubage_moy(x.getCubage_moy())
        .id_grume( x.getId_grume())
        .diam_moy(x.getDiam_moy())
        .entree(x.getEntree())
        .longueur_moy(x.getLongueur_moy())
        .poids_moy(x.getPoids_moy())
        .traiter(this.isTraiter(x.getId_grume()))
        .quantite(x.getQuantite())
        .qualite(x.getQualite())
        .id_essence(x.getEssence().getId_essence())
        .build() 
        ).collect(Collectors.toList());   
        
    }

    
    public List<GrumeDTO2> dataChartStockEssence(){
        

        return  this.er.findAll().stream().map(
            x->
                GrumeDTO2.builder()
                .essence( x.getLibelle())
                .qtGrume(sumAll( x.getGrumes()))
                .build()      
        ).collect( Collectors.toList());
    }


    public GrumeDTO1 edit(GrumeDTO1 g){
        var e = this.er.findByLibelle(g.getNom_essence()).orElseThrow(()-> new EssenceNotFoundException("Essence not found"));
        var rav = this.r.findByCode(g.getCode_lots()).orElseThrow(()-> new RuntimeException("ravitaillement not found"));

        Float cubage = (float) (Math.PI * Math.pow((g.getDiam_moy()/ 2) , 2)) * g.getLongueur_moy();

        this.gr.save(
            Grume.builder()
            .id_grume(g.getId_grume())
            .diam_moy(g.getDiam_moy())
            .longueur_moy(g.getLongueur_moy())
            .poids_moy(g.getPoids_moy())
            .code_rav(rav)
            .cubage_moy(cubage)
            .poids_lots_grume(g.getQuantite() * g.getPoids_moy())
            .qualite( g.getQualite())
            .quantite(g.getQuantite())
            .essence(e)
            .entree(rav.getDate_rav())
            .build()
        );
        return g ; 
    }


    public Integer sumAll(List<Grume> list) {
        return list.stream()
            .mapToInt(Grume::getQuantite)
            .sum();
    }
    

    public boolean delete(Long id_grume){
        if(!this.gr.existsById(id_grume)) throw new GrumeNotFoundException( "Grume not found");
        this.gr.deleteById(id_grume);
        return true ; 
    }

    public List<GrumeDTO1> search(String keyword){
        return this.gr.search(keyword).stream().map(x->
                GrumeDTO1.builder()
                        .nom_essence(x.getEssence().getLibelle())
                        .code_lots(x.getCode_rav().getCode_rav())
                        .cubage_moy(x.getCubage_moy())
                        .id_grume( x.getId_grume())
                        .diam_moy(x.getDiam_moy())
                        .entree(x.getEntree())
                        .longueur_moy(x.getLongueur_moy())
                        .poids_moy(x.getPoids_moy())
                        .quantite(x.getQuantite())
                        .qualite(x.getQualite())
                        .traiter(this.isTraiter(x.getId_grume()))
                        .id_essence(x.getEssence().getId_essence())
                        .build()
        ).collect(Collectors.toList());

    }

    public boolean isTraiter(Long id_grume){
        List<Long> list =  this.gtr.getAllGrumeTraitsId();
        return list.contains(id_grume);
    }
}
