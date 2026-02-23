# Analysis for Three Equal Parts
# *Phân tích cho bài toán Ba phần Bằng nhau*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Divide binary array into three parts with equal binary value.
*Chia mảng nhị phân thành ba phần có giá trị nhị phân bằng nhau.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- The total number of `1`s must be divisible by 3. If not, impossible.
- If total `1`s is 0, any split works (e.g., `[0, 2]`).
- Let `totalOnes = cnt`. Each part must have `cnt / 3` ones.
- The pattern of `1`s must be identical in all three parts. The `0`s *between* the `1`s must match.
- The `0`s *after* the last `1` of each part constraint is tricky. The third part determines the number of trailing zeros.
- Let the number of trailing zeros in the third part be `z`.
- Then the first part must also end with `z` zeros, and the second part must also end with `z` zeros.
- Algorithm:
  1. Count total ones. If not divisible by 3, return `[-1, -1]`.
  2. If 0 ones, return `[0, 2]`.
  3. Find the indices of the 1s that start each block.
     - `k = totalOnes / 3`.
     - 1st block starts at the 1st '1'.
     - 2nd block starts at the `(k+1)`-th '1'.
     - 3rd block starts at the `(2k+1)`-th '1'.
  4. Compare the three blocks. They must match bit by bit until the end of the array.
     - Specifically, match `arr[start1...]` vs `arr[start2...]` vs `arr[start3...]`.
     - The length to match is `len(arr) - start3`. All three parts must have this length of matching bits.
  5. The remaining gaps between matched parts must be all zeros.
  6. Return the split points. `i` will be `start1 + len - 1` (plus potential zeros? No, the indices found by matching will naturally handle it).
  - Actually, `start3` is fixed. The length of the pattern is determined by `start3` to `end`.
  - Let `len = arr.length - start3`.
  - We verify `arr[start1 ... start1 + len - 1]` matches `arr[start3 ... end]`.
  - We verify `arr[start2 ... start2 + len - 1]` matches `arr[start3 ... end]`.
  - If they match, our split points are `start1 + len - 1` and `start2 + len`.
*Tổng số `1` phải chia hết cho 3. Mỗi phần có cùng số lượng `1`. Mẫu bit `1` và `0` xen kẽ phải giống nhau. Số lượng số `0` ở cuối phần 3 xác định số lượng số `0` cần thiết ở cuối phần 1 và 2. Tìm vị trí bắt đầu của `1` đầu tiên trong mỗi khối. So sánh từng bit.*

---

## 2. Strategy: Pattern Matching
## *2. Chiến lược: Khớp Mẫu*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Count Ones:** `cnt`. If `cnt % 3 != 0`, return `[-1, -1]`.
    *   **Đếm số 1:** Nếu không chia hết cho 3, trả về `[-1, -1]`.*

2.  **Special Case:** `cnt == 0`. Return `[0, 2]`.
    *   **Trường hợp 0:** Trả về `[0, 2]`.*

3.  **Find Start Indices:**
    - `k = cnt / 3`.
    - Find index of 1st one (`i1`), `(k+1)`-th one (`i2`), `(2k+1)`-th one (`i3`).
    *   **Tìm chỉ số bắt đầu:** Tìm vị trí bắt đầu của 3 khối.*

4.  **Match:**
    - Loop while `i3 < arr.length`.
    - Check `arr[i1] == arr[i2] == arr[i3]`. If not, fail.
    - Increment all indices.
    *   **Khớp:** So sánh từng bit cho đến khi hết mảng.*

5.  **Return:** `[i1 - 1, i2]`. Note: `i1` has advanced to the position *after* the first part in the loop. Wait.
    - Original `i1` was start of part 1. After loop, `i1` is at `start1 + len`.
    - The first part ends at `i1 - 1`. The second part starts at original `i2`, ends at `i2 - 1` (current `i2 - 1`).
    - The Problem asks for `[i, j]` where 1st part is `0..i` and 2nd is `i+1..j-1`.
    - So we return `[i1 - 1, i2]`.
    *   **Trả về:** `[i1 - 1, i2]`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int[] threeEqualParts(int[] arr) {
    int countOnes = 0;
    for (int x : arr) countOnes += x;
    
    if (countOnes % 3 != 0) return new int[]{-1, -1};
    if (countOnes == 0) return new int[]{0, 2}; // Or 0, arr.length - 1? No i+1 < j. 0,2 works for len >= 3.
    
    int k = countOnes / 3;
    int i1 = -1, i2 = -1, i3 = -1;
    int curOnes = 0;
    
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == 1) {
            curOnes++;
            if (curOnes == 1) i1 = i;
            else if (curOnes == k + 1) i2 = i;
            else if (curOnes == 2 * k + 1) i3 = i;
        }
    }
    
    // Determining the pattern length based on the third part
    // The third part starts at i3 and goes to the end.
    // The other parts must match this suffix.
    while (i3 < arr.length) {
        if (arr[i1] == arr[i2] && arr[i2] == arr[i3]) {
            i1++;
            i2++;
            i3++;
        } else {
            return new int[]{-1, -1};
        }
    }
    
    // i1 is now at the index AFTER the first part's essential 1s + trailing zeros
    // i2 is now at the index AFTER the second part
    return new int[]{i1 - 1, i2};
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Two passes.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Counting ones and matching patterns starting from specific 1-indices avoids converting to big integers and handles leading/trailing zeros correctly.
*Đếm số 1 và khớp mẫu bắt đầu từ các chỉ số cụ thể tránh việc chuyển đổi sang số nguyên lớn và xử lý đúng các số 0 ở đầu/cuối.*
