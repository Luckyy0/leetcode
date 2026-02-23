# Analysis for Letter Case Permutation
# *Phân tích cho bài toán Hoán vị Chữ hoa Chữ thường*

## 1. Problem Essence & Backtracking
## *1. Bản chất vấn đề & Quay lui (Backtracking)*

### The Challenge
### *Thách thức*
For each character in the string:
- If it's a digit, keep it as is.
- If it's a letter, we have two choices: Lowercase or Uppercase.
*Với mỗi ký tự trong chuỗi: Nếu là số, giữ nguyên. Nếu là chữ, ta có hai lựa chọn: Chữ thường hoặc Chữ hoa.*

This is a classic subset/permutation generation problem solvable by recursion (backtracking).
*Đây là bài toán sinh tập con/hoán vị kinh điển có thể giải bằng đệ quy (quay lui).*

---

## 2. Strategy: Recursion (DFS)
## *2. Chiến lược: Đệ quy (DFS)*

### Algorithm
### *Thuật toán*

1.  **Helper Function:** `backtrack(index, tempString)`.
2.  **Base Case:** If `index == length`, add `tempString` to results.
3.  **Recursive Step:**
    - If `char` at `index` is a digit: Append it, recurse `index + 1`.
    - If `char` is a letter:
        - Option 1: Append Lowercase version, recurse.
        - Option 2: Append Uppercase version, recurse.
    *   **Hàm phụ trợ:** `backtrack(index, tempString)`. **Trường hợp cơ sở:** Nếu `index == length`, thêm vào kết quả. **Bước đệ quy:** Nếu là số: thêm vào và đệ quy. Nếu là chữ: thử cả hai trường hợp Thường và Hoa.*

    Alternatively, iterate through the string and expand the result list iteratively.
    *Hoặc, duyệt qua chuỗi và mở rộng danh sách kết quả theo cách lặp.*
    
    **Iterative Approach:**
    - Start with `[""]`.
    - For each char `c`:
        - If digit: Append `c` to all existing strings.
        - If letter: Duplicate the list. Append lower `c` to first half, upper `c` to second half.
    *   **Cách tiếp cận Lặp:** Bắt đầu với `[""]`. Với mỗi ký tự `c`: Nếu là số: thêm vào tất cả. Nếu là chữ: nhân đôi danh sách, thêm chữ thường vào nửa đầu, chữ hoa vào nửa sau.*

### Code Logic Preview (Backtracking)
### *Xem trước Logic Mã (Quay lui)*

```java
List<String> res = new ArrayList<>();
public List<String> letterCasePermutation(String s) {
    backtrack(s.toCharArray(), 0);
    return res;
}

void backtrack(char[] chars, int i) {
    if (i == chars.length) {
        res.add(new String(chars));
        return;
    }
    
    if (Character.isDigit(chars[i])) {
        backtrack(chars, i + 1);
        return;
    }
    
    // Choose Lower
    chars[i] = Character.toLowerCase(chars[i]);
    backtrack(chars, i + 1);
    
    // Choose Upper
    chars[i] = Character.toUpperCase(chars[i]);
    backtrack(chars, i + 1);
}
```

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(2^N \cdot N)$. There are $2^N$ permutations (worst case all letters). Constructing string takes $N$.
    *   **Độ phức tạp thời gian:** $O(2^N \cdot N)$.*
*   **Space Complexity:** $O(2^N \cdot N)$ to store output. Recursion stack $O(N)$.
    *   **Độ phức tạp không gian:** $O(2^N \cdot N)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**In:** `a1b2`
1. `i=0` ('a'). lower -> `a...`. upper -> `A...`.
2. `i=1` ('1'). Append 1. `a1...`, `A1...`.
3. `i=2` ('b').
   - For `a1`: `a1b`, `a1B`.
   - For `A1`: `A1b`, `A1B`.
4. `i=3` ('2'). Append 2.
   - `a1b2`, `a1B2`, `A1b2`, `A1B2`.
**Result:** 4 strings.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Backtracking with a char array is very efficient as it avoids excessive string copying until the leaf node.
*Quay lui với mảng char rất hiệu quả vì nó tránh việc sao chép chuỗi quá mức cho đến khi đạt nút lá.*
