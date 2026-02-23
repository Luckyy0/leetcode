# Analysis for Hand of Straights
# *Phân tích cho bài toán Bộ bài liên tiếp*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Divide an array of integers into groups of size $K$, where each group contains consecutive integers.
*Chia một mảng các số nguyên thành các nhóm có kích thước $K$, trong đó mỗi nhóm chứa các số nguyên liên tiếp.*

### KEY INSIGHT
### *Nhận xét quan trọng*
To form a group starting from the smallest available number $X$, we **must** use $X, X+1, \dots, X+K-1$. There is no other way to use $X$. Therefore, a greedy approach starting from the smallest elements is optimal.
*Để tạo thành một nhóm bắt đầu từ số nhỏ nhất hiện có $X$, chúng ta **bắt buộc** phải sử dụng các số $X, X+1, \dots, X+K-1$. Không còn cách nào khác để sử dụng $X$. Do đó, cách tiếp cận tham lam bắt đầu từ các phần tử nhỏ nhất là tối ưu.*

---

## 2. Strategy: Greedy with Frequency Map
## *2. Chiến lược: Tham lam với Bản đồ Tần suất*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Count Frequencies:** Store the frequency of each card in a `TreeMap` (to keep the keys sorted).
    *   **Đếm tần suất:** Lưu tần suất của mỗi thẻ bài vào `TreeMap` để giữ các khóa luôn được sắp xếp.*

2.  **Form Groups:**
    - While the map is not empty:
        - Get the smallest key `first`.
        - Check if `first + 1, first + 2, ..., first + groupSize - 1` exist in the map.
        - If any are missing, return `false`.
        - Decrement the count of each used card in the map. If count reaches 0, remove the card from the map.
    *   **Tạo nhóm:** Trong khi bản đồ chưa trống: Lấy khóa nhỏ nhất `first`. Kiểm tra xem các số tiếp theo (đủ `groupSize` số) có tồn tại trong bản đồ không. Nếu thiếu bất kỳ số nào, trả về `false`. Giảm số lượng của mỗi thẻ bài đã dùng, nếu bằng 0 thì xóa khỏi bản đồ.*

3.  **Result:** If the loop completes successfully, return `true`.
    *   **Kết quả:** Nếu vòng lặp hoàn thành, trả về `true`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public boolean isNStraightHand(int[] hand, int groupSize) {
    if (hand.length % groupSize != 0) return false;
    
    TreeMap<Integer, Integer> counts = new TreeMap<>();
    for (int card : hand) {
        counts.put(card, counts.getOrDefault(card, 0) + 1);
    }
    
    while (!counts.isEmpty()) {
        int first = counts.firstKey();
        for (int i = 0; i < groupSize; i++) {
            int current = first + i;
            if (!counts.containsKey(current)) return false;
            
            int c = counts.get(current);
            if (c == 1) counts.remove(current);
            else counts.put(current, c - 1);
        }
    }
    return true;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N + N \cdot groupSize)$. Counting takes $O(N \log N)$ (using TreeMap). The processing loop visits each element. Map lookups are $O(\log N)$.
    *   **Độ phức tạp thời gian:** $O(N \log N)$ cho việc đếm và sắp xếp. Các thao tác trên bản đồ tiêu tốn logarit.*
*   **Space Complexity:** $O(N)$ for the frequency map.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Using a sorted frequency map (like `TreeMap`) is highly efficient for problems requiring greedy selection starting from extremal values.
*Sử dụng một bản đồ tần suất đã sắp xếp (như `TreeMap`) rất hiệu quả cho các bài toán yêu cầu lựa chọn tham lam bắt đầu từ các giá trị cực đại hoặc cực tiểu.*
