# Analysis for Count Unique Characters of All Substrings of a Given String
# *Phân tích cho bài toán Đếm các ký tự duy nhất của tất cả các chuỗi con*

## 1. Problem Essence & Contribution Counting
## *1. Bản chất vấn đề & Đếm sự đóng góp*

### THE CHALLENGE
### *Thách thức*
We need to calculate the sum of unique character counts for *all* possible substrings. Instead of iterating through all $O(N^2)$ substrings, we can calculate how many substrings each character *individually* contributes to as a unique character.
*Chúng ta cần tính tổng số ký tự duy nhất của *tất cả* các chuỗi con. Thay vì duyệt qua $O(N^2)$ chuỗi con, ta có thể tính xem mỗi ký tự *riêng lẻ* đóng góp vào bao nhiêu chuỗi con với tư cách là một ký tự duy nhất.*

---

## 2. Strategy: Sandwich Contribution
## *2. Chiến lược: Đóng góp kiểu kẹp bánh mì*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Define Contribution Range:**
    - For a character $s[i]$, let $L$ be the index of the **previous** same character (or -1 if none).
    - Let $R$ be the index of the **next** same character (or $N$ if none).
    - A substring $s[start \dots end]$ contains $s[i]$ as a **unique** character if and only if:
        - $L < start \le i$
        - $i \le end < R$
    *   **Xác định phạm vi đóng góp:** Với ký tự $s[i]$, gọi $L$ là vị trí của ký tự giống nó **đằng trước**, $R$ là vị trí ký tự giống nó **đằng sau**. Một chuỗi con $[start \dots end]$ chứa $s[i]$ duy nhất khi: $L < start \le i$ và $i \le end < R$.*

2.  **Calculate Number of Substrings:**
    - The number of choices for $start$ is $(i - L)$.
    - The number of choices for $end$ is $(R - i)$.
    - Total substrings where $s[i]$ is unique is $(i - L) \times (R - i)$.
    *   **Tính số lượng chuỗi con:** Số cách chọn `start` là $(i - L)$, số cách chọn `end` là $(R - i)$. Tổng số chuỗi con mà $s[i]$ là duy nhất là $(i - L) \times (R - i)$.*

3.  **Aggregation:** Sum up the contributions for all characters $i = 0 \dots N-1$.
    *   **Tổng hợp:** Cộng dồn sự đóng góp của tất cả các ký tự từ $0$ đến $N-1$.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int uniqueLetterString(String s) {
    int n = s.length();
    // For each character, store its previous two indices
    int[][] lastIndices = new int[26][2];
    for (int i = 0; i < 26; i++) {
        lastIndices[i][0] = -1; // Previous index
        lastIndices[i][1] = -1; // Second previous index (actually we need current and previous)
    }
    
    // Better way: Store positions of each char
    List<Integer>[] positions = new List[26];
    for (int i = 0; i < 26; i++) {
        positions[i] = new ArrayList<>();
        positions[i].add(-1);
    }
    for (int i = 0; i < n; i++) {
        positions[s.charAt(i) - 'A'].add(i);
    }
    for (int i = 0; i < 26; i++) {
        positions[i].add(n);
    }
    
    long result = 0;
    for (int i = 0; i < 26; i++) {
        for (int j = 1; j < positions[i].size() - 1; j++) {
            long prev = positions[i].get(j - 1);
            long curr = positions[i].get(j);
            long next = positions[i].get(j + 1);
            result += (curr - prev) * (next - curr);
        }
    }
    return (int) (result % 1_000_000_007);
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the length of the string. We look at each character position exactly once when summing up contributions.
    *   **Độ phức tạp thời gian:** $O(N)$, vì ta xét mỗi vị trí ký tự đúng một lần để tính tổng.*
*   **Space Complexity:** $O(N)$, for storing the positions of each of the 26 characters.
    *   **Độ phức tạp không gian:** $O(N)$ để lưu trữ vị trí của các ký tự.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `s = "ABA"`
1. **Char 'A':** Positions are [-1, 0, 2, 3] (sentinels included).
   - Index 0: `(0 - (-1)) * (2 - 0) = 1 * 2 = 2`. Substrings: "A", "AB".
   - Index 2: `(2 - 0) * (3 - 2) = 2 * 1 = 2`. Substrings: "A", "BA".
2. **Char 'B':** Positions are [-1, 1, 3].
   - Index 1: `(1 - (-1)) * (3 - 1) = 2 * 2 = 4`. Substrings: "B", "AB", "BC", "ABA".
**Total:** 2 + 2 + 4 = 8.
**Result:** 8.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Thinking about the "contribution of each element" rather than "calculating for each substring" is a powerful technique for $O(N^2)$ substring problems. It reduces the complexity to $O(N)$ and is mathematically clean.
*Suy nghĩ về "sự đóng góp của từng phần tử" thay vì "tính toán cho từng chuỗi con" là một kỹ thuật mạnh mẽ cho các bài toán chuỗi con $O(N^2)$. Nó giảm độ phức tạp xuống $O(N)$ và rất sạch sẽ về mặt toán học.*
