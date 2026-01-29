# 833. Find And Replace in String / Tìm và Thay thế trong Chuỗi

## Problem Description / Mô tả bài toán
You are given a string `s`, an array of integer `indices`, and two arrays of strings `sources` and `targets`.
Bạn được cấp một chuỗi `s`, một mảng số nguyên `indices` và hai mảng chuỗi `sources` và `targets`.

At each `indices[i]`, if the substring of `s` starting from `indices[i]` matches `sources[i]`, replace it with `targets[i]`.
Tại mỗi `indices[i]`, nếu chuỗi con của `s` bắt đầu từ `indices[i]` khớp với `sources[i]`, hãy thay thế nó bằng `targets[i]`.

All replacements are simultaneous (they don't affect each other's indices).
Tất cả các thay thế là đồng thời (chúng không ảnh hưởng đến chỉ số của nhau).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Index-based Reconstruction / Tái cấu trúc dựa trên Chỉ số
Since replacements are simultaneous, we should not modify the string in-place which would mess up indices.
Vì các thay thế là đồng thời, chúng ta không nên sửa đổi chuỗi trực tiếp (in-place) vì nó sẽ làm xáo trộn các chỉ số.

Algorithm:
1. Map each index in `indices` to its corresponding `source` and `target` only if the match condition is met.
2. Build the result string by iterating through `s`:
   - If current index has a replacement, append `target` and skip `source.length` characters.
   - Else, append the current character and move to next.

### Complexity / Độ phức tạp
- **Time**: O(S + Σ(source_length)).
- **Space**: O(S).

---

## Analysis / Phân tích

### Approach: Lookup-driven Assembly
Validate all replacement operations first and store valid ones in a lookup structure. Then, reconstruct the string by either using the original character or the target string based on the lookup results.
Xác thực tất cả các thao tác thay thế trước và lưu các thao tác hợp lệ vào một cấu trúc tra cứu. Sau đó, tái cấu trúc chuỗi bằng cách sử dụng ký tự gốc hoặc chuỗi mục tiêu dựa trên kết quả tra cứu.

---
