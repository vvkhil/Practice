package entities;

public class User {
    private Integer id;
    private String login;
    private String email;
    private String password;

    private Integer roleId;

    public User(int id) {
        this.id = id;
    }

    public User(int id, String login, String email, String password, int roleId) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Integer getRoleId() {
        return roleId;
    }

}
