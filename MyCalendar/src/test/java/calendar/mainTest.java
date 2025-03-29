package calendar;

import static org.junit.jupiter.api.Assertions.*;

import calendar.event.Evenements;
import calendar.event.attribut.DureeMinutes;
import calendar.event.attribut.Proprietaire;
import calendar.event.attribut.TitreEvenement;
import calendar.event.type.RdvPersonnel;
import calendar.gloable.EventID;
import calendar.user.MotDePasse;
import calendar.user.Nom;
import calendar.user.Utilisateur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class CalendarManagerTest {
    private Evenements calendrier;
    private Event evenement;

    @BeforeEach
    void setUp() {
        Utilisateur utilisateur = new Utilisateur(new Nom("Alexis"), new MotDePasse("123"));
        calendrier = new Evenements();
        evenement = new RdvPersonnel(
                new TitreEvenement("Dentiste"),
                new Proprietaire(utilisateur),
                LocalDateTime.of(2025, 4, 1, 10, 0),
                new DureeMinutes(60)
        );
    }

    @Test
    void testCreationEvenement() {
        assertNotNull(evenement);
        assertEquals("Dentiste", evenement.getTitle().getTitre());
        assertEquals(60, evenement.getDureeMinutes().getDuree());
    }


    @Test
    void testEvenementsEstVideInitialement() {
        assertTrue(calendrier.isEmpty());
    }

    @Test
    void testSuppressionEvenementExistant() {
        calendrier.addEvent(evenement);
        assertFalse(calendrier.isEmpty());
        EventID id = calendrier.getEvenements().get(0).getEventId();
        calendrier.supprimerEvenements(id);
        assertTrue(calendrier.isEmpty());
    }

    @Test
    void testSuppressionEvenementInexistant() {
        calendrier.addEvent(evenement);
        calendrier.supprimerEvenements(new EventID());
        assertFalse(calendrier.isEmpty());
    }
}
