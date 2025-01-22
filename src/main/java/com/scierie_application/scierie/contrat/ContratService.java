package com.scierie_application.scierie.contrat;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scierie_application.scierie.client.RepositoryClient;
import com.scierie_application.scierie.handler.exeption.ContratNotFoundException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ContratService {
    @Autowired
    private  ContratRepository contratRepository;

    @Autowired
    private  RepositoryClient clientRepository;


    public ContratDTO1 create(ContratDTO1 contrat){
        if(!this.clientRepository.existsById(contrat.getClient())) throw new ContratNotFoundException("client not found") ;

        
        contratRepository.save(Contrat.builder()
            .id_contrat(contrat.getId_contrat())
            .date_contrat(contrat.getDate_contrat())
            .montant(contrat.getMontant())
            .build());
        return contrat;
    }


    public ContratDTO1 edit(ContratDTO1 contrat){
        if(!this.contratRepository.existsById(contrat.getId_contrat()))  throw new ContratNotFoundException("contrat not found") ;
        var e = Contrat.builder()
            .id_contrat(contrat.getId_contrat())
            .date_contrat(contrat.getDate_contrat())
            .montant(contrat.getMontant())
            .build();
        this.contratRepository.save(e);
        return contrat;
    }




    public boolean delete(Long id_contrat){
        if(!this.contratRepository.existsById(id_contrat))  throw new ContratNotFoundException("contrat not found") ;
        this.contratRepository.deleteById(id_contrat);
        return true;
    }

    public List<ContratDTO1> getAllContrat(){
        return this.contratRepository.findAll().stream().map(contrat -> ContratDTO1.builder()
            .id_contrat(contrat.getId_contrat())
            .date_contrat(contrat.getDate_contrat())
            .montant(contrat.getMontant())
            .build()).collect(Collectors.toList());
    }

}
