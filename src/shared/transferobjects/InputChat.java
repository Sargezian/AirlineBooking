package shared.transferobjects;

import java.io.Serializable;

public class InputChat implements Serializable {

    private String input;

    public InputChat(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

}
