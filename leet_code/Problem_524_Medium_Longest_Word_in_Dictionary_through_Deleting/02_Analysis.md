# Analysis for Longest Word in Dictionary through Deleting
# *Phân tích cho bài toán Từ dài nhất trong Từ điển thông qua Xóa*

## 1. Problem Essence & Subsequence Matching
## *1. Bản chất vấn đề & Khớp Dãy con*

### The Challenge
### *Thách thức*
Finding the "best" string in a dictionary that is a subsequence of `s`.
- Best means: Max length, then lexicographically smallest.

### Strategy: Linear Scan with Update Logic
### *Chiến lược: Quét Tuyến tính với Logic Cập nhật*

1.  **Iterate:** Check every word in dictionary.
2.  **Filter:** Only process if `word` is a subsequence of `s`.
3.  **Update:** Maintain a `result` string.
    - If `word` matches:
        - If `word.length > result.length`: `result = word`.
        - If `word.length == result.length && word < result`: `result = word`.
4.  **Subsequence Check:** Two pointers greedy approach.

---

## 2. Approach: Iteration without Sorting
## *2. Hướng tiếp cận: Lặp không Sắp xếp*

### Logic
### *Logic*
(See above). Sorting the dictionary first would cost $O(N \log N \cdot L)$, then finding the first match is quick. But linear scan is $O(N \cdot (L + S))$, which is generally comparable or faster given constraints and simpler to implement.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Greedy Matching:** Subsequence check is $O(len(s))$.
    *Khớp tham lam: Kiểm tra dãy con là $O(len(s))$.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot S)$, where $N$ is dictionary size, $S$ is string length.
    *Độ phức tạp thời gian: $O(N \cdot S)$.*
*   **Space Complexity:** $O(1)$ (excluding result storage).
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `s="abpcplea"`, `d=["ale","apple"]`
1. Check `ale`: subseq? Yes. Res=`ale`.
2. Check `apple`: subseq? Yes. `len(apple)=5 > len(ale)=3`. Res=`apple`.
Result: `apple`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Iterate dictionary and update best candidate.
*Duyệt từ điển và cập nhật ứng viên tốt nhất.*
---
*Việc tìm kiếm phiên bản tốt nhất (longest word) không đòi hỏi ta phải sắp xếp lại cả thế giới (sorting dictionary). Chỉ cần kiên nhẫn xem xét từng cơ hội (iterating) và sẵn sàng thay thế cái cũ bằng cái tốt đẹp hơn (updating result), ta sẽ tìm được câu trả lời hoàn hảo.*
Finding the best version (Longest Word) implies we don't need to reorder the whole world (Sorting Dictionary). Just patiently consider each opportunity (Iterating) and ready to replace the old one with better (Updating Result), we will find the perfect answer.
