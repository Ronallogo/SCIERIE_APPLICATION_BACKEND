package com.scierie_application.scierie.ville;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scierie_application.scierie.handler.exeption.PaysNotFoundException;
import com.scierie_application.scierie.handler.exeption.VilleNotFoundException;
import com.scierie_application.scierie.pays.PaysRepository;

import jakarta.transaction.Transactional;
 

@Service
@Transactional
public class VilleService {

    @Autowired
    private VilleRepository villeRepository;

    @Autowired
    private PaysRepository paysRepository;



    public VilleDTO1 create(VilleDTO1 ville){

        var pays = this.paysRepository.findById(ville.getId_pays());  
        if(!pays.isPresent()) throw new PaysNotFoundException("pays not found") ;

        villeRepository.save(Ville.builder()
            .id_ville(ville.getId_ville())
            .nom_ville(ville.getNom_ville())
            .pays(pays.get())
            .build());
        return ville;
    }


    public VilleDTO1 edit(VilleDTO1 ville){
        if(!this.villeRepository.existsById(ville.getId_ville()))  throw new VilleNotFoundException("ville not found") ;
        var pays = this.paysRepository.findById(ville.getId_pays());  
        if(!pays.isPresent()) throw new PaysNotFoundException("pays not found") ;
        var e = Ville.builder()
            .id_ville(ville.getId_ville())
            .nom_ville(ville.getNom_ville())
            .pays(pays.get())
            .build();
        this.villeRepository.save(e);
        ville.setId_pays(e.getPays().getId_pays());
        return ville;
    }


    public List<VilleDTO1> getAllVille(){
        return this.villeRepository.findAll().stream().map(ville -> VilleDTO1.builder()
            .id_ville(ville.getId_ville())
            .nom_ville(ville.getNom_ville())
            .id_pays(ville.getPays().getId_pays())
            .nom_pays(ville.getPays().getNom_pays())
            .build()).collect(Collectors.toList());
    }




    public boolean delete(Long id_ville){
        if(!this.villeRepository.existsById(id_ville))  throw new VilleNotFoundException("ville not found") ;
        this.villeRepository.deleteById(id_ville);
        return true;
    }

}
