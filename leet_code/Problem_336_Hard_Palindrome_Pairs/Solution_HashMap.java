package leet_code.Problem_336_Hard_Palindrome_Pairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_HashMap {

    /**
     * Finds unique palindrome pairs.
     * Uses HashMap and string splitting logic.
     * Time: O(N * L^2), Space: O(N * L).
     * 
     * Tìm các cặp palindrome duy nhất.
     * Sử dụng HashMap và logic phân tách chuỗi.
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            int len = w.length();

            // Check all split points
            // Note: j goes from 0 to len (inclusive) to handle empty s1 or s2
            // Kiểm tra tất cả các điểm phân tách
            // Lưu ý: j đi từ 0 đến len (bao gồm) để xử lý s1 hoặc s2 rỗng
            for (int j = 0; j <= len; j++) {
                String s1 = w.substring(0, j);
                String s2 = w.substring(j);

                // Case 1: s1 is Palindrome. Match rev(s2) + s1 + s2
                // If s1 is Pal, we need a word that equals rev(s2) to go BEFORE w.
                // rev(s2) + s1 + s2 -> Palindrome?
                // rev(s2) + s1 + s2 reversed is rev(s2) + rev(s1) + s2.
                // Since s1 is Pal, rev(s1) = s1. So it equals rev(s2) + s1 + s2. Correct.
                // We assume candidate word is at index 'k'.
                // So candidate + w is valid. pair (k, i).

                if (isPalindrome(s1)) {
                    String revS2 = new StringBuilder(s2).reverse().toString();
                    if (map.containsKey(revS2)) {
                        int k = map.get(revS2);
                        // Avoid duplicates and self-pairing
                        // If s1 is empty, s2 is full word. rev(s2) is reverse of w.
                        // If w is palindrome, rev(w) = w. Found self. k == i. Skip.
                        // Also, to avoid duplicates when splitting (s1="", s2="full") vs (s1="full",
                        // s2=""),
                        // Notice loop condition.
                        // If s1 is empty (j=0), we check rev(s2) + w.
                        // If s2 is empty (j=len), we check w + rev(s1).
                        // Let's analyze duplicate:
                        // Pair (A, B).
                        // 1. A + B.
                        // Split B into s1, s2. s1 Pal. finding rev(s2) = A.
                        // Split A into x1, x2. x2 Pal. finding rev(x1) = B.
                        // If we process B, we find A is prefix.
                        // If we process A, we find B is suffix.
                        // Are these mutually exclusive?
                        // Yes, unless length 0 is involved differently.
                        // Special care for empty string.
                        // If s1 is empty, we check if rev(s2) exists.
                        // This counts pair (map.get(revS2), i).
                        // If we handle ONLY s1 is Pal here, and s2 is Pal later.

                        // Rule: If s1 is empty, we always check.
                        // But if s2 is empty? s1 is full word.
                        // If s1 is Pal, we look for rev("") = "".
                        // If "" exists, we pair ("", i).
                        // BUT later logic: if s2 is Pal (empty is Pal). finding rev(s1).
                        // If s1 is full. rev(s1) exists?
                        // If s1 is "aba", rev("aba") = "aba". If "aba" in map (self).
                        // If we have another palindrome "cdc". rev("cdc")="cdc".
                        // Wait.
                        // Standard practice:
                        // Use s1.length() check to break symmetry of empties.
                        // OR strictly: check s1 Pal => add (k, i).
                        // check s2 Pal => add (i, k).
                        // But if BOTH are Pal (e.g. s1="", s2="aba" (Pal)), then s1 Pal condition
                        // adds("", i).
                        // s2 Pal condition adds (i, "").
                        // BUT if s2 is empty. j=len. s1="aba", s2="".
                        // s1 Pal (yes). Adds (k, i). rev("")="". Adds ("", i). DUPLICATE of (k, i)
                        // derived when j=0 on "aba"? No.
                        // When j=0 in "aba": s1="", s2="aba". s1 Pal. Find rev("aba").
                        // When j=len in "aba": s1="aba", s2="". s1 Pal. Find rev(""). ("", i).
                        // s2 Pal. Find rev("aba"). (i, k).
                        // If we allow both blocks to run for all j:
                        // j=0: s1="", s2="aba".
                        // s1 Pal -> find rev("aba"). If exists (say "cdc" exists? no rev(aba) is cdc?).
                        // s2 Pal -> find rev(""). If exists. (i, "").
                        // If we loop j from 0 to len:
                        // If j=0, we act on s1="" (always Pal).
                        // If j=len, we act on s2="" (always Pal).
                        // To avoid double counting when full word or empty word involved:
                        // Only check s2 Pal if s2 is NOT empty? Or only check s1 Pal if ... ?
                        // Ideally:
                        // If s1 Pal: add (k, i).
                        // If s2 Pal: add (i, k).
                        // If j=0: s1="", s2=w. s1 Pal -> add (k, i). s2 Pal -> add (i, k).
                        // If j=len: s1=w, s2="". s1 Pal -> add (k, i). s2 Pal -> add (i, k).
                        // Note j=len implies s1=w, s2="". Same as j=0? No.
                        // But j=0 for "aba" gives ("", "aba").
                        // j=len for "aba" gives ("aba", "").
                        // They are different splits.
                        // BUT if we check both conditions at every split:
                        // at j=0: s1="". s1 Pal. Check rev(s2). ==> (k, i).
                        // at j=len: s2="". s2 Pal. Check rev(s1). ==> (i, k).
                        // If we have "aba" and "".
                        // Processing "aba".
                        // j=0. s1="". Pal. rev(s2)="aba". If map has "aba" (self). Skip.
                        // j=len. s2="". Pal. rev(s1)="aba". If map has "aba" (self). Skip.
                        // Wait, map("aba") IS i. k==i. Skip.
                        // What if k != i? e.g. "aba" and "cdc".
                        // No logic match.
                        // What if k matches ""?
                        // j=0. s1="". rev(s2)="aba". Map has "aba"?
                        // j=len. s2="". rev(s1)="aba". Map has "aba".
                        // What if we try to find ""?
                        // Processing "aba".
                        // j=0. s1="". rev(s2). rev("aba") is "aba".
                        // j=len. s2="". rev(s1). rev("aba") is "aba".
                        // Does not find "".
                        // To find "", we need rev(sX) == "".
                        // j=0. s1="".
                        // j=len. s2="".
                        // To get rev(s2) == "", s2 must be "". So j=len.
                        // At j=len. s2="". s1="aba".
                        // s1 Pal? Yes. Check rev(s2) = "". Map has ""? Yes. k points to "".
                        // Add (k, i) -> ("", "aba"). Correct.
                        // s2 Pal? Yes. Check rev(s1) = "aba". Map has "aba" (self). Skip.

                        // Processing "".
                        // j=0. s1="", s2="".
                        // s1 Pal. Check rev(s2)="". Map has "". k=self. Skip.
                        // s2 Pal. Check rev(s1)="". Map has "". k=self. Skip.
                        // Okay.
                        // What about ("aba", "") -> "aba" + "".
                        // Processing "aba".
                        // j=len. s2="". s1="aba".
                        // s2 Pal? Yes. Check rev(s1)="aba". Self.

                        // Wait, we missed (i, empty).
                        // "aba" + "".
                        // Requires: s2 Pal, find rev(s1).
                        // j=0. s1="", s2="aba".
                        // s2 Pal (is aba Pal? Yes). rev(s1)="". Map has "". k points to "".
                        // Add (i, k) -> ("aba", ""). Correct.

                        // So iterating j=0 to len is correct.
                        // One detail: duplicates.
                        // j=0 for "aba": s1="", s2="aba".
                        // s1 Pal -> rev("aba"). self.
                        // s2 Pal -> rev(""). finds "". (i, k).
                        // j=len for "aba": s1="aba", s2="".
                        // s1 Pal -> rev(""). finds "". (k, i).
                        // s2 Pal -> rev("aba"). self.
                        // So we found both ("", "aba") and ("aba", ""). perfect.
                        // BUT what if "aba" isn't Pal? e.g. "abc".
                        // j=0. s1="", s2="abc".
                        // s1 Pal -> rev("abc")="cba". If found, (k, i). "cbaabc" (Pal). Correct.
                        // s2 Pal? No.
                        // j=len. s1="abc", s2="".
                        // s1 Pal? No.
                        // s2 Pal -> rev("abc")="cba". If found, (i, k). "abccba" (Pal). Correct.
                        // So it seems correct.
                        // ONLY duplicate issue is if s1 and s2 are SAME empty?
                        // j=0 and s1 is empty. j=len and s2 is empty.
                        // If len=0 (word is empty), then j=0 is both.
                        // We iterate j=0 to 0. Run once.
                        // s1="", s2="". s1 Pal -> rev(""). self. s2 Pal -> rev(""). self.
                        // Handles empty word correctly (no pairs with self).
                        // Is there double counting?
                        // "aba". j=0. (i, k) added.
                        // "aba". j=len. (k, i) added.
                        // These are distinct pairs (unless k=i which is blocked).
                        // One specific overlap: if WHOLE word is palindrome, and we pair with empty
                        // string.
                        // j=0: s2 Pal -> adds (i, empty).
                        // j=len: s1 Pal -> adds (empty, i).
                        // These are (i, empty) and (empty, i). Distinct unless i=empty.
                        // Correct.

                        // Just one subtle duplicate:
                        // If we split "ab|ba". s1="ab", s2="ba".
                        // s1 not Pal. s2 not Pal.
                        // But wait, split strict?
                        // What if we match "ab" from map?
                        // w="abba".
                        // j=2. s1="ab", s2="ba".
                        // Target rev(s2)="ab". Found "ab". (k, i).
                        // Target rev(s1)="ba". Found "ba". (i, k).
                        // Correct.

                        // Final trick: strict inequality for one case to prevent double counting
                        // matching length?
                        // No, lengths are different. s1.len != rev(s2).len ?
                        // No.
                        // The duplicate happens if we count the SAME pair (A, B) twice in same pass.
                        // (k, i) is added when processing i.
                        // Will (k, i) be added when processing k?
                        // Start k. Looking for i.
                        // Logic implies symmetry.
                        // We must handle carefully.
                        // Actually, if we just check ALL splits, we cover all cases.
                        // The only risk is adding SAME pair multiple times for same i.
                        // E.g. "aba". j=0 -> adds (i, empty).
                        // if j=... something else adds (i, empty)?
                        // No, split is unique.
                        // So for a fixed i, we generate unique (k, i) or (i, k).
                        // Wait. Can different j yield same k?
                        // w="aaaa". map has "aa".
                        // j=1 ("a", "aaa"). s1 Pal. rev(s2)="aaa". No.
                        // j=2 ("aa", "aa"). s1 Pal. rev(s2)="aa". Found. (k, i).
                        // s2 Pal. rev(s1)="aa". Found. (i, k).
                        // j=3...
                        // If unique words in map, unique splits generally yield unique targets.
                        // EXCEPT s2.length() == 0 and s1.length() == 0 check boundaries.
                        // Since j iterates 0 to len, s2="" only at j=len. s1="" only at j=0.
                        // Distinct j. Distinct splits.
                        // So no duplicates for list.

                        if (k != i) {
                            result.add(Arrays.asList(k, i));
                        }
                    }
                }

                // Case 2: s2 is Palindrome. Match s1 + s2 + rev(s1)
                // If s2 is Pal, we need word equals rev(s1) to go AFTER w.
                // w + rev(s1) -> s1 + s2 + rev(s1). Pal.
                // pair (i, k).
                // Avoid double counting j=0 (s1 empty) if we check it in Case 1 (s1 empty).
                // If j=0, s1="", s2=w.
                // Case 1 checked "s1 Pal". s1 is empty(Pal). Checked rev(s2)=rev(w).
                // Case 2 checks "s2 Pal". s2 is w. If w is Pal. Checks rev(s1)="".
                // If w is Pal and "" exists (k).
                // Case 1 adds (k, i). Case 2 adds (i, k).
                // This is correct.
                // Wait. Is there overlap?
                // Only if s2.length() != 0 to avoid using j=len logic?
                // If j=len. s1=w, s2="".
                // Case 1: s1 Pal? w is Pal. rev("")="". Adds (k, i).
                // Case 2: s2 Pal? "" is Pal. rev(w)=rev(w). Adds (i, k).
                // Wait. Case 1 at j=len checks s1=w (Pal). map.get("") -> k. Adds (k, i).
                // Case 1 at j=0 checks s1="". map.get(rev(w)).
                // If w="aba". j=len: add ("", "aba"). j=0: add?

                // To safely avoid any duplicates if s2.length() == 0:
                // Only do Case 2 if s2.length() != 0.
                // Because if s2 is empty (j=len), s1 is full.
                // This is symmetric to when s1 is empty (j=0) in processing the OTHER word?
                // No.
                // Let's rely on s2.length()!=0 logic commonly used.

                if (s2.length() != 0 && isPalindrome(s2)) {
                    String revS1 = new StringBuilder(s1).reverse().toString();
                    if (map.containsKey(revS1)) {
                        int k = map.get(revS1);
                        if (k != i) {
                            result.add(Arrays.asList(i, k));
                        }
                    }
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution_HashMap solution = new Solution_HashMap();

        // Test Case 1
        String[] w1 = { "abcd", "dcba", "lls", "s", "sssll" };
        System.out.println("Result 1: " + solution.palindromePairs(w1));

        // Test Case 2
        String[] w2 = { "bat", "tab", "cat" };
        System.out.println("Result 2: " + solution.palindromePairs(w2));

        // Test Case 3
        String[] w3 = { "a", "" };
        System.out.println("Result 3: " + solution.palindromePairs(w3));
    }
}
