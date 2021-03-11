package lesson8.part2;

public class Dog {
    protected Color color;

    public Dog(Color color) {
        this.color = color;
        System.out.println(color.name());
        System.out.println(color);
        System.out.println(color.getRussianColor());
    }

    public Color getColor() {
        return color;
    }
}
