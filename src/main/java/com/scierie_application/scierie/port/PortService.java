package com.scierie_application.scierie.port;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scierie_application.scierie.ville.VilleRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PortService {

    @Autowired
    private PortRepository portRepository;

    @Autowired
    private VilleRepository villeRepository;


    public Port createPort(PortDTO1 port){

        var ville = this.villeRepository.findById(port.getVille()).get();
        return portRepository.save(Port.builder()
                .id_port(port.getId_port())
                .nom_port(port.getNom_port())
                .ville(ville)
                .build());
    }

}
