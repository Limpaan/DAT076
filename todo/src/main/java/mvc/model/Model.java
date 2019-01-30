package mvc.model;

/**
 * Singleton to access the model parts of application
 *
 * @author hajo
 */
public enum Model {
    INSTANCE;

    private final TodoList list = new TodoList();
    private final UserRegistry reg = new UserRegistry();

    public TodoList getList() {
        return list;
    }

    public UserRegistry getUserRegistry() {
        return reg;
    }

    public User login(String email, String passwd) {
        User user = reg.lookup(new User(null, passwd, email));
        if(user == null)
            return null;

        return user;
    }

    public User register(String name, String password, String email) {
        User user = new User(name, password, email);
        if(reg.register(user))
            return user;
        return null;
    }

    public void add(TodoNote note) {
        list.add(note);
    }

    public void delete(Long id) {
        list.delete(id);
    }

    public void edit(Long id, String text) {
        list.edit(id, text);
    }
}
