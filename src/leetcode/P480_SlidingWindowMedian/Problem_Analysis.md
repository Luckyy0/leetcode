# 480. Sliding Window Median / Trung Vị Cửa Sổ Trượt

## Problem Description / Mô tả bài toán
The **median** is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle values.
**Trung vị** là giá trị nằm ở giữa trong một danh sách các số nguyên đã được sắp xếp. Nếu kích thước của danh sách là chẵn, trung vị là trung bình cộng của hai giá trị ở giữa.

You are given an integer array `nums` and an integer `k`. There is a sliding window of size `k` which is moving from the very left of the array to the very right. 
Bạn được cho một mảng số nguyên `nums` và một số nguyên `k`. Có một cửa sổ trượt kích thước `k` đang di chuyển từ cực trái của mảng sang cực phải.

Return the median array for each window in the original array. Answers within `10^-5` of the actual value will be accepted.
Hãy trả về mảng chứa trung vị cho mỗi cửa sổ.

### Example 1:
```text
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
Explanation: 
Window position                Median
---------------                -----
[1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7      -1
 1  3 [-1  -3  5] 3  6  7      -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6
```

## Constraints / Ràng buộc
- `1 <= k <= nums.length <= 10^5`
- `-2^31 <= nums[i] <= 2^31 - 1`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Two Heaps (Priority Queues) / Hai hàng xếp ưu tiên
To find the median efficiently in a moving stream, we usually use a `maxHeap` (left half) and a `minHeap` (right half).
However, standard `PriorityQueue` in Java doesn't support $O(log N)$ removal of an arbitrary element. Removal is $O(N)$.
To achieve $O(log N)$ for removal, we can use:
1. Two `TreeMaps` (to store values and their frequencies).
2. Or a `TreeSet` of custom `Pair(value, index)` objects to handle duplicates.

Algorithm (TreeMap approach):
1. `maxHeap` (contains smaller elements) and `minHeap` (contains larger elements).
2. Maintain balance: `size(maxHeap) == size(minHeap)` or `size(maxHeap) == size(minHeap) + 1`.
3. For each window:
   - Add the new element.
   - Remove the element sliding out of the window.
   - Rebalance.
   - Calculate median using the top(s) of the heaps.

### Complexity / Độ phức tạp
- **Time**: O(N log K) using TreeMap or TreeSet.
- **Space**: O(K).

---

## Analysis / Phân tích

### Approach: Dual Multiset for Median Management

**Algorithm**:
1.  Initialize two sorted structures (Heaps with lazy removal or TreeSets).
2.  Slide window: add/remove/balance.
3.  Compute median based on parity of `k`.

---
