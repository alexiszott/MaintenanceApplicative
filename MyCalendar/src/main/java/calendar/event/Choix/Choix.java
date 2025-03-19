package calendar.event.Choix;

import calendar.event.Actions.Action;

import java.util.List;
import java.util.Map;

public class Choix {

    List<Action> actions;

    public Choix(List<Action> actions) {
        this.actions = actions;
    }

    public void addAction(int order, Action action) {
        actions.add(order, action);
    }

    public void executeAction(int index) {
        if (index < actions.size() || index > actions.size()) {
            actions.get(0).execute();
        } else {
            actions.get(index).execute();
        }
    }
}
