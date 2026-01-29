package leetcode.P1268_SearchSuggestionsSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> res = new ArrayList<>();
        int left = 0, right = products.length - 1;

        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);

            // Narrow down left and right
            while (left <= right && (products[left].length() <= i || products[left].charAt(i) != c)) {
                left++;
            }
            while (left <= right && (products[right].length() <= i || products[right].charAt(i) != c)) {
                right--;
            }

            List<String> list = new ArrayList<>();
            int remaining = right - left + 1;
            for (int k = 0; k < Math.min(3, remaining); k++) {
                list.add(products[left + k]);
            }
            res.add(list);
        }

        return res;
    }
}
