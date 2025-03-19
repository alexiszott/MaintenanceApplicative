package calendar.event.Attribut;

import calendar.Globale.Titre;

public class TitreEvenement extends Titre{

    public TitreEvenement(String titre) {
        super(titre);
    }

    @Override
    public String toString() {
        return getTitre();
    }
}
