package com.esprit.spring.controller;

import com.esprit.spring.entites.Rayon;
import com.esprit.spring.services.IRayon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rayon")
public class RayonRestController {
    @Autowired
    IRayon rayonService;
    //http://localhost:8081/springMVC/servlet/rayon/retrieve_all_rayons
    @GetMapping("/retrieve_all_rayons")
    @ResponseBody
    public List<Rayon> getRayons() {
        List<Rayon> rayons = rayonService.retrieveAllRayons();
        System.out.println(rayons);
        return rayons;
    }
    // http://localhost:8081/springMVC/servlet/rayon/add_rayon
    @PostMapping("/add_rayon")
    @ResponseBody
    public Rayon addRayon(@RequestBody Rayon c) {
        Rayon rayon = rayonService.addRayon(c);
        return rayon;
    }
    //http://localhost:8081/springMVC/servlet/rayon/retrieve_rayon/1
    @GetMapping("/retrieve_rayon/{rayon_id}")
    @ResponseBody
    public Rayon retrieveRayon(@PathVariable("rayon_id") Long rayonId) {
        return rayonService.retrieveRayon(rayonId);
    }




    // http://localhost:8081/springMVC/servlet/rayon/remove-rayon/1
    @DeleteMapping("/remove-rayon/{rayon-id}")
    @ResponseBody
    public void removeRayon(@PathVariable("rayon-id") Long rayonId) {
        rayonService.deleteRayon(rayonId);
    }

    // http://localhost:8081/springMVC/servlet/rayon/modify_rayon
    @PutMapping("/modify_rayon")
    @ResponseBody
    public Rayon modifyRayon(@RequestBody Rayon rayon) {
        return rayonService.updateRayon(rayon);
    }

}
