package leetcode.P2194_CellsInARangeOnAnExcelSheet;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> cellsInRange(String s) {
        String[] parts = s.split(":");
        char c1 = parts[0].charAt(0);
        int r1 = parts[0].charAt(1) - '0';
        char c2 = parts[1].charAt(0);
        int r2 = parts[1].charAt(1) - '0';

        List<String> res = new ArrayList<>();

        for (char c = c1; c <= c2; c++) {
            for (int r = r1; r <= r2; r++) {
                res.add("" + c + r);
            }
        }

        return res;
    }
}
