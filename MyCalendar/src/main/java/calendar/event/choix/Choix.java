package calendar.event.choix;// Classe Choix qui regroupe plusieurs actions et permet de les exécuter via un identifiant

import calendar.event.action.Action;

import java.util.HashMap;
import java.util.Map;

public abstract class Choix {
    private Map<Integer, Action> actions = new HashMap<>();

    public void ajouterAction(int code, Action action) {
        actions.put(code, action);
    }

    public void executerWithCode(int code) {
        Action action = actions.get(code);
        if (action != null) {
            action.execute();
        } else {
            System.out.println("Choix invalide");
        }
    }

    abstract public void executerChoix();
}
