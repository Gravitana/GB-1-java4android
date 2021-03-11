package lesson8.homework;

public class Track {
    private int length;

    public Track(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void printInfo() {
        System.out.println("Беговая дорожка длиной " + length);
    }
}
