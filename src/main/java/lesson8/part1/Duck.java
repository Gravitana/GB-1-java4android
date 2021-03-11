package lesson8.part1;

public class Duck extends Animal implements Flying, HomeAnimal{
    @Override
    public void fly() {
        System.out.println("Утка летит");
    }

    @Override
    public void lovingPeople() {

    }

    @Override
    public void run() {

    }

    @Override
    public void voice() {

    }
}
