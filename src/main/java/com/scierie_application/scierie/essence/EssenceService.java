package com.scierie_application.scierie.essence;


import com.scierie_application.scierie.handler.exeption.EssenceNotFoundException;
 
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class EssenceService {

    @Autowired
    private EssenceRepository essenceRepository ;


    public EssenceDTO1 create(EssenceDTO1 e) {
       var essence =  this.essenceRepository.save(
               new Essence(
                e.getId_essence() ,
                e.getLibelle() , 
                e.getAbbreviation() , 
                e.getDensite() ,
                e.getMercuriale() , 
                e.getTeneur_en_eau()
                ) 
            );
        e.setId_essence( essence.getId_essence());
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
        if(!this.essenceRepository.existsById(e.getId_essence()))  throw new EssenceNotFoundException("essence not found") ;
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
        System.out.println(libelle);
        return this.essenceRepository.searchEssences(libelle)
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


    public  Float mercurialeMoyenne(){
        return essenceRepository.mercurialeMoyenne();
             
    }

    public  EssenceDTO1 getOne(String essence){
         var e = this.essenceRepository.findByLibelle(essence).orElseThrow(()-> new EssenceNotFoundException("essence not found"));
         return EssenceDTO1.builder()
                 .id_essence(e.getId_essence())
                 .libelle(e.getLibelle())
                 .abbreviation(e.getAbbreviation())
                 .densite(e.getDensite())
                 .mercuriale(e.getMercuriale())
                 .teneur_en_eau(e.getTeneur_en_eau())
                 .build();
    }


    public EssenceDTO1 essenceLaPlusAcheter(){
        Essence e = this.essenceRepository.essenceLePlusAcheter();
        return EssenceDTO1.builder()
                .id_essence(e.getId_essence())
                .densite(e.getDensite())
                .teneur_en_eau(e.getTeneur_en_eau())
                .libelle(e.getLibelle())
                .abbreviation(e.getAbbreviation())
                .build();
    }

    
}

