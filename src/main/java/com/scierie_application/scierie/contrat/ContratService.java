package com.scierie_application.scierie.contrat;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scierie_application.scierie.client.RepositoryClient;
import com.scierie_application.scierie.handler.exeption.ContratNotFoundException;
import com.scierie_application.scierie.monnaie.MonnaieRepository;



import jakarta.transaction.Transactional;

@Service
@Transactional
public class ContratService {
    @Autowired
    private  ContratRepository contratRepository;

    @Autowired
    private  RepositoryClient clientRepository;


    @Autowired
    private MonnaieRepository monnaieRepository;


    public ContratDTO1 create(ContratDTO1 contrat){
        var client = this.clientRepository.findById(contrat.getClient())
            .orElseThrow(() -> new ContratNotFoundException("client not found"));
        
        var monnaie = this.monnaieRepository.findByNom(contrat.getMonnaie())
            .orElseThrow(() -> new ContratNotFoundException("monnaie not found"));


        
        contratRepository.save(Contrat.builder()
            .id_contrat(contrat.getId_contrat())
            .date_contrat(contrat.getDate_contrat())
            .montant(contrat.getMontant())
            .monnaie(monnaie)
            .date_contrat(null != contrat.getDate_contrat() ? contrat.getDate_contrat() : null)
            .etat_contrat(null != contrat.getEtat_contrat() ? contrat.getEtat_contrat() : null)
            .code_contrat(Contrat.generateUUID())
            .typeContract(null != contrat.getTypeContract() ? contrat.getTypeContract() : null)
            .client(client)
            .build());
        return contrat;
    }


    public ContratDTO1 edit(ContratDTO1 contrat){
        if(!this.contratRepository.existsById(contrat.getId_contrat()))  throw new ContratNotFoundException("contrat not found") ;
        var client = this.clientRepository.findById(contrat.getClient())
            .orElseThrow(() -> new ContratNotFoundException("client not found"));

        var con = Contrat.builder()
            .id_contrat(contrat.getId_contrat())
            .date_contrat(contrat.getDate_contrat())
            .montant(contrat.getMontant())
            .monnaie(monnaieRepository.findByNom(contrat.getMonnaie()).get())
            .date_contrat(contrat.getDate_contrat())
            .etat_contrat(contrat.getEtat_contrat())
            .code_contrat(contrat.getCode_contrat())
            .typeContract( contrat.getTypeContract() )
            .client(client)
            .build();

        this.contratRepository.save(con);
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
            .client( contrat.getClient().getId_client())
        
            .build()).collect(Collectors.toList());
    }

}
