# Analysis for Reordered Power of 2
# *Phân tích cho bài toán Sắp xếp lại thành Lũy thừa của 2*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Can we rearrange the digits of $N$ to form a power of 2? The result must not have a leading zero.
*Liệu chúng ta có thể sắp xếp lại các chữ số của $N$ để tạo thành một lũy thừa của 2 hay không? Kết quả không được có số không ở đầu.*

Key property: If two numbers are rearrangements of each other, they have the **same counts of each digit**.
*Thuộc tính quan trọng: Nếu hai số là các cách sắp xếp lại của nhau, chúng có **số lượng từng chữ số giống nhau**.*

---

## 2. Strategy: Pre-calculate Powers and Compare Digit Counts
## *2. Chiến lược: Tính trước các lũy thừa và so sánh số lượng chữ số*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Generate Powers of 2:** Calculate all powers of 2 that fit in the range of $N$ ($1 \dots 10^9$). There are only 31 such powers ($2^0, 2^1, \dots, 2^{30}$).
    *   **Tạo các lũy thừa của 2:** Tính toán tất cả các lũy thừa của 2 nằm trong phạm vi của $N$. Chỉ có 31 lũy thừa như vậy.*

2.  **Digit Counting Function:** Create a helper function that returns an array of size 10, where `array[i]` is the count of digit `i` in a given number.
    *   **Hàm đếm chữ số:** Tạo một hàm trợ giúp trả về mảng kích thước 10, trong đó phần tử thứ `i` là số lượng chữ số `i` trong một số cho trước.*

3.  **Comparison:** 
    - Calculate the digit count of $N$.
    - Compare this count with the digit counts of all 31 powers of 2.
    - If any power of 2 has the exact same digit counts as $N$, return `true`.
    *   **So sánh:** Tính số lượng chữ số của $N$. So sánh số lượng này với số lượng chữ số của tất cả 31 lũy thừa của 2. Nếu bất kỳ lũy thừa nào có cùng số lượng chữ số như $N$, hãy trả về `true`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public boolean reorderedPowerOf2(int n) {
    int[] nCounts = countDigits(n);
    for (int i = 0; i < 31; i++) {
        if (Arrays.equals(nCounts, countDigits(1 << i))) {
            return true;
        }
    }
    return false;
}

private int[] countDigits(int n) {
    int[] counts = new int[10];
    while (n > 0) {
        counts[n % 10]++;
        n /= 10;
    }
    return counts;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log N)$, as there are only 31 powers to check, and each check takes $O(\text{number of digits})$ time.
    *   **Độ phức tạp thời gian:** $O(\log N)$, vì chỉ có 31 lũy thừa để kiểm tra.*
*   **Space Complexity:** $O(1)$ to store the tiny count arrays.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Ignoring the order and focusing on the underlying digit distribution is a common strategy for "reordering" or "anagram" problems.
*Bỏ qua thứ tự và tập trung vào phân phối chữ số là một chiến lược phổ biến cho các bài toán "sắp xếp lại" hoặc "hoán vị".*
