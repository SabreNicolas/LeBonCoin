package leSuperCoin.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table( name = "annonce",schema = "lesupercoin")
public class AnnonceEntity implements Serializable {

    @Id
    @Column(name = "idAnnonce")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name="idUser", referencedColumnName = "idUser")
    private UserEntity utilisateur;

    @ManyToOne
    @JoinColumn(name="idCategorie", referencedColumnName = "idCategorie")
    private CategorieEntity categorieEntity;

    @Column(name = "statut" )
    private boolean statut;

    @Column(name = "description" )
    private String description;

    public AnnonceEntity() {
    }

    public int getId() {
        return id;
    }


    public UserEntity getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UserEntity utilisateur) {
        this.utilisateur = utilisateur;
    }

    public CategorieEntity getCategorieEntity() {
        return categorieEntity;
    }

    public void setCategorieEntity(CategorieEntity categorieEntity) {
        this.categorieEntity = categorieEntity;
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
        AnnonceEntity annonceEntity = (AnnonceEntity) o;
        return statut == annonceEntity.statut &&
                Objects.equals(utilisateur, annonceEntity.utilisateur) &&
                Objects.equals(categorieEntity, annonceEntity.categorieEntity) &&
                Objects.equals(description, annonceEntity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(utilisateur, categorieEntity, statut, description);
    }

    @Override
    public String toString() {
        return "AnnonceEntity{" +
                "id=" + id +
                ", utilisateur=" + utilisateur +
                ", categorieEntity=" + categorieEntity +
                ", statut=" + statut +
                ", description='" + description + '\'' +
                '}';
    }
}
