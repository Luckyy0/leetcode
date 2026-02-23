# Result for Array of Doubled Pairs
# *Kết quả cho bài toán Mảng các Cặp Đôi Gấp Đôi*

## Description
## *Mô tả*

Given an integer array of even length `arr`, return `true` *if it is possible to reorder* `arr` *such that* `arr[2 * i + 1] = 2 * arr[2 * i]` *for every* `0 <= i < len(arr) / 2`, *or* `false` *otherwise*.
*Cho một mảng số nguyên có độ dài chẵn `arr`, hãy trả về `true` *nếu có thể sắp xếp lại* `arr` *sao cho* `arr[2 * i + 1] = 2 * arr[2 * i]` *với mọi* `0 <= i < len(arr) / 2`, *hoặc* `false` *nếu không*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** arr = [3,1,3,6]
**Output:** false

## Example 2:
## *Ví dụ 2:*

**Input:** arr = [2,1,2,6]
**Output:** false

## Example 3:
## *Ví dụ 3:*

**Input:** arr = [4,-2,2,-4]
**Output:** true
**Explanation:** We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].

---

## Constraints:
## *Ràng buộc:*

*   `0 <= arr.length <= 3 * 10^4`
*   `arr.length` is even.
*   `-10^5 <= arr[i] <= 10^5`
