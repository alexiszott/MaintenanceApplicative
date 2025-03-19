package calendar.event.attribut;

public class Frequence {

    int frequence;

    public Frequence(int frequence) {
        if (frequence <= 0) {
            frequence = 7;
        }
        this.frequence = frequence;
    }

    public int getFrequence() {
        return frequence;
    }

    public void setFrequence(int frequence) {
        this.frequence = frequence;
    }
}
