package calendar.user;

public class Utilisateur {

    Nom nom;
    MotDePasse motdepasse;

    public Utilisateur(Nom name, MotDePasse password) {
        this.nom = name;
        this.motdepasse = password;
    }

    public Nom getNom() {
        return nom;
    }

    public MotDePasse getMotdepasse() {
        return motdepasse;
    }
}
