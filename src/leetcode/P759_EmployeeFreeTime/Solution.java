package leetcode.P759_EmployeeFreeTime;

import java.util.*;

class Interval {
    public int start;
    public int end;

    public Interval() {
    }

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
}

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> allWork = new ArrayList<>();
        for (List<Interval> employee : schedule) {
            allWork.addAll(employee);
        }

        Collections.sort(allWork, (a, b) -> a.start - b.start);

        List<Interval> res = new ArrayList<>();
        int prevEnd = allWork.get(0).end;

        for (int i = 1; i < allWork.size(); i++) {
            Interval curr = allWork.get(i);
            if (curr.start > prevEnd) {
                // There is a gap
                res.add(new Interval(prevEnd, curr.start));
            }
            prevEnd = Math.max(prevEnd, curr.end);
        }

        return res;
    }
}
