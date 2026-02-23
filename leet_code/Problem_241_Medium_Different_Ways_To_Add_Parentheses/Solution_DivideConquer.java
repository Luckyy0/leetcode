package leet_code.Problem_241_Medium_Different_Ways_To_Add_Parentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_DivideConquer {

    // Memoization map to store results of sub-expressions
    // Bản đồ ghi nhớ để lưu kết quả các biểu thức con
    private Map<String, List<Integer>> memo = new HashMap<>();

    /**
     * Computes all possible results from different ways to add parentheses.
     * Uses Divide and Conquer with Memoization.
     * 
     * Tính toán tất cả các kết quả có thể từ các cách thêm dấu ngoặc khác nhau.
     * Sử dụng Chia để trị với Ghi nhớ.
     */
    public List<Integer> diffWaysToCompute(String expression) {
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> sortedResults = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // If operator, split expression
            // Nếu là toán tử, chia biểu thức
            if (c == '-' || c == '+' || c == '*') {
                String leftPart = expression.substring(0, i);
                String rightPart = expression.substring(i + 1);

                List<Integer> leftResults = diffWaysToCompute(leftPart);
                List<Integer> rightResults = diffWaysToCompute(rightPart);

                for (int leftVal : leftResults) {
                    for (int rightVal : rightResults) {
                        int computed = 0;
                        switch (c) {
                            case '+':
                                computed = leftVal + rightVal;
                                break;
                            case '-':
                                computed = leftVal - rightVal;
                                break;
                            case '*':
                                computed = leftVal * rightVal;
                                break;
                        }
                        sortedResults.add(computed);
                    }
                }
            }
        }

        // If no operator was found, the expression is just a number
        // Nếu không tìm thấy toán tử, biểu thức chỉ là một số
        if (sortedResults.isEmpty()) {
            sortedResults.add(Integer.parseInt(expression));
        }

        memo.put(expression, sortedResults);
        return sortedResults;
    }

    public static void main(String[] args) {
        Solution_DivideConquer solution = new Solution_DivideConquer();

        // Test Case 1: "2-1-1" -> [2, 0] (Order can vary)
        System.out.println("Result 1: " + solution.diffWaysToCompute("2-1-1"));

        // Test Case 2: "2*3-4*5" -> [-34, -10, -14, -10, 10]
        System.out.println("Result 2: " + solution.diffWaysToCompute("2*3-4*5"));
    }
}
