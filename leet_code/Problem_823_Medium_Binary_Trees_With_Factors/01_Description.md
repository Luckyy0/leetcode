# Result for Binary Trees With Factors
# *Kết quả cho bài toán Cây nhị phân với các Thừa số*

## Description
## *Mô tả*

Given an array of unique integers, `arr`, where each integer `arr[i]` is greater than 1.
*Cho một mảng các số nguyên duy nhất, `arr`, trong đó mỗi số nguyên `arr[i]` lớn hơn 1.*

We make a binary tree using these integers. Each node must have a value from `arr`, and for every node with children, its value must be equal to the product of the values of its children.
*Chúng ta tạo một cây nhị phân bằng các số nguyên này. Mỗi nút phải có một giá trị từ `arr`, và đối với mỗi nút có con, giá trị của nó phải bằng tích của các giá trị của các con của nó.*

Return *the number of binary trees we can make*. Since the answer may be too large, return it **modulo** `10^9 + 7`.
*Trả về *số lượng cây nhị phân chúng ta có thể tạo*. Vì câu trả lời có thể quá lớn, hãy trả về nó theo **modulo** `10^9 + 7`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** arr = [2,4]
**Output:** 3
**Explanation:** We can make these trees: `[2]`, `[4]`, `[4, 2, 2]`.

## Example 2:
## *Ví dụ 2:*

**Input:** arr = [2,4,5,10]
**Output:** 7
**Explanation:** We can make these trees: `[2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2]`.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= arr.length <= 1000`
*   `2 <= arr[i] <= 10^9`
*   All the values of `arr` are **unique**.
