# Result for Find Anagram Mappings
# *Kết quả cho bài toán Tìm Ánh xạ Anagram*

## Description
## *Mô tả*

You are given two integer arrays `nums1` and `nums2` where `nums2` is an anagram of `nums1`. Both arrays may contain duplicates.
*Bạn được cho hai mảng số nguyên `nums1` và `nums2` trong đó `nums2` là một hoán vị (anagram) của `nums1`. Cả hai mảng có thể chứa các phần tử trùng lặp.*

Return *an index mapping array `mapping` from `nums1` to `nums2` where `mapping[i] = j` means the `i-th` element in `nums1` appears in `nums2` at index `j`*. If there are multiple answers, return **any of them**.
*Trả về *một mảng ánh xạ chỉ số `mapping` từ `nums1` sang `nums2` trong đó `mapping[i] = j` nghĩa là phần tử thứ `i` trong `nums1` xuất hiện trong `nums2` tại chỉ số `j`*. Nếu có nhiều câu trả lời, hãy trả về **bất kỳ cái nào trong số đó**.*

An array `a` is an anagram of an array `b` means `a` is made by randomizing the order of the elements in `b`.
*Một mảng `a` là anagram của mảng `b` nghĩa là `a` được tạo ra bằng cách ngẫu nhiên hóa thứ tự các phần tử trong `b`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums1 = [12,28,46,32,50], nums2 = [50,12,32,46,28]
**Output:** [1,4,3,2,0]
**Explanation:** As mapping[0] = 1 because the 0th element of nums1 appears at nums2[1], and mapping[1] = 4 because the 1st element of nums1 appears at nums2[4], and so on.

## Example 2:
## *Ví dụ 2:*

**Input:** nums1 = [84,46], nums2 = [84,46]
**Output:** [0,1]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums1.length <= 100`
*   `nums2.length == nums1.length`
*   `0 <= nums1[i] <= 10^5`
*   `nums2` is an anagram of `nums1`.
