package chl.hajo.library.dao;

import chl.hajo.library.core.Book;
import chl.hajo.library.service.DataSupplier;

import javax.ejb.Stateless;
import java.util.List;

/**
 * All orders Responsible for putting new PurchaseOrders objects into the model
 *
 * @author hajo
 */
@Stateless
public class BookCatalogue  {
    private List<Book> books = DataSupplier.getBooks();
    
    public BookCatalogue() {
       
    }


    public List<Book> findAll() {
        return books;
    }

    public void create(Book book) {
        books.add(book);
    }

    public void delete(String isbn) {
        Book del = find(isbn);
        if( del != null) {
            books.remove(del);
        }
    }

    public Book find(String isbn) {
        for(Book b : books) {
            if(b.getIsbn().equals(isbn)) {
                return b;
            }
        }

        return null;
    }

    public void update(Book book) {
        delete(book.getIsbn());
        create(book);
    }
}
