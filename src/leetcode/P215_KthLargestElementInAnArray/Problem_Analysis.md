# 215. Kth Largest Element in an Array / Phần Tử Lớn Thứ K trong Mảng

## Problem Description / Mô tả bài toán
Given an integer array `nums` and an integer `k`, return the `k`th largest element in the array.
Cho một mảng số nguyên `nums` và một số nguyên `k`, hãy trả về phần tử lớn thứ `k` trong mảng.

Note that it is the `k`th largest element in the sorted order, not the `k`th distinct element.
Lưu ý rằng đây là phần tử lớn thứ `k` theo thứ tự đã sắp xếp, không phải là phần tử khác biệt thứ `k`.

Can you solve it without sorting?
Bạn có thể giải quyết nó mà không cần sắp xếp không?

### Example 1:
```text
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
```

### Example 2:
```text
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
```

## Constraints / Ràng buộc
- `1 <= k <= nums.length <= 10^5`
- `-10^4 <= nums[i] <= 10^4`

---

## Theoretical Foundation / Cơ sở lý thuyết

### QuickSelect Algorithm / Thuật toán QuickSelect
QuickSelect is a selection algorithm to find the `k`-th smallest/largest element in an unordered list. It is related to QuickSort.
QuickSelect là một thuật toán chọn lọc để tìm phần tử nhỏ nhất/lớn nhất thứ `k` trong một danh sách chưa được sắp xếp. Nó liên quan đến QuickSort.

**Mechanism**:
1.  Result is at index `target = nums.length - k` if the array were sorted ascending.
2.  Choose a `pivot`.
3.  **Partition**: Reorder the array so that all elements smaller than pivot come before it, and all elements larger come after it. The pivot is now in its final sorted position `pIndex`.
4.  If `pIndex == target`, return `nums[pIndex]`.
5.  If `pIndex < target`, recurse on the right side.
6.  If `pIndex > target`, recurse on the left side.

**Complexity**:
- **Time**: Average O(N), Worst Case O(N^2) (rare with random pivot).
- **Space**: O(1) (iterative) or O(log N) (recursive stack).

### Heap Approach / Cách tiếp cận Heap
- Use a **Min-Heap** of size `k`.
- Iterate through `nums`.
- Add element to heap.
- If heap size > `k`, poll (remove smallest).
- The root of the heap is the `k`th largest element.
- Time: O(N log K). Space: O(K).

---

## Analysis / Phân tích

### Approach: QuickSelect (Iterative)

**Algorithm**:
1.  `low = 0`, `high = n - 1`, `target = n - k`.
2.  While `low <= high`:
    - `pivotIndex = partition(nums, low, high)`.
    - If `pivotIndex == target`, return `nums[pivotIndex]`.
    - If `pivotIndex < target`, `low = pivotIndex + 1`.
    - Else `high = pivotIndex - 1`.

**Partition Logic**:
- Swap `pivot` to end.
- `storeIndex = low`.
- For `i` from `low` to `high - 1`:
    - If `nums[i] < pivot`, swap `nums[i]` with `nums[storeIndex]`, `storeIndex++`.
- Swap `nums[storeIndex]` with `nums[high]` (pivot).
- Return `storeIndex`.

---

## Edge Cases / Các trường hợp biên
1.  **k = 1**: Largest element.
2.  **k = n**: Smallest element.
3.  **All duplicates**: Partition needs to handle efficiently.
