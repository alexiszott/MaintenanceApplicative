package calendar.event.type;

import calendar.Event;
import calendar.event.attribut.*;

import java.time.LocalDateTime;

public class Reunion extends Event {

    Lieu lieu;
    Participants participants;

    public Reunion(TitreEvenement title, Proprietaire proprietaire, LocalDateTime dateDebut, DureeMinutes dureeMinutes, Lieu lieu, Participants participants) {
        super(title, proprietaire, dateDebut, dureeMinutes);

        this.lieu = lieu;
        this.participants = participants;
    }

    @Override
    public String description() {

        return "Réunion : " + title.getTitre() + " à " + lieu.getLieu() + " avec " + participants.toString();
    }

}
