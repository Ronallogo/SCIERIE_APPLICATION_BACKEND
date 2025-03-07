package com.scierie_application.scierie.pays;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scierie_application.scierie.paiement.PaiementDTO1;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class PaysService {



    @Autowired
    private   PaysRepository paysRepository;

    

    public PaysDTO1 createPays(PaysDTO1 pays){
        paysRepository.save(Pays.builder()
            .id_pays(pays.getId_pays())
            .nom_pays(pays.getNom_pays())
            .build());
        
        return pays;
    }
 

    public List<PaysDTO1> findAllPays(){
        return paysRepository.findAll().stream().map( x -> PaysDTO1.builder()
            .id_pays(x.getId_pays())
            .nom_pays(x.getNom_pays())
            .build())
            .collect(Collectors.toList());
    }

    public PaysDTO1 updatePays(PaysDTO1 pays){
        paysRepository.save(Pays.builder()
            .id_pays(pays.getId_pays())
            .nom_pays(pays.getNom_pays())
            .build());
        return pays;
    }

    public boolean deletePays(Long id){
        if(!paysRepository.existsById(id)) return false ; 
        paysRepository.deleteById(id);
        return true ;
    }

}
