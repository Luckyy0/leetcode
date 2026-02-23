# Analysis for Valid Anagram
# *Phân tích cho bài toán Đảo chữ hợp lệ*

## 1. Problem Essence & Character Counting
## *1. Bản chất vấn đề & Đếm ký tự*

### Definition
### *Định nghĩa*
Anagram means same counts for every character.
Order doesn't matter.
*Đảo chữ nghĩa là cùng số lượng cho mỗi ký tự. Thứ tự không quan trọng.*

### Approaches
### *Các cách tiếp cận*
1.  **Sorting:** Sort both strings and compare. Time $O(N \log N)$.
2.  **Hash Map:** Count char frequencies. Time $O(N)$. Space $O(1)$ (since charset is fixed 26).
3.  **Array:** Use `int[26]` since inputs are lowercase English letters. Faster than HashMap.

---

## 2. Approach: Frequency Array
## *2. Hướng tiếp cận: Mảng tần số*

### Logic
### *Logic*
1.  If lengths differ, return `false`.
2.  Use `int[26] count`.
3.  Iterate `s`: `count[s.charAt(i) - 'a']++`.
4.  Iterate `t`: `count[t.charAt(i) - 'a']--`.
5.  Iterate `t` again (or checking inside loop is tricky):
    - Optimization: While iterating `t`, if count drops below 0, return `false`.
    - Or just check array at the end: if any value != 0, return `false`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Fixed Size:** Array size 26 is negligible space.
    *Kích thước cố định: Mảng 26 là không đáng kể.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$ (or $O(26)$).
    *Độ phức tạp không gian: $O(1)$.*

### Follow up: Unicode?
Use `HashMap<Character, Integer>`.
*Nếu là Unicode, dùng HashMap.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** "rat", "car"
1.  'r' -> count['r'] = 1
2.  'a' -> count['a'] = 1
3.  't' -> count['t'] = 1
4.  'c' -> count['c'] = -1 (Mismatch if checking on the fly? No, usually inc S dec T).
    - Let's say we increment for S, decrement for T.
    - 'c' -> count['c']-- -> -1.
    - 'a' -> count['a']-- -> 0.
    - 'r' -> count['r']-- -> 0.
5.  Check array: count['t']=1, count['c']=-1. Not all zero. Return `false`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Simplest hash map problem. Array is preferred for speed.
*Bài toán hash map đơn giản nhất. Mảng được ưu tiên vì tốc độ.*
---
*Cùng một nguyên liệu (ký tự), nhưng cách sắp xếp khác nhau tạo nên những món ăn (từ) khác nhau.*
Same ingredients (characters), but different arrangements create different dishes (words).
