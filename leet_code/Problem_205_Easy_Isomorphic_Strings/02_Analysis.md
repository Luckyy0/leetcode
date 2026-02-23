# Analysis for Isomorphic Strings
# *Phân tích cho bài toán Chuỗi đẳng cấu*

## 1. Problem Essence & Mapping Rules
## *1. Bản chất vấn đề & Quy tắc ánh xạ*

### The Bi-directional Constraint
### *Ràng buộc hai chiều*
Standard mapping only requires `s[i] -> t[i]`.
However, Isomorphic mapping forbids two different characters mapping to the same target character ($a \to x$ and $b \to x$ is invalid).
This means the mapping must be **one-to-one (bijective)**.
*Ánh xạ đẳng cấu cấm hai ký tự khác nhau ánh xạ đến cùng một ký tự đích. Điều này có nghĩa là ánh xạ phải là **một-một (song ánh)**.*

For example: `s = "badc", t = "baba"`
- b -> b (OK)
- a -> a (OK)
- d -> b (Wait, 'b' is already mapped from 'b'. Conflict!)

---

## 2. Approach: Two Maps (or Two Arrays)
## *2. Hướng tiếp cận: Hai bản đồ (hoặc Hai mảng)*

### Logic
### *Logic*
We need to track:
1.  What char from `s` maps to what char in `t` (`s2t`).
2.  What char in `t` is already mapped from `s` (`t2s`).
*Chúng ta cần theo dõi: 1. Ký tự từ `s` ánh xạ đến ký tự nào trong `t`. 2. Ký tự nào trong `t` đã được ánh xạ từ `s`.*

Algorithm:
- Loop `i` from 0 to length.
- Char `c1 = s[i]`, `c2 = t[i]`.
- If `c1` in `s2t`:
    - check if `s2t[c1] == c2`. If not, return False.
- Else:
    - check if `c2` in `t2s`. If yes, return False (because it implies multiple chars map to `c2`).
    - Set `s2t[c1] = c2`, `t2s[c2] = c1`.
- Return True.

### Optimization: Integer Arrays
### *Tối ưu hóa: Mảng số nguyên*
Since inputs are ASCII strings, we can use int arrays `m1[256]` and `m2[256]` instead of HashMaps for speed.
Instead of storing the character mapping directly, we can store the **last seen index** + 1.
- If `m1[s[i]] != m2[t[i]]`, it means the characters were last seen at different positions, implying inconsistency.
*Thay vì lưu trữ ánh xạ ký tự, chúng ta có thể lưu trữ **chỉ số xuất hiện gần nhất** + 1. Nếu `m1[s[i]] != m2[t[i]]`, điều đó có nghĩa là các ký tự đã được nhìn thấy lần cuối ở các vị trí khác nhau, ngụ ý sự không nhất quán.*

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Index Mapping Logic:** Storing the index simplifies the logic significantly. We don't need to check "contains key" and then "get value". We just check if the recorded history aligns.
    *Logic ánh xạ chỉ số: Lưu trữ chỉ số đơn giản hóa logic đáng kể. Chỉ cần kiểm tra xem lịch sử đã ghi có khớp hay không.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Single pass.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$ (constant size of charset, 256 for ASCII).
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run (Index Logic)
## *5. Chạy thử bằng hình ảnh (Logic chỉ số)*

**Input:** `s="foo"`, `t="bar"`

1.  `i=0`: `s='f'`, `t='b'`. `m1['f']=0`, `m2['b']=0`. Equal.
    - Set `m1['f']=1`, `m2['b']=1`.
2.  `i=1`: `s='o'`, `t='a'`. `m1['o']=0`, `m2['a']=0`. Equal.
    - Set `m1['o']=2`, `m2['a']=2`.
3.  `i=2`: `s='o'`, `t='r'`. 
    - `m1['o']=2`.
    - `m2['r']=0`.
    - `2 != 0`. Return **False**.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Isomorphic Strings is a variation of the pattern matching problem. The "Two Arrays of Indices" trick is a very clever interview pattern that saves writing verbose `Map` code. It essentially checks: "Have I seen these two characters paired up *synchronously* before?"
*Chuỗi đẳng cấu là một biến thể của bài toán so khớp mẫu. Mẹo "Hai mảng chỉ số" là một mẫu phỏng vấn rất thông minh giúp tiết kiệm việc viết mã `Map`. Về cơ bản nó kiểm tra: "Tôi đã thấy hai ký tự này được ghép đôi *đồng bộ* trước đây chưa?"*
---
*Định mệnh của các ký tự không phải là giá trị của chúng, mà là cách chúng song hành cùng nhau qua thời gian.*
The destiny of characters is not their values, but how they walk together through time.
