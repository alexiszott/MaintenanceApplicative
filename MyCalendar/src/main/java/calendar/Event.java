package calendar;

import calendar.Globale.Titre;
import calendar.event.Attribut.*;

import java.time.LocalDateTime;

public abstract class Event {
    //public String type; // "RDV_PERSONNEL", "REUNION", "PERIODIQUE"
    //public String title;
    //public String proprietaire;
    //public LocalDateTime dateDebut;
    //public int dureeMinutes;
    //public String lieu; // utilisé seulement pour REUNION
    //public String participants; // séparés par virgules (pour REUNION uniquement)
    //public int frequenceJours; // uniquement pour PERIODIQUE

    public Titre title;
    public Proprietaire proprietaire;
    public LocalDateTime dateDebut;
    public DureeMinutes dureeMinutes;


    public Event(TitreEvenement title, Proprietaire proprietaire, LocalDateTime dateDebut, DureeMinutes dureeMinutes) {
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
    }

    public abstract String description();
}