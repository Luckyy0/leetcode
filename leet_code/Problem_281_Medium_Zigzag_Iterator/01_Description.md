# Result for Zigzag Iterator
# *Kết quả cho bài toán Iterator Zigzag*

## Description
## *Mô tả*

Given two 1d vectors, implement an iterator to return their elements alternately.
*Cho hai vectơ 1 chiều, hãy triển khai một iterator để trả về các phần tử của chúng xen kẽ nhau.*

## Example:
## *Ví dụ:*

**Input:**
`v1 = [1,2]`
`v2 = [3,4,5,6]`
**Output:** `[1,3,2,4,5,6]`
**Explanation:** By calling `next` repeatedly until `hasNext` returns `false`, the order of elements returned by `next` should be: `[1,3,2,4,5,6]`.

## Constraints:
## *Ràng buộc:*

*   `0 <= v1.length, v2.length <= 1000`
*   `1 <= v1.length + v2.length <= 2000`
*   `-2^31 <= v1[i], v2[i] <= 2^31 - 1`

**Follow up:** What if you are given `k` 1d vectors? How well can your code be extended to such cases?
**Câu hỏi mở rộng:** Điều gì sẽ xảy ra nếu bạn được cung cấp `k` vectơ 1 chiều? Mã của bạn có thể mở rộng tốt như thế nào cho các trường hợp như vậy?
