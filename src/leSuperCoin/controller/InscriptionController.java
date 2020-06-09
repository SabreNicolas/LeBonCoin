package leSuperCoin.controller;

import leSuperCoin.view.View;


public class InscriptionController {
    private Controller controller;

    private String pseudo;
    private String motDePasse;
    private String nom;
    private String prenom;
    private String mail;

    public InscriptionController(Controller controller) {
        this.controller = controller;
    }

    public Controller getController() {
        return this.controller;
    }

    public String getPseudo() {
        return this.pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMotDePasse() {
        return this.motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isReady() {
        return this.pseudo != null && this.motDePasse != null && this.nom != null && this.prenom != null && this.mail != null;
    }

    public void submit() {
        this.controller.getModel().register(pseudo, motDePasse, nom, prenom, mail);
        this.controller.getView().navigate(View.Target.ACCUEIL);

    }
}
