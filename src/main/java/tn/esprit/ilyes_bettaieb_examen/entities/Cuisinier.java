package tn.esprit.ilyes_bettaieb_examen.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Cuisinier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String nom;
    private String prenom;

    @ManyToMany(mappedBy = "cuisinierList",fetch = FetchType.EAGER)
            @JsonIgnore
    List<Plat> CuisinierPlats;
}
