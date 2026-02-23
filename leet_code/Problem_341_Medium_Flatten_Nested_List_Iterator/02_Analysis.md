# Analysis for Flatten Nested List Iterator
# *Phân tích cho bài toán Bộ lặp Làm phẳng Danh sách Lồng nhau*

## 1. Problem Essence & Stack/Queue
## *1. Bản chất vấn đề & Ngăn xếp/Hàng đợi*

### The Challenge
### *Thách thức*
We need to traverse a recursive list structure lazily (iterator pattern).
Unlike simple recursion where we just `dfs` and collect all, the Iterator requires maintaining state.

### Strategy: Stack of Iterators
### *Chiến lược: Ngăn xếp các Bộ lặp*
Or simpler: Stack of NestedIntegers?
Usually `Stack<Iterator<NestedInteger>>` is cleaner, pointing to current position in current nesting level.
But keeping simple lists in stack works directly too.
Wait, `hasNext()` needs to ensure the top of the stack is an Integer. If top is a List, we must "unpack" it (flatten one level) and push contents back.
Key Logic: `hasNext()` does the heavy lifting (unpacking until integer found). `next()` just returns.
To preserve order, iterating list `[A, B]`. Push B, then A?
If using Stack of Lists: Push `nestedList`.
`hasNext`: Peek top.
- If Integer: true.
- If List: Pop. Iterate list from back to front, push to stack. Loop `hasNext` again.
- If stack empty: false.

### Alternative: Queue / Full Flatten
### *Thay thế: Hàng đợi / Làm phẳng hoàn toàn*
If we just recursively flatten everything in Constructor into a `List<Integer>`, then iterator reduces to a simple index pointer.
Valid? Problem says `initialize iterator`. Complexity constraints? Usually memory $O(N)$ is acceptable.
However, strictly "iterator" usually implies lazy evaluation.
Stack approach is usually preferred for Interview.

---

## 2. Approach: Stack (Lazy)
## *2. Hướng tiếp cận: Ngăn xếp (Lười)*

### Logic
### *Logic*
1.  Stack stores `NestedInteger`.
2.  Constructor: loop input backwards, push to stack.
3.  `next()`: `hasNext()` check. Pop and return.
4.  `hasNext()`:
    - While stack not empty:
        - Peek top.
        - If Integer -> Return true.
        - If List -> Pop. Get list. Loop backwards. Push to stack.
        - (Continue while loops to unpack empty lists like `[[]]`).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Lazy Evaluation:** Only flattens what is needed.
    *Đánh giá lười: Chỉ làm phẳng những gì cần thiết.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** Constructor $O(N)$ (shallow). `next()` $O(1)$. `hasNext()` $O(L)$ amortized where L is nesting depth. Total for full traversal $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(N)$ worst case (all elements flat in stack) or $O(D)$ depth if structure allows.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[[1,1], 2, [1,1]]`
Stack init: `[1,1] (List)`, `2`, `[1,1] (List)` (pushed backwards). Top is `[1,1]`.
`hasNext()`:
- Top is List `[1,1]`. Pop.
- Loop `[1,1]` back. Push `1`, `1`.
- Stack: `1`, `1`, `2`, `[1,1]`.
- Top is `1` (Int). Return true.
`next()`: Pop `1`. Stack: `1`, `2`, `[1,1]`.
`next()`: Pop `1`. Stack: `2`, `[1,1]`.
`next()`: Pop `2`. Stack: `[1,1]`.
`hasNext()`:
- Top List `[1,1]`. Unpack -> `1`, `1`.
- Return true.
Pop `1`.
Pop `1`.
Done.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Stack-based Lazy Unpacking.
*Giải nén Lười dựa trên Ngăn xếp.*
---
*Một bộ lặp tốt (iterator) không cần nhìn thấy toàn bộ tương lai, chỉ cần biết cách bóc tách lớp vỏ hiện tại (unpack) để lộ ra giá trị thực sự (integer) bên trong.*
A good iterator doesn't need to see the whole future, just needs to know how to unpack the current layer to reveal the true value (integer) inside.
