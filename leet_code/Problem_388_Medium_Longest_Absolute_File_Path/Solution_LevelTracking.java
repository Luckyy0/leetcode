package leet_code.Problem_388_Medium_Longest_Absolute_File_Path;

import java.util.Stack;

public class Solution_LevelTracking {

    /**
     * Finds the length of the longest absolute path to a file.
     * Use an array to keep track of path lengths at each level.
     * Time: O(N), Space: O(depth).
     * 
     * Tìm độ dài của đường dẫn tuyệt đối dài nhất đến một tệp.
     * Sử dụng một mảng để theo dõi độ dài đường dẫn ở mỗi cấp độ.
     */
    public int lengthLongestPath(String input) {
        String[] parts = input.split("\n");
        // pathLength[i] stores the length of path UP TO level i-1 plus a '/'
        // pathLength[i] lưu độ dài đường dẫn ĐẾN cấp i-1 cộng với một ký tự '/'
        int[] pathLength = new int[parts.length + 1];
        int maxLen = 0;

        for (String s : parts) {
            // Level is determined by the number of last index of '\t' + 1
            // Cấp độ được xác định bởi số lượng ký tự '\t' ở đầu
            int level = s.lastIndexOf("\t") + 1;

            // Actual length of the folder or file name
            // Độ dài thực tế của tên thư mục hoặc tệp
            int nameLen = s.length() - level;

            if (s.contains(".")) {
                // It's a file
                // Đó là một tệp
                maxLen = Math.max(maxLen, pathLength[level] + nameLen);
            } else {
                // It's a directory, store path length for its children
                // Đó là một thư mục, lưu độ dài đường dẫn cho các con của nó
                pathLength[level + 1] = pathLength[level] + nameLen + 1;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution_LevelTracking solution = new Solution_LevelTracking();

        // Test Case 1: "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" -> 20
        String t1 = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        System.out.println("Result 1: " + solution.lengthLongestPath(t1));

        // Test Case 2:
        // "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
        // -> 32
        String t2 = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.println("Result 2: " + solution.lengthLongestPath(t2));
    }
}
