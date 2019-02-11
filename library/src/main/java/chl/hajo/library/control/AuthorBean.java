package chl.hajo.library.control;

import chl.hajo.library.core.Author;
import chl.hajo.library.dao.AuthorRegistry;
import chl.hajo.library.service.DataSupplier;
import java.io.Serializable;
import static java.lang.System.out;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import net.bootsfaces.utils.FacesMessages;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import net.bootsfaces.component.dataTable.DataTable;


/**
 * This is an CDI bean, look at annotations
 * https://docs.oracle.com/javaee/7/tutorial/cdi-basic.htm
 * 
 * Also using library Lombok for setter/getters 
 * 
 * This is part of the control layer handling interaction between view
 * and model
 * 
 * @author hajo
 */
@Named("auth")
//@RequestScoped
@SessionScoped
public class AuthorBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(AuthorBean.class.getName());
    @EJB        // Injecting an Enterprise bean
    private AuthorRegistry areg;
    @Getter     // Lombok
    @Setter
    private Author tmp = new Author();
   

    @PostConstruct // CDI life cycle callbacks
    void post() {
        out.println(this + "Alive");
    }

    public void page() {
       // Faces context hold all data relevant for this request
       DataTable dt = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent("authorForm:authorTable");
       LOG.log(Level.INFO, "Test {0}", dt.getJQueryEvents()); 
    }
    // ------------ Navigation -------------------

    public void cancel() {
        tmp = new Author();
    }

    // --------- Call backend -------------------------
    public void setAuthor() {
        tmp = areg.find(tmp.getId());
    }

    public List<Author> findAll() {
        return areg.findAll();
    }

    public void add() {
        tmp.setAddress(DataSupplier.getRandomAddress());
        try {
            areg.create(tmp);
            FacesMessages.info("Success");
        } catch (RuntimeException sql) {
            String message = sql.getMessage();
            FacesMessages.info("Fail " + message);
        }
        tmp = new Author();
    }

    public void update() {
        areg.update(tmp);
        tmp = new Author();
    }

    public void delete() {
        areg.delete(tmp.getId());
        tmp = new Author();
    }

}
