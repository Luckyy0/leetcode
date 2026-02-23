package leet_code.Problem_379_Medium_Design_Phone_Directory;

import java.util.*;

public class PhoneDirectory {

    private Set<Integer> available;
    private Queue<Integer> queue;

    /**
     * Design Phone Directory.
     * Use Queue for available pool and Set for O(1) checks.
     * Time: O(1) for all ops, Space: O(N).
     * 
     * Thiết kế Danh bạ Điện thoại.
     * Sử dụng Hàng đợi cho nhóm số khả dụng và Tập hợp cho việc kiểm tra O(1).
     */
    public PhoneDirectory(int maxNumbers) {
        available = new HashSet<>();
        queue = new LinkedList<>();
        for (int i = 0; i < maxNumbers; i++) {
            available.add(i);
            queue.offer(i);
        }
    }

    /**
     * Provides a number that is not assigned to anyone.
     */
    public int get() {
        if (queue.isEmpty())
            return -1;
        int num = queue.poll();
        available.remove(num);
        return num;
    }

    /**
     * Checks if a number is available or not.
     */
    public boolean check(int number) {
        return available.contains(number);
    }

    /**
     * Recycle or release a number.
     */
    public void release(int number) {
        if (available.contains(number))
            return;
        available.add(number);
        queue.offer(number);
    }

    public static void main(String[] args) {
        PhoneDirectory directory = new PhoneDirectory(3);
        System.out.println("Get: " + directory.get()); // 0
        System.out.println("Get: " + directory.get()); // 1
        System.out.println("Check 2: " + directory.check(2)); // true
        System.out.println("Get: " + directory.get()); // 2
        System.out.println("Check 2: " + directory.check(2)); // false
        directory.release(2);
        System.out.println("Check 2: " + directory.check(2)); // true
    }
}
