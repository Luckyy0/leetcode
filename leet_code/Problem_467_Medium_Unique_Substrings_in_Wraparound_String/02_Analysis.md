# Analysis for Unique Substrings in Wraparound String
# *Phân tích cho bài toán Chuỗi con Duy nhất trong Chuỗi Vòng*

## 1. Problem Essence & Longest Sequence Tracking
## *1. Bản chất vấn đề & Theo dõi Chuỗi dài nhất*

### The Challenge
### *Thách thức*
Counting unique substrings of `s` that follow the sequence `...xyzabc...`. A substring follows this sequence if every character is the successor of the previous one (modulo 26).
- For a sequence like `"abcd"`, it contains substrings: `"a", "b", "c", "d", "ab", "bc", "cd", "abc", "bcd", "abcd"`.
- Total length-4 sequence contains 4 unique substrings ending in 'd', 3 ending in 'c', etc.

### Strategy: Max Length per Character
### *Chiến lược: Độ dài Tối đa trên mỗi Ký tự*

1.  **Fundamental Insight:** To avoid over-counting unique substrings, we only need to know the **maximum length** of a valid "wraparound" sequence ending with each character 'a'...'z'.
    - If the longest sequence ending in 'd' is 4 (`"abcd"`), it implies that all shorter sequences ending in 'd' (`"bcd", "cd", "d"`) are already covered.
    - We maintain an array `count[26]` where `count[i]` stores the length of the longest valid sequence ending in the $i$-th character.
2.  **Algorithm:**
    - Iterate through `s`.
    - Maintain a `currentLen`. If `s[i]` is the successor of `s[i-1]`, `currentLen++`. Otherwise, reset `currentLen = 1`.
    - Update `count[s[i] - 'a'] = max(count[s[i] - 'a'], currentLen)`.
3.  **Result:** Sum of all values in the `count` array.

---

## 2. Approach: Dynamic Programming on Endpoints
## *2. Hướng tiếp cận: Quy hoạch động trên Điểm cuối*

### Logic
### *Logic*
(See above). The successor check is `(s[i] - s[i - 1] == 1 || s[i - 1] - s[i] == 25)`. By tracking the max length ending at each character, we utilize the property that a valid sequence of length $L$ contributes $L$ unique new substrings (those starting at different points and ending at this character).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Efficiency:** Single linear scan through the string.
    *Hiệu quả O(N): Duyệt tuyến tính chuỗi một lần.*
*   **Constant Space:** Only needs an array of size 26.
    *Không gian hằng số: Chỉ cần mảng kích thước 26.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the length of `s`.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$ (ignoring the alphabet array).
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `s = "zab"`
1. `i=0, char='z', len=1`. `count['z']=1`.
2. `i=1, char='a', len=2`. Successor! `count['a']=2`. (Covers "a", "za").
3. `i=2, char='b', len=3`. Successor! `count['b']=3`. (Covers "b", "ab", "zab").
Total: `count['z'](1) + count['a'](2) + count['b'](3) = 6`.
Result: 6.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Track the max length of consecutive wraparound sequences for each ending character.
*Theo dõi độ dài tối đa của các chuỗi vòng liên tiếp cho mỗi ký tự kết thúc.*
---
*Vòng xoay vô tận của bảng chữ cái (wraparound string) là hình ảnh của sự kế thừa và tiếp diễn. Trong thế giới của dữ liệu, thay vì đếm từng mảnh vụn rời rạc (substrings), ta hãy tập trung vào những mạch cảm xúc dài nhất (max length) kết thúc tại mỗi điểm dừng. Bởi lẽ, trong một chuỗi thành công rực rỡ, mọi bước tiến nhỏ hơn đều đã được bao hàm trong vinh quang cuối cùng.*
The endless rotation of the alphabet (wraparound string) is an image of legacy and continuation. In the world of data, instead of counting each discrete debris (substrings), let focus on the longest emotional circuits (max length) ending at each stop. Because, in a glorious chain of success, all smaller steps have been included in the final glory.
