package com.scierie_application.scierie.essence;


import com.scierie_application.scierie.handler.exeption.EssenceNotFound;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class EssenceService {

    @Autowired
    private EssenceRepository essenceRepository ;


    public EssenceDTO1 create(EssenceDTO1 e) {
        this.essenceRepository.save(
               new Essence(
                e.getId_essence() ,
                e.getLibelle() , 
                e.getAbbreviation() , 
                e.getDensite() ,
                e.getMercuriale() , 
                e.getTeneur_en_eau()
                ) 
            );
        return e ;

    }

    public List<EssenceDTO1> getAllEssence(){
       return  this.essenceRepository.findAll()
               .stream().map(x-> EssenceDTO1.builder()
                       .id_essence(x.getId_essence())
                       .teneur_en_eau(x.getTeneur_en_eau())
                       .abbreviation(x.getAbbreviation())
                       .libelle(x.getLibelle())
                       .densite(x.getDensite())
                       .mercuriale(x.getMercuriale())
                       .build())
               .collect(Collectors.toList());

    }

    public EssenceDTO1 edit(EssenceDTO1 e){
        if(!this.essenceRepository.existsById(e.getId_essence()))  throw new EssenceNotFound("essence not found") ;
        this.essenceRepository.save(
            new Essence(
                e.getId_essence() ,
                e.getLibelle() , 
                e.getAbbreviation() , 
                e.getDensite() ,
                e.getMercuriale() , 
                e.getTeneur_en_eau()
                ) 
        );
        return e ;


    }


    public Boolean delete(Long id_essence){
        if(!this.essenceRepository.existsById(id_essence))  return  false ;
        this.essenceRepository.deleteById(id_essence);
        
        return true ;

    }


    public List<EssenceDTO1> searchEssenceByLibelleContainDto1s(String libelle){
        return this.essenceRepository.findByLibelleContaining(libelle)
                .stream().map(x-> EssenceDTO1.builder()
                        .id_essence(x.getId_essence())
                        .teneur_en_eau(x.getTeneur_en_eau())
                        .abbreviation(x.getAbbreviation())
                        .libelle(x.getLibelle())
                        .densite(x.getDensite())
                        .mercuriale(x.getMercuriale())
                        .build())
                .collect(Collectors.toList());
    }
}

