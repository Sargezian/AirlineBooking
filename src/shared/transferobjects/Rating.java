package shared.transferobjects;

import java.io.Serializable;
import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return Double.compare(rating.star, star) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(star);
    }
}
