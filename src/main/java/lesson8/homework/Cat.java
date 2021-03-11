package lesson8.homework;

public class Cat implements Running, Jumping {
    int runningDistance;
    int jumpingHeight;

    boolean isActive = true;

    public Cat(int runningDistance, int jumpingHeight) {
        this.runningDistance = runningDistance;
        this.jumpingHeight = jumpingHeight;
    }

    @Override
    public void run(Track track) {
        if (track.getLength() > runningDistance) {
            isActive = false;
            System.out.println("Кот не смог пробежать");
        } else {
            System.out.printf("Кот пробежал %d, а мог бы %d%n", track.getLength(), runningDistance);
        }
    }

    @Override
    public void jump(Wall wall) {
        if (wall.getHeight() > jumpingHeight) {
            isActive = false;
            System.out.println("Кот не смог перепрыгнуть");
        } else {
            System.out.printf("Кот перепрыгнул %d, а мог бы %d%n", wall.getHeight(), jumpingHeight);
        }
    }

    @Override
    public boolean isActive() {
        return isActive;
    }
}
