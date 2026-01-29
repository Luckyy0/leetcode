package leetcode.P609_FindDuplicateFileInSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> contentMap = new HashMap<>();

        for (String pathStr : paths) {
            // "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ..."
            // Split by space
            String[] parts = pathStr.split(" ");
            String dir = parts[0];

            for (int i = 1; i < parts.length; i++) {
                String fileInfo = parts[i];
                // fileInfo format: "filename(content)"
                // Find content
                int openParen = fileInfo.indexOf('(');
                String fileName = fileInfo.substring(0, openParen);
                String content = fileInfo.substring(openParen + 1, fileInfo.length() - 1);

                String fullPath = dir + "/" + fileName;

                contentMap.putIfAbsent(content, new ArrayList<>());
                contentMap.get(content).add(fullPath);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> group : contentMap.values()) {
            if (group.size() > 1) {
                result.add(group);
            }
        }

        return result;
    }
}
