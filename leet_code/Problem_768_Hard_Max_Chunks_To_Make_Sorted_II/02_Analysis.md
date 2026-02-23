# Analysis for Max Chunks To Make Sorted II
# *Phân tích cho bài toán Số Khối Tối đa để Sắp xếp II*

## 1. Problem Essence & Partitions
## *1. Bản chất vấn đề & Phân vùng*

### The Challenge
### *Thách thức*
We can split the array at index `k` if all elements to the left (prefix `0..k`) are smaller than or equal to all elements to the right (suffix `k+1..n-1`).
Formally, we can cut if `max(left_part) <= min(right_part)`.
*Ta có thể cắt mảng tại chỉ số `k` nếu tất cả phần tử bên trái nhỏ hơn hoặc bằng tất cả phần tử bên phải. Cụ thể: `max(phần trái) <= min(phần phải)`.*

Wait, actually, sorting chunks individually works if and only if the set of elements in the prefix `arr[0..k]` is exactly the same as the set of elements in the sorted array `sorted[0..k]`.
But simply checking `max(left) <= min(right)` is the sufficient condition.
*Thực ra, kiểm tra `max(trái) <= min(phải)` là điều kiện đủ.*

---

## 2. Strategy: Left Max vs Right Min
## *2. Chiến lược: Max Trái vs Min Phải*

### Algorithm
### *Thuật toán*

1.  **Right Min Array:**
    - Compute `minOfRight[i]`, which stores the minimum value in `arr[i...n-1]`.
    - Iterate from right to left. `minOfRight[i] = min(arr[i], minOfRight[i+1])`.
    *   **Mảng Min Phải:** Tính `minOfRight[i]` lưu giá trị nhỏ nhất của phần hậu tố.*

2.  **Iterate and Check:**
    - Maintain `maxOfLeft` while iterating from left `i = 0` to `n-1`.
    - At each point `i`, update `maxOfLeft`.
    - Check if `maxOfLeft <= minOfRight[i+1]`.
    - If true, it means everything to the left is $\le$ everything to the right. We can safely form a chunk ending at `i`. Increment count.
    - Note: This counts valid split points. The number of chunks = split points + 1. Wait.
    - Let's trace carefully: If we split after `i` (between `i` and `i+1`), we increment count.
    - Finally, return `count + 1`.
    *   **Duyệt và Kiểm tra:** Duy trì `maxOfLeft`. Nếu `maxOfLeft <= minOfRight[i+1]`, ta có một điểm cắt hợp lệ. Số khối = số điểm cắt + 1.*

### Code Logic Preview
### *Xem trước Logic Mã*

```java
public int maxChunksToSorted(int[] arr) {
    int n = arr.length;
    int[] minRight = new int[n];
    minRight[n - 1] = arr[n - 1];
    
    for (int i = n - 2; i >= 0; i--) {
        minRight[i] = Math.min(arr[i], minRight[i + 1]);
    }
    
    int chunks = 0;
    int maxLeft = Integer.MIN_VALUE;
    
    // Iterate up to n-2 since we check cut after i
    // Duyệt đến n-2 vì kiểm tra điểm cắt sau i
    for (int i = 0; i < n - 1; i++) {
        maxLeft = Math.max(maxLeft, arr[i]);
        if (maxLeft <= minRight[i + 1]) {
            chunks++;
        }
    }
    
    return chunks + 1;
}
```

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Two passes (one for right min, one for left max).
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(N)$ for the right-min array.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Input:** `[2, 1, 3, 4, 4]`
1. MinRight:
   - i=4: 4
   - i=3: min(4, 4) = 4
   - i=2: min(3, 4) = 3
   - i=1: min(1, 3) = 1
   - i=0: min(2, 1) = 1
   - Arr: `[1, 1, 3, 4, 4]` (Values of minRight)
2. Iterate `i`:
   - i=0 (val 2). MaxLeft=2. RightMin[1]=1. 2 <= 1? No.
   - i=1 (val 1). MaxLeft=2. RightMin[2]=3. 2 <= 3? Yes. Cut! (Count=1)
   - i=2 (val 3). MaxLeft=3. RightMin[3]=4. 3 <= 4? Yes. Cut! (Count=2)
   - i=3 (val 4). MaxLeft=4. RightMin[4]=4. 4 <= 4? Yes. Cut! (Count=3)
3. Return `Count + 1` = 4.
**Result:** 4.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Simple two-pass logic is robust for hard constraints ($N=2000$ or even $10^5$).
*Logic hai lượt đơn giản rất mạnh mẽ cho các ràng buộc khó ($N=2000$ hoặc thậm chí $10^5$).*
