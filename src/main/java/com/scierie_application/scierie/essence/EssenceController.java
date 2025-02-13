package com.scierie_application.scierie.essence;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
 
 
 


@RestController
@RequestMapping(value = "/api/auth/scierie/essence")
@CrossOrigin("*")
public class EssenceController {


    @Autowired
    private EssenceService essenceService ;
    @RequestMapping(value = "/create",method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public EssenceDTO1 create(@RequestBody EssenceDTO1 e){
        return this.essenceService.create(e);
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<EssenceDTO1> all(){
        return this.essenceService.getAllEssence() ; 
    }
    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public EssenceDTO1 edit(@RequestBody EssenceDTO1 e){
        return this.essenceService.edit(e);
    }

    @DeleteMapping(value = "/delete/{id_essence}")
    public boolean delete(@PathVariable Long id_essence){
        return  this.essenceService.delete(id_essence);
    }

    @GetMapping(value = "/search/{libelle}")
    public List<EssenceDTO1> search(@PathVariable String libelle){
        return this.essenceService.searchEssenceByLibelleContainDto1s(libelle);
    }

    @GetMapping("/mercuriale")
    public  Float getMethodName() {
        return    this.essenceService.mercurialeMoyenne() ;
    }


    @GetMapping("/getOne/{essence}")
     EssenceDTO1 getOne(@PathVariable String essence){
        return this.essenceService.getOne(essence);
    }


    @GetMapping("/plusAcheter")
    public EssenceDTO1 essencePlusAcheter(){
        return this.essenceService.essenceLaPlusAcheter() ;
    }

}
