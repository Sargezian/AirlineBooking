package shared.transferobjects;

import java.io.Serializable;

public class InputUser implements Serializable {

    private int id;
    private String user;
    private String password;

    public InputUser(int id, String user, String password) {
        this.id = id;
        this.user = user;
        this.password = password;
    }

    public InputUser(int id, String user) {
        this.id = id;
        this.user = user;
    }

    public InputUser(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getOutput() {
        return user;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "InputUser{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }

}
