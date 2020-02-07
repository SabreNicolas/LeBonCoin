package leSuperCoin.model.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "categorie",schema = "lesupercoin")
public class Categorie implements Serializable {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long idCategorie;

    @Column(name = "nom")
    private String nom;

}
