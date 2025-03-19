package calendar.user;

public class Membre extends Utilisateur{

    Nom nom;
    MotDePasse motdepasse;

    public Membre(Nom name, MotDePasse password) {
        super(name);
        this.motdepasse = password;
    }

    public Nom getNom() {
        return nom;
    }

    public MotDePasse getMotdepasse() {
        return motdepasse;
    }
}
