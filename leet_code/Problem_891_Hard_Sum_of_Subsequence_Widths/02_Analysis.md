# Analysis for Sum of Subsequence Widths
# *Phân tích cho bài toán Tổng Độ rộng của các Dãy con*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
We need to calculate $\sum (max(S) - min(S))$ for all subsequences $S$ of `nums`.
*Chúng ta cần tính tổng $\sum (max(S) - min(S))$ cho tất cả các dãy con $S$ của `nums`.*

### KEY INSIGHT
### *Nhận xét quan trọng*
The order of elements in a subsequence matters for finding subsequences, but the max and min of a set of numbers does **not** depend on their order.
Therefore, we can sort the array `nums` without changing the answer.
*Thứ tự của các phần tử trong một dãy con rất quan trọng việc tìm các dãy con, nhưng giá trị lớn nhất và nhỏ nhất của một tập hợp các số thì **không** phụ thuộc vào thứ tự của chúng. Do đó, chúng ta có thể sắp xếp mảng `nums` mà không làm thay đổi kết quả.*

After sorting `nums`:
- Consider `nums[i]`.
- How many subsequences use `nums[i]` as the maximum?
  Any subsequence consisting of `nums[i]` and a subset of `{nums[0], ..., nums[i-1]}` will have `nums[i]` as the maximum.
  There are $2^i$ such subsequences.
- How many subsequences use `nums[i]` as the minimum?
  Any subsequence consisting of `nums[i]` and a subset of `{nums[i+1], ..., nums[n-1]}` will have `nums[i]` as the minimum.
  There are $2^{n-1-i}$ such subsequences.

Contribution of `nums[i]` to the total sum:
$nums[i] \times (2^i - 2^{n-1-i})$

---

## 2. Strategy: Sorting + Math
## *2. Chiến lược: Sắp xếp + Toán học*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Sort `nums`:** Sort the input array in ascending order.
    *   **Sắp xếp `nums`:** Sắp xếp mảng đầu vào theo thứ tự tăng dần.*

2.  **Precompute Powers of 2:** Calculate powers of 2 modulo $10^9 + 7$.
    *   **Tính trước lũy thừa của 2:** Tính các lũy thừa của 2 modulo $10^9 + 7$.*

3.  **Calculate Total:** Iterate through `nums` sum up:
    $Total = \sum_{i=0}^{n-1} nums[i] \times (pow[i] - pow[n-1-i])$
    *   **Tính tổng:** Duyệt qua `nums` và cộng dồn vào tổng.*

4.  **Modulo Arithmetic:** Apply modulo operations at each step to prevent overflow. Handle negative results from subtraction by adding MOD.
    *   **Số học Modulo:** Áp dụng phép modulo ở mỗi bước để tránh tràn số. Xử lý kết quả âm từ phép trừ bằng cách cộng thêm MOD.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int sumSubseqWidths(int[] nums) {
    int MOD = 1_000_000_007;
    int n = nums.length;
    Arrays.sort(nums);
    
    long[] pow = new long[n];
    pow[0] = 1;
    for (int i = 1; i < n; i++) {
        pow[i] = (pow[i - 1] * 2) % MOD;
    }
    
    long ans = 0;
    for (int i = 0; i < n; i++) {
        long contribution = (pow[i] - pow[n - 1 - i]) * nums[i];
        ans = (ans + contribution) % MOD;
    }
    
    // Handle potential negative result from modulo subtraction (though mathematical logic ensures positive for standard definition, modulo arithmetic needs care)
    // Actually, (A - B) % MOD can be negative in Java.
    // The correct way is (pow[i] - pow[n-1-i] + MOD) % MOD
    
    return (int) ans;
}
```

Wait, `(pow[i] - pow[n-1-i])` could be negative. Java's `%` operator returns remainder, which can be negative.
Correct logic: `ans = (ans + (pow[i] - pow[n-1-i]) * nums[i]) % MOD;`.
Then finally `return (int) ((ans + MOD) % MOD);`.

Alternatively:
`long contribution = (pow[i] * nums[i]) % MOD - (pow[n-1-i] * nums[i]) % MOD;`
`ans = (ans + contribution + MOD) % MOD;`

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$ due to sorting. The linear pass is $O(N)$.
    *   **Độ phức tạp thời gian:** $O(N \log N)$ do sắp xếp.*
*   **Space Complexity:** $O(N)$ for the powers array. Can be optimized to $O(1)$ if powers are computed on the fly.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Sorting transforms the subsequence problem into a subset counting problem based on array positions, which is solvable in linear time after sorting.
*Việc sắp xếp chuyển đổi bài toán dãy con thành bài toán đếm tập hợp con dựa trên vị trí mảng, có thể giải quyết trong thời gian tuyến tính sau khi sắp xếp.*
