package leetcode.P855_ExamRoom;

import java.util.TreeSet;

class ExamRoom {
    int n;
    TreeSet<Integer> seats;

    public ExamRoom(int n) {
        this.n = n;
        this.seats = new TreeSet<>();
    }

    public int seat() {
        if (seats.isEmpty()) {
            seats.add(0);
            return 0;
        }

        int dist = seats.first(); // Gap at start
        int pos = 0;

        int prev = -1;
        for (int s : seats) {
            if (prev != -1) {
                int d = (s - prev) / 2;
                if (d > dist) {
                    dist = d;
                    pos = prev + d;
                }
            }
            prev = s;
        }

        // Gap at end
        if (n - 1 - seats.last() > dist) {
            pos = n - 1;
        }

        seats.add(pos);
        return pos;
    }

    public void leave(int p) {
        seats.remove(p);
    }
}
