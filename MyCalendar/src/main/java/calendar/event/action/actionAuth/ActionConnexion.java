package calendar.event.action.actionAuth;

import calendar.event.action.Action;
import calendar.event.choix.Choix;
import calendar.event.choix.ChoixGestionEvenements;
import calendar.user.*;

import java.util.Scanner;

import static calendar.Main.utilisateur;
import static calendar.Main.utilisateurs;

public class ActionConnexion implements Action {
    private Choix choixPostConnexion;

    public ActionConnexion(Choix choixPostConnexion) {
        this.choixPostConnexion = choixPostConnexion;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nom d'utilisateur : ");
        Nom nom = new Nom(scanner.nextLine());
        System.out.print("Mot de passe : ");
        MotDePasse motDePasse = new MotDePasse(scanner.nextLine());

        utilisateur = utilisateurs.trouverUtilisateur(nom, motDePasse);

        if (utilisateur != null) {
            System.out.println("Connexion réussie !");
            choixPostConnexion.executerChoix();
        } else {
            System.out.println("Identifiants invalides.");
        }
    }
}
