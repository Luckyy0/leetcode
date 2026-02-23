# Analysis for Swap Adjacent in LR String
# *Phân tích cho bài toán Hoán đổi Liền kề trong Chuỗi LR*

## 1. Problem Essence & Invariants
## *1. Bản chất vấn đề & Bất biến*

### Movement Rules
### *Quy tắc Di chuyển*
- `XL` -> `LX`: 'L' moves Left over an 'X'. 'L' cannot move Right.
- `RX` -> `XR`: 'R' moves Right over an 'X'. 'R' cannot move Left.
- 'L' and 'R' can never jump over each other. They just move through 'X's.
- `X` is fluid, but relative order of L and R is fixed.
*`XL` -> `LX`: 'L' di chuyển sang Trái qua 'X'. 'L' không thể sang Phải. `RX` -> `XR`: 'R' di chuyển sang Phải qua 'X'. 'R' không thể sang Trái. 'L' và 'R' không bao giờ nhảy qua nhau. Thứ tự tương đối của L và R là cố định.*

### Invariants
### *Bất biến*
1.  **Relative Order:** Start and End (ignoring 'X') must be identical. E.g., `L...R` cannot become `R...L`.
    *   **Thứ tự Tương đối:** Start và End sau khi bỏ 'X' phải giống hệt nhau.*
2.  **Position Constraints:**
    - For any `L` at index `i` in `start` and matching `L` at index `j` in `end`: Since `L` only moves left, `i >= j`.
    - For any `R` at index `i` in `start` and matching `R` at index `j` in `end`: Since `R` only moves right, `i <= j`.
    *   **Ràng buộc Vị trí:** Với `L`, `i >= j` (chỉ đi trái). Với `R`, `i <= j` (chỉ đi phải).*

---

## 2. Strategy: Two Pointers
## *2. Chiến lược: Hai Con trỏ*

### Algorithm
### *Thuật toán*

1.  **Check Length:** Must be equal.
2.  **Pointer Loop:** Use `p1` for `start`, `p2` for `end`.
3.  **Find Next Char:** Skip 'X's in both strings to find the next meaningful char ('L' or 'R').
4.  **Compare:**
    - If one reaches end but other doesn't (checking valid chars), return False.
    - If characters mismatch (`char1 != char2`), return False.
    - If char is 'L' and `p1 < p2` (Tried to move right), return False.
    - If char is 'R' and `p1 > p2` (Tried to move left), return False.
5.  **Advance:** `p1++`, `p2++`.
    *   **Vòng lặp Con trỏ:** Bỏ qua 'X'. So sánh ký tự tiếp theo. Nếu khác nhau -> False. Nếu vi phạm ràng buộc vị trí (`L` đi phải hoặc `R` đi trái) -> False.*

### Code Logic Preview
### *Xem trước Logic Mã*

```java
public boolean canTransform(String start, String end) {
    if (start.length() != end.length()) return false;
    // Check relative order by simple replacement? No, O(N) constraint check is better.
    // Replace approach is O(N) too but consumes memory.
    // Iterative.
    
    int n = start.length();
    int i = 0, j = 0;
    while (i < n || j < n) { // Use || because one might finish 'X's later
        while (i < n && start.charAt(i) == 'X') i++;
        while (j < n && end.charAt(j) == 'X') j++;
        
        if (i == n || j == n) return i == j; // Both must finish together
        
        if (start.charAt(i) != end.charAt(j)) return false;
        
        if (start.charAt(i) == 'L' && i < j) return false; // L cant go right
        if (start.charAt(i) == 'R' && i > j) return false; // R cant go left
        
        i++; j++;
    }
    return true;
}
```

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Single pass.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Start:** `RXXLRXRXL`, **End:** `XRLXXRRLX`
- Skip X:
  - `i=0` (R), `j=1` (R). Match R. `i(0) <= j(1)`. OK. `i=1, j=2`.
- Skip X:
  - `start[1..2]`=XX -> `i=3` (L).
  - `end[2]`=L -> `j=2` (L).
  - Match L. `i(3) >= j(2)`. OK. `i=4, j=3`.
- ... All match and constraints sat.
**Result:** True.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Two pointers skipping 'X' is the standard optimal approach.
*Hai con trỏ bỏ qua 'X' là phương pháp tối ưu tiêu chuẩn.*
