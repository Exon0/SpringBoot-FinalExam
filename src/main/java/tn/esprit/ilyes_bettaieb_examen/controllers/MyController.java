package tn.esprit.ilyes_bettaieb_examen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ilyes_bettaieb_examen.entities.Client;
import tn.esprit.ilyes_bettaieb_examen.entities.Cuisinier;
import tn.esprit.ilyes_bettaieb_examen.entities.Plat;
import tn.esprit.ilyes_bettaieb_examen.services.Iservice;

import java.util.List;


@RestController
@RequestMapping("/examen")
public class MyController {

    @Autowired
    Iservice iservice;

    @PostMapping("/addCliient")
    public Client ajouterClient(@RequestBody Client client) {
        return iservice.ajouterClient(client);
    }
    @PostMapping("/addCuisinier")
    public void ajouterCuisinier(@RequestBody Cuisinier cuisinier) {
         iservice.ajouterCuisinier(cuisinier);
    }

    @PostMapping("/addPlat")
    public void ajouterPlatAffecterClientEtCuisinier(@RequestBody Plat plat, @RequestParam Integer idClient,@RequestParam Integer idCuisinier) {

        iservice.ajouterPlatAffecterClientEtCuisinier(plat,idClient,idCuisinier);

    }

    @GetMapping("/afficherPlar")
    public List<Plat> afficherListPlatParClient(@RequestParam String nom,@RequestParam String prenom) {
        return iservice.afficherListPlatParClient(nom,prenom);
    }

    @GetMapping("/CalculerMontant")
    public float montantApayer(@RequestParam Integer idClient) {
        return iservice.montantApayer(idClient);
    }

    @PutMapping("/ModifierImc")
    public void modifierImc(@RequestParam Integer idClient) {
        iservice.modifierImc(idClient);
    }



    }
