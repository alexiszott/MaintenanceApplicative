package calendar.event;

import calendar.Event;

public class Periodique extends Event {

    Frequence frequenceJours;

    public Periodique(TitreEvenement title, Proprietaire proprietaire, DateEvenement dateDebut, DureeMinutes dureeMinutes, Lieu lieu, Participants participants, Frequence frequenceJours) {
        super(title, proprietaire, dateDebut, dureeMinutes, lieu, participants);
        this.frequenceJours = frequenceJours;
    }
}
