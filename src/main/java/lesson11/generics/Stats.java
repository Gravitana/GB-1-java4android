package lesson11.generics;

public class Stats<E extends Number> {

    private E[] nums;

    public Stats(E... nums) {
        this.nums = nums;
    }

    public double avg() {
        double sum = 0.0;
        for (E num : nums) {
            sum += num.doubleValue();
        }
        return sum / nums.length;
    }

    private boolean isAvg(Stats<?> eStats) {
        return Math.abs(eStats.avg() - avg()) < 0.001;
    }


    public static void main(String[] args) {
        Stats<Integer> ints = new Stats<>(1, 2, 3, 4, 5, 6);
        Stats<Double> doubles = new Stats<>(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);

        System.out.println("avg int: " + ints.avg());
        System.out.println("avg double: " + doubles.avg());

        System.out.println("avg vs avg : " + ints.isAvg(doubles) );
    }
}

