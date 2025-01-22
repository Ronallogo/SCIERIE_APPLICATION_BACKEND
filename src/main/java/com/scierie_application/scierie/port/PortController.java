package com.scierie_application.scierie.port;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


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


    @PutMapping("/edit")
    public PortDTO1 editPort( @RequestBody PortDTO1 entity) {
         
        return this.portService.editPort(entity);
    }


    @DeleteMapping("/delete/{id_port}")
    public boolean deletePort(@PathVariable Long id_port){
        return this.portService.deletePort(id_port);
    }



    
}
