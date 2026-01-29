package leetcode.P1233_RemoveSubFoldersFromTheFilesystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();

        String parent = "//"; // Dummy value
        for (String f : folder) {
            if (!f.startsWith(parent + "/")) {
                result.add(f);
                parent = f;
            }
        }

        return result;
    }
}
