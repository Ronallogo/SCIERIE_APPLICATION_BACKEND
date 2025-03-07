package com.scierie_application.scierie.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/auth/scierie/client")
@CrossOrigin("*")
public class ClientController {
    @Autowired
    private ClientService clientService;


    @PostMapping(value = "/create" , produces = "application/json" , consumes = "application/json")
    public ClientDTO1 createClient(ClientDTO1 client){
        return this.clientService.create(client);
    }



    @GetMapping("/all")
    public List<ClientDTO1> getAllMethod() {
        return this.clientService.getAllClient();
    }

    @PutMapping("/edit")
    public ClientDTO1 putMethodName( @RequestBody ClientDTO1 entity) {
        return this.clientService.edit(entity);
    }


    @DeleteMapping("/delete/{id_client}")
    public boolean delete(@PathVariable Long id_client){
        return this.clientService.delete(id_client);
    }
    

}
