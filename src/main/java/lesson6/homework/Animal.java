package lesson6.homework;

public abstract class Animal {

    private String name;

    private int maxRunDistance;
    private int maxSwimDistance;

    private static int count;

    public Animal(String name, int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        count++;
    }

    public void run(int distance) {
        if (maxRunDistance <= 0)
            System.out.printf("%s не умеет бегать!\n", name);
        else if (distance > maxRunDistance)
            System.out.printf("%s пробежал только %d метров из %d.\n", name, maxRunDistance, distance);
        else
            System.out.printf("%s пробежал %d метров.\n", name, distance);
    }

    public void swim(int distance) {
        if (maxSwimDistance <= 0)
            System.out.printf("%s не умеет плавать!\n", name);
        else if (distance > maxSwimDistance)
            System.out.printf("%s не сможет проплыть %d метров.\n", name, distance);
        else
            System.out.printf("%s проплыл %d метров.\n", name, distance);
    }

    public static int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxRunDistance() {
        return maxRunDistance;
    }

    public void setMaxRunDistance(int maxRunDistance) {
        this.maxRunDistance = maxRunDistance > 0 ? maxRunDistance : 0;
    }

    public int getMaxSwimDistance() {
        return maxSwimDistance;
    }

    public void setMaxSwimDistance(int maxSwimDistance) {
        this.maxSwimDistance = maxSwimDistance > 0 ? maxSwimDistance : 0;
    }
}
