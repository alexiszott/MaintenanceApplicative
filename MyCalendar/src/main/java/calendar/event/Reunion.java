package calendar.event;

import calendar.Event;

public class Reunion extends Event {
    public Reunion(TitreEvenement title, Proprietaire proprietaire, DateEvenement dateDebut, DureeMinutes dureeMinutes, Lieu lieu, Participants participants) {
        super(title, proprietaire, dateDebut, dureeMinutes, lieu, participants);
    }

}
