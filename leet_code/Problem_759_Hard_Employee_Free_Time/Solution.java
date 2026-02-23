package leet_code.Problem_759_Hard_Employee_Free_Time;

import java.util.*;

// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {
    }

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }

    @Override
    public String toString() {
        return "[" + start + "," + end + "]";
    }
}

public class Solution {

    /**
     * Finds common free time for all employees.
     * Strategy: Flatten all intervals, sort by start time, and merge to find gaps.
     * Time: O(N log N), Space: O(N).
     */
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> allIntervals = new ArrayList<>();
        for (List<Interval> list : schedule) {
            allIntervals.addAll(list);
        }

        // Sort by start time. If start times equal, end time logic handled naturally by
        // merge loop
        Collections.sort(allIntervals, (a, b) -> a.start - b.start);

        List<Interval> result = new ArrayList<>();
        if (allIntervals.isEmpty())
            return result;

        int end = allIntervals.get(0).end;

        for (int i = 1; i < allIntervals.size(); i++) {
            Interval curr = allIntervals.get(i);

            if (curr.start > end) {
                // Gap found! From previous 'end' to current 'start'
                result.add(new Interval(end, curr.start));
                end = curr.end;
            } else {
                // Overlap, extend the 'end'
                end = Math.max(end, curr.end);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        List<List<Interval>> schedule1 = new ArrayList<>();
        schedule1.add(Arrays.asList(new Interval(1, 2), new Interval(5, 6)));
        schedule1.add(Arrays.asList(new Interval(1, 3)));
        schedule1.add(Arrays.asList(new Interval(4, 10)));

        System.out.println("Result 1: " + sol.employeeFreeTime(schedule1));
        // [[3,4]]

        List<List<Interval>> schedule2 = new ArrayList<>();
        schedule2.add(Arrays.asList(new Interval(1, 3), new Interval(6, 7)));
        schedule2.add(Arrays.asList(new Interval(2, 4)));
        schedule2.add(Arrays.asList(new Interval(2, 5), new Interval(9, 12)));

        System.out.println("Result 2: " + sol.employeeFreeTime(schedule2));
        // [[5,6], [7,9]]
    }
}
