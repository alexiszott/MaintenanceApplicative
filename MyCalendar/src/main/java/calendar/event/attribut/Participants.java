package calendar.event.attribut;

import calendar.user.Membre;
import calendar.user.Membres;
import calendar.user.Utilisateur;
import calendar.user.Utilisateurs;

public class Participants {

    Membres participants;

    public Participants() {
        this.participants = new Membres();
    }

    public void ajouterParticipant(Membre participant) {
        participants.ajouterMembre(participant);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Membre user : participants.getMembres()) {
            if (res.length() > 0) {
                res.append(" ");
            }
            res.append(user.getNom().getNom());
        }
        return res.toString();
    }

}
