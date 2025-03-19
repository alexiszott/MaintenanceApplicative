package calendar;

import calendar.Globale.Titre;
import calendar.event.*;

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
    public Participants participants;
    public DateEvenement dateDebut
    public DureeMinutes dureeMinutes
    public Lieu lieu;
    public Frequence frequenceJours;



    public Event(TitreEvenement title, Proprietaire proprietaire, DateEvenement dateDebut, DureeMinutes dureeMinutes,
                 Lieu lieu, Participants participants) {

        this.type = type;
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
        this.lieu = lieu;
        this.participants = participants;
    }

    public String description() {
        String desc = "";
        if (type.equals("RDV_PERSONNEL")) {
            desc = "RDV : " + title + " à " + dateDebut.toString();
        } else if (type.equals("REUNION")) {
            desc = "Réunion : " + title + " à " + lieu + " avec " + participants;
        } else if (type.equals("PERIODIQUE")) {
            desc = "Événement périodique : " + title + " tous les " + frequenceJours + " jours";
        }
        return desc;
    }
}