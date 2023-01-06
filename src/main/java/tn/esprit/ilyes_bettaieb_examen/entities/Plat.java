package tn.esprit.ilyes_bettaieb_examen.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import tn.esprit.ilyes_bettaieb_examen.entities.enums.Categorie;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Plat implements Serializable {

    //mapped by fel child
    //unid -> configuration fel parent
    //3 tables : ManyToMany(UNI + BI) - OneToMany(UNI)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String label;
    private float prix;
    private float calories;
    @Enumerated(EnumType.STRING)
    private Categorie categorie;

    @ManyToOne
    @JsonIgnore
    Client client;

    @ManyToMany
    List<Cuisinier> cuisinierList;
}
