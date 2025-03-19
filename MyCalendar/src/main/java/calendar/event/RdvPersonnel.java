package calendar.event;

import calendar.Event;

public class RdvPersonnel extends Event {
    public RdvPersonnel(TitreEvenement title, Proprietaire proprietaire, DateEvenement dateDebut, DureeMinutes dureeMinutes, Lieu lieu, Participants participants) {
        super(title, proprietaire, dateDebut, dureeMinutes, lieu, participants);
    }


}
