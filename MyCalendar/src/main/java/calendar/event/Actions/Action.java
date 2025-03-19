package calendar.event.Actions;

import calendar.event.Choix.Choix;

public abstract class Action {

    String message;
    Choix choix;

    public Action(String message) {
        this.message = message;
    }

    public Action(String message, Choix choix) {
        this.message = message;
        this.choix = choix;
    }

    public abstract void execute();

    public void showMessage() {
        System.out.println(message);
    }
}
