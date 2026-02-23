# Analysis for Max Chunks To Make Sorted
# *Phân tích cho bài toán Số Khối Tối đa để Sắp xếp*

## 1. Problem Essence & Permutation Property
## *1. Bản chất vấn đề & Thuộc tính Hoán vị*

### The Challenge
### *Thách thức*
Since the array is a permutation of `[0, n-1]`, if we sort `arr`, the element at index `i` must be `i`.
Thus, if we split at index `k` (chunk ending at `k`, next chunk starting at `k+1`), it implies that the chunk `arr[0...k]` must contain exactly the elements `0, 1, ..., k`.
*Vì mảng là hoán vị của `[0, n-1]`, nếu sắp xếp `arr`, phần tử tại chỉ số `i` phải là `i`. Do đó, nếu cắt tại `k`, khối `arr[0...k]` phải chứa chính xác các phần tử `0, 1, ..., k`.*

This brings a very strong necessary and sufficient condition:
`max(arr[0...k]) == k`.
*Điều này dẫn đến điều kiện cần và đủ rất mạnh: `max(arr[0...k]) == k`.*

---

## 2. Strategy: Running Max
## *2. Chiến lược: Max Chạy*

### Algorithm
### *Thuật toán*

1.  **Iterate:** Loop `i` from `0` to `n-1`.
2.  **Track Max:** `currMax = max(currMax, arr[i])`.
3.  **Check Condition:** If `currMax == i`, it means all elements from `0` to `i` are contained within indices `0` to `i` (because max is `i` and count is `i+1` and values are distinct).
    - Increment `count`.
    *   **Duyệt:** Lặp `i`. Theo dõi `currMax`. Nếu `currMax == i`, nghĩa là tất cả phần tử từ `0` đến `i` đều nằm trong khoảng này. Tăng biến đếm.*

### Code Logic Preview
### *Xem trước Logic Mã*

```java
public int maxChunksToSorted(int[] arr) {
    int chunks = 0;
    int max = 0;
    for (int i = 0; i < arr.length; i++) {
        max = Math.max(max, arr[i]);
        if (max == i) {
            chunks++;
        }
    }
    return chunks;
}
```

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**In:** `[1, 0, 2, 3, 4]`
1. i=0, v=1. Max=1. 1==0? No.
2. i=1, v=0. Max=1. 1==1? Yes. Chunk 1 (`[1, 0]`).
3. i=2, v=2. Max=2. 2==2? Yes. Chunk 2 (`[2]`).
4. i=3, v=3. Max=3. 3==3? Yes. Chunk 3 (`[3]`).
5. i=4, v=4. Max=4. 4==4? Yes. Chunk 4 (`[4]`).
**Result:** 4.

**In:** `[4, 3, 2, 1, 0]`
1. i=0..3: Max=4. Condition `4==i` never met.
2. i=4: Max=4. 4==4? Yes.
**Result:** 1.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Simpler version of Problem 768. The condition `max == i` is elegant and sufficient.
*Phiên bản đơn giản hơn của Bài 768. Điều kiện `max == i` là thanh lịch và đầy đủ.*
