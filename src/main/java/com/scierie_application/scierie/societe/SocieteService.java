package com.scierie_application.scierie.societe;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
 

@Transactional
@Service
public class SocieteService {

    @Autowired
    private SocieteRepository societeRepository;
    

    public SocieteDTO1 create(SocieteDTO1 s){
        this.societeRepository.save(Societe.builder()
        .nom_societe(s.getNom_societe())
        .build());
        return s; 
    } 
    
    
    public List<SocieteDTO1> readAll(){
        return this.societeRepository.findAll().stream().map(s -> SocieteDTO1.builder()
        .id_societe(s.getId_societe())
        .nom_societe(s.getNom_societe()) 
        .build()).collect(Collectors.toList());
    }


    public SocieteDTO1 edit(SocieteDTO1 s){
        this.societeRepository.save(Societe.builder()
        .id_societe(s.getId_societe())
        .nom_societe(s.getNom_societe())
        .build());
        return s;
    }

    public boolean delete(Long id){
        this.societeRepository.deleteById(id);
        return !this.societeRepository.existsById(id);
    }

}
