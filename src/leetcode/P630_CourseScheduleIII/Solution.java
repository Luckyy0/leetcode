package leetcode.P630_CourseScheduleIII;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int scheduleCourse(int[][] courses) {
        // Sort by lastDay ascending
        // Sắp xếp theo lastDay tăng dần
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        // PriorityQueue to store durations of taken courses (Max Heap)
        // PriorityQueue để lưu trữ thời lượng của các khóa học đã tham gia (Max Heap)
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int time = 0;
        for (int[] course : courses) {
            int duration = course[0];
            int lastDay = course[1];

            // If we add this course using current time, will it finish by lastDay?
            // Nếu chúng ta thêm khóa học này bằng thời gian hiện tại, liệu nó có kết thúc
            // trước lastDay không?
            if (time + duration <= lastDay) {
                time += duration;
                pq.offer(duration);
            } else if (!pq.isEmpty() && pq.peek() > duration) {
                // If we can't take it, but this course is shorter than the longest course we
                // took
                // We drop the longest one and take this one to save time
                // Nếu chúng ta không thể tham gia, nhưng khóa học này ngắn hơn khóa học dài
                // nhất chúng ta đã tham gia
                // Chúng ta bỏ khóa học dài nhất và tham gia khóa học này để tiết kiệm thời gian
                time += duration - pq.poll();
                pq.offer(duration);
            }
        }

        return pq.size();
    }
}
