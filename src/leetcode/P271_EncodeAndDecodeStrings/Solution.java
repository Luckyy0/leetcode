package leetcode.P271_EncodeAndDecodeStrings;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Problem 271: Encode and Decode Strings
     * Approach: Length Prefixing
     * 
     * Theoretical Basis:
     * - "len#string" format allows binary-safe encoding.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public static class Codec {

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();
            for (String s : strs) {
                sb.append(s.length()).append('#').append(s);
            }
            return sb.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> result = new ArrayList<>();
            int i = 0;
            while (i < s.length()) {
                int slash = s.indexOf('#', i);
                int len = Integer.parseInt(s.substring(i, slash));

                // Extract content
                String content = s.substring(slash + 1, slash + 1 + len);
                result.add(content);

                // Move pointer
                i = slash + 1 + len;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();

        // ["Hello", "World"]
        List<String> input1 = new ArrayList<>();
        input1.add("Hello");
        input1.add("World");

        String encoded1 = codec.encode(input1);
        List<String> decoded1 = codec.decode(encoded1);

        System.out.println("Input: " + input1);
        System.out.println("Encoded: " + encoded1);
        System.out.println("Decoded: " + decoded1);
        runTest(input1, decoded1);

        System.out.println("-----------------");

        // ["", "abc#def", "123"]
        List<String> input2 = new ArrayList<>();
        input2.add("");
        input2.add("abc#def");
        input2.add("123");

        String encoded2 = codec.encode(input2);
        List<String> decoded2 = codec.decode(encoded2);

        System.out.println("Input: " + input2);
        System.out.println("Encoded: " + encoded2); // Expected: "0#7#abc#def3#123"
        System.out.println("Decoded: " + decoded2);
        runTest(input2, decoded2);
    }

    private static void runTest(List<String> original, List<String> result) {
        if (original.equals(result)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }
}
