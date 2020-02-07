package leSuperCoin.model.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "user",schema = "lesupercoin")
public class User implements Serializable {

    @Id
    @Column(name="idUser")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long idUser;

    @Column(name="nom")
    private String nom;

    @Column(name="prenom")
    private String prenom;

    @Column(name="login")
    private String login;

    @Column(name="mdp")
    private String motDePasse;

    @Column(name="mail")
    private String mail;
}