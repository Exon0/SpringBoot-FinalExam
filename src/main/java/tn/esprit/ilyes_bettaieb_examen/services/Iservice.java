package tn.esprit.ilyes_bettaieb_examen.services;

import tn.esprit.ilyes_bettaieb_examen.entities.Client;
import tn.esprit.ilyes_bettaieb_examen.entities.Cuisinier;
import tn.esprit.ilyes_bettaieb_examen.entities.Plat;

import java.util.List;

public interface Iservice {

    //change database startegy to update
    //check CrudRepository primitive type!!!

    Client ajouterClient(Client client);

    void ajouterCuisinier(Cuisinier cuisinier);

    void ajouterPlatAffecterClientEtCuisinier(Plat plat,Integer idClient,Integer idCuisinier);

    List<Plat> afficherListPlatParClient(String nom,String prenom);

    float montantApayer(Integer idClient);

    void modifierImc(Integer idClient);

    void afficherListCuisinier();
}
