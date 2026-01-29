# 791. Custom Sort String / Sắp xếp Chuỗi Tùy chỉnh

## Problem Description / Mô tả bài toán
You are given two strings `order` and `s`. All the characters of `order` are unique and were sorted in some custom order previously.
Bạn được cho hai chuỗi `order` và `s`. Tất cả các ký tự của `order` là duy nhất và đã được sắp xếp theo một thứ tự tùy chỉnh nào đó trước đó.

Permute the characters of `s` so that they match the order that `order` was sorted. More specifically, if a character `x` occurs before a character `y` in `order`, then `x` should occur before `y` in the permuted string.
Hãy hoán vị các ký tự của `s` sao cho chúng khớp với thứ tự mà `order` đã được sắp xếp. Cụ thể hơn, nếu một ký tự `x` xuất hiện trước một ký tự `y` trong `order`, thì `x` phải xuất hiện trước `y` trong chuỗi đã hoán vị.

Return any permutation of `s` that satisfies this property.
Trả về bất kỳ hoán vị nào của `s` thỏa mãn thuộc tính này.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Frequency Bucket Sort / Sắp xếp Thùng Tần suất
We can use the frequency of characters in `s`.
Chúng ta có thể sử dụng tần suất của các ký tự trong `s`.

Algorithm:
1. Count the frequency of each char in `s` (using an array `count[26]`).
2. Iterate through each char `c` in `order`.
3. For each `c`, append it `count[c]` times to the result and set `count[c] = 0`.
4. Append any remaining characters from `s` (where `count[i] > 0`) to the end of the result.

### Complexity / Độ phức tạp
- **Time**: O(OrderLength + SLength).
- **Space**: O(1) beyond result (only size 26 array).

---

## Analysis / Phân tích

### Approach: Frequency-based construction
Rather than using a library sort, we build the string manually based on the priority given in `order`. This ensures O(N) performance.
Thay vì sử dụng các hàm sắp xếp có sẵn, chúng ta xây dựng chuỗi thủ công dựa trên thứ tự ưu tiên được đưa ra trong `order`. Điều này đảm bảo hiệu suất O(N).

---
