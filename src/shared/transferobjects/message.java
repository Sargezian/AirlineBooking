package shared.transferobjects;

import java.io.Serializable;

public class message implements Serializable {
    private String type;
    private Object arg;

    public message(String type, Object arg) {
        this.type = type;
        this.arg = arg;
    }

    public String getType() {
        return type;
    }

    public Object getArg() {
        return arg;
    }
}
