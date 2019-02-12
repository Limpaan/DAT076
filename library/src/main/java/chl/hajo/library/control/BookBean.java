package chl.hajo.library.control;

import chl.hajo.library.core.Book;
import chl.hajo.library.core.Genre;
import chl.hajo.library.dao.AuthorRegistry;
import chl.hajo.library.dao.BookCatalogue;
import lombok.Getter;
import lombok.Setter;
import net.bootsfaces.component.dataTable.DataTable;
import net.bootsfaces.utils.FacesMessages;

import static java.lang.System.out;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named("book")
@SessionScoped
public class BookBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(AuthorBean.class.getName());
    @EJB        // Injecting an Enterprise bean
    private BookCatalogue bcat;
    @Getter     // Lombok
    @Setter
    private Book tmp = new Book();

    @PostConstruct
    void post() {
        out.println(this + " alive");
    }

    public void page() {
        DataTable dt = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent("bookForm:bookTable");
        LOG.log(Level.INFO, "Test {0}", dt.getJQueryEvents());
    }

    public List<Book> findAll() {
        return bcat.findAll();
    }

    public Genre getGenre(int index) {
        switch(index) {
            case 0: return Genre.THRILLER;
            case 1: return Genre.NOVEL;
            case 2: return Genre.ROMANTIC_NOVEL;
            case 3: return Genre.BIOGRAPHY;
            default: throw new Error("Unknown genre");
        }
    }

    public void add() {
        try {
            bcat.create(tmp);
            FacesMessages.info("Success");
        } catch(RuntimeException sql) {
            FacesMessages.warning("Failure" + sql.getMessage());
        }
        tmp = new Book();
    }

    public void cancel() {
        tmp = new Book();
    }

    public void update() {
        bcat.update(tmp);
        tmp = new Book();
    }

    public void setBook() {
        tmp = bcat.find(tmp.getIsbn());
    }

    public void delete() {
        bcat.delete(tmp.getIsbn());
        tmp = new Book();
    }
}
