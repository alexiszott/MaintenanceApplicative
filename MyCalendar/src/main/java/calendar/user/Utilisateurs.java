package calendar.user;

import java.util.ArrayList;
import java.util.List;

public class Utilisateurs {

    List<Utilisateur> utilisateurs;

    public Utilisateurs() {
        this.utilisateurs = new ArrayList<>();
    }

    public List<Utilisateur> getUtilisateur() {
        return utilisateurs;
    }

    public void setUtilisateur(List<Utilisateur> utilisateur) {
        this.utilisateurs = utilisateur;
    }

    public void logOutUtilisateur(Utilisateur utilisateur){
        this.utilisateurs.remove(utilisateur);
    }

    public void ajouterUtilisateur(Utilisateur utilisateur) {
        utilisateurs.add(utilisateur);
    }

    public Utilisateur trouverUtilisateur(Nom nomUtilisateur, MotDePasse motDePasseUtilisateur) {
        Utilisateur userFind = null;

        String mdpUtilisateur = motDePasseUtilisateur.motdepasse;
        String nomtilisateur = nomUtilisateur.nom;

        for (Utilisateur user : utilisateurs) {
            String mdpUser = user.getMotDePasse().motdepasse;
            String nomUser = user.getNom().nom;

            if (nomtilisateur.equals(nomUser) && mdpUtilisateur.equals(mdpUser)) {
                userFind = user;
            }
        }

        return userFind;
    }
}
