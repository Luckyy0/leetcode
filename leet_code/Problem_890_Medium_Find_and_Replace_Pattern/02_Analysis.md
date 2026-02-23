# Analysis for Find and Replace Pattern
# *Phân tích cho bài toán Tìm và Thay thế Mẫu*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
We need to find words that have the same "structure" or "isomorphic pattern" as a given pattern string. This means there is a one-to-one mapping (bijection) between the characters of the pattern and the characters of the word.
*Chúng ta cần tìm các từ có cùng "cấu trúc" hoặc "mẫu đẳng hình" với một chuỗi mẫu đã cho. Điều này có nghĩa là có một ánh xạ một-một (song ánh) giữa các ký tự của mẫu và các ký tự của từ.*

---

## 2. Strategy: Canonical Representation
## *2. Chiến lược: Biểu diễn Chính tắc*

### Key Insight
### *Nhận xét quan trọng*
Two strings are isomorphic if and only if they convert to the same "canonical form".
A simple way to create a canonical form is to replace the first occurrence of each character with 0, the second distinct character with 1, and so on. Subsequent occurrences reuse the assigned integer ID.
*Hai chuỗi là đẳng hình khi và chỉ khi chúng chuyển đổi thành cùng một "dạng chính tắc". Một cách đơn giản để tạo dạng chính tắc là thay thế lần xuất hiện đầu tiên của mỗi ký tự bằng 0, ký tự khác biệt thứ hai bằng 1, và cứ thế. Các lần xuất hiện sau sử dụng lại ID số nguyên đã được gán.*

**Example:**
- "abb" -> `a` is 0. `b` is 1. result: `[0, 1, 1]`
- "mee" -> `m` is 0. `e` is 1. result: `[0, 1, 1]`
- "abc" -> `a` is 0. `b` is 1. `c` is 2. result: `[0, 1, 2]`

### Algorithm Steps
### *Các bước thuật toán*

1.  **Define `normalize(string)` function:**
    - Use a map or array to track the ID assigned to each character.
    - Iterate through the string. If a character is new, assign it `nextID++`. If seen, use its existing ID.
    - Return the list of IDs.
    *   **Định nghĩa hàm `normalize(chuỗi)`:** Sử dụng bản đồ hoặc mảng để theo dõi ID được gán cho mỗi ký tự. Duyệt qua chuỗi. Nếu một ký tự là mới, gán cho nó `nextID++`. Nếu đã thấy, sử dụng ID hiện có. Trả về danh sách các ID.*

2.  **Process:**
    - Calculate `p = normalize(pattern)`.
    - Iterate through each word `w` in `words`.
    - If `normalize(w)` equals `p`, add `w` to the result list.
    *   **Xử lý:** Tính `p = normalize(pattern)`. Duyệt qua từng từ `w` trong `words`. Nếu `normalize(w)` bằng `p`, thêm `w` vào danh sách kết quả.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public List<String> findAndReplacePattern(String[] words, String pattern) {
    List<String> res = new ArrayList<>();
    int[] p = normalize(pattern);
    for (String w : words) {
        if (Arrays.equals(p, normalize(w))) {
            res.add(w);
        }
    }
    return res;
}

private int[] normalize(String s) {
    int[] res = new int[s.length()];
    Map<Character, Integer> map = new HashMap<>();
    int id = 0;
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (!map.containsKey(c)) {
            map.put(c, id++);
        }
        res[i] = map.get(c);
    }
    return res;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot K)$, where $N$ is the number of words and $K$ is the length of each word. We normalize each string once.
    *   **Độ phức tạp thời gian:** $O(N \cdot K)$, chúng ta chuẩn hóa mỗi chuỗi một lần.*
*   **Space Complexity:** $O(N \cdot K)$ to store the result list and temporary arrays.
    *   **Độ phức tạp không gian:** $O(N \cdot K)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Canonical representation is a versatile technique for isomorphism problems. It avoids the need for pairwise checking (bi-directional mapping checks) by transforming everything into a standard format.
*Biểu diễn chính tắc là một kỹ thuật linh hoạt cho các bài toán đẳng hình. Nó tránh được việc phải kiểm tra từng cặp (kiểm tra ánh xạ hai chiều) bằng cách chuyển đổi mọi thứ thành một định dạng chuẩn.*
