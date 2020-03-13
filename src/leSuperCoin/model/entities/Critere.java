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
    private int id;

    @ManyToOne
    @JoinColumn(name="idSurCategorie", referencedColumnName = "idSurCategorie")
    private SurCategorie surCategorie;

    @Column(name="nomCritere")
    private String nomCritere;

    @Column(name="type")
    private String type;

    public Critere() {
    }

    public int getId() {
        return id;
    }


    public SurCategorie getSurCategorie() {
        return surCategorie;
    }

    public void setSurCategorie(SurCategorie surCategorie) {
        this.surCategorie = surCategorie;
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
        return Objects.equals(surCategorie, critere.surCategorie) &&
                Objects.equals(nomCritere, critere.nomCritere) &&
                Objects.equals(type, critere.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surCategorie, nomCritere, type);
    }

    @Override
    public String toString() {
        return "Critere{" +
                "id=" + id +
                ", categorie=" + surCategorie +
                ", nomCritere='" + nomCritere + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
