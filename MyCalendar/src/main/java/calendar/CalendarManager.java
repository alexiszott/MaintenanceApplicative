package calendar;

import calendar.event.attribut.DateEvenement;
import calendar.event.Evenements;

import java.time.LocalDateTime;

public class CalendarManager {

    public Evenements evenements;

    public void ajouterEvent(Event event) {
        evenements.addEvent(event);
    }

    public Evenements eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        return evenements.eventsDansPeriode(debut, fin);
    }

    public boolean conflit(Event e1, Event e2) {
        return evenements.conflit(e1, e2);
    }

    public void afficherEvenements() {
        for (Event e : evenements.getEvenements()) {
            System.out.println(e.description());
        }
    }
}