# Analysis for Repeated DNA Sequences
# *Phân tích cho bài toán Chuỗi DNA lặp lại*

## 1. Problem Essence & Sliding Window Requirements
## *1. Bản chất vấn đề & Yêu cầu cửa sổ trượt*

### Constant Window Length
### *Độ dài cửa sổ cố định*
The problem asks for repeating substrings of length **exactly 10**. This fixed length is a significant advantage. It allows us to use a sliding window of size 10 across the string.
*Bài toán yêu cầu các chuỗi con lặp lại với độ dài **chính xác là 10**. Độ dài cố định này là một lợi thế lớn. Nó cho phép chúng ta sử dụng một cửa sổ trượt kích thước 10 trên toàn bộ chuỗi.*

### Target Data Structure
### *Cấu trúc dữ liệu mục tiêu*
To identify duplicates, we need to remember which substrings we have encountered. A `HashSet` is the ideal tool for $O(1)$ lookups and insertions.
*Để xác định các chuỗi trùng lặp, chúng ta cần ghi nhớ những chuỗi con nào mình đã gặp. `HashSet` là công cụ lý tưởng.*

---

## 2. Approach: Double HashSet for Non-redundant Results
## *2. Hướng tiếp cận: Hai lớp HashSet cho kết quả không dư thừa*

### The Strategy
### *Chiến lược*
1.  **`seen` Set:** To store every 10-letter substring encountered so far.
2.  **`repeated` Set (The Result):** To store only those substrings that have been seen **more than once**.
    - If a substring is already in `seen` but not in `repeated`, add it to `repeated`.
    - This automatically prevents adding the same repeated sequence multiple times to the output list if it appears 3, 4, or more times.

### Algorithm Steps
### *Các bước thuật toán*
1.  Initialize `seen = new HashSet()` and `repeated = new HashSet()`.
2.  Loop from `i = 0` to `s.length() - 10`.
3.  Extract `substring = s.substring(i, i + 10)`.
4.  If `!seen.add(substring)`, it means the substring was already seen. Add it to `repeated`.
5.  Return the contents of the `repeated` set as a list.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Simple Logic:** By using the return value of `Set.add()` (which returns false if the element already exists), we can write a very concise and readable solution.
    *Logic đơn giản: Bằng cách sử dụng giá trị trả về của `Set.add()`, chúng ta có thể viết một giải pháp rất súc tích.*
*   **Duplicate Prevention:** Using a second set for results ensures we don't return `["AAAAACCCCC", "AAAAACCCCC"]` if that pattern appears three times in the input.
    *Ngăn chặn trùng lặp: Việc sử dụng tập hợp thứ hai cho kết quả đảm bảo chúng ta không trả về cùng một chuỗi lặp lại nhiều lần.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \times L)$, where $N$ is the length of string $s$ and $L = 10$ is the length of the substring.
    - We perform $N - L$ iterations.
    - Each `substring()` and `HashSet` operation takes $O(L)$ time for hashing.
    *Độ phức tạp thời gian: $O(N \times L)$.*
*   **Space Complexity:** $O(N \times L)$. In the worst case, every substring is unique, and we store them all in the set.
    *Độ phức tạp không gian: $O(N \times L)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"`

1. `i=0`: Sub="AAAAACCCCC". `seen: {"AAAAACCCCC"}`.
2. `i=1`: Sub="AAAACCCCCA". `seen: {"AAAAACCCCC", "AAAACCCCCA"}`.
...
10. `i=10`: Sub="AAAAACCCCC". `AAAAACCCCC` is already in `seen`! 
    - `repeated: {"AAAAACCCCC"}`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Repeated DNA Sequences is a great entry point into string hashing and set theory. While `substring()` and `HashSet` are sufficient for $L=10$, be aware that for significantly larger $L$ or extremely long strings, you might need **Rolling Hash (Rabin-Karp)** or **Bit Manipulation** (encoding A=00, C=01, G=10, T=11 into an integer) to avoid the $O(L)$ cost of string creation and hashing.
*Chuỗi DNA lặp lại là một điểm khởi đầu tuyệt vời vào lý thuyết tập hợp và hash chuỗi. Mặc dù `substring()` và `HashSet` là đủ cho $L=10$, hãy lưu ý rằng đối với $L$ lớn hơn đáng kể, bạn có thể cần **Rolling Hash** hoặc **Thao tác Bit** để tránh chi phí $O(L)$ của việc tạo chuỗi.*
---
*Những đoạn mã của sự sống đôi khi lặp lại chính mình, để rồi qua sự trùng lặp đó, chúng ta tìm thấy những quy luật ẩn giấu.*
The codes of life sometimes repeat themselves, and through that repetition, we find the hidden rules.
