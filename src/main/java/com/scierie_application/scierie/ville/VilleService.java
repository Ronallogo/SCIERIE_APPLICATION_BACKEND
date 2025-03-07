package com.scierie_application.scierie.ville;

import java.util.List;
import java.util.stream.Collectors;

import com.scierie_application.scierie.pays.Pays;
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

        var pays = this.paysRepository.findByNom(ville.getNom_pays()).orElse(null);
        if(pays == null){
            pays =  this.paysRepository.save(
                    Pays.builder()
                            .nom_pays(ville.getNom_pays())
                            .build()
            );
        }

        villeRepository.save(Ville.builder()
            .nom_ville(ville.getNom_ville())
            .pays(pays)
            .build());
        return ville;
    }


    public VilleDTO1 edit(VilleDTO1 ville){
        if(!this.villeRepository.existsById(ville.getId_ville()))  throw new VilleNotFoundException("ville not found") ;
        var pays = this.paysRepository.findById(ville.getId_pays()).orElseThrow(()-> new PaysNotFoundException("pays not found"));

        pays.setNom_pays(ville.getNom_pays());
        pays.setId_pays( ville.getId_pays());
        this.paysRepository.save(pays);
        
        

        var e = Ville.builder()
            .id_ville(ville.getId_ville())
            .nom_ville(ville.getNom_ville())
            .pays(pays)
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

    public List<VilleDTO1> search(String keyword){
        return this.villeRepository.search(keyword).stream().map(ville -> VilleDTO1.builder()
                .id_ville(ville.getId_ville())
                .nom_ville(ville.getNom_ville())
                .id_pays(ville.getPays().getId_pays())
                .nom_pays(ville.getPays().getNom_pays())
                .build()).collect(Collectors.toList());
    }





    public boolean delete(Long id_ville){
        if(!this.villeRepository.existsById(id_ville))  throw new VilleNotFoundException("ville not found") ;
        var ville = this.villeRepository.findById(id_ville).orElseThrow(()-> new VilleNotFoundException("ville not found"));
        if(!ville.getFournisseurs().isEmpty() && !ville.getPorts().isEmpty()){
                return  false ;
        }
        this.villeRepository.deleteById(id_ville);
        return true;
    }

}
