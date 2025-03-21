package calendar;

import calendar.event.attribut.*;
import calendar.event.type.Periodique;
import calendar.event.type.RdvPersonnel;
import calendar.event.type.Reunion;
import calendar.user.*;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CalendarManager calendar = new CalendarManager();
        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;

        Membre utilisateur = null;

        Utilisateurs allUtilisateurs = new Utilisateurs();

        while (true) {
            if (utilisateur == null) {
                System.out.println("  _____         _                   _                __  __");
                System.out.println(" / ____|       | |                 | |              |  \\/  |");
                System.out.println(
                        "| |       __ _ | |  ___  _ __    __| |  __ _  _ __  | \\  / |  __ _  _ __    __ _   __ _   ___  _ __");
                System.out.println(
                        "| |      / _` || | / _ \\| '_ \\  / _` | / _` || '__| | |\\/| | / _` || '_ \\  / _` | / _` | / _ \\| '__|");
                System.out.println(
                        "| |____ | (_| || ||  __/| | | || (_| || (_| || |    | |  | || (_| || | | || (_| || (_| ||  __/| |");
                System.out.println(
                        " \\_____| \\__,_||_| \\___||_| |_| \\__,_| \\__,_||_|    |_|  |_| \\__,_||_| |_| \\__,_| \\__, | \\___||_|");
                System.out.println(
                        "                                                                                   __/ |");
                System.out.println(
                        "                                                                                  |___/");

                System.out.println("1 - Se connecter");
                System.out.println("2 - Créer un compte");
                System.out.println("Choix : ");
g
                switch (scanner.nextLine()) {
                    case "1":
                        System.out.print("Nom d'utilisateur: ");
                        Nom nomUtilisateur = new Nom(scanner.nextLine());

                        System.out.print("Mot de passe: ");
                        MotDePasse motDePasse = new MotDePasse(scanner.nextLine());

                        utilisateur = new Membre(nomUtilisateur, motDePasse);

                        for (Membre user; allUtilisateurs.getUtilisateur()) {
                            Nom nomUtilisateurInscrit = user.getNom();
                            MotDePasse motdepasseUserInscrit = user.getMotdepasse();

                            if (nomUtilisateur.equals(nomUtilisateurInscrit) && motDePasse.equals(motdepasseUserInscrit)) {
                                utilisateur = user;
                            }
                        }

                        for (int i = 0; i < allUtilisateurs.getUtilisateur().size(); i = i + 1) {
                            if (utilisateurs[i].equals(utilisateur) && motsDePasses[i].equals(motDePasse)) {
                                utilisateur = utilisateurs[i];
                            }
                        }

                        break;

                    case "2":
                        System.out.print("Nom d'utilisateur: ");
                        utilisateur = scanner.nextLine();
                        System.out.print("Mot de passe: ");
                        motDePasse = scanner.nextLine();

                        System.out.print("Répéter mot de passe: ");
                        if (scanner.nextLine().equals(motDePasse)) {
                            utilisateurs[nbUtilisateurs] = utilisateur;
                            motsDePasses[nbUtilisateurs] = motDePasse;
                            nbUtilisateurs = nbUtilisateurs + 1;
                        } else {
                            System.out.println("Les mots de passes ne correspondent pas...");
                            utilisateur = null;
                        }
                        break;
                }
            }

            while (continuer && utilisateur != null) {
                System.out.println("\nBonjour, " + utilisateur);
                System.out.println("=== Menu Gestionnaire d'Événements ===");
                System.out.println("1 - Voir les événements");
                System.out.println("2 - Ajouter un rendez-vous perso");
                System.out.println("3 - Ajouter une réunion");
                System.out.println("4 - Ajouter un évènement périodique");
                System.out.println("5 - Se déconnecter");
                System.out.print("Votre choix : ");

                String choix = scanner.nextLine();

                switch (choix) {
                    case "1":
                        System.out.println("\n=== Menu de visualisation d'Événements ===");
                        System.out.println("1 - Afficher TOUS les événements");
                        System.out.println("2 - Afficher les événements d'un MOIS précis");
                        System.out.println("3 - Afficher les événements d'une SEMAINE précise");
                        System.out.println("4 - Afficher les événements d'un JOUR précis");
                        System.out.println("5 - Retour");
                        System.out.print("Votre choix : ");

                        choix = scanner.nextLine();

                        switch (choix) {
                            case "1":
                                calendar.afficherEvenements();
                                break;

                            case "2":
                                System.out.print("Entrez l'année (AAAA) : ");
                                int anneeMois = Integer.parseInt(scanner.nextLine());
                                System.out.print("Entrez le mois (1-12) : ");
                                int mois = Integer.parseInt(scanner.nextLine());

                                LocalDateTime debutMois = new LocalDateTime(anneeMois, mois, 1, 0, 0);
                                LocalDateTime finMois = new LocalDateTime()debutMois.plusMonths(1).minusSeconds(1);

                                afficherListe(calendar.eventsDansPeriode(debutMois, finMois));
                                break;

                            case "3":
                                System.out.print("Entrez l'année (AAAA) : ");
                                int anneeSemaine = Integer.parseInt(scanner.nextLine());
                                System.out.print("Entrez le numéro de semaine (1-52) : ");
                                int semaine = Integer.parseInt(scanner.nextLine());

                                LocalDateTime debutSemaine = LocalDateTime.now()
                                        .withYear(anneeSemaine)
                                        .with(WeekFields.of(Locale.FRANCE).weekOfYear(), semaine)
                                        .with(WeekFields.of(Locale.FRANCE).dayOfWeek(), 1)
                                        .withHour(0).withMinute(0);
                                LocalDateTime finSemaine = debutSemaine.plusDays(7).minusSeconds(1);

                                afficherListe(calendar.eventsDansPeriode(debutSemaine, finSemaine));
                                break;

                            case "4":
                                System.out.print("Entrez l'année (AAAA) : ");
                                int anneeJour = Integer.parseInt(scanner.nextLine());
                                System.out.print("Entrez le mois (1-12) : ");
                                int moisJour = Integer.parseInt(scanner.nextLine());
                                System.out.print("Entrez le jour (1-31) : ");
                                int jour = Integer.parseInt(scanner.nextLine());

                                LocalDateTime debutJour = LocalDateTime.of(anneeJour, moisJour, jour, 0, 0);
                                LocalDateTime finJour = debutJour.plusDays(1).minusSeconds(1);

                                afficherListe(calendar.eventsDansPeriode(debutJour, finJour));
                                break;
                        }
                        break;

                    case "2":
                        // Ajout simplifié d'un RDV personnel
                        System.out.print("Titre de l'événement : ");
                        String titre = scanner.nextLine();
                        System.out.print("Année (AAAA) : ");
                        int annee = Integer.parseInt(scanner.nextLine());
                        System.out.print("Mois (1-12) : ");
                        int moisRdv = Integer.parseInt(scanner.nextLine());
                        System.out.print("Jour (1-31) : ");
                        int jourRdv = Integer.parseInt(scanner.nextLine());
                        System.out.print("Heure début (0-23) : ");
                        int heure = Integer.parseInt(scanner.nextLine());
                        System.out.print("Minute début (0-59) : ");
                        int minute = Integer.parseInt(scanner.nextLine());
                        System.out.print("Durée (en minutes) : ");
                        int duree = Integer.parseInt(scanner.nextLine());

                        TitreEvenement titleRDV = new TitreEvenement(titre);
                        Proprietaire proprietaireRDV = new Proprietaire(utilisateur);
                        DateEvenement dateDebutRDV = new DateEvenement(annee, moisRdv, jourRdv, heure, minute);
                        DureeMinutes dureeMinutesRDV = new DureeMinutes(duree);

                        RdvPersonnel eventPersonnel = new RdvPersonnel(titleRDV, proprietaireRDV, dateDebutRDV, dureeMinutesRDV);

                        calendar.ajouterEvent(eventPersonnel);

                        System.out.println("Événement ajouté.");
                        break;

                    case "3":
                        // Ajout simplifié d'une réunion
                        System.out.print("Titre de l'événement : ");
                        String titre2 = scanner.nextLine();
                        System.out.print("Année (AAAA) : ");
                        int annee2 = Integer.parseInt(scanner.nextLine());
                        System.out.print("Mois (1-12) : ");
                        int moisRdv2 = Integer.parseInt(scanner.nextLine());
                        System.out.print("Jour (1-31) : ");
                        int jourRdv2 = Integer.parseInt(scanner.nextLine());
                        System.out.print("Heure début (0-23) : ");
                        int heure2 = Integer.parseInt(scanner.nextLine());
                        System.out.print("Minute début (0-59) : ");
                        int minute2 = Integer.parseInt(scanner.nextLine());
                        System.out.print("Durée (en minutes) : ");
                        int duree2 = Integer.parseInt(scanner.nextLine());
                        System.out.println("Lieu :");
                        String lieu = scanner.nextLine();

                        Participants participants = new Participants();

                        participants.ajouterParticipant(utilisateur);

                        System.out.println("Ajouter un participant ? (oui / non)");
                        while (scanner.nextLine().equals("oui")) {
                            System.out.print("Participants : " + participants);

                            Nom nomParticipant = new Nom(scanner.nextLine());
                            Participant newParticipant = new Participant(nomParticipant);
                            participants.ajouterParticipant(newParticipant);
                        }

                        TitreEvenement titleReunion = new TitreEvenement(titre);
                        Proprietaire proprietaireReunion = new Proprietaire(utilisateur);
                        LocalDateTime dateDebutReunion = new LocalDateTime(annee, moisRdv, jourRdv, heure, minute);
                        DureeMinutes dureeMinutesReunion = new DureeMinutes(duree);
                        Lieu lieuReunion = new Lieu(lieu);

                        Reunion eventReunion = new Reunion(titleReunion, proprietaireReunion, dateDebutReunion, dureeMinutesReunion, lieuReunion, participants);

                        calendar.ajouterEvent(eventReunion);

                        System.out.println("Événement ajouté.");
                        break;

                    case "4":
                        // Ajout simplifié d'une réunion
                        System.out.print("Titre de l'événement : ");
                        String titre3 = scanner.nextLine();
                        System.out.print("Année (AAAA) : ");
                        int annee3 = Integer.parseInt(scanner.nextLine());
                        System.out.print("Mois (1-12) : ");
                        int moisRdv3 = Integer.parseInt(scanner.nextLine());
                        System.out.print("Jour (1-31) : ");
                        int jourRdv3 = Integer.parseInt(scanner.nextLine());
                        System.out.print("Heure début (0-23) : ");
                        int heure3 = Integer.parseInt(scanner.nextLine());
                        System.out.print("Minute début (0-59) : ");
                        int minute3 = Integer.parseInt(scanner.nextLine());
                        System.out.print("Frequence (en jours) : ");
                        int frequence = Integer.parseInt(scanner.nextLine());

                        TitreEvenement titlePeriodique = new TitreEvenement(titre3);
                        Proprietaire proprietairePeriodique = new Proprietaire(utilisateur);
                        LocalDateTime dateDebutPeriodique = new LocalDateTime(annee3, moisRdv3, jourRdv3, heure3, minute3);
                        Frequence frequencePeriodique = new Frequence(frequence);

                        Periodique eventPeriodique = new Periodique(titlePeriodique, proprietairePeriodique, dateDebutPeriodique, dureeMinutesPeriodique, frequencePeriodique);

                        System.out.println("Événement ajouté.");
                        break;

                    default:
                        System.out.println("Déconnexion ! Voulez-vous continuer ? (O/N)");
                        continuer = scanner.nextLine().trim().equalsIgnoreCase("oui");

                        utilisateur = null;
                }
            }
        }
    }

    private static void afficherListe(List<Event> evenements) {
        if (evenements.isEmpty()) {
            System.out.println("Aucun événement trouvé pour cette période.");
        } else {
            System.out.println("Événements trouvés : ");
            for (Event e : evenements) {
                System.out.println("- " + e.description());
            }
        }
    }
}
