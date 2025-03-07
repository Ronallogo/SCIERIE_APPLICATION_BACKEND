package com.scierie_application.scierie.monnaie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scierie_application.scierie.handler.exeption.MonnaieNotFoundException;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;




@Service
@Transactional
public class MonnaieService {
    @Autowired
    private MonnaieRepository monnaieRepository;


    ///////create monnaie
    public MonnaieDTO1 create(MonnaieDTO1 m) {
        this.monnaieRepository.save(
                new Monnaie(
                m.getNom_monnaie() ,
                m.getAbbreviation() 
                ) 
             );
        return m ;

    }
    ///////edit monnaie
    public MonnaieDTO1 edit(MonnaieDTO1 m){
        if(!this.monnaieRepository.existsById(m.getId_monnaie()))  throw new  MonnaieNotFoundException( "monnaie not found") ;
        var e = new Monnaie(
            m.getId_monnaie() ,
            m.getNom_monnaie() ,
            m.getAbbreviation() 
            ) ;
        this.monnaieRepository.save(e);
        return m ;
    }

    ///////get all monnaie
    public List<MonnaieDTO1> getAllMonnaie(){
        return  this.monnaieRepository.findAll()
                .stream().map(x-> MonnaieDTO1.builder()
                        .id_monnaie(x.getId_monnaie())
                        .nom_monnaie(x.getNom_monnaie())
                        .abbreviation(x.getAbbreviation())
                        .build())
                .collect(Collectors.toList());

    }

    ///////delete monnaie
    public boolean delete(Long id_monnaie){
        if(!this.monnaieRepository.existsById(id_monnaie)) return false ;
        this.monnaieRepository.deleteById(id_monnaie);
        return true ;
    }
   


 

}
