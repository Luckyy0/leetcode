# Analysis for Uncommon Words from Two Sentences
# *Phân tích cho bài toán Các từ Không phổ biến từ Hai Câu*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Identify words that appear exactly once in one sentence and zero times in the other.
*Xác định các từ xuất hiện đúng một lần trong một câu và không xuất hiện lần nào trong câu kia.*

### KEY LOGIC
### *Logic chính*
This condition simplifies to: **Find all words that appear exactly once in the combined text of both sentences.**
- If a word appears once in `s1` and zero times in `s2`, its total count is 1.
- If a word appears once in `s2` and zero times in `s1`, its total count is 1.
- If a word appears in both, its total count is $\ge 2$.
- If a word appears twice in `s1`, its total count is $\ge 2$.
*Điều kiện này đơn giản hóa thành: **Tìm tất cả các từ xuất hiện đúng một lần trong văn bản kết hợp của cả hai câu.** Nếu một từ xuất hiện một lần trong `s1` và không có trong `s2`, tổng số lần là 1. Tương tự ngược lại. Nếu xuất hiện ở cả hai hoặc nhiều lần trong một câu, tổng số lần $\ge 2$.*

---

## 2. Strategy: HashMap Counting
## *2. Chiến lược: Đếm bằng HashMap*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Split both sentences:** Convert `s1` and `s2` into arrays of words using space as a delimiter.
    *   **Tách cả hai câu:** Chuyển đổi `s1` và `s2` thành mảng các từ bằng cách sử dụng dấu cách làm dấu phân cách.*

2.  **Count Frequencies:** Iterate through all words from both sentences and store their counts in a standard `HashMap<String, Integer>`.
    *   **Đếm tần suất:** Duyệt qua tất cả các từ từ cả hai câu và lưu số lượng của chúng vào một `HashMap` tiêu chuẩn.*

3.  **Filter:** Iterate through the map's keys. If a word's count is exactly `1`, add it to the result list.
    *   **Lọc:** Duyệt qua các khóa của bản đồ. Nếu số lượng của một từ đúng bằng `1`, thêm nó vào danh sách kết quả.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public String[] uncommonFromSentences(String s1, String s2) {
    Map<String, Integer> count = new HashMap<>();
    
    for (String w : s1.split(" ")) count.put(w, count.getOrDefault(w, 0) + 1);
    for (String w : s2.split(" ")) count.put(w, count.getOrDefault(w, 0) + 1);
    
    List<String> res = new ArrayList<>();
    for (String w : count.keySet()) {
        if (count.get(w) == 1) res.add(w);
    }
    
    return res.toArray(new String[0]);
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N + M)$, where $N$ and $M$ are lengths of the sentences. Using `split` and map operations is linear.
    *   **Độ phức tạp thời gian:** $O(N + M)$, các thao tác tách chuỗi và bản đồ là tuyến tính.*
*   **Space Complexity:** $O(N + M)$ to store the map and result.
    *   **Độ phức tạp không gian:** $O(N + M)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Simplifying the problem statement's condition (Total Count == 1) makes the implementation trivial and robust.
*Đơn giản hóa điều kiện của đề bài (Tổng số lượng == 1) giúp việc triển khai trở nên tầm thường và mạnh mẽ.*
