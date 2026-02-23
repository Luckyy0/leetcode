package leet_code.Problem_631_Hard_Design_Excel_Sum_Formula;

import java.util.*;

public class Excel {

    private class Cell {
        int val;
        // Map to store frequency of dependent cells: "ColRow" -> count
        Map<String, Integer> formula;

        Cell(int v) {
            this.val = v;
            this.formula = null;
        }

        void setFormula(Map<String, Integer> f) {
            this.formula = f;
        }

        void setValue(int v) {
            this.val = v;
            this.formula = null;
        }
    }

    private Cell[][] sheet;
    private int rows;
    private int cols;

    /**
     * Initializes the Excel sheet.
     * height: 1-26, width: 'A'-'Z'
     */
    public Excel(int height, char width) {
        this.rows = height;
        this.cols = width - 'A' + 1;
        this.sheet = new Cell[rows + 1][cols];
        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < cols; j++) {
                sheet[i][j] = new Cell(0);
            }
        }
    }

    /**
     * Sets a cell value and clears any existing formula.
     */
    public void set(int row, char column, int val) {
        sheet[row][column - 'A'].setValue(val);
    }

    /**
     * Gets the value of a cell. Recalculates if it's a sum formula.
     */
    public int get(int row, char column) {
        Cell c = sheet[row][column - 'A'];
        if (c.formula == null) {
            return c.val;
        }

        int total = 0;
        for (String key : c.formula.keySet()) {
            int count = c.formula.get(key);
            int r = Integer.parseInt(key.substring(1));
            char col = key.charAt(0);
            total += get(r, col) * count;
        }
        return total;
    }

    /**
     * Sets a sum formula for a cell and returns its current value.
     */
    public int sum(int row, char column, List<String> numbers) {
        Map<String, Integer> formula = new HashMap<>();
        for (String s : numbers) {
            if (s.contains(":")) {
                String[] parts = s.split(":");
                char colStart = parts[0].charAt(0);
                int rowStart = Integer.parseInt(parts[0].substring(1));
                char colEnd = parts[1].charAt(0);
                int rowEnd = Integer.parseInt(parts[1].substring(1));

                for (int r = rowStart; r <= rowEnd; r++) {
                    for (char c = colStart; c <= colEnd; c++) {
                        String key = "" + c + r;
                        formula.put(key, formula.getOrDefault(key, 0) + 1);
                    }
                }
            } else {
                formula.put(s, formula.getOrDefault(s, 0) + 1);
            }
        }
        sheet[row][column - 'A'].setFormula(formula);
        return get(row, column);
    }

    public static void main(String[] args) {
        Excel excel = new Excel(3, 'C');
        excel.set(1, 'A', 2);
        System.out.println("Sum C3: " + excel.sum(3, 'C', Arrays.asList("A1", "A1:B2"))); // 4
        excel.set(2, 'B', 2);
        System.out.println("Get C3: " + excel.get(3, 'C')); // 6
    }
}
