# Analysis for Sort an Array
# *Phân tích cho bài toán Sắp xếp Mảng*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Implement an $O(N \log N)$ sorting algorithm without using built-in functions.
*Triển khai một thuật toán sắp xếp với độ phức tạp $O(N \log N)$ mà không sử dụng các hàm có sẵn.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- The constraints allow for $O(N \log N)$ algorithms like **Merge Sort**, **Heap Sort**, or **Quick Sort** (though Quick Sort is worst-case $O(N^2)$, randomized pivot helps).
- Since we want minimal space complexity, Heap Sort ($O(1)$ auxiliary space) is a candidate. However, iterative Merge Sort is stable and efficient ($O(N)$ space).
- Given the strict constraints and potential for recursive depth issues (though 50k is fine), Merge Sort is often preferred for stability and guaranteed performance.
- Wait, **Radix Sort** or **Counting Sort** could work with the given range `[-5*10^4, 5*10^4]`. The range size is $10^5$, which is comparable to $N$. Counting Sort would be $O(N + K)$ time and $O(K)$ space. This might be faster in practice than $O(N \log N)$.
- The problem asks for "smallest space complexity possible".
  - Heap Sort: $O(1)$ extra space.
  - Merge Sort: $O(N)$ extra space.
  - Quick Sort: $O(\log N)$ stack space.
  - Counting Sort: $O(K)$ extra space.
- The safest bet for a generic "Sort an Array" problem on LeetCode that often targets $O(N \log N)$ is usually **Merge Sort** or a robust **Quick Sort**. Heap Sort is good for space but often slower due to cache locality.
- Let's implement **Merge Sort** as it is a classic divide-and-conquer algorithm that guarantees $O(N \log N)$. Or Heap Sort for stricter space. I'll provide Merge Sort for robustness, or better yet, randomized Quick Sort.
- Actually, for LeetCode, simple QuickSort often TLEs on sorted input. I will use **Merge Sort**.

*Các ràng buộc cho phép các thuật toán $O(N \log N)$ như **Merge Sort**, **Heap Sort**, hoặc **Quick Sort**. Counting Sort cũng khả thi vì phạm vi giá trị nhỏ. Tuy nhiên, để tuân thủ yêu cầu chung $O(N \log N)$ và độ ổn định, tôi sẽ chọn **Merge Sort**.*

---

## 2. Strategy: Merge Sort
## *2. Chiến lược: Sắp xếp Trộn (Merge Sort)*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Divide:** Split array into two halves.
    *   **Chia:** Chia mảng thành hai nửa.*

2.  **Conquer:** Recursively sort each half.
    *   **Trị:** Đệ quy sắp xếp từng nửa.*

3.  **Combine:** Merge the two sorted halves into one sorted array.
    *   **Kết hợp:** Trộn hai nửa đã sắp xếp thành một mảng.*

4.  **Base Case:** If array size is 1 or 0, it is already sorted.
    *   **Trường hợp cơ sở:** Nếu kích thước mảng là 1 hoặc 0, nó đã được sắp xếp.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int[] sortArray(int[] nums) {
    if (nums == null || nums.length <= 1) {
        return nums;
    }
    int[] temp = new int[nums.length];
    mergeSort(nums, 0, nums.length - 1, temp);
    return nums;
}

private void mergeSort(int[] nums, int left, int right, int[] temp) {
    if (left >= right) {
        return;
    }
    int mid = left + (right - left) / 2;
    mergeSort(nums, left, mid, temp);
    mergeSort(nums, mid + 1, right, temp);
    merge(nums, left, mid, right, temp);
}

private void merge(int[] nums, int left, int mid, int right, int[] temp) {
    for (int i = left; i <= right; i++) {
        temp[i] = nums[i];
    }
    
    int i = left;
    int j = mid + 1;
    int k = left;
    
    while (i <= mid && j <= right) {
        if (temp[i] <= temp[j]) {
            nums[k++] = temp[i++];
        } else {
            nums[k++] = temp[j++];
        }
    }
    
    while (i <= mid) {
        nums[k++] = temp[i++];
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$ in all cases.
    *   **Độ phức tạp thời gian:** $O(N \log N)$.*
*   **Space Complexity:** $O(N)$ for the temporary array and recursion stack.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Merge Sort is consistent and stable. While Heap Sort saves space ($O(1)$), Merge Sort's sequential access pattern is usually faster on modern hardware.
*Merge Sort nhất quán và ổn định. Mặc dù Heap Sort tiết kiệm không gian ($O(1)$), kiểu truy cập tuần tự của Merge Sort thường nhanh hơn trên phần cứng hiện đại.*
