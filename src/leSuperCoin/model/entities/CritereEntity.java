package leSuperCoin.model.entities;


import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table( name = "critere",schema = "lesupercoin")
public class CritereEntity implements Serializable {

    @Id
    @Column(name = "idCritere")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="idSurCategorie", referencedColumnName = "idSurCategorie")
    private SurCategorieEntity surCategorieEntity;

    @Column(name="nomCritere")
    private String nomCritere;

    @Column(name="type")
    private String type;

    public CritereEntity() {
    }

    public int getId() {
        return id;
    }


    public SurCategorieEntity getSurCategorieEntity() {
        return surCategorieEntity;
    }

    public void setSurCategorieEntity(SurCategorieEntity surCategorieEntity) {
        this.surCategorieEntity = surCategorieEntity;
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
        CritereEntity critereEntity = (CritereEntity) o;
        return Objects.equals(surCategorieEntity, critereEntity.surCategorieEntity) &&
                Objects.equals(nomCritere, critereEntity.nomCritere) &&
                Objects.equals(type, critereEntity.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surCategorieEntity, nomCritere, type);
    }

    @Override
    public String toString() {
        return "CritereEntity{" +
                "id=" + id +
                ", categorie=" + surCategorieEntity +
                ", nomCritere='" + nomCritere + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
