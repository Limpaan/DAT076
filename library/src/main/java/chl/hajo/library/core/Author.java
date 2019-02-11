package chl.hajo.library.core;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * An author for some book(s)
 * Core model class
 * @author hajo
 */
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Author implements Serializable {

    @Getter
    @Setter
    @NotNull(message = "Name cannot be null")
    private String id;
    @Getter
    @Setter
    @NotNull(message = "Name cannot be null")
    private String firstName;
    @Setter
    @Getter
    private String lastName;
    @Getter
    @Setter
    private String email;   // Should be verified with external service
    @Getter
    @Setter
    private Address address;

    public Author(String id, String firstName, String lastName, String email, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Author{" + "id=" + id + ", firstName="
                + firstName + ", lastName=" + lastName
                + ", email=" + email + ", address="
                + address + '}';
    }

}
