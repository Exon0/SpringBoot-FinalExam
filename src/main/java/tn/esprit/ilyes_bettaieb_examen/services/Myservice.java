package tn.esprit.ilyes_bettaieb_examen.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.ilyes_bettaieb_examen.entities.Client;
import tn.esprit.ilyes_bettaieb_examen.entities.Cuisinier;
import tn.esprit.ilyes_bettaieb_examen.entities.Plat;
import tn.esprit.ilyes_bettaieb_examen.entities.enums.Categorie;
import tn.esprit.ilyes_bettaieb_examen.entities.enums.Imc;
import tn.esprit.ilyes_bettaieb_examen.repositories.ClientRepository;
import tn.esprit.ilyes_bettaieb_examen.repositories.CuisinierRepository;
import tn.esprit.ilyes_bettaieb_examen.repositories.PlatRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class Myservice implements Iservice{

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    CuisinierRepository cuisinierRepository;

    @Autowired
    PlatRepository platRepository;
    @Override
    public Client ajouterClient(Client client) {

        return clientRepository.save(client);
    }

    @Override
    public void ajouterCuisinier(Cuisinier cuisinier) {
        cuisinierRepository.save(cuisinier);
    }

    @Override
    public void ajouterPlatAffecterClientEtCuisinier(Plat plat, Integer idClient, Integer idCuisinier) {
        Client client=clientRepository.findById(idClient).get();
        Cuisinier cuisinier=cuisinierRepository.findById(idCuisinier).get();
        List<Cuisinier> cuisinierList = new ArrayList<>();
        cuisinierList.add(cuisinier);
        plat.setCuisinierList(cuisinierList);
       // plat.getCuisinierList().add(cuisinier);
        int nb=0;
        platRepository.save(plat);
        for (Plat p:client.getClientplats()) {
            if(p.getCategorie().equals(Categorie.PRINCIPAL) ) {
                nb++;
            }}
            if(nb<2 || plat.getCategorie().equals(Categorie.ENTREE)|| plat.getCategorie().equals(Categorie.DESSERT))
            {
                plat.setClient(client);
                platRepository.save(plat);
            }
       //platRepository.save(plat);

        }

    @Override
    public List<Plat> afficherListPlatParClient(String nom, String prenom) {
        Client client=clientRepository.findClientByNomAndPrenom(nom,prenom);
        return new ArrayList<>(client.getClientplats());
    }

    @Override
    public float montantApayer(Integer idClient) {
        Client client=clientRepository.findById(idClient).get();
        float montant=0;
        for(Plat p:client.getClientplats()){
            montant+=p.getPrix();
        }
        return montant;
    }

    @Override
    public void modifierImc(Integer idClient) {
        Client client=clientRepository.findById(idClient).get();
        int calories=0;
        for (Plat p:client.getClientplats()) {
            calories+=p.getCalories();
        }
        if(calories<2000){
            client.setImc(Imc.FAIIBLE);
        }   if(calories==2000){
            client.setImc(Imc.IDEAL);
        }   if(calories>2000){
            client.setImc(Imc.FORT);
        }
        clientRepository.save(client);
    }

    @Override
    @Scheduled(cron = "*/15 * * * * *")
    public void afficherListCuisinier() {
        int nbP=0;
        List<Cuisinier> cuisinierList= (List<Cuisinier>) cuisinierRepository.findAll();
        for (Cuisinier cuisinier:cuisinierList) {
            for (Plat p:cuisinier.getCuisinierPlats()) {
                if(p.getCategorie().equals(Categorie.PRINCIPAL))
                    nbP++;
            }
            if(nbP>1)
                log.info("Cuisinier => NOM :"+cuisinier.getNom()+" - PRENOM :"+cuisinier.getPrenom());
                nbP=0;

        }
    }

    //TO DO: Autowire all repositories !!!!!!!!

    //change database startegy to update
    //check CrudRepository primitive type!!!

}
