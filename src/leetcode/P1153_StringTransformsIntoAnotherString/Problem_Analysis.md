# 1153. String Transforms Into Another String / Chuỗi Chuyển đổi Thành Chuỗi Khác

## Problem Description / Mô tả bài toán
Given two strings `str1` and `str2`, determine if `str1` can be transformed into `str2` by performing zero or more conversions.
In one conversion, you can convert all occurrences of one character in `str1` to any other lowercase English character.
(e.g., 'a' -> 'b', all 'a's become 'b').
You can reuse characters.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Graph Mapping / Components / Ánh xạ Đồ thị / Thành phần
This is a character mapping problem.
1. `str1[i]` must map to `str2[i]`. If `str1[i]` maps to multiple different chars in `str2`, impossible. Return `false`.
2. Construct map `char -> char`.
3. If valid map exists (functional mapping), can we perform it?
   - The graph of mapping might have cycles.
   - Example `a -> b, b -> a`. Need temp char: `a -> temp, b -> a, temp -> b`.
   - We need at least one unused character in `str2` (target character set) to use as temporary buffer to break cycles.
   - If `str2` uses all 26 characters, and mapping is not identity, we have no temp char. Impossible.
   - Exception: if `str1 == str2`, possible (0 moves).

Algorithm:
1. Validate single-valued mapping. Iterate `i`:
   - If `map[s1[i]]` exists and `!= s2[i]`, return false.
   - Else `map[s1[i]] = s2[i]`.
2. If `str1.equals(str2)`, return true.
3. Check `Set(str2.chars()).size() < 26`. If true, possible. If 26, impossible.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1) (size 26 map).

---

## Analysis / Phân tích

### Approach: Functional Mapping and Cycle Breaking
First, verify that a consistent functional mapping exists from `str1` to `str2` (i.e., one character in `str1` cannot map to two different characters in `str2`). If the mapping is consistent, the transformation is possible unless the mapping forms a cycle that involves all 26 characters (leaving no temporary placeholder to facilitate the swap). If `str2` utilizes strictly fewer than 26 unique characters, a placeholder is guaranteed to exist. If `str2` uses all 26 characters, transformation is only possible if no actual change is needed (`str1 == str2`).
Đầu tiên, xác minh rằng tồn tại một ánh xạ chức năng nhất quán từ `str1` đến `str2` (tức là, một ký tự trong `str1` không thể ánh xạ tới hai ký tự khác nhau trong `str2`). Nếu ánh xạ nhất quán, việc chuyển đổi là có thể trừ khi ánh xạ tạo thành một chu trình liên quan đến tất cả 26 ký tự (không để lại chỗ giữ tạm thời nào để thực hiện hoán đổi). Nếu `str2` sử dụng ít hơn hẳn 26 ký tự duy nhất, một chỗ giữ được đảm bảo tồn tại. Nếu `str2` sử dụng tất cả 26 ký tự, việc chuyển đổi chỉ có thể thực hiện được nếu không cần thay đổi thực tế (`str1 == str2`).

---
