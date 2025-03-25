package calendar.user;

public class Utilisateur extends Membre{

    Nom nom;
    MotDePasse motDePasse;

    public Utilisateur(Nom name, MotDePasse mdp) {
        super(name);
        this.motDePasse = mdp;
    }

    public MotDePasse getMotDePasse() {
        return motDePasse;
    }
}
