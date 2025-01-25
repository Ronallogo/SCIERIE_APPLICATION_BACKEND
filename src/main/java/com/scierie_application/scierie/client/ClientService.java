package com.scierie_application.scierie.client;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.stereotype.Service;

import com.scierie_application.scierie.handler.exeption.SocieteNotFoundException;

import com.scierie_application.scierie.societe.SocieteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ClientService {

    @Autowired
    private  RepositoryClient repositoryClient;
    @Autowired
    private SocieteRepository societeRepository;


    public ClientDTO1 create(ClientDTO1 client){


        if(!this.societeRepository.existsById(client.getId_societe())) throw new SocieteNotFoundException("societe not found") ;

        var societe = this.societeRepository.findById(client.getId_societe());

        repositoryClient.save(Client.builder()
            .id_client(client.getId_client())
            .adresse(client.getAdresse())
            .email(client.getEmail())
            .fax(client.getFax())
            .societe(societe.get())
            .build());
        return ClientDTO1.builder()
            .id_client(client.getId_client())
            .adresse(client.getAdresse())
            .email(client.getEmail())
            .fax(client.getFax())
            .id_societe(client.getId_societe())
            .build();
    }



    public ClientDTO1 edit(ClientDTO1 client){
        if(!this.repositoryClient.existsById(client.getId_client()))  throw new SocieteNotFoundException("client not found") ;
        var societe = this.societeRepository.findById(client.getId_societe());
        if(!societe.isPresent()) throw new SocieteNotFoundException("societe not found") ;
        var e = Client.builder()
            .id_client(client.getId_client())
            .adresse(client.getAdresse())
            .email(client.getEmail())
            .fax(client.getFax())
            .societe(societe.get())
            .build();
        this.repositoryClient.save(e);
        client.setId_societe(e.getSociete().getId_societe());
        return client;
    }   

  public List<ClientDTO1> getAllClient(){
        return this.repositoryClient.findAll().stream().map(s -> ClientDTO1.builder()
            .id_client(s.getId_client())
            .adresse(s.getAdresse())
            .email(s.getEmail())
            .fax(s.getFax())
            .id_societe(s.getSociete().getId_societe())
            .build()).collect(Collectors.toList());
    }


    public boolean delete(Long id_client){
        this.repositoryClient.deleteById(id_client);
        return true;
    }
}
