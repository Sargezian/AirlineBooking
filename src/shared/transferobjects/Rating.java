package shared.transferobjects;

import java.io.Serializable;

public class Rating implements Serializable {

    public int star;

    public Rating(int star) {
        this.star = star;
    }

    public int getStar() {
        return star;
    }

    @Override
    public String toString() {
        return " " + star;
    }


}
