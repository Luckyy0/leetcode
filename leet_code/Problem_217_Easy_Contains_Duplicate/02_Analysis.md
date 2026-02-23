# Analysis for Contains Duplicate
# *Phân tích cho bài toán Chứa bản sao*

## 1. Problem Essence & Lookup Strategies
## *1. Bản chất vấn đề & Chiến lược tra cứu*

### The Question
### *Câu hỏi*
Is there any $x$ such that `count(x) > 1`?
*Có bất kỳ $x$ nào sao cho `count(x) > 1` không?*

### Options
### *Các lựa chọn*
1.  **Brute Force:** Compare every pair. $O(N^2)$. Too slow.
2.  **Sorting:** Sort array. Compare `nums[i]` with `nums[i+1]`. $O(N \log N)$. Good.
3.  **Hashing:** Use a HashSet to store seen elements. $O(N)$. Best.
*1. Vét cạn: $O(N^2)$. Quá chậm. 2. Sắp xếp: $O(N \log N)$. Tốt. 3. Băm: Sử dụng HashSet. $O(N)$. Tốt nhất.*

---

## 2. Approach: HashSet
## *2. Hướng tiếp cận: HashSet*

### Logic
### *Logic*
1.  Initialize empty Set.
2.  Loop through numbers.
3.  If `num` is already in Set -> Return `true`.
4.  Add `num` to Set.
5.  If loop finishes -> Return `false`.

### Trade-offs
### *Đánh đổi*
- **Sorting:** Uses $O(1)$ extra space (if heapsort) or $O(\log N)$ (quicksort recursion), but modifies the array or requires copy. Slower time.
- **HashSet:** Uses $O(N)$ extra space. Fastest time.
*Sắp xếp tốn ít bộ nhớ hơn nhưng chậm hơn. HashSet nhanh nhất nhưng tốn bộ nhớ.*

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **HashSet:** $O(1)$ average time complexity for insertion and lookup makes the linear scan extremely efficient.
    *HashSet: Độ phức tạp trung bình $O(1)$ cho chèn và tra cứu giúp quét tuyến tính cực kỳ hiệu quả.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(N)$.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[1, 2, 3, 1]`

1.  Set: `{}`. Process 1. Add 1. Set: `{1}`.
2.  Process 2. Add 2. Set: `{1, 2}`.
3.  Process 3. Add 3. Set: `{1, 2, 3}`.
4.  Process 1. Check Set. 1 exists. **Return True**.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

This is the standard warm-up question for HashSets. Always mention sorting as an alternative for space-constrained environments ($O(1)$ space, $O(N \log N)$ time), but implement the HashSet solution by default.
*Đây là câu hỏi khởi động tiêu chuẩn cho HashSet. Luôn nhắc đến sắp xếp như một giải pháp thay thế cho môi trường hạn chế bộ nhớ, nhưng hãy mặc định triển khai giải pháp HashSet.*
---
*Một tấm gương (HashSet) phản chiếu sự thật ngay lập tức, nhưng việc sắp xếp ngăn nắp cũng có vẻ đẹp riêng của nó.*
A mirror (HashSet) reflects the truth instantly, but orderly arrangement (Sorting) also has its own beauty.
