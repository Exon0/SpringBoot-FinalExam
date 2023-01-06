package tn.esprit.ilyes_bettaieb_examen.entities;

import lombok.*;
import tn.esprit.ilyes_bettaieb_examen.entities.enums.Imc;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String nom;
    private String prenom;

    @Enumerated(EnumType.STRING)
    private Imc imc;

    @OneToMany(mappedBy = "client")
    List<Plat> Clientplats;
}
