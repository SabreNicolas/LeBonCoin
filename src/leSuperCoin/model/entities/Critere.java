package leSuperCoin.model.entities;


import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table( name = "critere",schema = "lesupercoin")
public class Critere implements Serializable {

    @Id
    @Column(name = "idCritere")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="idCategorie", referencedColumnName = "idCategorie")
    private Categorie categorie;

    @Column(name="nomCritere")
    private String nomCritere;

    @Column(name="type")
    private String type;

    public Critere() {
    }

    public Long getId() {
        return id;
    }


    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getNomCritere() {
        return nomCritere;
    }

    public void setNomCritere(String nomCritere) {
        this.nomCritere = nomCritere;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Critere critere = (Critere) o;
        return Objects.equals(categorie, critere.categorie) &&
                Objects.equals(nomCritere, critere.nomCritere) &&
                Objects.equals(type, critere.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categorie, nomCritere, type);
    }

    @Override
    public String toString() {
        return "Critere{" +
                "id=" + id +
                ", categorie=" + categorie +
                ", nomCritere='" + nomCritere + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
