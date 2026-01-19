# 118. Pascal's Triangle / Tam Giác Pascal

## Problem Description / Mô tả bài toán
Given an integer `numRows`, return the first `numRows` of **Pascal's triangle**.
Cho một số nguyên `numRows`, trả về `numRows` hàng đầu tiên của **tam giác Pascal**.

In **Pascal's triangle**, each number is the sum of the two numbers directly above it.
Trong **tam giác Pascal**, mỗi số là tổng của hai số ngay phía trên nó.

### Example 1:
```text
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
```

### Example 2:
```text
Input: numRows = 1
Output: [[1]]
```

## Constraints / Ràng buộc
- `1 <= numRows <= 30`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Pascal's Triangle Properties / Thuộc tính Tam Giác Pascal

1.  **Shape**: Row `n` has `n` elements.
    **Hình dạng**: Hàng `n` có `n` phần tử.

2.  **Edge Elements**: First and last element of each row is `1`.
    **Phần tử Biên**: Phần tử đầu và cuối của mỗi hàng là `1`.

3.  **Interior Elements**: `triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j]`.
    **Phần tử Bên trong**: `triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j]`.

### Mathematical Connection / Liên kết Toán học

Pascal's triangle element at row `n`, position `k` equals the **binomial coefficient**:
Phần tử tam giác Pascal tại hàng `n`, vị trí `k` bằng **hệ số nhị thức**:

```
triangle[n][k] = C(n, k) = n! / (k! × (n-k)!)
```

**Applications / Ứng dụng**:
- Binomial expansion: `(a+b)^n`
- Combinatorics: choosing k items from n
- Probability theory

### Visual Representation / Biểu diễn Trực quan
```
Row 0:       [1]
Row 1:      [1,1]
Row 2:     [1,2,1]
Row 3:    [1,3,3,1]
Row 4:   [1,4,6,4,1]

Building row 4 from row 3:
[1] + [1,3,3,1] + [1] -> [1, 1+3, 3+3, 3+1, 1] = [1,4,6,4,1]
```

---

## Analysis / Phân tích

### Approach: Iterative Row Construction / Xây dựng Hàng Lặp

**Algorithm**:
```
result = []
for i = 0 to numRows - 1:
    row = [1] * (i + 1)  // Initialize with 1s
    for j = 1 to i - 1:  // Fill interior
        row[j] = result[i-1][j-1] + result[i-1][j]
    result.add(row)
return result
```

### Complexity / Độ phức tạp
- **Time**: O(numRows²) - sum of 1+2+...+numRows = numRows(numRows+1)/2.
- **Space**: O(1) extra (output not counted).

---

## Edge Cases / Các trường hợp biên
1.  **numRows = 1**: `[[1]]`.
2.  **numRows = 2**: `[[1], [1,1]]`.
