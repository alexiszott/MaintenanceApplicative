package calendar.user;

import java.util.List;

public class Utilisateurs {

    List<Utilisateur> utilisateurs;

    public List<Utilisateur> getUtilisateur() {
        return utilisateurs;
    }

    public void setUtilisateur(List<Utilisateur> utilisateur) {
        this.utilisateurs = utilisateur;
    }

    public void ajouterUtilisateur(Utilisateur utilisateur){
        utilisateurs.add(utilisateur);
    }
}
