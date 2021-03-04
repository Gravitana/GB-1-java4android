package lesson7.oop;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int countFoods) {
        if (food < countFoods) {
            return false;
        }

        food -= countFoods;
        return true;
    }

    public void printInfo() {
        System.out.println("Кол-во еды в миске: " + food);
        System.out.println();
    }

    public int getFood() {
        return food;
    }

    public void addFood(int countFoods) {
        if (countFoods <= 0) {
            System.out.println("В миску ничего не добавлено");
        }

        food += countFoods;
        System.out.println("В миску добавлено " + countFoods + " еды");
        System.out.println();
    }
}
