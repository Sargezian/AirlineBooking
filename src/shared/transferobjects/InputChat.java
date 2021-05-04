package shared.transferobjects;

import java.io.Serializable;

public class InputChat implements Serializable {

    public String chat;
    public Rating rating;

    public InputChat(String chat, Rating rating) {
        this.chat = chat;
        this.rating = rating;
    }

    public double getStar() {
        return rating.star;
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
