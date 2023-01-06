package tn.esprit.ilyes_bettaieb_examen.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.ilyes_bettaieb_examen.entities.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client,Integer> //a verifier avant de commencer la couche service
{
    Client findClientByNomAndPrenom(String nom,String prenom);

}
