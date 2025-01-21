package com.scierie_application.scierie.port;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scierie_application.scierie.handler.exeption.PortNotFoundException;
import com.scierie_application.scierie.ville.VilleRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PortService {

    @Autowired
    private PortRepository portRepository;

    @Autowired
    private VilleRepository villeRepository;


    public PortDTO1 createPort(PortDTO1 port){

        var ville = this.villeRepository.findByNom_Ville(port.getVille()).get();
        portRepository.save(Port.builder()
            .id_port(port.getId_port())
            .nom_port(port.getNom_port())
            .ville(ville)
            .build());
        return port;
    }


    public PortDTO1 editPort(PortDTO1 port){
        if(!this.portRepository.existsById(port.getId_port()))  throw new PortNotFoundException("port not found") ;
        var ville = this.villeRepository.findByNom_Ville(port.getVille()).get();
        var e = Port.builder()
            .id_port(port.getId_port())
            .nom_port(port.getNom_port())
            .ville(ville)
            .build();
        this.portRepository.save(e);
        port.setId_ville(e.getVille().getId_ville());
        return port;
    }


    public List<PortDTO1> getAllPort(){
        return  this.portRepository.findAll()
            .stream().map( x -> PortDTO1.builder()
            .id_port(x.getId_port())
            .nom_port(x.getNom_port())
            .id_ville(x.getVille().getId_ville())
            .ville(x.getVille().getNom_ville())
            .build())
            .collect(Collectors.toList());

    }

    public boolean deletePort(Long id_port){
        if(!this.portRepository.existsById(id_port)) return false ;
        this.portRepository.deleteById(id_port);
        return true ;
    }

}
