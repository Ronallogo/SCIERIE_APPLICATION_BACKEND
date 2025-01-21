package com.scierie_application.scierie.port;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/auth/scierie/port")
@CrossOrigin("*")
public class PortController {
    @Autowired
    private PortService portService;



    @PostMapping(value = "/create" , produces = "application/json" , consumes = "application/json")
    public PortDTO1 createPort(PortDTO1 port){
        return this.portService.createPort(port);

    }


    @GetMapping("/all")
    public List<PortDTO1> getAllPort( ) {
        return  this.portService.getAllPort();
    }



    
}
