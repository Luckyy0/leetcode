# 241. Different Ways to Add Parentheses / Các Cách Khác Nhau để Thêm Dấu Ngoặc

## Problem Description / Mô tả bài toán
Given a string `expression` of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. You may return the answer in **any order**.
Cho một chuỗi `expression` gồm các số và toán tử, trả về tất cả các kết quả có thể có từ việc tính toán tất cả các cách khác nhau có thể để nhóm các số và toán tử. Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.

The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed 10^4.
Các trường hợp kiểm tra được tạo ra sao cho các giá trị đầu ra nằm gọn trong một số nguyên 32-bit và số lượng kết quả khác nhau không vượt quá 10^4.

### Example 1:
```text
Input: expression = "2-1-1"
Output: [0,2]
Explanation:
((2-1)-1) = 0 
(2-(1-1)) = 2
```

### Example 2:
```text
Input: expression = "2*3-4*5"
Output: [-34,-14,-10,-10,10]
Explanation:
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10
```

## Constraints / Ràng buộc
- `1 <= expression.length <= 20`
- `expression` consists of digits and the operator `'+'`, `'-'`, and `'*'`.
- All the integer values in the input expression are in the range `[0, 99]`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Divide and Conquer (Recursion) / Chia Để Trị (Đệ quy)
To evaluate the expression with different parentheses, we can iterate through the expression to find operators.
When we find an operator at index `i` (e.g., `+`, `-`, `*`), it splits the expression into a Left Part (`0` to `i-1`) and a Right Part (`i+1` to `end`).

`Result = (Results of Left) <Operator> (Results of Right)`

We can do this recursively for every operator found.
- If `Left` returns `{l1, l2}` and `Right` returns `{r1, r2}`, the combination produces `{l1 op r1, l1 op r2, l2 op r1, l2 op r2}`.

### Memoization / Ghi Nhớ
Since substrings like `"3-4*5"` might be evaluated multiple times in recursive branches, we can store the computed results for each substring in a map: `Map<String, List<Integer>>`.

---

## Analysis / Phân tích

### Approach: Recursive with Memoization

**Algorithm**:
1.  Initialize memoization map.
2.  Define `compute(input)`:
    - If `input` is in map, return it.
    - List `res` = [].
    - Iterate `i` from `0` to `length`:
        - If `char` at `i` is operator:
            - `leftResults = compute(input.substring(0, i))`
            - `rightResults = compute(input.substring(i + 1))`
            - Combine results into `res`.
    - If `res` is empty (no operator found), it means `input` is just a number. Parse it and add to `res`.
    - Store `res` in map and return.

### Complexity / Độ phức tạp
- **Time**: Exponential in worst case without memoization (Catalan number). With memoization, it's roughly O(N^3) or O(N^4) depending on number of subproblems and list sizes. Constraints N=20 is very small, so this is efficient.
- **Space**: O(N) recursion depth + storing intermediate lists.

---

## Edge Cases / Các trường hợp biên
1.  **Single number**: "2" -> Returns `[2]`.
2.  **Two numbers**: "2-1" -> Returns `[1]`.
3.  **Multiple operators**: Standard recursion.
