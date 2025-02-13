package com.scierie_application.scierie.ravitaillement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/auth/scierie/rav")
@CrossOrigin("*")
public class RavitaillementController {
    @Autowired
    public RavitaillementService service ; 

    @PostMapping(value="/create" ,   consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public RavitaillementDTO1 create(@RequestBody RavitaillementDTO1 r){
        return  this.service.create(r);
    }

    @GetMapping("/all")
    public List<RavitaillementDTO1>  getAllRav( ) {
        return  this.service.getAllRavitaillement();
    }


    @PutMapping("/edit")
    public RavitaillementDTO1 edit(@RequestBody RavitaillementDTO1 r){
        return this.service.edit(r);

    }

    @DeleteMapping("/delete/{code_rav}")
    public boolean delete(@PathVariable String code_rav){
        return this.service.delete(code_rav);
    }

    @GetMapping("/search/{keyword}")
    public List<RavitaillementDTO1> search(@PathVariable String keyword){
            return this.service.search(keyword);
    }
    

    @GetMapping("/dataChart")
    public  int[] getDataChart(){
        return  this.service.getDataChart() ;
    }
}
