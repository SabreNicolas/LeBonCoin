package leSuperCoin.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table( name = "categorie",schema = "lesupercoin")
public class Categorie implements Serializable {

    @Id
    @Column(name = "idCategorie")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomCategorie")
    private String nom;

    @ManyToOne
    @JoinColumn(name="idSurCategorie", referencedColumnName = "idSurCategorie")
    private SurCategorie surCategorie;

    public Categorie() {
    }

    public Long getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public SurCategorie getSurCategorie() {
        return surCategorie;
    }

    public void setSurCategorie(SurCategorie surCategorie) {
        this.surCategorie = surCategorie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categorie categorie = (Categorie) o;
        return Objects.equals(nom, categorie.nom) &&
                Objects.equals(surCategorie, categorie.surCategorie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, surCategorie);

    }

    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", surCategorie=" + surCategorie +
                '}';
    }
}
