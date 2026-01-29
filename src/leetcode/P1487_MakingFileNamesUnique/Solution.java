package leetcode.P1487_MakingFileNamesUnique;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> nextSuffix = new HashMap<>();
        String[] result = new String[names.length];

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (!nextSuffix.containsKey(name)) {
                result[i] = name;
                nextSuffix.put(name, 1);
            } else {
                int k = nextSuffix.get(name);
                String newName = name + "(" + k + ")";
                while (nextSuffix.containsKey(newName)) {
                    k++;
                    newName = name + "(" + k + ")";
                }
                result[i] = newName;
                nextSuffix.put(name, k + 1); // Update next search start for original name
                nextSuffix.put(newName, 1); // Add new name to map
            }
        }

        return result;
    }
}
