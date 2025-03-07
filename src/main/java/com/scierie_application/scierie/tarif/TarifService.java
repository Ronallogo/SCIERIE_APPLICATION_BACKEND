package com.scierie_application.scierie.tarif;


import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.scierie_application.scierie.essence.EssenceRepository;
import com.scierie_application.scierie.handler.exeption.EssenceNotFoundException;
import com.scierie_application.scierie.handler.exeption.MonnaieNotFoundException;
import com.scierie_application.scierie.monnaie.MonnaieRepository;
import com.scierie_application.scierie.traitement.TraitementDTO2;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class TarifService {
    @Autowired
    private EssenceRepository er ;
    @Autowired
    private TarifRepository tr ;
    @Autowired
    private MonnaieRepository mr ;


    public TarifDTO1 create(TarifDTO1 t){
        var m = this.mr.findByNom(t.getMonnaie()).orElseThrow(()-> new MonnaieNotFoundException("monnaie not found"));
        var e = this.er.findByLibelle(t.getEssence()).orElseThrow(()-> new EssenceNotFoundException("Essence not found"));

        this.tr.save(
                Tarif.builder()
                        .code_tarif(this.generateUUID())
                        .diam_moy(t.getDiam_moy())
                        .essence(e)
                        .montant_unitaire(t.getMontant_unitaire())
                        .long_moy(t.getLong_moy())
                        .monnaie(m)
                        .build()
        );
        return t ;

    }

    public List<TarifDTO1> getAll(){
        return this.tr.findAll().stream().map(x->
                    TarifDTO1.builder()
                            .id_tarif(x.getId_tarif())
                            .code_tarif(x.getCode_tarif())
                            .diam_moy(x.getDiam_moy())
                            .montant_unitaire(x.getMontant_unitaire())
                            .long_moy(x.getLong_moy())
                            .essence(x.getEssence().getLibelle())
                            .monnaie(x.getMonnaie().getNom_monnaie())
                            .build()
                ).collect(Collectors.toList());

    }

    public List<TarifDTO1> search(String keyword){
        return this.tr.search(keyword).stream().map(x->
                TarifDTO1.builder()
                        .id_tarif(x.getId_tarif())
                        .code_tarif(x.getCode_tarif())
                        .diam_moy(x.getDiam_moy())
                        .montant_unitaire(x.getMontant_unitaire())
                        .long_moy(x.getLong_moy())
                        .essence(x.getEssence().getLibelle())
                        .monnaie(x.getMonnaie().getNom_monnaie())
                        .build()
        ).collect(Collectors.toList());

    }


    public String generateUUID() {
        return UUID.randomUUID().toString().substring(0, 10);
    }


    public TarifDTO1 edit(TarifDTO1 t){
        var m = this.mr.findByNom(t.getMonnaie()).orElseThrow(()-> new MonnaieNotFoundException("monnaie not found"));
        var e = this.er.findByLibelle(t.getEssence()).orElseThrow(()-> new EssenceNotFoundException("Essence not found"));

        this.tr.save(
                Tarif.builder()
                        .id_tarif(t.getId_tarif())
                        .code_tarif(this.generateUUID())
                        .diam_moy(t.getDiam_moy())
                        .essence(e)
                        .montant_unitaire(t.getMontant_unitaire())
                        .long_moy(t.getLong_moy())
                        .monnaie(m)
                        .build()
        );
        return t ;
    }

    public boolean delete(Long id){
        if(!this.tr.existsById(id)) return false ;
        this.tr.deleteById(id);
        return true ;
    }




    public int indexOfMax(List<Integer> list){
        if(list.isEmpty()) return 0 ;
        int max = list.get(0) ;
        int index = 0 ;
        for (Integer integer : list) {
            if(integer > max) {
                max = integer ;
                index = list.indexOf(integer) ;

            }
        }
        return index ;
    }
    public TarifDTO2  MonnaieWithMostTarif(){

        List<TarifDTO2>  values =  this.tr.getAllMonnaieWithTarif().stream().map(x->
                TarifDTO2.builder()
                        . nom( x.get("nom").toString())
                        .nbr(Integer.parseInt(x.get("nbr").toString()))
                        .build()

        ).toList();
        int index =  this.indexOfMax(values.stream().map(TarifDTO2::getNbr).toList());
        return values.get(index);

    }
}
