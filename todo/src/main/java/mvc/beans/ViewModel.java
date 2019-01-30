package mvc.beans;

import lombok.Getter;
import lombok.Setter;
import mvc.model.Model;
import mvc.model.TodoList;
import mvc.model.TodoNote;

import java.util.List;

/**
 * Data for JSP pages (an instance of this class is used in the JSP page)
 * 
 * ***  NOTHING TO DO HERE ***
 * 
 * @author hajo
 */

public class ViewModel {

    @Getter
    @Setter
    private TodoList todoListObject;

    @Getter
    @Setter
    private List<TodoNote> todoList;

    public ViewModel() {
        todoListObject = Model.INSTANCE.getList();
        todoList = todoListObject.getNotes();
    }
    // TODO Supply data to JSP pages
   
   
}
