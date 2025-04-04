package calendar.event;

import calendar.Event;
import calendar.event.type.Periodique;
import calendar.gloable.EventID;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Evenements {

    private final List<Event> evenements;

    public Evenements() {
        this.evenements = new ArrayList<>();
    }

    public boolean isEmpty() {
        return evenements.isEmpty();
    }

    public void supprimerEvenements(EventID id) {
        try {
            for (Event e : evenements) {
                if (e.eventId.getId() == id.getId()) {
                    evenements.remove(e);
                    System.out.println("L'évènement " + e.title + " a été supprimer.");
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la suppression de l'événement : " + e.getMessage());
        }
    }

    public void addEvent(Event event) {
        for (Event e : evenements) {
            if (conflit(event, e)) {
                System.out.println("Conflit détecté entre " + event.title + " et " + e.title);
                return;
            }
        }
        evenements.add(event);
    }

    public List<Event> getEvenements() {
        return new ArrayList<>(evenements);
    }

    public Evenements eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        Evenements result = new Evenements();

        for (Event e : evenements) {
            if (e instanceof Periodique) {
                LocalDateTime dateTemporaire = e.dateDebut;
                Periodique periodique = (Periodique) e;

                while (dateTemporaire.isBefore(fin)) {
                    if (!dateTemporaire.isBefore(debut)) {
                        result.addEvent(e);
                        break;
                    }
                    dateTemporaire = dateTemporaire.plusDays(periodique.getFrequenceJours());
                }
            } else if (!e.dateDebut.isBefore(debut) && !e.dateDebut.isAfter(fin)) {
                result.addEvent(e);
            }
        }
        return result;
    }

    public boolean conflit(Event event1, Event event2) {
        if (event1 instanceof Periodique || event2 instanceof Periodique) {
            return false;
        }

        LocalDateTime fin1 = event1.dateDebut.plusMinutes(event1.dureeMinutes.getDuree());
        LocalDateTime fin2 = event2.dateDebut.plusMinutes(event2.dureeMinutes.getDuree());

        return event1.dateDebut.isBefore(fin2) && fin1.isAfter(event2.dateDebut);
    }
}
