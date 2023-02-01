package com.example.demo.ws;

import com.example.demo.pojo.Demo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = ApiRegistration.DEMO_WS)
public class DemoWs {

    public static List<Demo> listDemo = new ArrayList<Demo>();

    @GetMapping
    public List<Demo> getAllDemo(){
        return listDemo;
    }

    @GetMapping("/{libelle}")
    public Demo getDemoByLibelle(@PathVariable("libelle") String libelle){
        return listDemo.stream()
                .filter(demo -> demo.getLibelle()
                        .equals(libelle))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public void createDemo(@RequestBody Demo demo){
        listDemo.add(demo);
    }

    @PutMapping("/{libelle}")
    public void updateDemo(@RequestBody Demo demo,
                           @PathVariable("libelle") String libelle){
        Demo maDemo = getDemoByLibelle(libelle);
        maDemo.setPoid(demo.getPoid());
        listDemo.removeIf(demoItem -> demoItem.getLibelle()
                .equals(maDemo.getLibelle()));
        listDemo.add(maDemo);

    }

    @DeleteMapping("/{libelle}")
    public void deleteDemo(@PathVariable("libelle") String libelle){
        listDemo.removeIf(demoItem -> demoItem.getLibelle()
                .equals(libelle));
    }
}
