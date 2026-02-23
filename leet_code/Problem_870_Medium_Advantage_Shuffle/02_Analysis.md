# Analysis for Advantage Shuffle
# *Phân tích cho bài toán Tráo đổi Lợi thế*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
We need to reorder `nums1` such that it beats `nums2` at as many indices as possible. This is comparable to the famous "Tian Ji's Horse Racing" strategy.
*Chúng ta cần sắp xếp lại `nums1` sao cho nó đánh bại `nums2` tại càng nhiều chỉ số càng tốt. Điều này tương đương với chiến lược "Đua ngựa Điền Kỵ" nổi tiếng.*

---

## 2. Strategy: Greedy with Sorting
## *2. Chiến lược: Tham lam với Sắp xếp*

### The "Horse Racing" Logic
### *Logic "Đua ngựa"*
1. If our **strongest** card in `nums1` can't beat their **strongest** card in `nums2`, just use our **weakest** card from `nums1` to take the loss (sacrifice).
2. If our **strongest** card can beat theirs, use it to capture that "win".
*1. Nếu quân bài **mạnh nhất** của mình trong `nums1` không thể đánh bại quân bài **mạnh nhất** của họ trong `nums2`, hãy dùng quân bài **yếu nhất** của mình để chấp nhận thất bại (hy sinh). 2. Nếu quân bài mạnh nhất của mình có thể thắng, hãy dùng nó để giành lấy "chiến thắng" đó.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Sort `nums1`:** Sort the first array in ascending order.
    *   **Sắp xếp `nums1`:** Sắp xếp mảng đầu tiên theo thứ tự tăng dần.*

2.  **Pair and Sort `nums2`:** Since we need to return the result in the order of `nums2`, we need to store their original indices. Sort `nums2` based on values (usually descending makes logic easier).
    *   **Ghép cặp và sắp xếp `nums2`:** Vì chúng ta cần trả về kết quả theo thứ tự của `nums2`, chúng ta cần lưu trữ các chỉ số gốc của chúng. Sắp xếp `nums2` theo giá trị.*

3.  **Two Pointers on `nums1`:**
    - Use two pointers, `low` and `high`, to point to the smallest and largest elements of the sorted `nums1`.
    - Iterate through sorted `nums2` (from largest to smallest):
        - If `nums1[high] > nums2[i]`, assign `nums1[high]` to this index and `high--`.
        - Else, the sacrifice logic: assign `nums1[low]` to this index and `low++`.
    *   **Hai con trỏ trên `nums1`:** Sử dụng hai con trỏ `low` và `high` để trỏ đến các phần tử nhỏ nhất và lớn nhất của `nums1` đã sắp xếp. Duyệt qua `nums2` đã sắp xếp (từ lớn nhất đến nhỏ nhất): Nếu `nums1[high]` thắng được `nums2[i]`, hãy gán nó cho chỉ số này. Ngược lại, thực hiện phép hy sinh: gán `nums1[low]` cho chỉ số này.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int[] advantageCount(int[] nums1, int[] nums2) {
    int n = nums1.length;
    Arrays.sort(nums1);
    
    // Store nums2 with original indices
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
    for (int i = 0; i < n; i++) maxHeap.offer(new int[]{nums2[i], i});
    
    int[] res = new int[n];
    int left = 0, right = n - 1;
    
    while (!maxHeap.isEmpty()) {
        int[] curr = maxHeap.poll();
        int val = curr[0], idx = curr[1];
        if (nums1[right] > val) {
            res[idx] = nums1[right--];
        } else {
            res[idx] = nums1[left++];
        }
    }
    return res;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$ for sorting `nums1` and building the Max-Heap for `nums2`.
    *   **Độ phức tạp thời gian:** $O(N \log N)$ cho việc sắp xếp `nums1` và xây dựng Max-Heap cho `nums2`.*
*   **Space Complexity:** $O(N)$ to store the indices and the result array.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

This is a classic greedy problem. The key is recognizing that if you can't win against their strongest, you shouldn't waste your best resources; instead, sacrifice your worst.
*Đây là bài toán tham lam kinh điển. Chìa khóa là nhận ra rằng nếu bạn không thể thắng trước quân mạnh nhất của đối phương, bạn không nên lãng phí tài nguyên tốt nhất của mình; thay vào đó, hãy hy sinh quân bài tệ nhất.*
