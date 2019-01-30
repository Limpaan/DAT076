/*
     Control part of application
 */
package mvc.control;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.model.Model;
import mvc.model.TodoList;
import mvc.model.TodoNote;
import mvc.model.User;

/**
 *
 * @author hajo
 */
@WebServlet(name = "FrontController", urlPatterns = {"/fc"})
public class FrontController extends HttpServlet {

    private static final Logger LOG = Logger.getAnonymousLogger();
    private static final Level I = Level.INFO;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String action = req.getParameter("action");
        LOG.log(I, "Action {0}", action);

        switch (action) {
            case "login":
            {
                String email = req.getParameter("email");
                String password = req.getParameter("password");
                User user = Model.INSTANCE.login(email, password);
                if (user == null) {
                    resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                } else {
                    req.getSession().setAttribute("user", user);
                    resp.sendRedirect("/todo/list.jsp");
                }
                break;
            }
            case "register":
            {
                String name = req.getParameter("name");
                String email = req.getParameter("email");
                String password = req.getParameter("password");
                User user = Model.INSTANCE.register(name, password, email);
                if(user == null) {
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                } else {
                    resp.sendRedirect("/todo/todo.jsp");
                }
                break;
            }
            case "update":
            {
                Long id = Long.parseLong(req.getParameter("id"));
                String text = req.getParameter("text");
                Model.INSTANCE.edit(id, text);
                resp.sendRedirect("/todo/list.jsp");
                break;
            }
            case "delete":
            {
                Long id = Long.parseLong(req.getParameter("id"));
                Model.INSTANCE.delete(id);
                resp.sendRedirect("/todo/list.jsp");
                break;
            }
            case "add":
            {
                Long id = findNextId();
                String text = req.getParameter("text");
                TodoNote note = new TodoNote(id, text);
                Model.INSTANCE.add(note);
                resp.sendRedirect("/todo/list.jsp");
                break;
            }
            default:
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
// TODO Other POST actions
        }
        // PRG pattern
    }

    private Long findNextId() {
        TodoList list = Model.INSTANCE.getList();
        //Returns sorted so that is nice
        List<TodoNote> notes = list.getNotes();
        Long id = notes.get(notes.size() - 1).getId() + 1;
        return id;
    }

}
