package leetcode.P649_Dota2Senate;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();

        // Populate queues with indices
        // Điền các hàng đợi với các chỉ số
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        // Simulate voting rounds
        // Mô phỏng các vòng bỏ phiếu
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rIndex = radiant.poll();
            int dIndex = dire.poll();

            // The senator with smaller index acts first
            // Thượng nghị sĩ có chỉ số nhỏ hơn hành động trước
            if (rIndex < dIndex) {
                // Radiant bans Dire, goes to next round
                radiant.offer(rIndex + n);
            } else {
                // Dire bans Radiant, goes to next round
                dire.offer(dIndex + n);
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
