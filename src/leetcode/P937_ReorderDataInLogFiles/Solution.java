package leetcode.P937_ReorderDataInLogFiles;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                int split1 = log1.indexOf(' ');
                int split2 = log2.indexOf(' ');
                char char1 = log1.charAt(split1 + 1);
                char char2 = log2.charAt(split2 + 1);

                boolean isDigit1 = Character.isDigit(char1);
                boolean isDigit2 = Character.isDigit(char2);

                if (!isDigit1 && !isDigit2) {
                    int cmp = log1.substring(split1 + 1).compareTo(log2.substring(split2 + 1));
                    if (cmp != 0)
                        return cmp;
                    return log1.substring(0, split1).compareTo(log2.substring(0, split2));
                }

                if (!isDigit1 && isDigit2)
                    return -1;
                if (isDigit1 && !isDigit2)
                    return 1;
                return 0; // maintain relative order for digit logs
            }
        };

        Arrays.sort(logs, myComp);
        return logs;
    }
}
