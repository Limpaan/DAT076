package chl.hajo.library.dao;

import chl.hajo.library.core.Author;
import chl.hajo.library.service.DataSupplier;
import java.util.List;
import javax.ejb.Stateless;

/**
 * This is an Data access object (DAO) used to access model objects
 * 
 * It's transaction aware because it's an Enterprise Java Bean (EJB)
 * (thou we don't use a database for now, ... but used later) 
 * Look at annotation. It a stateless session bean EJB (unique per session).
 * 
 * @author hajo
 */
@Stateless
public class AuthorRegistry {
    // Simulate database
    private final List<Author> authors = DataSupplier.getAuthors();
          
    public List<Author> findByName(String name) {
       
        return null;
    }

    public Author find(String id) {
        for( Author a : authors){
            if( a.getId().equals(id)){
                return a;
            }
        }
        return null;
    }

    public List<Author> findAll() {
        return authors;
    }

    public void create(Author author) {
         authors.add(author);
    }

    public void update(Author author) {
        delete(author.getId());
        create(author);
    }

    public void delete(String id) {
        Author a = find(id);
        if( a != null){
            authors.remove(a);
        }
    }
}
