package calendar.event;

import calendar.Event;
import calendar.event.Attribut.DateEvenement;
import calendar.event.Type.Periodique;
import calendar.event.Type.RdvPersonnel;
import calendar.event.Type.Reunion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Evenements {

    List<Event> evenements;

    public Evenements() {
        this.evenements = new ArrayList<>();
    }

    public void addEvent(Event event) {
        evenements.add(event);
    }

    public List<Event> getEvenements() {
        return evenements;
    }

    public void setEvenements(List<Event> evenements) {
        this.evenements = evenements;
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
        LocalDateTime fin1 = event1.dateDebut.plusMinutes(event1.dureeMinutes.getDuree());
        LocalDateTime fin2 = event2.dateDebut.plusMinutes(event2.dureeMinutes.getDuree());

        if (event1 instanceof Periodique && event2 instanceof Periodique) {
            return false;
        }

        return event1.dateDebut.isBefore(fin2) && fin1.isAfter(event2.dateDebut);
    }


}
