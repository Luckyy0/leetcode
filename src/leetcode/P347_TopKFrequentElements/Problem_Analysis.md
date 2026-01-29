# 347. Top K Frequent Elements / K Phần Tử Xuất Hiện Thường Xuyên Nhất

## Problem Description / Mô tả bài toán
Given an integer array `nums` and an integer `k`, return the `k` most frequent elements. You may return the answer in **any order**.
Cho một mảng số nguyên `nums` và một số nguyên `k`, trả về `k` phần tử xuất hiện thường xuyên nhất.

### Example 1:
```text
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
```

### Example 2:
```text
Input: nums = [1], k = 1
Output: [1]
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 10^5`
- `k` is in the range `[1, the number of unique elements in the array]`.
- It is **guaranteed** that the answer is **unique**.

**Follow up**: Your algorithm's time complexity must be better than `O(n log n)`, where n is the array's size.

---

## Theoretical Foundation / Cơ sở lý thuyết

### HashMap + PriorityQueue / Heap
1.  Count frequencies using HashMap. O(N).
2.  Use a Min-Heap of size `k` to store top `k` elements.
    - Iterate map entries.
    - Add to heap.
    - If heap size > `k`, poll (remove smallest frequency).
3.  Heap contains top `k`.
Time: O(N log K).

### Bucket Sort / Sắp Xếp Thùng
1.  Count frequencies. O(N).
2.  Data Structure: Array of Lists `bucket[]` where index is frequency.
    - `bucket[freq]` contains list of numbers with that frequency.
    - Max frequency is N. Array size N+1.
3.  Iterate buckets from end (max freq) to beginning.
    - Collect elements until we have `k`.
Time: O(N).
Space: O(N).

I will implement the **Bucket Sort** approach as it is O(N).

---

## Analysis / Phân tích

### Approach: Bucket Sort

**Algorithm**:
1.  Map `count`.
2.  `List<Integer>[] buckets = new List[n + 1]`.
3.  Fill buckets.
4.  Result list. Loop `i` from `n` down to 1.
    - Add all from `buckets[i]` to result.
    - If result size >= k, break.

---
