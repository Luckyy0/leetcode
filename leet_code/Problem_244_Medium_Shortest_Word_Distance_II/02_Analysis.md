# Analysis for Shortest Word Distance II
# *Phân tích cho bài toán Khoảng cách từ ngắn nhất II*

## 1. Problem Essence & Preprocessing
## *1. Bản chất vấn đề & Tiền xử lý*

### The Challenge
### *Thách thức*
In Problem 243, one query took $O(N)$.
Here, we have up to 5000 calls. $5000 \times 30000 = 1.5 \times 10^8$. Might be too slow if $N$ is large.
We need faster query time.

### The Solution: Hash Map of Indices
### *Giải pháp: Bảng băm chỉ số*
Store indices for each word: `Map<String, List<Integer>>`.
- "practice" -> [0]
- "makes" -> [1, 4]
- "coding" -> [3]

Query `shortest("makes", "coding")`:
Find min distance between sorted list `[1, 4]` and `[3]`.
This is efficient using Two Pointers (O(L1 + L2)).

---

## 2. Approach: HashMap + Two Pointers
## *2. Hướng tiếp cận: HashMap + Hai con trỏ*

### Initialization (Constructor)
### *Khởi tạo (Constructor)*
Iterate `wordsDict`. Populate the map. Time $O(N)$.

### Shortest (Query)
### *Shortest (Truy vấn)*
Get `list1` and `list2`.
Use two pointers `i, j`:
- `diff = abs(list1[i] - list2[j])`. Update min.
- If `list1[i] < list2[j]`: `i++` (Need larger index from list1 to potentially close gap).
- Else: `j++`.
Time $O(K + M)$ where K, M are occurrences. Worst case $O(N)$ still, but average much faster because words are sparse.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Average Efficiency:** Most words appear few times.
    *Hiệu quả trung bình: Hầu hết các từ xuất hiện ít lần.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:**
    - Init: $O(N)$.
    - Query: $O(K + M)$.
*   **Space Complexity:** $O(N)$.

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Map:**
`makes: [1, 4]`
`coding: [3]`

Query:
1.  i=0 (val 1), j=0 (val 3). Dist = 2.
    - `1 < 3`, so `i++`.
2.  i=1 (val 4), j=0 (val 3). Dist = 1.
    - `4 > 3`, so `j++`.
3.  j out of bounds. End.
Min = 1.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Standard pre-processing design problem.
*Bài toán thiết kế tiền xử lý tiêu chuẩn.*
---
*Chuẩn bị kỹ (Map) giúp trả lời nhanh (Query). Đó là giá trị của việc học tập.*
Thorough preparation (Map) helps answer quickly (Query). That is the value of learning.
