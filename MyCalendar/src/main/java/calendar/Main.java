package calendar;

import calendar.event.action.actionAffichage.*;
import calendar.event.action.actionGestionEvenements.*;
import calendar.event.action.actionAuth.ActionConnexion;
import calendar.event.action.actionAuth.ActionInscription;
import calendar.event.choix.ChoixAuthentification;
import calendar.event.choix.ChoixGestionEvenements;
import calendar.event.choix.ChoixVisualisation;
import calendar.user.*;

import java.util.Scanner;

public class Main {

    public static Utilisateurs utilisateurs = new Utilisateurs();
    public static CalendarManager calendar = new CalendarManager();
    public static Utilisateur utilisateur;
    public static ChoixVisualisation menuVisualisation = new ChoixVisualisation();
    public static ChoixGestionEvenements menuEvenements = new ChoixGestionEvenements();
    public static ChoixAuthentification menuAuth = new ChoixAuthentification();

    public static void main(String[] args) {

        menuVisualisation.ajouterAction(1, new ActionAfficherTousEvenements());
        menuVisualisation.ajouterAction(2, new ActionAfficherEvenementsMois());
        menuVisualisation.ajouterAction(3, new ActionAfficherEvenementsSemaine());
        menuVisualisation.ajouterAction(4, new ActionAfficherEvenementsJour());
        menuVisualisation.ajouterAction(5, new ActionRetour());

        menuEvenements.ajouterAction(1, new ActionVisualiserEvenements(menuVisualisation));
        menuEvenements.ajouterAction(2, new ActionAjouterRdv());
        menuEvenements.ajouterAction(3, new ActionAjouterReunion());
        menuEvenements.ajouterAction(4, new ActionAjouterEvenementPeriodique());
        menuEvenements.ajouterAction(5, new ActionAjouterDS());
        menuEvenements.ajouterAction(6, new ActionSupprimerEvent());
        menuEvenements.ajouterAction(7, new ActionDeconnexion());


        menuAuth.ajouterAction(1, new ActionConnexion(menuEvenements));
        menuAuth.ajouterAction(2, new ActionInscription(menuEvenements));

        menuAuth.executerChoix();
    }
}