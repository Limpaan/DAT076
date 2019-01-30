package mvc.model;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Single to do item
 *
 * *** NOTHING TO DO HERE ***
 *
 * NOTE: Immutable objects hopeless with JEE, add setter/getter for everything
 *
 * @author hajo
 */
@EqualsAndHashCode(of = "id")
public class TodoNote {

    private static final AtomicLong counter = new AtomicLong(100);

    // Using Lombok annotaions to generate setter/getter
    @Setter
    @Getter
    private Long id;
    @Setter
    @Getter
    private String text;
    @Setter
    @Getter
    private Date dateTime;
    @Setter
    @Getter
    private boolean done;

    // Often need default contructor for injection to work
    public TodoNote() {
        this("emty");
    }

    // Id for easy testing
    public TodoNote(Long id, String text) {
        this.id = id;
        Calendar cal = Calendar.getInstance();
        dateTime = cal.getTime();
        this.text = text;
        this.done = false;
    }

    public TodoNote(String text) {
        this.id = counter.incrementAndGet();
        Calendar cal = Calendar.getInstance();
        dateTime = cal.getTime();
        this.text = text;
        this.done = false;
    }

    @Override
    public String toString() {
        return "TodoNote{" + "id=" + id + ", text=" + text
                + ", dateTime=" + dateTime + ", done=" + done + '}';
    }

    void edit(String text) {
        this.text = text;
    }

}
