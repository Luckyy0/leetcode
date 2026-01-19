# 75. Sort Colors / Sắp Xếp Màu

## Problem Description / Mô tả bài toán
Given an array `nums` with `n` objects colored red, white, or blue, sort them **in-place** so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
Cho một mảng `nums` với `n` đối tượng có màu đỏ, trắng hoặc xanh, hãy sắp xếp chúng **tại chỗ** sao cho các đối tượng cùng màu nằm cạnh nhau, với các màu theo thứ tự đỏ, trắng và xanh.

We will use the integers `0`, `1`, and `2` to represent the color red, white, and blue, respectively.
Chúng tôi sẽ sử dụng các số nguyên `0`, `1` và `2` để lần lượt biểu thị màu đỏ, trắng và xanh.

You must solve this problem without using the library's sort function.
Bạn phải giải quyết bài toán này mà không sử dụng hàm sắp xếp của thư viện.

### Example 1:
```text
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
```

### Example 2:
```text
Input: nums = [2,0,1]
Output: [0,1,2]
```

## Constraints / Ràng buộc
- `n == nums.length`
- `1 <= n <= 300`
- `nums[i]` is either `0`, `1`, or `2`.

---

## Analysis / Phân tích

### Approach: Dutch National Flag Algorithm / Thuật Toán Dutch National Flag
- **Idea**: Use 3 pointers to partition the array into 3 regions: `[0s]`, `[1s]`, `[Unprocessed]`, `[2s]`.
- **Ý tưởng**: Sử dụng 3 con trỏ để phân chia mảng thành 3 vùng: `[0s]`, `[1s]`, `[Chưa xử lý]`, `[2s]`.
- **Pointers**:
    - `low`: Boundary of 0s. (Exclusive or inclusive depending on implementation, usually points to first 1).
    - `mid`: Current element being considered.
    - `high`: Boundary of 2s.
- **Algorithm**:
    - Init `low = 0`, `mid = 0`, `high = n - 1`.
    - While `mid <= high`:
        - If `nums[mid] == 0`: Swap `nums[low]` and `nums[mid]`. `low++`, `mid++`.
        - If `nums[mid] == 1`: `mid++`.
        - If `nums[mid] == 2`: Swap `nums[mid]` and `nums[high]`. `high--`. (Do NOT increment `mid` because swapped element needs checking).
- **Time Complexity**: O(n). One pass.
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Already Sorted**: `[0, 1, 2]`.
2.  **Reverse Sorted**: `[2, 1, 0]`.
3.  **Single Element**: `[1]`.
