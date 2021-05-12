package shared.transferobjects;

import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputChat inputChat = (InputChat) o;
        return chat.equals(inputChat.chat) && rating.equals(inputChat.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chat, rating);
    }
}
