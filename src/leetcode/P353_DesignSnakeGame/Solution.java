package leetcode.P353_DesignSnakeGame;

import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Solution {

    /**
     * Problem 353: Design Snake Game
     * Approach: Deque + HashSet
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(N)
     */
    public static class SnakeGame {
        private int width;
        private int height;
        private int[][] food;
        private int foodIndex;
        private int score;

        private Deque<Integer> body;
        private Set<Integer> bodySet;
        private int headRow;
        private int headCol;

        public SnakeGame(int width, int height, int[][] food) {
            this.width = width;
            this.height = height;
            this.food = food;
            this.foodIndex = 0;
            this.score = 0;

            this.body = new LinkedList<>();
            this.bodySet = new HashSet<>();

            // Initial position (0, 0)
            this.headRow = 0;
            this.headCol = 0;
            int initialPos = encode(0, 0);
            this.body.offerLast(initialPos);
            this.bodySet.add(initialPos);
        }

        public int move(String direction) {
            int newRow = headRow;
            int newCol = headCol;

            if (direction.equals("U"))
                newRow--;
            else if (direction.equals("D"))
                newRow++;
            else if (direction.equals("L"))
                newCol--;
            else if (direction.equals("R"))
                newCol++;

            // Check bounds
            if (newRow < 0 || newRow >= height || newCol < 0 || newCol >= width) {
                return -1;
            }

            // Check collision with body
            // IMPORTANT: If we are not eating, tail moves. Tail will vacate its spot.
            // Even if new head is currently occupied by tail, it will be free validly.

            int newHeadEncoded = encode(newRow, newCol);

            // Check if food
            boolean eating = false;
            if (foodIndex < food.length && food[foodIndex][0] == newRow && food[foodIndex][1] == newCol) {
                eating = true;
            }

            if (!eating) {
                // Remove tail
                int tail = body.pollFirst();
                bodySet.remove(tail);
            }

            // Now check if new head hits body
            if (bodySet.contains(newHeadEncoded)) {
                return -1; // Game Over
            }

            // Valid move
            body.offerLast(newHeadEncoded);
            bodySet.add(newHeadEncoded);
            headRow = newRow;
            headCol = newCol;

            if (eating) {
                score++;
                foodIndex++;
            }

            return score;
        }

        private int encode(int r, int c) {
            return r * width + c;
        }
    }

    public static void main(String[] args) {
        // 3x2 board. Food at [1,2], [0,1]
        // SnakeGame sg = new SnakeGame(3, 2, [[1, 2], [0, 1]]);
        SnakeGame sg = new SnakeGame(3, 2, new int[][] { { 1, 2 }, { 0, 1 } });

        System.out.println(sg.move("R")); // (0,1) -> 0. (food at 0,1 is index 1. food[0] is 1,2)
        // Wait, food array: 1st food is [1,2]. 2nd is [0,1].
        // Currently at (0,0). Move R -> (0,1). No food (0,1 is 2nd). No collision.
        // Score 0.

        System.out.println(sg.move("D")); // (1,1). Score 0.

        System.out.println(sg.move("R")); // (1,2). Food[0] is here! Eat. Score 1. Length 2. Tail stays.
        // Body: (0,1), (1,1), (1,2).

        System.out.println(sg.move("U")); // (0,2). Score 1. Tail (0,1) moves? Yes.
        // Body: (1,1), (1,2), (0,2).

        System.out.println(sg.move("L")); // (0,1). Food[1] is here! Eat. Score 2.

        System.out.println(sg.move("U")); // (-1, 1) -> Out of bounds. -1.
    }
}
