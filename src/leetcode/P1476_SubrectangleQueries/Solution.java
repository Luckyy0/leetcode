package leetcode.P1476_SubrectangleQueries;

import java.util.ArrayList;
import java.util.List;

class SubrectangleQueries {
    private int[][] rectangle;
    private List<int[]> updates;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle; // Or deep copy if needed, but usually reference fine or problem implies we own
                                    // it
        // Actually usually deep copy to be safe, but LC constraints usually imply
        // static init.
        // Let's keep rect and list.
        this.updates = new ArrayList<>();
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        updates.add(new int[] { row1, col1, row2, col2, newValue });
    }

    public int getValue(int row, int col) {
        for (int i = updates.size() - 1; i >= 0; i--) {
            int[] u = updates.get(i);
            if (row >= u[0] && row <= u[2] && col >= u[1] && col <= u[3]) {
                return u[4];
            }
        }
        return rectangle[row][col];
    }
}
