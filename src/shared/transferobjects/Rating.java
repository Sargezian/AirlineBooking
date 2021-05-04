package shared.transferobjects;

import java.io.Serializable;

public class Rating implements Serializable {

    public double star;

    public Rating(double star) {
        this.star = star;
    }

    public double getStar() {
        return star;
    }

    @Override
    public String toString() {
        return " " + star;
    }


}
