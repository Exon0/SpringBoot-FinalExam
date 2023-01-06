package tn.esprit.ilyes_bettaieb_examen.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.ilyes_bettaieb_examen.entities.Client;
import tn.esprit.ilyes_bettaieb_examen.entities.Plat;

@Repository
public interface PlatRepository extends CrudRepository<Plat,Integer> {
}
