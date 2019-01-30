package mvc.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * A user
 *
 *    *** Nothing to do here *****
 *
 * @author hajo
 */
@EqualsAndHashCode(of = {"email", "password"})
public class User {

    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private String password;
    @Setter
    @Getter
    private String email;

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

}
