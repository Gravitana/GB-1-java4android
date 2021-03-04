package lesson7.oop;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int countFoods) {
        food -= countFoods;
    }

    public void printInfo() {
        System.out.println("Кол-во еды в миске: " + food);
    }

    public int getFood() {
        return food;
    }
}
