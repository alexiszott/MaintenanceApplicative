package calendar.event.Attribut;

import calendar.user.Utilisateur;
import calendar.user.Utilisateurs;

public class Participants {

    Utilisateurs participants;

    public void ajouterParticipant(Utilisateur participant) {
        participants.ajouterUtilisateur(participant);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Utilisateur user : participants.getUtilisateur()) {
            if (res.length() > 0) {
                res.append(" ");
            }
            res.append(user.getNom());
        }
        return res.toString();
    }

}
