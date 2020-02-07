package leSuperCoin.model.entities;


import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table( name = "critere",schema = "lesupercoin")
public class Critere implements Serializable {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long idCritere;

    @ManyToOne
    @JoinColumn(name="categorie", referencedColumnName = "id_categorie")
    private Categorie categorie;

}
