# Analysis for Split Concatenated Strings
# *Phân tích cho bài toán Cắt Chuỗi Liên kết*

## 1. Problem Essence & The Paradox of the Cycle
## *1. Bản chất vấn đề & Nghịch lý của Chu trình*

### The Challenge
### *Thách thức*
We are given a list of strings that form a cycle. Each string can be used as-is or reversed. We need to find the lexicographically largest string that can be formed by cutting this cycle at any point.
*Chúng ta được cung cấp một danh sách các chuỗi tạo thành một chu trình. Mỗi chuỗi có thể được sử dụng nguyên bản hoặc đảo ngược. Chúng ta cần tìm chuỗi lớn nhất theo thứ tự từ điển có thể tạo ra bằng cách cắt chu trình này tại bất kỳ điểm nào.*

Crucially, once a cut is made in string $S_i$, the other strings $S_j$ ($j \neq i$) must contribute to the body of the final string in their best possible orientation (original or reversed).
*Quan trọng là, một khi đường cắt được thực hiện trong chuỗi $S_i$, các chuỗi khác $S_j$ ($j \neq i$) phải đóng góp vào thân của chuỗi cuối cùng theo hướng tốt nhất có thể của chúng (nguyên bản hoặc đảo ngược).*

---

## 2. Strategy: Greedy Foundation with Selective Exploration
## *2. Chiến lược: Nền tảng Tham lam với Thám hiểm Có chọn lọc*

While the choice of where to cut is exhaustive, the choice of orientation for strings that are **not** being cut is greedy.
*Trong khi sự lựa chọn vị trí cắt là vét cạn, sự lựa chọn hướng cho các chuỗi **không** bị cắt là tham lam.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Optimization Step (Orientation):** For every string in the list, determine which is lexicographically larger: the original string or its reverse. Store these "best versions" in an array `best_strs`.
    * **Bước tối ưu hóa (Hướng):** Đối với mọi chuỗi trong danh sách, hãy xác định chuỗi nào lớn hơn theo thứ tự từ điển: chuỗi gốc hay chuỗi đảo ngược của nó. Lưu trữ những "phiên bản tốt nhất" này vào một mảng `best_strs`.*
    - If `strs[i] = "abc"`, `reverse = "cba"`, then `best_strs[i] = "cba"`.
    - *Nếu `strs[i] = "abc"`, `reverse = "cba"`, thì `best_strs[i] = "cba"`.*

2.  **Iterate for the Cut Point:** Try each string in the original list as the "cut string".
    * **Lặp để tìm điểm cắt:** Thử từng chuỗi trong danh sách ban đầu làm "chuỗi bị cắt".*

3.  **Explore Both Orientations for Cut:** For the current "cut string" $S_i$:
    * **Khám phá cả hai hướng cho điểm cắt:** Đối với "chuỗi bị cắt" $S_i$ hiện tại:*
    - Try splitting the original $S_i$ at every index $j$.
    - *Thử cắt $S_i$ nguyên bản tại mọi chỉ số $j$.*
    - Try splitting the reverse of $S_i$ at every index $j$.
    - *Thử cắt chuỗi đảo ngược của $S_i$ tại mọi chỉ số $j$.*

4.  **Form Candidate String:** For a cut at index $j$ in string $T$ (where $T \in \{S_i, \text{reverse}(S_i)\}$), the candidate string is formed as:
    * **Tạo chuỗi ứng cử viên:** Đối với một điểm cắt tại chỉ số $j$ trong chuỗi $T$ (trong đó $T \in \{S_i, \text{reverse}(S_i)\}$), chuỗi ứng cử viên được hình thành như sau:*
    `Candidate = T.substring(j) + (best_strs[(i+1)%n] + ... + best_strs[(i-1+n)%n]) + T.substring(0, j)`
    - Basically: Tail of cur string + Body of all other best strings + Head of cur string.
    - *Về cơ bản: Phần đuôi của chuỗi hiện tại + Thân của tất cả các chuỗi tốt nhất khác + Phần đầu của chuỗi hiện tại.*

5.  **Global Maximum:** Keep track of the largest candidate found across all iterations.
    * **Giá trị lớn nhất toàn cục:** Theo dõi ứng cử viên lớn nhất tìm thấy qua tất cả các lần lặp.*

---

## 3. Structural Advantages & Complexity Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái Độ phức tạp*

*   **Logic Reduction:** The core insight is that for strings not being cut, we *must* use their best version. This drastically reduces the search space from $2^N \times L$ to $N \times L$.
    * **Giảm thiểu logic:** Hiểu biết cốt lõi là đối với những chuỗi không bị cắt, ta *phải* sử dụng phiên bản tốt nhất của chúng. Điều này giúp giảm đáng kể không gian tìm kiếm từ $2^N \times L$ xuống $N \times L$.*
*   **Total length constraint:** Since $L \le 1000$, an $O(L^2)$ solution is highly efficient.
    * **Ràng buộc tổng độ dài:** Vì $L \le 1000$, giải pháp $O(L^2)$ là cực kỳ hiệu quả.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(L^2)$. For each character (split point), we build a string of length $L$ and compare it.
    * **Độ phức tạp thời gian:** $O(L^2)$. Với mỗi ký tự (điểm chia), chúng ta xây dựng một chuỗi độ dài $L$ và so sánh nó.*
*   **Space Complexity:** $O(L)$. To store the strings and the current best result.
    * **Độ phức tạp không gian:** $O(L)$. Để lưu trữ các chuỗi và kết quả tốt nhất hiện tại.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `["abc", "xyz"]`
1. Best versions: `["cba", "zyx"]`.
2. Try cutting "abc" (color 1):
   - Cut at index 0 ('a'): "abc" + "zyx" -> "abczyx".
   - Cut at index 1 ('b'): "bc" + "zyx" + "a" -> "bczyxa".
   - Cut at index 2 ('c'): "c" + "zyx" + "ab" -> "czyxab".
3. Try cutting "cba" (reverse of "abc"):
   - Cut index 0 ('c'): "cba" + "zyx" -> "cbazyx".
4. Try cutting "xyz" (color 2):
   - Cut index 0 ('x'): "xyz" + "cba" -> "xyzcba".
   - Cut reverse "zyx" index 0 ('z'): "zyx" + "cba" -> "zyxcba". (Matches Example 1).

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Use pre-calculation to simplify cyclic properties and then explore all possible cut points meticulously.
*Sử dụng tính toán trước để đơn giản hóa các đặc tính chu trình và sau đó khám phá tỉ mỉ tất cả các điểm cắt khả dĩ.*
---
*Đôi khi để đạt được kết quả lớn nhất (Max), ta cần phải biết linh hoạt (Reverse or not) và tìm ra điểm đột phá (Cut point) đúng đắn. Trong khi những yếu tố ổn định (non-cut strings) nên được tối ưu hóa một cách nhất quán, thì chính tại nơi ta lựa chọn thay đổi (the cut), ta cần sự tỉ mỉ để thử mọi khả năng.*
Sometimes to achieve the greatest result (Max), we need to be flexible (Reverse or not) and find the right breakthrough point (Cut point). While stable factors (non-cut strings) should be optimized consistently, it is at the place where we choose to change (the cut) that we need meticulousness to try every possibility.
