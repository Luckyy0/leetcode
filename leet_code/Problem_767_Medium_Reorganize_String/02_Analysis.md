# Analysis for Reorganize String
# *Phân tích cho bài toán Tái cấu trúc Chuỗi*

## 1. Problem Essence & Frequency Constraint
## *1. Bản chất vấn đề & Ràng buộc Tần suất*

### The Challenge
### *Thách thức*
If a character appears too frequently, it's impossible to space them out so no two are adjacent.
Ideally, if the most frequent character appears `maxFrag` times, we need enough "other" characters to act as buffers.
Condition for impossibility: `maxFreq > (N + 1) / 2`.
*Nếu một ký tự xuất hiện quá nhiều, không thể sắp xếp chúng cách xa nhau. Điều kiện không thể: `maxFreq > (N + 1) / 2`.*

---

## 2. Strategy: Greedy Max-Heap or Odd/Even Filling
## *2. Chiến lược: Heap Max Tham lam hoặc Điền Chẵn/Lẻ*

### Strategy A: Greedy Max-Heap
### *Chiến lược A: Heap Max Tham lam*

1.  Count frequencies.
2.  Put `(freq, char)` into a Max-Heap.
3.  Pop top `(f1, c1)`. If `res` is empty or `res.last != c1`, append `c1` and update freq.
4.  If `res.last == c1`, pop next top `(f2, c2)`, append `c2`, then push back `c1`.
    *Wait, simpler logic:* Always pop 2 distinct chars (most frequent and 2nd most frequent). Append them. Decrement counts. Push back if `>0`. If only 1 char remains, count must be 1.

### Strategy B: Odd/Even Filling (Choosing this for O(N))
### *Chiến lược B: Điền Chẵn/Lẻ (Chọn cách này cho O(N))*

1.  **Count Frequencies:** Find max freq. If `max > (N+1)/2`, return "".
2.  **Sort/Prioritize:** Find the char with max freq.
3.  **Fill Max Char:** Place this char at indices 0, 2, 4...
4.  **Fill Others:** Continue filing remaining indices (first odd, then even if needed, wrapping around or just continuing).
    *Implementation nuance:* We need to be careful. A safe way is: Place most frequent char at `0, 2, 4...` then strictly follow with other chars.
    *Actually, fill even indices `0, 2, 4...` first with the most frequent char. Once evens are full (or max char exhausted), switch to odds `1, 3, 5...`. BUT we must ensure the most frequent char is exhausted first to maximize spacing.*

### Code Logic Preview
### *Xem trước Logic Mã*

```java
public String reorganizeString(String s) {
    int[] hash = new int[26];
    for (char c : s.toCharArray()) hash[c - 'a']++;
    
    int max = 0, letter = 0;
    for (int i = 0; i < hash.length; i++) {
        if (hash[i] > max) {
            max = hash[i];
            letter = i;
        }
    }
    
    if (max > (s.length() + 1) / 2) return "";
    
    char[] res = new char[s.length()];
    int idx = 0;
    
    // Fill most frequent char at even indices
    // Điền ký tự xuất hiện nhiều nhất vào các chỉ số chẵn
    while (hash[letter] > 0) {
        res[idx] = (char) (letter + 'a');
        idx += 2;
        hash[letter]--;
    }
    
    // Fill remaining chars
    // Điền các ký tự còn lại
    for (int i = 0; i < hash.length; i++) {
        while (hash[i] > 0) {
            if (idx >= res.length) {
                idx = 1; // Switch to odd indices
            }
            res[idx] = (char) (i + 'a');
            idx += 2;
            hash[i]--;
        }
    }
    return String.valueOf(res);
}
```

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Counting takes $O(N)$. Filling takes $O(N)$.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(N)$ for result array. (Alphabet size 26 is constant).
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**s="aab"**
Count: a:2, b:1. Max: a(2). (2 <= (3+1)/2? Yes).
Fill 'a': `res[0]='a'`, `hash[a]=1`, idx=2.
`res[2]='a'`, `hash[a]=0`, idx=4.
Loop 'b':
idx check: 4 >= 3 -> idx=1.
`res[1]='b'`, `hash[b]=0`, idx=3.
Result: `aba`.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Odd/Even filling is $O(N)$ and strictly optimal if we prioritize the most frequent character.
*Điền Chẵn/Lẻ đạt $O(N)$ và tối ưu nghiêm ngặt nếu ta ưu tiên ký tự có tần suất cao nhất.*
