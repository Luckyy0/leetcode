package leet_code.Problem_855_Medium_Exam_Room;

import java.util.*;

/**
 * Problem 855: Exam Room
 * https://leetcode.com/problems/exam-room/
 */
public class ExamRoom {

    private final int N;
    private final TreeSet<Integer> occupied;

    /**
     * Tóm tắt chiến lược:
     * Chúng ta lưu trữ các chỉ số ghế đang có người ngồi trong một TreeSet
     * để tự động sắp xếp. Khi một sinh viên vào, chúng ta duyệt qua các
     * khoảng trống giữa các sinh viên để tìm vị trí có khoảng cách lớn nhất.
     * Đừng quên kiểm tra khoảng trống ở đầu (đến ghế 0) và ở cuối (đến ghế N-1).
     */
    public ExamRoom(int n) {
        this.N = n;
        this.occupied = new TreeSet<>();
    }

    public int seat() {
        if (occupied.isEmpty()) {
            occupied.add(0);
            return 0;
        }

        // Potential best seat and its distance to the closest person
        int bestSeat = 0;
        int maxDist = occupied.first(); // initial gap distance if we sit at 0

        // Find best seat in the gaps between students
        Integer prev = null;
        for (int s : occupied) {
            if (prev != null) {
                int dist = (s - prev) / 2;
                if (dist > maxDist) {
                    maxDist = dist;
                    bestSeat = prev + dist;
                }
            }
            prev = s;
        }

        // Final check for the gap at the end of the row
        if (N - 1 - occupied.last() > maxDist) {
            bestSeat = N - 1;
        }

        occupied.add(bestSeat);
        return bestSeat;
    }

    public void leave(int p) {
        occupied.remove(p);
    }

    public static void main(String[] args) {
        ExamRoom room = new ExamRoom(10);
        System.out.println(room.seat()); // 0
        System.out.println(room.seat()); // 9
        System.out.println(room.seat()); // 4
        System.out.println(room.seat()); // 2
        room.leave(4);
        System.out.println(room.seat()); // 5
    }
}
