# Analysis for Split Array into Fibonacci Sequence
# *Phân tích cho bài toán Chia Mảng thành Dãy Fibonacci*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
We need to partition a numeric string into a sequence of integers that follow the Fibonacci additive property ($A + B = C$).
*Chúng ta cần chia một chuỗi số thành một dãy các số nguyên tuân theo đặc tính cộng của Fibonacci ($A + B = C$).*

### KEY CONSTRAINTS
### *Các ràng buộc chính*
- Minimum 3 numbers.
- No leading zeros (unless the value is exactly 0).
- Must fit into a 32-bit signed integer.
- The string length is up to 200.
*- Ít nhất 3 số. Không có số 0 đứng đầu. Phải vừa với kiểu số nguyên 32-bit. Độ dài chuỗi lên tới 200.*

---

## 2. Strategy: Backtracking
## *2. Chiến lược: Quay lui (Backtracking)*

### Why Backtracking?
### *Tại sao dùng Quay lui?*
Once we pick the first two numbers, the rest of the sequence is mathematically determined. However, we don't know the lengths of the first two numbers. Backtracking allows us to explore different partitioning possibilities systematically.
*Một khi chúng ta đã chọn xong hai số đầu tiên, phần còn lại của dãy đã được xác định về mặt toán học. Tuy nhiên, chúng ta không biết độ dài của hai số đầu tiên. Quay lui cho phép chúng ta khám phá các khả năng chia cắt một cách hệ thống.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Define a recursive function `backtrack(index, result)`:**
    *   **Định nghĩa hàm đệ quy:** `backtrack(vị trí, danh sách kết quả)`*

2.  **Base Case:** If `index == num.length()` and `result.size() >= 3`, we found a solution.
    *   **Trường hợp cơ sở:** Nếu đã duyệt hết chuỗi và danh sách có ít nhất 3 số, ta đã tìm thấy lời giải.*

3.  **Recursive Step:** Starting from `index`, try picking a substring of length `i`:
    - Check for leading zero: `if (num[index] == '0' && i > 1) break;`.
    - Convert to long: Handles 32-bit overflow check.
    - If `result.size() < 2`: Add to result and recurse.
    - If `result.size() >= 2`: Compare with sum of last two.
        - If `val == sum`: Add and recurse.
        - If `val > sum`: Break (no need to check longer substrings).
        - If `val < sum`: Continue picking a longer substring.
    *   **Bước đệ quy:** Thử các chuỗi con bắt đầu từ `index` với độ dài tăng dần. Kiểm tra số 0 đứng đầu và tràn số. Nếu danh sách chưa đủ 2 số, cứ thêm vào. Nếu đã có ít nhất 2 số, so sánh số hiện tại với tổng của 2 số trước. Nếu bằng, thêm vào và đệ quy. Nếu lớn hơn, dừng lại vì chuỗi con dài hơn chắc chắn sẽ lớn hơn.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public boolean backtrack(String num, int idx, List<Integer> res) {
    if (idx == num.length() && res.size() >= 3) return true;

    for (int i = idx; i < num.length(); i++) {
        // Leading zero check
        if (num.charAt(idx) == '0' && i > idx) break;
        
        long val = Long.parseLong(num.substring(idx, i + 1));
        if (val > Integer.MAX_VALUE) break; // Overflow

        int size = res.size();
        if (size >= 2 && val > res.get(size - 1) + res.get(size - 2)) break;

        if (size < 2 || val == res.get(size - 1) + res.get(size - 2)) {
            res.add((int) val);
            if (backtrack(num, i + 1, res)) return true;
            res.remove(res.size() - 1);
        }
    }
    return false;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(2^N)$ in the worst case (permutation of all splits), but due to the strong Fibonacci constraint and 32-bit limit, the search space is pruned very quickly. In practice, it's very efficient.
    *   **Độ phức tạp thời gian:** $O(2^N)$ trong trường hợp xấu nhất, nhưng nhờ ràng buộc Fibonacci và giới hạn 32-bit, không gian tìm kiếm bị cắt tỉa rất nhanh.*
*   **Space Complexity:** $O(N)$ for the recursion stack and output list.
    *   **Độ phức tạp không gian:** $O(N)$ cho ngăn xếp đệ quy và danh sách kết quả.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Pruning is essential for backtracking problems. By breaking early when `val > sum`, we significantly reduce the number of paths explored.
*Cắt tỉa là điều cần thiết cho các bài toán quay lui. Bằng cách dừng sớm khi giá trị vượt quá tổng, chúng ta giảm đáng kể số lượng các đường dẫn cần khám phá.*
