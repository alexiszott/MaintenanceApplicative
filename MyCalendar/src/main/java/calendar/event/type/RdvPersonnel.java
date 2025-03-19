package calendar.event.type;

import calendar.Event;
import calendar.event.attribut.*;

import java.time.LocalDateTime;

public class RdvPersonnel extends Event {
    public RdvPersonnel(TitreEvenement title, Proprietaire proprietaire, LocalDateTime dateDebut, DureeMinutes dureeMinutes) {
        super(title, proprietaire, dateDebut, dureeMinutes);
    }

    @Override
    public String description() {
        return "RDV : " + title.getTitre() + " à " + dateDebut.toString();
    }
}
