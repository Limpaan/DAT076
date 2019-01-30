package mvc.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Just an example, no serious testing ...
 */
public class TodoListTest {

    TodoList list = new TodoList();

    @Test
    public void testRead() {
        TodoNote note = list.getById(23L);
        assertTrue(note == null);

        note = list.getById(1L);
        assertTrue(note != null);
    }

    @Test
    public void testCreate() {
        TodoNote note = new TodoNote("bla bla bla");
        int size = list.size();
        list.add(note);
        assertTrue(list.size() == size + 1);

    }

}
