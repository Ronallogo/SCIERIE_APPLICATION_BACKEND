package com.scierie_application.scierie.bille;


import com.scierie_application.scierie.colis.Colis;
import com.scierie_application.scierie.colis.ColisRepository;
import com.scierie_application.scierie.grume.GrumeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BilleService {
    @Autowired
    private BilleRepository br ;
    @Autowired
    private GrumeRepository gr ;
    @Autowired
    private ColisRepository cr ;


    public BilleDTO1 create(BilleDTO1 b ){
        var g = this.gr.findByCodeLots(null) ;
        return  null ;


    }
}
