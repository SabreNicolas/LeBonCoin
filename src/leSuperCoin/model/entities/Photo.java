package leSuperCoin.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table( name = "photo",schema = "lesupercoin")
public class Photo implements Serializable {

    @Id
    @Column(name = "idPhoto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "photo")
    private String nom;

    @ManyToOne
    @JoinColumn(name="idAnnonce", referencedColumnName = "idAnnonce")
    private Annonce annonce;

    public Photo() {
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

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return Objects.equals(nom, photo.nom) &&
                Objects.equals(annonce, photo.annonce);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, annonce);
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", annonce=" + annonce +
                '}';
    }
}