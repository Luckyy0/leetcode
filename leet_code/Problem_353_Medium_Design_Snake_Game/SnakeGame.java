package leet_code.Problem_353_Medium_Design_Snake_Game;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class SnakeGame {

    private int width;
    private int height;
    private int[][] food;
    private int foodIndex;
    private int score;
    private Deque<Integer> snake;
    private Set<Integer> bodySet;

    /**
     * Design Snake Game.
     * Uses Deque for body management and Set for collision detection.
     * Time: O(1) per move, Space: O(W*H).
     * 
     * Thiết kế Trò chơi Rắn săn mồi.
     * Sử dụng Deque để quản lý thân rắn và Set để phát hiện va chạm.
     */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.foodIndex = 0;
        this.score = 0;
        this.snake = new ArrayDeque<>();
        this.bodySet = new HashSet<>();

        // Initial position (0,0)
        snake.offerFirst(0);
        bodySet.add(0);
    }

    public int move(String direction) {
        int head = snake.peekFirst();
        int r = head / width;
        int c = head % width;

        // Update head coordinate
        if (direction.equals("U"))
            r--;
        else if (direction.equals("D"))
            r++;
        else if (direction.equals("L"))
            c--;
        else if (direction.equals("R"))
            c++;

        int newHead = r * width + c;

        // 1. Boundary check
        if (r < 0 || r >= height || c < 0 || c >= width)
            return -1;

        // 2. Food check
        if (foodIndex < food.length && r == food[foodIndex][0] && c == food[foodIndex][1]) {
            // Food eaten: head grows, tail stays
            score++;
            foodIndex++;
        } else {
            // No food: tail moves out
            int tail = snake.pollLast();
            bodySet.remove(tail);
        }

        // 3. Self-collision check
        if (bodySet.contains(newHead))
            return -1;

        // 4. Update head
        snake.offerFirst(newHead);
        bodySet.add(newHead);

        return score;
    }

    // Wait, small fix in foodIndex check: food[foodIndex] is a 1D array [r, c]
    // My code had food[foodIndex].length - 2 which is wrong.
    // Fixed implementation below in write_to_file

    public static void main(String[] args) {
        int[][] food = { { 1, 2 }, { 0, 1 } };
        SnakeGame snakeGame = new SnakeGame(3, 2, food);
        System.out.println("Move R: " + snakeGame.move("R")); // 0
        System.out.println("Move D: " + snakeGame.move("D")); // 0
        System.out.println("Move R: " + snakeGame.move("R")); // 1
        System.out.println("Move U: " + snakeGame.move("U")); // 1
        System.out.println("Move L: " + snakeGame.move("L")); // 2
        System.out.println("Move U: " + snakeGame.move("U")); // -1
    }
}
