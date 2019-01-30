/*
     Control part of application
 */
package mvc.control;

import java.io.IOException;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.model.Model;
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
            default:
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
// TODO Other POST actions
        }
        // PRG pattern
    }

}
