package shared.transferobjects;

import java.io.Serializable;
import java.util.Objects;

public class InputChat implements Serializable {

    private String chat;
    private Rating rating;

    public InputChat(String chat, Rating rating) {
        this.chat = chat;
        this.rating = rating;
    }

    public double getStar() {
        return rating.getStar();
    }

    public Rating getRating() {
        return rating;
    }

    public String getChat() {
        return chat;
    }

    @Override
    public String toString() {
        return "InputChat{" +
                "input='" + chat + '\'' +
                ", rating=" + rating +
                '}';
    }



}
