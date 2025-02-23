package com.scierie_application.scierie.facture;


import com.scierie_application.scierie.paiement.Paiement;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FactureService {
    @Autowired
    private FactureRepository fr ;

    public void makeFacture(Paiement p){

    }

}
