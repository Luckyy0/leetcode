# Analysis for Word Break
# *Phân tích cho bài toán Tách Từ*

## 1. Problem Essence & Decision Making
## *1. Bản Chất Vấn Đề & Ra Quyết Định*

### The Overlapping Subproblems
### *Sự Trùng Lặp Của Các Bài Toán Con*
*   To check if a string `s` of length $N$ can be word-broken, we can check if a prefix `s[0...j]` is valid AND the remaining suffix `s[j...N]` is a word in the dictionary.
    *Để kiểm tra xem một chuỗi `s` độ dài $N$ có thể tách từ được không, chúng ta có thể kiểm tra xem tiền tố `s[0...j]` có hợp lệ hay không VÀ hậu tố còn lại `s[j...N]` có phải là một từ trong từ điển hay không.*
*   If we use a simple recursion, we might recalculate the same prefixes multiple times. For example, in "applepenapple", we might try to split at the first "apple" or the second "apple". The validity of "applepen" remains a common intermediate step.
    *Nếu sử dụng đệ quy đơn giản, chúng ta có thể tính toán lại cùng một tiền tố nhiều lần. Ví dụ, trong "applepenapple", chúng ta có thể thử tách tại chữ "apple" đầu tiên hoặc thứ hai. Tính hợp lệ của "applepen" vẫn là một bước trung gian chung.*
*   This structure of **Optimal Substructure** and **Overlapping Subproblems** hints directly at **Dynamic Programming**.
    *Cấu trúc này về **Cấu trúc con tối ưu** và **Các bài toán con trùng lặp** gợi ý trực tiếp đến **Quy hoạch động (DP)**.*

---

## 2. Approach: 1D Dynamic Programming
## *2. Hướng Tiếp Cận: Quy Hoạch Động 1 Chiều*

### State Definition
### *Định Nghĩa Trạng Thái*
*   Let `dp[i]` be a boolean indicating whether the prefix of `s` of length `i` (`s.substring(0, i)`) can be segmented using the dictionary.
    *Gọi `dp[i]` là một giá trị boolean cho biết liệu tiền tố của `s` có độ dài `i` (`s.substring(0, i)`) có thể được phân tách bằng từ điển hay không.*
*   Our goal is to find `dp[n]`, where `n` is `s.length()`.
    *Mục tiêu của chúng ta là tìm `dp[n]`, với `n` là độ dài của `s`.*

### Transition Logic
### *Logic Chuyển Đổi*
*   **Base Case:** `dp[0] = true` (an empty string is always segmentable).
*   For each index `i` from 1 to `n`:
    -   Iterate `j` from 0 to `i-1`.
    -   If `dp[j]` is true AND `s.substring(j, i)` is in the `wordDict`:
        -   Set `dp[i] = true` and break the inner loop (since we found at least one way).
        -   *Lưu ý: Để việc tra cứu nhanh chóng, hãy chuyển `wordDict` thành một `HashSet`.*

---

## 3. Structural Advantages
## *3. Ưu Điểm Cấu Trúc*

*   **Memoization:** By storing the results in the `dp` array, we avoid exponential time complexity caused by redundant recursive calls.
    *Ghi nhớ: Bằng cách lưu trữ các kết quả trong mảng `dp`, chúng ta tránh được độ phức tạp thời gian hàm mũ do các cuộc gọi đệ quy dư thừa.*
*   **Optimization:** We can limit the inner loop $j$ based on the maximum length of words in the dictionary to further speed up the process.
    *Tối ưu hóa: Chúng ta có thể giới hạn vòng lặp bên trong $j$ dựa trên độ dài tối đa của các từ trong từ điển để tăng tốc thêm quá trình.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^3)$, where $N$ is the length of the string. There are two nested loops ($O(N^2)$), and inside the loops, the `substring` operation and set lookup take $O(N)$ (due to string hashing and creation).
    *Độ phức tạp thời gian: $O(N^3)$, trong đó $N$ là độ dài của chuỗi. Có hai vòng lặp lồng nhau ($O(N^2)$), và bên trong các vòng lặp, thao tác `substring` và tra cứu tập hợp tốn $O(N)$ (do việc băm chuỗi và tạo chuỗi).*
*   **Space Complexity:** $O(N + D)$, where $N$ is the size of the DP array and $D$ is the size of the dictionary set.
    *Độ phức tạp không gian: $O(N + D)$, trong đó $N$ là kích thước của mảng DP và $D$ là kích thước của tập hợp từ điển.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

`s = "leetcode"`, `dict = {"leet", "code"}`
`dp` size is 9 (0 to 8)

-   `dp[0] = T`
-   ...
-   `i = 4` ("leet"):
    -   `j = 0`: `dp[0]` is T, `s[0...4]` ("leet") in dict? Yes. `dp[4] = T`.
-   ...
-   `i = 8` ("leetcode"):
    -   `j = 0`: `s[0...8]` in dict? No.
    -   ...
    -   `j = 4`: `dp[4]` is T, `s[4...8]` ("code") in dict? Yes. `dp[8] = T`.

**Final Result:** `dp[8]` is True.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

This is a quintessential DP problem. Understanding how to build up the solution from the base case `dp[0]` is vital. Always remember to use a `HashSet` for word lookup to maintain efficiency. For production-grade code, checking the max word length in the dictionary can reduce the inner loop range from $O(N)$ to a constant $O(L_{max})$.
*Đây là một bài toán DP tinh túy. Hiểu cách xây dựng giải pháp từ trường hợp cơ sở `dp[0]` là rất quan trọng. Luôn nhớ sử dụng `HashSet` để tra cứu từ nhằm duy trì hiệu quả. Đối với mã cấp độ sản xuất, việc kiểm tra độ dài từ tối đa trong từ điển có thể giảm phạm vi vòng lặp bên trong từ $O(N)$ xuống một hằng số $O(L_{max})$.*
---
*Việc thấu hiểu một thông điệp lớn bắt đầu từ khả năng nhận diện những mảnh ghép nhỏ bé đã từng được xác thực.*
Understanding a large message begins with the ability to recognize small, previously validated pieces.
