package lesson8.part1;

public interface HomeAnimal extends Run, Voice{
    void lovingPeople();

    @Override
    default void action() {

    }
}
