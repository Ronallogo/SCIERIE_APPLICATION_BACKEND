package com.scierie_application.scierie.client;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/scierie/client")
@CrossOrigin("*")
public class ClientController {
    @Autowired
    private ClientService clientService;

}
