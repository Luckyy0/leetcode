package leetcode.P631_DesignExcelSumFormula;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Excel {
    private int height;
    private char width;
    private int[][] values; // Stores current value of each cell
                            // Lưu trữ giá trị hiện tại của từng ô
    private Map<String, String[]> formulas; // Maps "row:col" to formula array
                                            // Ánh xạ "hàng:cột" tới mảng công thức

    public Excel(int height, char width) {
        this.height = height;
        this.width = width;
        this.values = new int[height + 1][width - 'A' + 1];
        this.formulas = new HashMap<>();
    }

    public void set(int row, char column, int val) {
        // Remove formula if exists
        String key = row + ":" + column;
        formulas.remove(key);

        values[row][column - 'A'] = val;
    }

    public int get(int row, char column) {
        String key = row + ":" + column;
        if (formulas.containsKey(key)) {
            // Re-calculate if it's a formula?
            // Problem says sum formula exists until overlapped.
            // And implicitly, values updates propagate.
            // So get() should return current computed value.
            return calculate(row, column);
        }
        return values[row][column - 'A'];
    }

    public int sum(int row, char column, String[] numbers) {
        String key = row + ":" + column;
        formulas.put(key, numbers);
        return calculate(row, column);
    }

    private int calculate(int row, char column) {
        String key = row + ":" + column;
        if (!formulas.containsKey(key)) {
            return values[row][column - 'A'];
        }

        String[] numbers = formulas.get(key);
        int sum = 0;

        for (String str : numbers) {
            if (str.indexOf(':') == -1) {
                // Single cell "A1"
                int[] pos = parse(str);
                sum += calculate(pos[0], (char) pos[1]);
            } else {
                // Range "A1:B2"
                String[] parts = str.split(":");
                int[] start = parse(parts[0]);
                int[] end = parse(parts[1]);

                for (int r = start[0]; r <= end[0]; r++) {
                    for (int c = start[1]; c <= end[1]; c++) {
                        sum += calculate(r, (char) c);
                    }
                }
            }
        }

        values[row][column - 'A'] = sum; // Cache/Update value
        return sum;
    }

    private int[] parse(String s) {
        // "A1" -> [1, 'A']
        // Actually column ('A') is char. 'A' is 65.
        // Return [row, col_char_int]
        char col = s.charAt(0);
        int row = Integer.parseInt(s.substring(1));
        return new int[] { row, col };
    }
}
