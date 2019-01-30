package mvc.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A user registry
 *
 *  *** Nothing to do here *****
 *
 *
 * @author hajo
 */
public class UserRegistry {

    private final List<User> users = new ArrayList();

    public UserRegistry() {
        users.add(new User("Anonymous", "anon", "anon@anon"));
    }

    public boolean register(User user) {
        if (!users.contains(user)) {
            return users.add(user);
        }
        return false;
    }

    public User lookup(User user) {
        if (users.contains(user)) {
            return users.get(users.indexOf(user));
        }
        return null;
    }

    public int size() {
        return users.size();
    }

}
