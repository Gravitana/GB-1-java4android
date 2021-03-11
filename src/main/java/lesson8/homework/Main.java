package lesson8.homework;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat(10, 2);
        Human human = new Human(100, 1);
        Robot robot = new Robot(1000, 0);

        Track track = new Track(50);
        Wall wall = new Wall(1);

        Running[] runnings = {cat, human, robot};
        Jumping[] jumpings = {cat, human, robot};

        System.out.println();
        track.printInfo();

        for (Running obj : runnings) {
            doRun(obj, track);
        }

        System.out.println();
        wall.printInfo();

        for (Jumping obj : jumpings) {
            doJump(obj, wall);
        }
    }

    private static void doRun(Running obj, Track track) {
        obj.run(track);
    }

    private static void doJump(Jumping obj, Wall wall) {
        obj.jump(wall);
    }
}
