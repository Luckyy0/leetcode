# Analysis for Word Subsets
# *Phân tích cho bài toán Tập hợp Con từ của Từ*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find strings in `words1` that are "supersets" of *every* string in `words2`.
*Tìm các chuỗi trong `words1` là "tập cha" của *mọi* chuỗi trong `words2`.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- A string `b` is a subset of `a` if `freq(char, b) <= freq(char, a)` for all characters.
- For `a` to be a superset of ALL `b` in `words2`, it must satisfy:
  `freq(char, a) >= max(freq(char, b))` for all `b` in `words2`.
- Instead of checking each `a` against each `b` (which is $O(N \cdot M)$), we can precompute the "maximum requirement" from `words2`.
- Let `max_freq[char]` be the maximum frequency of `char` across all words in `words2`.
- Then `a` is universal if `freq(char, a) >= max_freq[char]` for all 'a'...'z'.
*Một chuỗi `b` là tập con của `a` nếu tần suất ký tự trong `b` nhỏ hơn hoặc bằng trong `a`. Để `a` là tập cha của TẤT CẢ `b`, `a` phải thỏa mãn tần suất lớn hơn hoặc bằng tần suất TỐI ĐA của mỗi ký tự trong `words2`. Thay vì kiểm tra từng cặp, ta tính trước tần suất tối đa yêu cầu từ `words2`.*

---

## 2. Strategy: Frequency Aggregation
## *2. Chiến lược: Tổng hợp Tần suất*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Precompute Requirements:**
    - Initialize `maxFreq` array of size 26 (for 'a'-'z').
    - Iterate through each `word` in `words2`.
    - Calculate its frequency array `currentFreq`.
    - Update `maxFreq[i] = max(maxFreq[i], currentFreq[i])`.
    *   **Tính toán trước yêu cầu:** Khởi tạo mảng `maxFreq`. Duyệt qua `words2`, tính tần suất mỗi từ và cập nhật `maxFreq`.*

2.  **Filter `words1`:**
    - Initialize result list.
    - Iterate through each `word` in `words1`.
    - Calculate its frequency array `wordFreq`.
    - Check if `wordFreq[i] >= maxFreq[i]` for all 26 characters.
    - If yes, add `word` to result.
    *   **Lọc `words1`:** Duyệt qua `words1`. Kiểm tra xem tần suất của từ có thỏa mãn `maxFreq` không. Nếu có, thêm vào kết quả.*

3.  **Return Result.**
    *   **Trả về kết quả.**

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public List<String> wordSubsets(String[] words1, String[] words2) {
    int[] maxFreq = new int[26];
    
    // Aggregating requirements from words2
    for (String b : words2) {
        int[] freq = countFreq(b);
        for (int i = 0; i < 26; i++) {
            maxFreq[i] = Math.max(maxFreq[i], freq[i]);
        }
    }
    
    List<String> result = new ArrayList<>();
    
    // Determine universal words
    for (String a : words1) {
        int[] freq = countFreq(a);
        boolean isUniversal = true;
        for (int i = 0; i < 26; i++) {
            if (freq[i] < maxFreq[i]) {
                isUniversal = false;
                break;
            }
        }
        if (isUniversal) {
            result.add(a);
        }
    }
    
    return result;
}

private int[] countFreq(String s) {
    int[] freq = new int[26];
    for (char c : s.toCharArray()) {
        freq[c - 'a']++;
    }
    return freq;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N + M)$, where $N$ is total characters in `words1` and $M$ in `words2`.
    *   **Độ phức tạp thời gian:** $O(N + M)$.*
*   **Space Complexity:** $O(1)$ (constant size arrays for alphabet).
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Reducing the constraints of `words2` into a single aggregate frequency array is the standard way to solve "superset of all" problems efficiently.
*Việc giảm các ràng buộc của `words2` thành một mảng tần suất tổng hợp duy nhất là cách tiêu chuẩn để giải quyết các bài toán "tập cha của tất cả" một cách hiệu quả.*
