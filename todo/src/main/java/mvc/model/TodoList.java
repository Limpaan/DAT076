package mvc.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Emulating a OO - model of a TODO list
 *
 *          *** NOTHING TO DO HERE ***
 *
 * @author hajo
 *
 */
public class TodoList {

    private final List<TodoNote> notes = new ArrayList<>();

    public TodoList() {
        // Test data
        notes.add(new TodoNote(1L, "Äta gröt"));
        notes.add(new TodoNote(2L, "Rensa sallad"));
        notes.add(new TodoNote(3L, "Jaga älg"));
    }

    public List<TodoNote> getNotes() {
        Collections.sort(notes, new Comparator<TodoNote>() {
            @Override
            public int compare(TodoNote t1, TodoNote t2) {
                return t1.getId() < t2.getId() ? -1
                        : Objects.equals(t1.getId(), t2.getId()) ? 0 : 1;
            }

        });
        return notes;
    }

    public TodoNote getById(Long id) {

        for (TodoNote t : notes) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    public void add(TodoNote note) {
        if (!notes.contains(note)) {
            notes.add(note);
        }
    }

    public void update(TodoNote note) {
        TodoNote n = delete(note.getId());
        note.setId(n.getId());
        note.setDateTime(n.getDateTime());
        add(note);
    }

    public TodoNote delete(Long id) {
        TodoNote n = getById(id);
        notes.remove(n);
        return n;
    }

    public int size() {
        return notes.size();
    }

    public void edit(Long id, String text) {
        TodoNote n = getById(id);
        n.edit(text);
    }
}
