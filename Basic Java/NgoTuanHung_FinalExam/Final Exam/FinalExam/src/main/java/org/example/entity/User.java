package org.example.entity;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private int expInYear;
    private String proSkill;
    private int projectID;
    private Role role;

    public User(int id, String name, String email, String password, int expInYear, String proSkill, int projectID, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.expInYear = expInYear;
        this.proSkill = proSkill;
        this.projectID = projectID;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", expInYear=" + expInYear +
                ", proSkill='" + proSkill + '\'' +
                ", projectID=" + projectID +
                ", role=" + role +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
