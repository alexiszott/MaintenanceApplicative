package calendar;

import calendar.Globale.Titre;
import calendar.event.Attribut.DateEvenement;
import calendar.event.Attribut.DureeMinutes;
import calendar.event.Attribut.Proprietaire;
import calendar.event.Evenements;
import calendar.event.Type.RdvPersonnel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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