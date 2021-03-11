package lesson8.homework;

public class Human implements Running, Jumping {
    int runningDistance;
    int jumpingHeight;

    public Human(int runningDistance, int jumpingHeight) {
        this.runningDistance = runningDistance;
        this.jumpingHeight = jumpingHeight;
    }

    @Override
    public void run(Track track) {
        if (track.getLength() > runningDistance)
            System.out.println("Человек не смог пробежать");
        else
            System.out.printf("Человек пробежал %d, а мог бы %d%n", track.getLength(), runningDistance);
    }

    @Override
    public void jump(Wall wall) {
        if (wall.getHeight() > jumpingHeight)
            System.out.println("Человек не прыгает");
        else
            System.out.printf("Человек перепрыгнул %d, а мог бы %d%n", wall.getHeight(), jumpingHeight);
    }
}
