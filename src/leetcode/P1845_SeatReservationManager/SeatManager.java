package leetcode.P1845_SeatReservationManager;

import java.util.PriorityQueue;

public class SeatManager {
    private PriorityQueue<Integer> pq;
    private int nextSeat;

    public SeatManager(int n) {
        pq = new PriorityQueue<>();
        nextSeat = 1;
    }

    public int reserve() {
        if (!pq.isEmpty()) {
            return pq.poll();
        }
        return nextSeat++;
    }

    public void unreserve(int seatNumber) {
        pq.offer(seatNumber);
    }
}
