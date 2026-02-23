# Analysis for Group Shifted Strings
# *Phân tích cho bài toán Nhóm các chuỗi dịch chuyển*

## 1. Problem Essence & Relative Differences
## *1. Bản chất vấn đề & Chênh lệch tương đối*

### The Pattern
### *Mẫu*
`abc` -> `0, 1, 2` (ascii-relative) -> Diffs: `1, 1`.
`bcd` -> `1, 2, 3` -> Diffs: `1, 1`.
`xyz` -> `23, 24, 25` -> Diffs: `1, 1`.

`az` -> `0, 25` -> Diff: `25`.
`ba` -> `1, 0`. `0 - 1 = -1`. Wrap around? `(0 - 1 + 26) % 26 = 25`.
Diffs: `25`.

### The Key
### *Chìa khóa*
Two strings are in the same shifted sequence if the **sequence of differences between consecutive characters** is the same.
We can use this sequence of differences as a **Hash Key**.
*Hai chuỗi cùng nhóm nếu chuỗi chênh lệch giữa các ký tự liên tiếp là giống nhau. Dùng chuỗi chênh lệch này làm Khóa Băm.*

---

## 2. Approach: Hash Map with Key Generation
## *2. Hướng tiếp cận: Hash Map với Tạo khóa*

### Logic
### *Logic*
1.  Map `String -> List<String>`.
2.  For each string `s`:
    - Generate key.
    - Key can be a string like `"1,1,"` or a specific encoded string.
    - Alternatively, shift the string so it starts with 'a'.
        - `abc` -> shift 'a' to 'a' (0). `abc`.
        - `bcd` -> shift 'b' to 'a' (-1). `bcd` -> `abc`.
        - `az` -> shift 'a' to 'a'. `az`.
        - `ba` -> shift 'b' to 'a' (-1). `ba` -> `az`.
    - This "Normalization" approach is cleaner.
3.  Add original string to the list corresponding to the key.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Canonical Form:** Every group has exactly one "Canonical" representation (starting with 'a').
    *Dạng chính tắc: Mỗi nhóm có đúng một đại diện chính tắc (bắt đầu bằng 'a').*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot L)$.
    *Độ phức tạp thời gian: $O(N \cdot L)$.*
*   **Space Complexity:** $O(N \cdot L)$.
    *Độ phức tạp không gian: $O(N \cdot L)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** "abc", "bcd", "az", "ba"

1.  "abc": Shift 'a'->'a' (offset 0). Result "abc". Key "abc".
2.  "bcd": Shift 'b'->'a' (offset -1).
    - 'b' -> 'a'
    - 'c' -> 'b'
    - 'd' -> 'c'
    - Result "abc". Key "abc". Group with previous.
3.  "az": Shift "az". Key "az".
4.  "ba": Shift 'b'->'a' (offset -1).
    - 'b' -> 'a'
    - 'a' -> 'z' ('a'-'b' = -1 + 26 = 25 = 'z').
    - Result "az". Key "az". Group with previous.

Result: `[["abc", "bcd"], ["az", "ba"]]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Normalization to 'a' is intuitive. Remember modulo 26 for wrapping.
*Chuẩn hóa về 'a' là trực quan. Nhớ modulo 26 cho việc quay vòng.*
---
*Dù xuất phát điểm khác nhau (a, b, x...), nhưng nếu chúng ta giữ vững khoảng cách (diffs) với những người bên cạnh, chúng ta vẫn thuộc về cùng một đội (group).*
Even if starting points differ (a, b, x...), as long as we maintain the distance (diffs) with those next to us, we belong to the same team (group).
