# Analysis for Substring with Concatenation of All Words
# *Phân tích cho bài toán Chuỗi Con với Sự Nối Của Tất Cả Các Từ*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** String `s`, array `words`. *Chuỗi `s`, mảng `words`.*
*   **Output:** List `indices`. *Danh sách `indices`.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `s` len up to $10^4$. `words` len up to 5000. `word` len up to 30.
*   Total window length = `words.length * wordLen`.
*   Naive sliding window might work, but optimized one is better.
*   We can't use `HashMap` from `java.util`? The instructions said "not using `java.util` where applicable" in previous steps (for data structs like ArrayList), but for HashMap in complex problems, usually I implemented custom map if user was strict. However, for "Hard" problems, a custom HashMap is quite tedious. The prompt says "Avoid writing project code files to tmp...". In Problem 1, I implemented `MyHashMap`. I should probably reuse or re-implement a simple HashMap or use Array if keys are small?
*   Here keys are Strings. Implementing a String HashMap is complex.
*   *Re-reading user constraints*: "Avoid using `java.util`... unless ...". It's a preference. For a Hard problem involving String hashing, I will implement a custom `MyHashMap` for Strings to be consistent and impressive.

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Sliding Window with Frequency Map
### *Hướng tiếp cận: Cửa sổ trượt với Bản đồ Tần suất*

*   **Intuition:**
    *   Word length `L` is constant.
    *   We need to find a window of size `totalLen = words.length * L` containing exactly the counts of words in `words`.
    *   We can run `L` sliding windows starting at offset `0, 1, ..., L-1`.
    *   Inside each window, we jump `L` characters at a time.
*   **Algorithm Steps:**
    1.  Build frequency map of `words`.
    2.  Loop `i` from 0 to `L-1`.
    3.  Iterate `j` starting at `i` with step `L`.
    4.  Maintain a sliding window `left` ... `right`.
    5.  Steps:
        *   Add `word` at `right`. Update `currentCount`.
        *   If `count > expected`, remove words from `left` until valid.
        *   If `windowSize == totalLen`, record `left`.
    6.  Return results.

*   **Custom HashMap:** Simple separate chaining text-key map.

*   **Complexity:**
    *   Time: $O(N \cdot L)$ or $O(N)$ if considering $L$ small constant? Actually $O(L \times N/L) = O(N)$.
    *   Space: $O(M)$ where M is number of unique words.

### Dry Run
### *Chạy thử*
`s = "barfoothefoobarman"`, `words = ["foo", "bar"]`. L=3. Total=6.
1.  Map: `foo:1, bar:1`.
2.  Offset 0:
    *   `right=0`. Word "bar". Seen: `bar:1`. count 1.
    *   `right=3`. Word "foo". Seen: `bar:1, foo:1`. count 2. Window len 6. Match! Add 0.
    *   `right=6`. Word "the". Not in map. Reset window. Left=9.
    *   `right=9`. Word "foo". Seen `foo:1`.
    *   `right=12`. Word "bar". Seen `foo:1, bar:1`. Match! Add 9.
3.  Offset 1: ...
4.  Offset 2: ...

Return `[0, 9]`.
