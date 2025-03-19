package calendar.event;

import java.time.LocalDateTime;

public class DateEvenement {

    LocalDateTime dateTime;

    public DateEvenement(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
