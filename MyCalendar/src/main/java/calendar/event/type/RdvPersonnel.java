package calendar.event.type;

import calendar.Event;
import calendar.event.attribut.*;
import calendar.gloable.EventID;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RdvPersonnel extends Event {
    public RdvPersonnel(TitreEvenement title, Proprietaire proprietaire, LocalDateTime dateDebut, DureeMinutes dureeMinutes) {
        super(title, proprietaire, dateDebut, dureeMinutes, new EventID());
    }

    @Override
    public String description() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "RDV : " + title + " à " + dateDebut.format(formatter) + " (" + eventId.getId()+ ")";
    }
}
