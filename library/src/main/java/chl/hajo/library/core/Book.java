package chl.hajo.library.core;

import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A book written by some author(s)
 * Core model class
 * @author hajo
 */
@NoArgsConstructor
@EqualsAndHashCode(of = {"isbn"})
public class Book implements Serializable {

    @Setter
    @Getter
    private String isbn;
    @Setter
    @Getter
    private String title;
    @Setter
    @Getter
    private Genre genre;
    @Setter
    @Getter
    private double price;

    public Book(String isbn, String title, double price) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" + "isbn=" + isbn + ", title="
                + title + ", genre=" + genre
                + ", price=" + price + '}';
    }

}
