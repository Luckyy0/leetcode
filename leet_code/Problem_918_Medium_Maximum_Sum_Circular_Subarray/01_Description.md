# Result for Maximum Sum Circular Subarray
# *Kết quả cho bài toán Tổng Mảng con Vòng tròn Lớn nhất*

## Description
## *Mô tả*

Given a **circular integer array** `nums` of length `n`, return *the maximum possible sum of a non-empty subarray of `nums`*.
*Cho một **mảng số nguyên vòng tròn** `nums` có độ dài `n`, hãy trả về *tổng lớn nhất có thể của một mảng con không rỗng của `nums`*.*

A **circular array** means the end of the array connects to the beginning of the array. Formally, the next element of `nums[i]` is `nums[(i + 1) % n]` and the previous element of `nums[i]` is `nums[(i - 1 + n) % n]`.
*Một **mảng vòng tròn** có nghĩa là phần cuối của mảng kết nối với phần đầu của mảng. Về mặt hình thức, phần tử tiếp theo của `nums[i]` là `nums[(i + 1) % n]` và phần tử trước đó của `nums[i]` là `nums[(i - 1 + n) % n]`.*

A **subarray** may only include each element of the fixed buffer `nums` at most once. Formally, for a subarray `nums[i], nums[i + 1], ..., nums[j]`, there does not exist `i <= k1`, `k2 <= j` with `k1 % n == k2 % n`.
*Một **mảng con** chỉ có thể bao gồm mỗi phần tử của bộ đệm cố định `nums` tối đa một lần. Về mặt hình thức, đối với một mảng con `nums[i], nums[i + 1], ..., nums[j]`, không tồn tại `i <= k1`, `k2 <= j` với `k1 % n == k2 % n`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [1,-2,3,-2]
**Output:** 3
**Explanation:** Subarray [3] has maximum sum 3.

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [5,-3,5]
**Output:** 10
**Explanation:** Subarray [5,5] has maximum sum 5 + 5 = 10.

## Example 3:
## *Ví dụ 3:*

**Input:** nums = [-3,-2,-3]
**Output:** -2
**Explanation:** Subarray [-2] has maximum sum -2.

---

## Constraints:
## *Ràng buộc:*

*   `n == nums.length`
*   `1 <= n <= 3 * 10^4`
*   `-3 * 10^4 <= nums[i] <= 3 * 10^4`
