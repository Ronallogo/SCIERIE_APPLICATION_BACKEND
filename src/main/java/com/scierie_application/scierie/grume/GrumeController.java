package com.scierie_application.scierie.grume;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
 




@RestController
@RequestMapping(value = "/api/auth/scierie/grume")
@CrossOrigin("*")
public class GrumeController {

    @Autowired
    private GrumeService gs;
 

    @PostMapping(value = "/create", produces = "application/json" , consumes = "application/json")
    public GrumeDTO1 create(@RequestBody GrumeDTO1 entity) {
       
        return this.gs.create(entity);
    }


    @PostMapping(value = "/gtr/create", produces = "application/json" , consumes = "application/json")
    public GrumeTraiterDTO1 createGtr(@RequestBody GrumeTraiterDTO1 entity) {
        return this.gs.create_gt(entity);
    }


    @GetMapping(value = "/gtr/all")
    public List<GrumeTraiterDTO1> getAllGrumeGtr() {
        return  this.gs.getAllGrumeTraiter();
    }

    
    @GetMapping(value = "/all")
    public List<GrumeDTO1> getAllGrume() {
        return  this.gs.getAllGrume();
    }

    @GetMapping(value = "/dataChart")
    public List<GrumeDTO2> getDataChart() {
        return  this.gs.dataChartStockEssence();
    }

    @GetMapping(value = "/dataGrumeTraiter/{essence}")
    public List<Integer> dataNbrGrumeTraiter(@PathVariable String essence) {
        return  this.gs.dataNbrGrumeTraiter(essence);
    }

    @PutMapping("/edit")
    public GrumeDTO1 putMethodName( @RequestBody GrumeDTO1 entity) {
 
        return this.gs.edit(entity);
       
    }

    
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return this.gs.delete(id);
    }

    @GetMapping("/search/{keyword}")
    public List<GrumeDTO1> search(@PathVariable String keyword){
        return  this.gs.search(keyword);
    }



    
    
}
