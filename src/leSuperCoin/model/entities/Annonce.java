package leSuperCoin.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table( name = "annonce",schema = "lesupercoin")
public class Annonce implements Serializable {

    @Id
    @Column(name = "idAnnonce")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name="idUser", referencedColumnName = "idUser")
    private User utilisateur;

    @ManyToOne
    @JoinColumn(name="idCategorie", referencedColumnName = "idCategorie")
    private Categorie categorie;

    @Column(name = "statut" )
    private boolean statut;

    @Column(name = "description" )
    private String description;

    public Annonce() {
    }

    public int getId() {
        return id;
    }


    public User getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(User utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Annonce annonce = (Annonce) o;
        return statut == annonce.statut &&
                Objects.equals(utilisateur, annonce.utilisateur) &&
                Objects.equals(categorie, annonce.categorie) &&
                Objects.equals(description, annonce.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(utilisateur, categorie, statut, description);
    }

    @Override
    public String toString() {
        return "Annonce{" +
                "id=" + id +
                ", utilisateur=" + utilisateur +
                ", categorie=" + categorie +
                ", statut=" + statut +
                ", description='" + description + '\'' +
                '}';
    }
}
