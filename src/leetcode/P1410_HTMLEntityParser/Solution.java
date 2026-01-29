package leetcode.P1410_HTMLEntityParser;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String entityParser(String text) {
        Map<String, String> map = new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");

        StringBuilder sb = new StringBuilder();
        int n = text.length();
        int i = 0;

        while (i < n) {
            if (text.charAt(i) == '&') {
                int j = i + 1;
                while (j < n && j < i + 7 && text.charAt(j) != ';') { // Max length is &frasl; (7 chars)
                    j++;
                }

                if (j < n && text.charAt(j) == ';') {
                    // Possible entity
                    String sub = text.substring(i, j + 1);
                    if (map.containsKey(sub)) {
                        sb.append(map.get(sub));
                        i = j + 1;
                        continue;
                    }
                }
            }
            sb.append(text.charAt(i));
            i++;
        }

        return sb.toString();
    }
}
