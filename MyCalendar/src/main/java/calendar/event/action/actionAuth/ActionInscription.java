package calendar.event.action.actionAuth;

import calendar.event.action.Action;
import calendar.event.choix.Choix;
import calendar.user.*;

import java.util.Scanner;

import static calendar.Main.utilisateur;
import static calendar.Main.utilisateurs;

// Action concrète pour l'inscription
public class ActionInscription implements Action {
    private Choix choixPostInscription;

    public ActionInscription(Choix choixPostInscription) {
        this.choixPostInscription = choixPostInscription;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nom d'utilisateur : ");
        String nom = scanner.nextLine();
        System.out.print("Mot de passe : ");
        String motDePasse = scanner.nextLine();
        System.out.print("Répéter mot de passe : ");
        String confirmation = scanner.nextLine();

        if (!motDePasse.equals(confirmation)) {
            System.out.println("Les mots de passe ne correspondent pas.");
            return;
        }

        utilisateur = new Utilisateur(new Nom(nom), new MotDePasse(motDePasse));
        utilisateurs.ajouterUtilisateur(utilisateur);
        System.out.println("Inscription réussie pour " + nom);
        choixPostInscription.executerChoix();
    }
}
