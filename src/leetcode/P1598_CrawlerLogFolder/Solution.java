package leetcode.P1598_CrawlerLogFolder;

public class Solution {
    public int minOperations(String[] logs) {
        int depth = 0;

        for (String log : logs) {
            if (log.equals("../")) {
                if (depth > 0) {
                    depth--;
                }
            } else if (log.equals("./")) {
                // Do nothing
            } else {
                // Child folder
                depth++;
            }
        }

        return depth;
    }
}
