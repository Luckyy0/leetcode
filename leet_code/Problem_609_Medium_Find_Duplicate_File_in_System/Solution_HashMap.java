package leet_code.Problem_609_Medium_Find_Duplicate_File_in_System;

import java.util.*;

public class Solution_HashMap {

    /**
     * Finds groups of duplicate files based on content.
     * Strategy: Use a HashMap where key = content, value = list of file paths.
     * Time: O(C), Space: O(C).
     */
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();

        for (String pathInfo : paths) {
            String[] parts = pathInfo.split(" ");
            String directory = parts[0];

            for (int i = 1; i < parts.length; i++) {
                String fileInfo = parts[i];
                int openBrace = fileInfo.indexOf('(');
                int closeBrace = fileInfo.indexOf(')');

                String fileName = fileInfo.substring(0, openBrace);
                String content = fileInfo.substring(openBrace + 1, closeBrace);

                String fullPath = directory + "/" + fileName;

                map.computeIfAbsent(content, k -> new ArrayList<>()).add(fullPath);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> group : map.values()) {
            if (group.size() > 1) {
                result.add(group);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_HashMap solution = new Solution_HashMap();
        String[] paths = {
                "root/a 1.txt(abcd) 2.txt(efgh)",
                "root/c 3.txt(abcd)",
                "root/c/d 4.txt(efgh)",
                "root 4.txt(gjstrm)"
        };
        System.out.println("Duplicate Groups: " + solution.findDuplicate(paths));
    }
}
