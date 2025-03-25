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

    public abstract String description();
}