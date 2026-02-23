# Analysis for Long Pressed Name
# *Phân tích cho bài toán Nhấn dài*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Check if `typed` string can be formed from `name` by duplicating some characters (simulating long presses).
*Kiểm tra xem chuỗi `typed` có thể được tạo từ `name` bằng cách nhân đôi một số ký tự (mô phỏng nhấn giữ lâu) hay không.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- This is a string matching problem with relaxed rules.
- We iterate through both `name` (index `i`) and `typed` (index `j`).
- If `name[i] == typed[j]`, both advance.
- If `name[i] != typed[j]`, then:
  - If `j > 0` and `typed[j] == typed[j-1]` (it's a long press of the previous matching character), we advance `j` only.
  - Otherwise, it's a mismatch -> Return `False`.
- After the loop:
  - If `i` hasn't reached end of `name`, return `False` (not all characters in name were typed).
  - If `j` hasn't reached end of `typed`, make sure all remaining characters in `typed` are long presses of the last character. Or better, allow the loop to run until `j` finishes, but ensure `i` finishes too.
- Refined Logic:
  - Loop while `j < typed.length`:
    - If `i < name.length` and `name[i] == typed[j]`: `i++, j++`.
    - Else if `j > 0` and `typed[j] == typed[j-1]`: `j++` (consume long press).
    - Else: return `False` (Mismatch).
  - Finally, check if `i == name.length`.
*Đây là bài toán so khớp chuỗi với quy tắc nới lỏng. Duyệt cả hai. Nếu khớp, cả hai cùng tiến. Nếu không khớp nhưng `typed[j]` giống ký tự trước đó, chỉ `j` tiến (do nhấn lâu). Nếu khác cả trước đó, sai. Cuối cùng kiểm tra xem đã duyệt hết `name` chưa.*

---

## 2. Strategy: Two Pointers
## *2. Chiến lược: Hai Con Trỏ*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** `i = 0`, `j = 0`.
    *   **Khởi tạo:** `i = 0`, `j = 0`.*

2.  **Loop:** While `j < typed.length`:
    - Case 1: Match `name[i] == typed[j]`. Result: `i++`, `j++`.
    - Case 2: Mismatch, but `typed[j]` is a long press (`typed[j] == typed[j-1]`). Result: `j++`.
    - Case 3: Mismatch and not a long press. Result: `False`.
    *   **Vòng lặp:** Xử lý 3 trường hợp: Khớp, Nhấn lâu, Sai.*

3.  **Final Check:** Return `i == name.length`.
    *   **Kiểm tra cuối:** Trả về `i == name.length`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public boolean isLongPressedName(String name, String typed) {
    int i = 0;
    int j = 0;
    int m = name.length();
    int n = typed.length();
    
    while (j < n) {
        if (i < m && name.charAt(i) == typed.charAt(j)) {
            i++;
            j++;
        } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
            j++;
        } else {
            return false;
        }
    }
    
    return i == m;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is length of `typed`.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Simple two-pointer logic handles the "long press" condition effectively. It's crucial to check `j > 0` before accessing `typed[j-1]`.
*Logic hai con trỏ đơn giản xử lý điều kiện "nhấn lâu" một cách hiệu quả. Điều quan trọng là phải kiểm tra `j > 0` trước khi truy cập `typed[j-1]`.*
