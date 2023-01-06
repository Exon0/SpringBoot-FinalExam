package tn.esprit.ilyes_bettaieb_examen.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.ilyes_bettaieb_examen.entities.Cuisinier;

@Repository
public interface CuisinierRepository extends CrudRepository<Cuisinier,Integer> {
}
