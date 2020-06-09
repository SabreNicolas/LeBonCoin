package leSuperCoin.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table( name = "categorie",schema = "lesupercoin")
public class CategorieEntity implements Serializable {

    @Id
    @Column(name = "idCategorie")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private int id;

    @Column(name = "nomCategorie")
    private String nom;

    @ManyToOne
    @JoinColumn(name="idSurCategorie", referencedColumnName = "idSurCategorie")
    private SurCategorieEntity surCategorieEntity;

    public CategorieEntity() {
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

    public SurCategorieEntity getSurCategorieEntity() {
        return surCategorieEntity;
    }

    public void setSurCategorieEntity(SurCategorieEntity surCategorieEntity) {
        this.surCategorieEntity = surCategorieEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategorieEntity categorieEntity = (CategorieEntity) o;
        return Objects.equals(nom, categorieEntity.nom) &&
                Objects.equals(surCategorieEntity, categorieEntity.surCategorieEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, surCategorieEntity);

    }

    @Override
    public String toString() {
        return "CategorieEntity{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", surCategorieEntity=" + surCategorieEntity +
                '}';
    }
}
