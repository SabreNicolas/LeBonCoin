package leSuperCoin.model.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "annonce",schema = "lesupercoin")
public class Annonce implements Serializable {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long idAnnonce;


    @ManyToOne
    @JoinColumn(name="utilisateur", referencedColumnName = "id_user")
    private User utilisateur;

    @ManyToOne
    @JoinColumn(name="categorie", referencedColumnName = "id_categorie")
    private Categorie categorie;

    @Column(name = "statut" )
    private boolean statut;

    @Column(name = "description" )
    private String description;


}
