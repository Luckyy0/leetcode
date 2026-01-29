package leetcode.P621_TaskScheduler;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Count frequencies
        // Đếm tần suất
        int[] frequencies = new int[26];
        for (char task : tasks) {
            frequencies[task - 'A']++;
        }

        // Find max frequency
        // Tìm tần suất tối đa
        int maxFreq = 0;
        for (int freq : frequencies) {
            maxFreq = Math.max(maxFreq, freq);
        }

        // Count how many tasks have max frequency
        // Đếm xem có bao nhiêu tác vụ có tần suất tối đa
        int maxFreqTasks = 0;
        for (int freq : frequencies) {
            if (freq == maxFreq) {
                maxFreqTasks++;
            }
        }

        // Calculate constrained length
        // Tính độ dài bị ràng buộc
        // The most frequent task defines the structure: A _ _ A _ _ A
        // Empty slots (chunks) = maxFreq - 1
        // Chunk size = n + 1
        // Last chunk only has the tasks with maxFreq

        int result = (maxFreq - 1) * (n + 1) + maxFreqTasks;

        // The result cannot be less than total tasks (when no idle time is needed)
        // Kết quả không thể nhỏ hơn tổng số tác vụ (khi không cần thời gian nhàn rỗi)
        return Math.max(tasks.length, result);
    }
}
