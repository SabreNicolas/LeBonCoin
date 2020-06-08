package leSuperCoin.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table( name = "photo",schema = "lesupercoin")
public class PhotoEntity implements Serializable {

    @Id
    @Column(name = "idPhoto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "photo")
    private String nom;

    @ManyToOne
    @JoinColumn(name="idAnnonce", referencedColumnName = "idAnnonce")
    private AnnonceEntity annonceEntity;

    public PhotoEntity() {
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

    public AnnonceEntity getAnnonce() {
        return annonceEntity;
    }

    public void setAnnonce(AnnonceEntity annonceEntity) {
        this.annonceEntity = this.annonceEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotoEntity photoEntity = (PhotoEntity) o;
        return Objects.equals(nom, photoEntity.nom) &&
                Objects.equals(annonceEntity, photoEntity.annonceEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, annonceEntity);
    }

    @Override
    public String toString() {
        return "PhotoEntity{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", annonce=" + annonceEntity +
                '}';
    }
}