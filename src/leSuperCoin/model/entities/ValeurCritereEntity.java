package leSuperCoin.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table( name = "valeurcritere",schema = "lesupercoin")
public class ValeurCritereEntity implements Serializable {


    @Column(name = "value")
    private String valeur;

    @Id
    @ManyToOne
    @JoinColumn(name="annonce_idAnnonce", referencedColumnName = "idAnnonce")
    private AnnonceEntity annonceEntity;

    @Id
    @ManyToOne
    @JoinColumn(name="critere_idCritere", referencedColumnName = "idCritere")
    private CritereEntity critereEntity;

    public ValeurCritereEntity() {
    }

    public int getId() {
        return annonceEntity.getId();
    }
    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public AnnonceEntity getAnnonceEntity() {
        return annonceEntity;
    }

    public void setAnnonceEntity(AnnonceEntity annonceEntity) {
        this.annonceEntity = annonceEntity;
    }

    public CritereEntity getCritereEntity() {
        return critereEntity;
    }

    public void setCritereEntity(CritereEntity critereEntity) {
        this.critereEntity = critereEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValeurCritereEntity that = (ValeurCritereEntity) o;
        return Objects.equals(valeur, that.valeur) &&
                Objects.equals(annonceEntity, that.annonceEntity) &&
                Objects.equals(critereEntity, that.critereEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valeur, annonceEntity, critereEntity);
    }

    @Override
    public String toString() {
        return "ValeurCritereEntity{" +
                "id=" + getId() +
                ", valeur='" + valeur + '\'' +
                ", annonceEntity=" + annonceEntity +
                ", critereEntity=" + critereEntity +
                '}';
    }
}