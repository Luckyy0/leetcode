# Analysis for Vowel Spellchecker
# *Phân tích cho bài toán Trình kiểm tra chính tả Nguyên âm*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Match queries to words based on three precedence rules: Exact > Capitalization > Vowel Errors.
*Khớp truy vấn với các từ dựa trên ba quy tắc ưu tiên: Chính xác > Viết hoa > Lỗi Nguyên âm.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- We need to prioritize the matches.
- Preprocessing `wordlist` is key.
- Store three data structures:
  1. **Exact Set:** To check for exact matches quickly. `Set<String>`.
  2. **Capitalization Map:** `Map<String, String>`. Key is the lowercase version of the word. Value is the *first* word in `wordlist` that matches this key. "Yellow" -> "yellow": "Yellow".
  3. **Vowel Map:** `Map<String, String>`. Key is the lowercase word with all vowels normalized (e.g., replaced by '*'). Value is the *first* word in `wordlist` matching this pattern. "YellOw" -> "y*ll*w": "YellOw".
- Why store the *first* match? The problem states "return the first such match in the wordlist". So when populating maps, we only insert if the key doesn't exist yet. This preserves the original order precedence.
- Query Process:
  - Check Exact Set -> Return query.
  - Check Capitalization Map (query.toLowerCase()) -> Return value.
  - Check Vowel Map (query.toLowerCase().replaceVowels()) -> Return value.
  - Else return "".
*Tiền xử lý danh sách từ vào Set (chính xác), Map (chữ thường), và Map (nguyên âm hóa). Luôn giữ từ xuất hiện đầu tiên.*

---

## 2. Strategy: Multi-Level Hashing
## *2. Chiến lược: Băm Đa cấp*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** `exactSet`, `capMap`, `vowelMap`.
    *   **Khởi tạo:** Các cấu trúc dữ liệu.*

2.  **Preprocess Wordlist:**
    - Iterate `word` in `wordlist`.
    - Add to `exactSet`.
    - `lower = word.toLowerCase()`. If `!capMap.containsKey(lower)`, `capMap.put(lower, word)`.
    - `devoweled = removeVowels(lower)`. If `!vowelMap.containsKey(devoweled)`, `vowelMap.put(devoweled, word)`.
    *   **Tiền xử lý:** Điền dữ liệu vào Set/Map, giữ từ đầu tiên.*

3.  **Process Queries:**
    - Iterate `q` in `queries`.
    - If `exactSet` has `q`: add `q`.
    - Else if `capMap` has `q.lower()`: add `capMap.get(q.lower())`.
    - Else if `vowelMap` has `devoweled(q)`: add `vowelMap.get(devoweled(q))`.
    - Else: add "".
    *   **Xử lý truy vấn:** Kiểm tra theo thứ tự ưu tiên.*

4.  **Helper:** `removeVowels` replaces a,e,i,o,u with '*'.
    *   **Hàm trợ giúp:** Thay thế nguyên âm.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.*;

public class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactSet = new HashSet<>();
        Map<String, String> capMap = new HashMap<>(); // lower -> first original
        Map<String, String> vowelMap = new HashMap<>(); // devoweled -> first original
        
        for (String word : wordlist) {
            exactSet.add(word);
            
            String lower = word.toLowerCase();
            capMap.putIfAbsent(lower, word);
            
            String devoweled = devowel(lower);
            vowelMap.putIfAbsent(devoweled, word);
        }
        
        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            
            if (exactSet.contains(query)) {
                ans[i] = query;
                continue;
            }
            
            String lower = query.toLowerCase();
            if (capMap.containsKey(lower)) {
                ans[i] = capMap.get(lower);
                continue;
            }
            
            String devoweled = devowel(lower);
            if (vowelMap.containsKey(devoweled)) {
                ans[i] = vowelMap.get(devoweled);
                continue;
            }
            
            ans[i] = "";
        }
        
        return ans;
    }
    
    private String devowel(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot L + M \cdot L)$ where $N$ is wordlist size, $M$ is queries size, $L$ is max word length.
    *   **Độ phức tạp thời gian:** $O(N \cdot L + M \cdot L)$.*
*   **Space Complexity:** $O(N \cdot L)$ to store maps.
    *   **Độ phức tạp không gian:** $O(N \cdot L)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Using three hash structures efficiently handles the precedence rules. Correctly retaining the "first match" during preprocessing allows for $O(1)$ query resolution.
*Sử dụng ba cấu trúc băm xử lý hiệu quả các quy tắc ưu tiên. Việc giữ lại "kết quả khớp đầu tiên" trong quá trình tiền xử lý cho phép giải quyết truy vấn trong O(1).*
