package RandomQuestion.TaskManagement.Entity;

import java.util.UUID;

public class User {
    protected String name;
    protected String email;
    protected String id;
    protected Role role;

    public User(String name, String email, Role role) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getId() {
        return this.id;
    }

    public Role getRole() {
        return this.role;
    }
}
