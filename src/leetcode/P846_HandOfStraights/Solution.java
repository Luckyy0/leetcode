package leetcode.P846_HandOfStraights;

import java.util.TreeMap;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int card : hand)
            map.put(card, map.getOrDefault(card, 0) + 1);

        while (!map.isEmpty()) {
            int first = map.firstKey();
            for (int i = 0; i < groupSize; i++) {
                int curr = first + i;
                if (!map.containsKey(curr))
                    return false;

                int count = map.get(curr);
                if (count == 1)
                    map.remove(curr);
                else
                    map.put(curr, count - 1);
            }
        }

        return true;
    }
}
