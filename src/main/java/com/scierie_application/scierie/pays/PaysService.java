package com.scierie_application.scierie.pays;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class PaysService {



    @Autowired
    private   PaysRepository paysRepository;

    

    public Pays createPays(Pays pays){
        return paysRepository.save(pays);
    }
 

    public List<Pays> findAllPays(){
        return paysRepository.findAll();
    }

    public Pays updatePays(Pays pays){
        return paysRepository.save(pays);
    }

    public boolean deletePays(Long id){
        if(!paysRepository.existsById(id)) return false ; 
        paysRepository.deleteById(id);
        return true ;
    }

}
