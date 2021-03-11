package lesson8.homework;

public class Wall {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void printInfo() {
        System.out.println("Стена высотой " + height);
    }
}
