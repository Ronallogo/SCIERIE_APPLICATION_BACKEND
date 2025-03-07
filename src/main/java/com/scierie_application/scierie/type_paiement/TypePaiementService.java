package com.scierie_application.scierie.type_paiement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scierie_application.scierie.handler.exeption.TypePaiementNotFoundException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TypePaiementService {


    @Autowired
    private  Type_paiementRepository typePaiementRepository;



    public Type_paiementDTO1 create(Type_paiementDTO1 typePaiement){
        typePaiementRepository.save(TypePaiement.builder()
            .id_type_paiement(typePaiement.getId_type_paiement())
            .libelle(typePaiement.getLibelle())
            .nbrTranche(typePaiement.getNbrTranche())
            .build());
        return typePaiement;
    }



    public Type_paiementDTO1 edit(Type_paiementDTO1 typePaiement){
        if(!this.typePaiementRepository.existsById(typePaiement.getId_type_paiement()))  throw new TypePaiementNotFoundException("typePaiement not found") ;
        var e = TypePaiement.builder()
            .id_type_paiement(typePaiement.getId_type_paiement())
            .libelle(typePaiement.getLibelle())
            .nbrTranche(typePaiement.getNbrTranche())
            .build();
        this.typePaiementRepository.save(e);
        typePaiement.setId_type_paiement(e.getId_type_paiement());
        return typePaiement;
    }

    public boolean delete(Long id){
        this.typePaiementRepository.deleteById(id);
        return !this.typePaiementRepository.existsById(id);
    }


    public List<Type_paiementDTO1> getAll(){
        return this.typePaiementRepository.findAll().stream().map(s -> Type_paiementDTO1.builder()
            .id_type_paiement(s.getId_type_paiement())
            .libelle(s.getLibelle())
            .nbrTranche(s.getNbrTranche())
            .build()).collect(Collectors.toList());
    }

}
