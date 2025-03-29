package calendar;

import calendar.gloable.EventID;
import calendar.gloable.Titre;
import calendar.event.attribut.*;

import java.time.LocalDateTime;

public abstract class Event {
    public EventID eventId;
    public Titre title;
    public Proprietaire proprietaire;
    public LocalDateTime dateDebut;
    public DureeMinutes dureeMinutes;


    public Event(TitreEvenement title, Proprietaire proprietaire, LocalDateTime dateDebut, DureeMinutes dureeMinutes, EventID id) {
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
        this.eventId = id;
    }

    public EventID getEventId() {
        return eventId;
    }

    public void setEventId(EventID eventId) {
        this.eventId = eventId;
    }

    public Titre getTitle() {
        return title;
    }

    public void setTitle(Titre title) {
        this.title = title;
    }

    public Proprietaire getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Proprietaire proprietaire) {
        this.proprietaire = proprietaire;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public DureeMinutes getDureeMinutes() {
        return dureeMinutes;
    }

    public void setDureeMinutes(DureeMinutes dureeMinutes) {
        this.dureeMinutes = dureeMinutes;
    }

    public abstract String description();
}