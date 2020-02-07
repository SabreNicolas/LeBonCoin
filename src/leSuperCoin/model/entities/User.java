package leSuperCoin.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table( name = "user",schema = "lesupercoin")
public class User implements Serializable {

    @Id
    @Column(name="id_user")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long idUser;

    @Column(name="nom")
    private String nom;

    @Column(name="prenom")
    private String prenom;

    @Column(name="pseudo")
    private String pseudo;

    @Column(name="mdp")
    private String motDePasse;

    @Column(name="mail")
    private String mail;
}