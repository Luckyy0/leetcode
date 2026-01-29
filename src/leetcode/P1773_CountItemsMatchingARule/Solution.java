package leetcode.P1773_CountItemsMatchingARule;

import java.util.List;

public class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = -1;
        if (ruleKey.equals("type"))
            index = 0;
        else if (ruleKey.equals("color"))
            index = 1;
        else if (ruleKey.equals("name"))
            index = 2;

        int count = 0;
        for (List<String> item : items) {
            if (item.get(index).equals(ruleValue)) {
                count++;
            }
        }
        return count;
    }
}
