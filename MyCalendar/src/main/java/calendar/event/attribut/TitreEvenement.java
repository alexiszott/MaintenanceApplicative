package calendar.event.attribut;

import calendar.gloable.Titre;

public class TitreEvenement extends Titre{

    public TitreEvenement(String titre) {
        super(titre);
    }

    @Override
    public String toString() {
        return getTitre();
    }
}
