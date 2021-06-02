package shared.transferobjects;

import java.io.Serializable;
import java.util.Objects;

public class Rating implements Serializable {

    private double star;

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
