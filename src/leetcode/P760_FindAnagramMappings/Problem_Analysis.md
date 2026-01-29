# 760. Find Anagram Mappings / Tìm Ánh xạ Đảo chữ

## Problem Description / Mô tả bài toán
You are given two integer arrays `nums1` and `nums2` where `nums2` is an anagram of `nums1`.
Bạn được cho hai mảng số nguyên `nums1` và `nums2` trong đó `nums2` là một đảo chữ của `nums1`.

Return an index mapping array `mapping` from `nums1` to `nums2` where `mapping[i] = j` means the `ith` element in `nums1` appears in `nums2` at index `j`. If there are multiple answers, return any of them.
Trả về một mảng ánh xạ chỉ số `mapping` từ `nums1` sang `nums2` trong đó `mapping[i] = j` có nghĩa là phần tử thứ `i` trong `nums1` xuất hiện trong `nums2` tại chỉ số `j`. Nếu có nhiều câu trả lời, hãy trả về bất kỳ câu trả lời nào.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### HashMap for O(1) Lookup / HashMap để tra cứu với O(1)
Since we need to find the index of a value in `nums2` for each value in `nums1`:
1. Iterate through `nums2` and store the mapping `Value -> List of Indices`.
2. Iterate through `nums1` and pick an available index from the list.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of the arrays.
- **Space**: O(N) for indices storage.

---

## Analysis / Phân tích

### Approach: Lookup Map
Store all positions of each number in `nums2`. For each number in `nums1`, retrieve and remove one of its positions.
Lưu trữ tất cả các vị trí của mỗi số trong `nums2`. Đối với mỗi số trong `nums1`, hãy truy xuất và xóa một trong các vị trí của nó.

---
