package calendar;

import calendar.event.Evenements;
import calendar.gloable.EventID;

import java.time.LocalDateTime;

public class CalendarManager {

    public Evenements evenements;

    public CalendarManager() {
        this.evenements = new Evenements();
    }

    public void ajouterEvent(Event event) {
        evenements.addEvent(event);
    }

    public Evenements eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        return evenements.eventsDansPeriode(debut, fin);
    }

    public void afficherEvenements() {
        for (Event e : evenements.getEvenements()) {
            System.out.println(e.description());
        }
    }

    public void supprimerEvenements(EventID id) {
        evenements.supprimerEvenements(id);
    }

    public void afficherListe(Evenements events) {
        if (events.isEmpty()) {
            System.out.println("Aucun événement trouvé pour cette période.");
        } else {
            System.out.println("Événements trouvés : ");
            for (Event e : events.getEvenements()) {
                System.out.println("- " + e.description());
            }
        }
    }
}