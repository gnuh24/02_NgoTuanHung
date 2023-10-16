package entity;

public class User {
    private int id;
    private String fullname;
    private  String email;
    private String password;
    private int projectId;
    private Role role;

    public User() {
    }

    public User(int id, String fullname, String email, String password, int projectId, Role role) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.projectId = projectId;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
