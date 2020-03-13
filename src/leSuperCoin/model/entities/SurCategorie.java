package leSuperCoin.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table( name = "surcategorie",schema = "lesupercoin")
public class SurCategorie implements Serializable {

    @Id
    @Column(name = "idSurCategorie")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nomSurCategorie")
    private String nom;

    public SurCategorie() {
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SurCategorie that = (SurCategorie) o;
        return Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    @Override
    public String toString() {
        return "SurCategorie{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
