package com.scierie_application.scierie.contrat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/auth/scierie/contrat")
public class ContratController {


    @Autowired
    private ContratService contratService;


    @PostMapping(value = "/create", produces = "application/json", consumes = "application/json")
    public ContratDTO1 create(ContratDTO1 c) {
        return this.contratService.create(c);

    }

    @PutMapping("/edit")
    public ContratDTO1 edit(ContratDTO1 entity) {
        return this.contratService.edit(entity);
    }

    @GetMapping("/all")
    public List<ContratDTO1> getAllContrat() {
        return this.contratService.getAllContrat();
    }

    @DeleteMapping("/delete/{id_contrat}")
    public boolean delete(@PathVariable Long id_contrat) {
        return this.contratService.delete(id_contrat);
    }

}
