# 88. Merge Sorted Array / Hợp Nhất Mảng Đã Sắp Xếp

## Problem Description / Mô tả bài toán
You are given two integer arrays `nums1` and `nums2`, sorted in **non-decreasing order**, and two integers `m` and `n`, representing the number of elements in `nums1` and `nums2` respectively.
Bạn được cho hai mảng số nguyên `nums1` và `nums2`, được sắp xếp theo **thứ tự không giảm**, và hai số nguyên `m` và `n`, lần lượt biểu thị số lượng phần tử trong `nums1` và `nums2`.

Merge `nums1` and `nums2` into a single array sorted in **non-decreasing order**.
Hợp nhất `nums1` và `nums2` thành một mảng duy nhất được sắp xếp theo **thứ tự không giảm**.

The final sorted array should not be returned by the function, but instead be stored inside the array `nums1`. To accommodate this, `nums1` has a length of `m + n`, where the first `m` elements denote the elements that should be merged, and the last `n` elements are set to `0` and should be ignored. `nums2` has a length of `n`.
Mảng đã sắp xếp cuối cùng không nên được trả về bởi hàm, mà thay vào đó được lưu trữ bên trong mảng `nums1`. Để phù hợp với điều này, `nums1` có độ dài là `m + n`, trong đó `m` phần tử đầu tiên biểu thị các phần tử cần được hợp nhất, và `n` phần tử cuối cùng được đặt thành `0` và nên bị bỏ qua. `nums2` có độ dài là `n`.

### Example 1:
```text
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
```

### Example 2:
```text
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
```

## Constraints / Ràng buộc
- `nums1.length == m + n`
- `nums2.length == n`
- `0 <= m, n <= 200`
- `1 <= m + n <= 200`
- `-10^9 <= nums1[i], nums2[j] <= 10^9`

---

## Analysis / Phân tích

### Approach: Three Pointers (Backwards) / Ba Con Trỏ (Ngược)
- **Idea**: Since `nums1` has space at the end, fill it from the back to avoid overwriting elements in `nums1` that haven't been compared yet.
- **Ý tưởng**: Vì `nums1` có khoảng trống ở cuối, hãy điền nó từ phía sau để tránh ghi đè lên các phần tử trong `nums1` chưa được so sánh.
- **Algorithm**:
    - `p1 = m - 1` (last of actual nums1)
    - `p2 = n - 1` (last of nums2)
    - `p = m + n - 1` (last of merged nums1)
    - While `p2 >= 0`:
        - If `p1 >= 0` and `nums1[p1] > nums2[p2]`:
            - `nums1[p] = nums1[p1]`, `p1--`
        - Else:
            - `nums1[p] = nums2[p2]`, `p2--`
        - `p--`
- **Time Complexity**: O(m + n).
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **n = 0**: Nothing to merge, done.
2.  **m = 0**: Fill nums1 with nums2.
