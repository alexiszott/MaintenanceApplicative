package calendar.event.type;

import calendar.Event;
import calendar.event.attribut.*;

import java.time.LocalDateTime;

public class Periodique extends Event {

    Frequence frequenceJours;

    public Periodique(TitreEvenement title, Proprietaire proprietaire, LocalDateTime dateDebut, DureeMinutes dureeMinutes, Frequence frequenceJours) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.frequenceJours = frequenceJours;
    }

    public long getFrequenceJours() {
        return frequenceJours.getFrequence();
    }

    public void setFrequenceJours(Frequence frequenceJours) {
        this.frequenceJours = frequenceJours;
    }

    @Override
    public String description() {
        return "Événement périodique : " + title.getTitre() + " tous les " + frequenceJours.getFrequence() + " jours";
    }
}
