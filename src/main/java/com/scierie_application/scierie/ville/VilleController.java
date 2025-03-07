package com.scierie_application.scierie.ville ; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/scierie/ville")
@CrossOrigin("*")
public class VilleController {
    @Autowired
    private  VilleService villeService;

   
    @GetMapping("/all")
    public List<VilleDTO1> getVilles() {
        return villeService.getAllVille();
    }

    @GetMapping("/search/{key}")
    public List<VilleDTO1> search(@PathVariable String key) {
        return villeService.search(key);
    }
 

    @PostMapping("/create")
    public VilleDTO1 createVille(@RequestBody VilleDTO1 villeDTO1) {
        return villeService.create(villeDTO1);
    }

    @PutMapping("/edit")
    public VilleDTO1 updateVille( @RequestBody VilleDTO1 villeDTO1) {
        return villeService.edit(villeDTO1);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVille(@PathVariable Long id) {
        villeService.delete(id);
    }

}
