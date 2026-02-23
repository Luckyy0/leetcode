# Analysis for Pyramid Transition Matrix
# *Phân tích cho bài toán Ma trận Chuyển tiếp Kim tự tháp*

## 1. Problem Essence & Recursive Construction
## *1. Bản chất vấn đề & Xây dựng Đệ quy*

### The Challenge
### *Thách thức*
We need to determine if a valid pyramid can be built from a given base. Each layer is constructed from the layer below it. Since there can be multiple valid tops for a pair `(A, B)`, we must explore all possibilities (branching).
*Chúng ta cần xác định xem có thể xây dựng một kim tự tháp hợp lệ từ đáy đã cho hay không. Mỗi tầng được xây dựng từ tầng bên dưới nó. Vì có thể có nhiều đỉnh hợp lệ cho một cặp `(A, B)`, ta phải khám phá tất cả các khả năng (phân nhánh).*

### Graph Modeling
### *Mô hình hóa Đồ thị*
Allowed transitions form directed edges. `(A, B) -> {C1, C2...}`. We can use a map/table to store these relations.
*Các chuyển đổi cho phép tạo thành các cạnh có hướng. Ta có thể dùng bản đồ để lưu trữ các quan hệ này.*

---

## 2. Strategy: DFS with Memoization
## *2. Chiến lược: DFS với Ghi nhớ (Memoization)*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Parse Allowed:** Convert `allowed` list into a map `Map<String, List<Character>>` or `Map<Character, Map<Character, List<Character>>>` for quick lookup. E.g., `map.get(A).get(B)` returns allowed `Cs`.
    *   **Phân tích Allowed:** Chuyển đổi danh sách `allowed` thành bản đồ để tra cứu nhanh.*

2.  **Backtracking Loop:**
    - `solve(currentLevel)`:
        - If `currentLevel.length == 1`, we reached the top! Return `true`.
        - Otherwise, we need to build `nextLevel`.
    - `buildNext(index, currentLevel, nextLevelStr)`:
        - If `index == currentLevel.length - 1`, the `nextLevelStr` is complete. Recursively call `solve(nextLevelStr)`.
        - Else, find valid tops for pair `currentLevel[index], currentLevel[index+1]`.
        - For each valid top `C`, append to `nextLevelStr` and recurse `buildNext(index+1, ...)`.
    *   **Vòng lặp Quay lui:** Hàm `solve` kiểm tra điều kiện dừng. Hàm hỗ trợ `buildNext` xây dựng tầng tiếp theo từng ký tự một bằng cách thử tất cả các đỉnh `C` hợp lệ cho cặp bên dưới.*

3.  **Memoization:** Store `visited` states (strings that failed) to avoid re-computation. `Set<String> failed`.
    *   **Ghi nhớ:** Lưu trữ các trạng thái "thất bại" để tránh tính toán lại.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** Exponential in worst case, but constrained by limited alphabet (7 letters) and small height (8). $A^{N^2/2}$ theoretically, but pruning makes it fast.
    *   **Độ phức tạp thời gian:** Hàm mũ, nhưng khả thi do ràng buộc nhỏ.*
*   **Space Complexity:** $O(N^2)$ for recursion stack and memoization.
    *   **Độ phức tạp không gian:** $O(N^2)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Bottom: "BCD"**
Transitions: BC->A, CD->E, CD->A (fake example).
1. `solve("BCD")`. Need next level (len 2).
   - Pair B,C -> Top A. Next: "A...".
   - Pair C,D -> Top E. Next: "AE".
   - Recursion `solve("AE")`.
     - Need next level (len 1).
     - Pair A,E -> Top C (Allowed CEA). Next: "C".
     - `solve("C")`. Len 1 -> True.
**Result:** True.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Using a bitmask for allowed transitions (since 7 chars) could optimization lookup, but Map is simpler. Memoization of *failed* strings prevents Exploring the same dead-end sub-pyramids.
*Sử dụng bitmask cho các chuyển đổi (vì chỉ có 7 ký tự) có thể tối ưu hóa việc tra cứu, nhưng Map đơn giản hơn. Việc ghi nhớ các chuỗi *thất bại* giúp ngăn chặn việc khám phá lại các kim tự tháp con bế tắc.*
---
*Kim tự tháp (Pyramid) không được xây trong một ngày, và cũng không chỉ có một cách để xây lên đỉnh. Từ nền móng vững chắc (Bottom), mỗi viên gạch đặt lên (Block placement) phải dựa vào sự hòa hợp của những viên gạch bên dưới (Allowed triples). Dữ liệu dạy ta rằng bằng cách kiên trì thử nghiệm các khả năng (Backtracking) và ghi nhớ những sai lầm (Memoization), ta có thể tìm ra kiến trúc hoàn hảo vươn tới bầu trời.*
A pyramid (Pyramid) is not built in a day, nor is there only one way to build to the top. From a solid foundation (Bottom), every block placed (Block placement) must rely on the harmony of the ones below (Allowed triples). Data teaches us that by persistently testing possibilities (Backtracking) and remembering mistakes (Memoization), we can find the perfect architecture reaching for the sky.
