package leSuperCoin.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table( name = "valeurcritere",schema = "lesupercoin")
public class ValeurCritere implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value")
    private String valeur;

    @ManyToOne
    @JoinColumn(name="annonce_idAnnonce", referencedColumnName = "idAnnonce")
    private Annonce annonce;

    @ManyToOne
    @JoinColumn(name="critere_idCritere", referencedColumnName = "idCritere")
    private Critere critere;

    public ValeurCritere() {
    }

    public Long getId() {
        return id;
    }
    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }

    public Critere getCritere() {
        return critere;
    }
//test
    public void setCritere(Critere critere) {
        this.critere = critere;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValeurCritere that = (ValeurCritere) o;
        return Objects.equals(valeur, that.valeur) &&
                Objects.equals(annonce, that.annonce) &&
                Objects.equals(critere, that.critere);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valeur, annonce, critere);
    }

    @Override
    public String toString() {
        return "ValeurCritere{" +
                "id=" + id +
                ", valeur='" + valeur + '\'' +
                ", annonce=" + annonce +
                ", critere=" + critere +
                '}';
    }
}