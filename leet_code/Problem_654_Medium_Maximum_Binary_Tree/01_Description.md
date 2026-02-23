# Result for Maximum Binary Tree
# *Kết quả cho bài toán Cây Nhị phân Lớn nhất*

## Description
## *Mô tả*

You are given an integer array `nums` with no duplicates. A **maximum binary tree** can be built recursively from `nums` using the following algorithm:
*Bạn được cho một mảng số nguyên `nums` không có các phần tử trùng lặp. Một **cây nhị phân lớn nhất** có thể được xây dựng đệ quy từ `nums` bằng thuật toán sau:*

1.  Create a root node whose value is the maximum value in `nums`.
    *   *Tạo một nút gốc có giá trị là giá trị lớn nhất trong `nums`.*
2.  Recursively build the left subtree on the **subarray prefix** to the left of the maximum value.
    *   *Xây dựng đệ quy cây con bên trái trên **mảng con tiền tố** ở bên trái của giá trị lớn nhất.*
3.  Recursively build the right subtree on the **subarray suffix** to the right of the maximum value.
    *   *Xây dựng đệ quy cây con bên phải trên **mảng con hậu tố** ở bên phải của giá trị lớn nhất.*

Return the **maximum binary tree** built from `nums`.
*Hãy trả về **cây nhị phân lớn nhất** được xây dựng từ `nums`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [3,2,1,6,0,5]
**Output:** [6,3,5,null,2,0,null,null,1]
**Explanation:** The recursive calls are as follow:
- The largest value in [3,2,1,6,0,5] is 6. Left subtree is [3,2,1] and right subtree is [0,5].
    - The largest value in [3,2,1] is 3. Left subtree is [] and right subtree is [2,1].
        - The largest value in [2,1] is 2. Left subtree is [] and right subtree is [1].
            - The largest value in [1] is 1. Left subtree is [] and right subtree is [].
    - The largest value in [0,5] is 5. Left subtree is [0] and right subtree is [].
        - The largest value in [0] is 0. Left subtree is [] and right subtree is [].

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 1000`
*   `0 <= nums[i] <= 1000`
*   All integers in `nums` are **unique**.
