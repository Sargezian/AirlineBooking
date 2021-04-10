package shared.transferobjects;

import java.io.Serializable;

public class InputUser implements Serializable {

    private String output;

    private int id;

    public InputUser(int id, String output) {
        this.output = output;
        this.id = id;
    }

    public InputUser(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }

    public int getId() {
        return id;
    }
}
