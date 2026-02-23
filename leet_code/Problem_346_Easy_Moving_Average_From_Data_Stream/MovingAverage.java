package leet_code.Problem_346_Easy_Moving_Average_From_Data_Stream;

import java.util.ArrayDeque;
import java.util.Deque;

public class MovingAverage {

    private int size;
    private Deque<Integer> queue;
    private double runningSum;

    /**
     * Initializes the MovingAverage object.
     * Khởi tạo đối tượng MovingAverage.
     */
    public MovingAverage(int size) {
        this.size = size;
        this.queue = new ArrayDeque<>();
        this.runningSum = 0;
    }

    /**
     * Adds a new value to the stream and returns the moving average.
     * Thêm một giá trị mới vào luồng và trả về trung bình động.
     */
    public double next(int val) {
        if (queue.size() == size) {
            // Remove the oldest element
            // Xóa phần tử cũ nhất
            runningSum -= queue.pollFirst();
        }

        queue.offerLast(val);
        runningSum += val;

        return runningSum / queue.size();
    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println("Result 1: " + movingAverage.next(1)); // 1.0
        System.out.println("Result 2: " + movingAverage.next(10)); // 5.5
        System.out.println("Result 3: " + movingAverage.next(3)); // 4.66667
        System.out.println("Result 4: " + movingAverage.next(5)); // 6.0
    }
}
