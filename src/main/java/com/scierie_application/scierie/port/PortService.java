package com.scierie_application.scierie.port;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scierie_application.scierie.ville.VilleDTO1;
import com.scierie_application.scierie.ville.VilleRepository;
import com.scierie_application.scierie.handler.exeption.PortNotFoundException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PortService {

    @Autowired
    private PortRepository portRepository;

    @Autowired
    private VilleRepository villeRepository;


    public PortDTO2 createPort(PortDTO2 port){ 

        var ville  = this.villeRepository.findById(port.getId_ville()).orElseThrow(()-> new RuntimeException("Ville not ville"));
        this.portRepository.save(
            Port.builder()
            .nom_port(port.getNom_port())
            .ville(ville)
            .build()
        );
        return port ;
    }


    public PortDTO2 editPort(PortDTO2 port){

        if(!this.portRepository.existsById(port.getId_port()))  throw new PortNotFoundException("port not found") ;
        var ville = this.villeRepository.findByNom_Ville(port.getNom_ville()).get();
        var e = Port.builder()
            .id_port(port.getId_port())
            .nom_port(port.getNom_port())
            .ville(ville)
            .build();
        this.portRepository.save(e);
         
        return port;
    }


    public List<PortDTO1> getAllPort(){
        return  this.portRepository.findAll()
            .stream().map( x -> PortDTO1.builder()
            .id_port(x.getId_port())
            .nom_port(x.getNom_port())
            .ville(
                VilleDTO1.builder()
                .id_pays(x.getVille().getPays().getId_pays())
                .nom_pays(x.getVille().getPays().getNom_pays())
                .id_ville(x.getVille().getId_ville())
                .nom_ville(x.getVille().getNom_ville())
                .build()
            )
            .build())
            .collect(Collectors.toList());

    }

    public boolean deletePort(Long id_port){
        if(!this.portRepository.existsById(id_port)) return false ;
        this.portRepository.deleteById(id_port);
        return true ;
    }


    public List<PortDTO1> searchPort(String keyword){
            return this.portRepository.findPort(keyword).stream()
            .map(
                x->PortDTO1.builder()
                .id_port(x.getId_port())
                .nom_port(x.getNom_port())
                .ville( 
                    VilleDTO1.builder()
                    .id_pays(x.getVille().getPays().getId_pays())
                    .nom_pays(x.getVille().getPays().getNom_pays())
                    .nom_ville(x.getVille().getNom_ville())
                    .id_ville(x.getVille().getId_ville())
                    .build()
                )
                .build()
            )
            .collect( Collectors.toList());
    }

}
