# Analysis for Permutation Sequence
# *Phân tích cho bài toán Chuỗi Hoán Vị*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Integers `n` (numbers 1 to n) and `k` (target index). *Các số nguyên `n` (các số từ 1 đến n) và `k` (chỉ số mục tiêu).*
*   **Output:** The k-th permutation as a string. *Hoán vị thứ k dưới dạng chuỗi.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `n` is small (up to 9).
*   $n!$ can be up to $362,880$.
*   We need the $k$-th permutation directly without generating all permutations to be efficient.
*   *`n` nhỏ (lên tới 9).*
*   *$n!$ có thể lên tới $362,880$.*
*   *Chúng ta cần tìm trực tiếp hoán vị thứ $k$ mà không cần tạo tất cả các hoán vị để đảm bảo hiệu quả.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Factorial Number System (Math)
### *Hướng tiếp cận: Hệ số Giai thừa (Toán học)*

*   **Intuition:** For a set of $n$ numbers, there are $(n-1)!$ permutations starting with each of the $n$ numbers. We can determine which number the $k$-th permutation starts with by calculating `(k-1) / (n-1)!`.
*   *Ý tưởng: Đối với một tập hợp gồm $n$ số, luôn có $(n-1)!$ hoán vị bắt đầu bằng mỗi số trong $n$ số đó. Chúng ta có thể xác định hoán vị thứ $k$ bắt đầu bằng số nào bằng cách tính `(k-1) / (n-1)!`.*

*   **Algorithm Steps:**
    1.  Create a list of numbers `[1, 2, ..., n]`.
    2.  Precompute factorials up to `n-1`.
    3.  Adjust `k` to 0-indexed: `k = k - 1`.
    4.  Loop `i` from `n` down to `1`:
        *   `index = k / (i-1)!`.
        *   Append `numbers[index]` to the result string.
        *   Remove `numbers[index]` from the list.
        *   Update `k = k % (i-1)!`.
    5.  Return the string.

*   **Complexity:**
    *   Time: $O(N^2)$ (due to list removal in each of $N$ steps).
    *   Space: $O(N)$ for precomputing factorials and storing numbers.

### Dry Run
### *Chạy thử*
`n = 3, k = 3`
1. List: `[1, 2, 3]`. Factorials: `0!=1, 1!=1, 2!=2`. `k = 2`.
2. `i = 3`: `index = 2 / 2! = 2 / 2 = 1`.
   - Pick `list[1] = 2`. Result: `"2"`. List: `[1, 3]`.
   - `k = 2 % 2 = 0`.
3. `i = 2`: `index = 0 / 1! = 0 / 1 = 0`.
   - Pick `list[0] = 1`. Result: `"21"`. List: `[3]`.
   - `k = 0 % 1 = 0`.
4. `i = 1`: `index = 0 / 0! = 0 / 1 = 0`.
   - Pick `list[0] = 3`. Result: `"213"`.
Result: `"213"`. Correct.
---
*Toán học giúp chúng ta "nhảy" trực tiếp đến kết quả mong muốn.*
Mathematical logic allows us to "jump" directly to the desired result.
