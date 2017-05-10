package main.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name = "user_st_role")
public class Role {
    private int id;
    private String login;
    private String userStRole;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "user_st_role")
    public String getUserStRole() {
        return userStRole;
    }

    public void setUserStRole(String userStRole) {
        this.userStRole = userStRole;
    }
}
