# Result for Largest Component Size by Common Factor
# *Kết quả cho bài toán Kích thước Thành phần Lớn nhất theo Thừa số Chung*

## Description
## *Mô tả*

You are given an integer array of unique positive integers `nums`. Consider the following graph:
*Bạn được cho một mảng số nguyên gồm các số nguyên dương duy nhất `nums`. Xem xét đồ thị sau:*

*   There are `nums.length` nodes, labeled `nums[0]` to `nums[nums.length - 1]`.
    *   *Có `nums.length` nút, được dán nhãn từ `nums[0]` đến `nums[nums.length - 1]`.*
*   There is an undirected edge between `nums[i]` and `nums[j]` if `nums[i]` and `nums[j]` share a common factor greater than `1`.
    *   *Có một cạnh vô hướng giữa `nums[i]` và `nums[j]` nếu `nums[i]` và `nums[j]` chia sẻ một thừa số chung lớn hơn `1`.*

Return *the size of the largest connected component in the graph*.
*Trả về *kích thước của thành phần liên thông lớn nhất trong đồ thị*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [4,6,15,35]
**Output:** 4
**Explanation:** 
4 and 6 share common factor 2.
6 and 15 share common factor 3.
15 and 35 share common factor 5.
All nodes are connected in a single component.

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [20,50,9,63]
**Output:** 2
**Explanation:** 
20 and 50 share common factor 10.
9 and 63 share common factor 9.
No other connections. The largest component has specific nodes [20,50].

## Example 3:
## *Ví dụ 3:*

**Input:** nums = [2,3,6,7,4,12,21,39]
**Output:** 8

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 2 * 10^4`
*   `1 <= nums[i] <= 10^5`
*   All the values of `nums` are **unique**.
