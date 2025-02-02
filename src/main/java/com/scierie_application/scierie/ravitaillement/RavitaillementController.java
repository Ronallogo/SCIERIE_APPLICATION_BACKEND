package com.scierie_application.scierie.ravitaillement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
 


@RestController
@RequestMapping(value = "/api/auth/scierie/rav")
@CrossOrigin("*")
public class RavitaillementController {
    @Autowired
    public RavitaillementService service ; 

    @PostMapping(value="/create")
    public RavitaillementDTO1 create(RavitaillementDTO1 r){
        return  this.service.create(r);
    }

    @GetMapping("/all")
    public List<RavitaillementDTO1>  getAllRav( ) {
        return  this.service.getAllRavitaillement();
    }


    @PutMapping("/edit")
    public RavitaillementDTO1 edit(RavitaillementDTO1 r){
        return this.service.edit(r);

    }

    @DeleteMapping("/delete/{id_rav}")
    public boolean delete(@PathVariable String id_rav){
        return this.service.delete(id_rav);
    }

    @GetMapping("/search/{keyword}")
    public List<RavitaillementDTO1> search(@PathVariable String keyword){
            return this.service.search(keyword);
    }
    

}
