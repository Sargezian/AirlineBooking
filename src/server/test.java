package server;

public class test {

    public static void main(String[] args) {

        for (int i = 0; i < 6; i++) {
            System.out.println("INSERT INTO Rating (star)VALUES ( " + i + ");" );
        }

    }
}
