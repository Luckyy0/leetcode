# Analysis for Verifying an Alien Dictionary
# *Phân tích cho bài toán Xác minh Từ điển Người ngoài hành tinh*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Check if words are sorted lexicographically according to a custom alphabet order.
*Kiểm tra xem các từ có được sắp xếp theo thứ tự từ điển dựa trên bảng chữ cái tùy chỉnh hay không.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Map each character to its index (rank) in the `order` string. Array `index[26]` works perfectly.
- Iterate through adjacent pairs of words `(words[i], words[i+1])`.
- Compare them character by character.
- The first different character determines the order.
  - If `char1` comes before `char2` in `order`, the pair is correct. Break and check next pair.
  - If `char1` comes after `char2`, return `false`.
- Edge case: If one word is a prefix of another (e.g., "apple" vs "app"):
  - The shorter word must come first.
  - If `words[i]` is longer than `words[i+1]` and no difference found (prefix match), it's invalid. Return `false`.
- If all pairs are correct, return `true`.
*Ánh xạ ký tự sang thứ tự. So sánh từng cặp từ liền kề. Ký tự khác nhau đầu tiên quyết định. Nếu là tiền tố, từ ngắn hơn phải đứng trước.*

---

## 2. Strategy: Pairwise Comparison
## *2. Chiến lược: So sánh từng cặp*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Build Map:** Create `map[26]` where `map[char - 'a'] = index` from `order`.
    *   **Xây dựng Map:** Lưu thứ tự của mỗi ký tự.*

2.  **Iterate Pairs:** Loop `i` from 0 to `N-2`. Compare `w1 = words[i]` and `w2 = words[i+1]`.
    *   **Duyệt cặp:** So sánh từ `i` và `i+1`.*

3.  **Compare Words:**
    - Loop `j` through common length.
    - If `w1[j] != w2[j]`:
      - If `map[w1[j]] > map[w2[j]]`: Return `false`.
      - Else: Order is correct, `break` inner loop (move to next word pair).
    - If loop finishes without difference (prefix match):
      - If `w1.length > w2.length`: Return `false` ("apple" > "app").
    *   **So sánh từ:** So sánh từng ký tự. Xử lý trường hợp tiền tố.*

4.  **Return:** `true` if loop completes without returning `false`.
    *   **Trả về:** `true`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            
            int len = Math.min(w1.length(), w2.length());
            boolean sorted = false;
            
            for (int k = 0; k < len; k++) {
                char c1 = w1.charAt(k);
                char c2 = w2.charAt(k);
                
                if (c1 != c2) {
                    if (index[c1 - 'a'] > index[c2 - 'a']) {
                        return false; // Wrong order
                    }
                    sorted = true; // Correct order found at this char
                    break;
                }
            }
            
            // If we didn't find a difference, check length (shorter must come first)
            if (!sorted && w1.length() > w2.length()) {
                return false;
            }
        }
        
        return true;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(C)$ where $C$ is total number of characters in `words`.
    *   **Độ phức tạp thời gian:** $O(C)$.*
*   **Space Complexity:** $O(1)$ (array of size 26).
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Straightforward pairwise comparison logic with custom comparator mapping.
*Logic so sánh từng cặp trực tiếp với ánh xạ so sánh tùy chỉnh.*
