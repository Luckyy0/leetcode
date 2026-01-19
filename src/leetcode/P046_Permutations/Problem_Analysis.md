# 46. Permutations / Hoán Vị

## Problem Description / Mô tả bài toán
Given an array `nums` of distinct integers, return all the possible permutations. You can return the answer in **any order**.
Cho một mảng `nums` gồm các số nguyên khác nhau, trả về tất cả các hoán vị có thể. Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.

### Example 1:
```text
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
```

### Example 2:
```text
Input: nums = [0,1]
Output: [[0,1],[1,0]]
```

### Example 3:
```text
Input: nums = [1]
Output: [[1]]
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 6`
- `-10 <= nums[i] <= 10`
- All the integers of `nums` are **unique**.

---

## Analysis / Phân tích

### Approach: Backtracking (Swapping) / Quay Lui (Hoán Đổi)
- **Idea**: To generate permutations, we can swap each element to the current position `start` and then recursively generate permutations for the rest of the array starting from `start + 1`.
- **Ý tưởng**: Để tạo các hoán vị, ta có thể hoán đổi từng phần tử đến vị trí hiện tại `start` và sau đó đệ quy tạo các hoán vị cho phần còn lại của mảng bắt đầu từ `start + 1`.
- **Algorithm**:
    - Function `backtrack(start)`:
        - If `start == n`, add copy of `nums` to result.
        - Loop `i` from `start` to `n-1`:
            - Swap `nums[start]` and `nums[i]`.
            - `backtrack(start + 1)`.
            - Swap back (backtrack).
- **Time Complexity**: O(n * n!). There are n! permutations, each takes O(n) to copy.
- **Space Complexity**: O(n) recursion stack.

---

## Edge Cases / Các trường hợp biên
1.  **Single Element**: `[1]` -> `[[1]]`.
