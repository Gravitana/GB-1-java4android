package lesson8.homework;

public class Robot implements Running, Jumping {
    int runningDistance;
    int jumpingHeight;

    public Robot(int runningDistance, int jumpingHeight) {
        this.runningDistance = runningDistance;
        this.jumpingHeight = jumpingHeight;
    }

    boolean isActive = true;

    @Override
    public void run(Track track) {
        if (track.getLength() > runningDistance) {
            isActive = false;
            System.out.println("Робот не смог пробежать");
        } else {
            System.out.printf("Робот пробежал %d, а мог бы %d%n", track.getLength(), runningDistance);
        }
    }

    @Override
    public void jump(Wall wall) {
        if (wall.getHeight() > jumpingHeight) {
            isActive = false;
            System.out.println("Робот не смог перепрыгнуть");
        } else {
            System.out.printf("Робот перепрыгнул %d, а мог бы %d%n", wall.getHeight(), jumpingHeight);
        }
    }

    @Override
    public boolean isActive() {
        return isActive;
    }
}
