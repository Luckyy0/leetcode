# Analysis for Prime Palindrome
# *Phân tích cho bài toán Số nguyên tố Đối xứng*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find the smallest number $X \ge N$ such that $X$ is both a prime number and a palindrome. The constraint $N \le 10^8$ is quite large.
*Tìm số nhỏ nhất $X \ge N$ sao cho $X$ vừa là số nguyên tố vừa là số đối xứng (palindrome). Ràng buộc $N \le 10^8$ là khá lớn.*

---

## 2. Strategy: Palindrome Generation & Math Properties
## *2. Chiến lược: Tạo số đối xứng & Các thuộc tính toán học*

### Key Insight 1: Palindrome vs Prime check
### *Nhận thức 1: Kiểm tra Đối xứng vs Nguyên tố*
There are fewer palindromes than primes. It's much faster to generate palindromes and check if they are prime than to iterate through primes.
*Có ít số đối xứng hơn số nguyên tố. Việc tạo ra các số đối xứng và kiểm tra xem chúng có phải là số nguyên tố hay không nhanh hơn nhiều so với việc duyệt qua các số nguyên tố.*

### Key Insight 2: The "Even Length" rule
### *Nhận thức 2: Quy tắc "Độ dài chẵn"*
A mathematical property states that any palindrome with an even number of digits is divisible by 11.
*Một thuộc tính toán học chỉ ra rằng bất kỳ số đối xứng nào có số chữ số chẵn đều chia hết cho 11.*
- Example: $1221, 3553...$ are all multiples of 11.
- Exception: $11$ itself is a prime.
Therefore, any prime palindrome with more than 2 digits must have an **odd number of digits**. If $N$ is between $10^7$ and $10^8$ (8 digits), we can skip straight to $10^8$ (9 digits).
*Do đó, bất kỳ số nguyên tố đối xứng nào có nhiều hơn 2 chữ số đều phải có **số chữ số lẻ**. Nếu $N$ nằm trong khoảng $10^7$ đến $10^8$ (8 chữ số), chúng ta có thể nhảy thẳng lên $10^8$ (9 chữ số).*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Iterative Primes:** For very small numbers, handle cases manually ($2, 3, 5, 7, 11$).
    *   **Số nguyên tố nhỏ:** Xử lý thủ công các trường hợp rất nhỏ.*

2.  **Generate Palindromes:**
    - Iterate through numbers $1, 2, 3 \dots$ and treat them as the "root" (half) of a palindrome.
    - Create odd-length palindromes from these roots.
    - Example: Root `123` -> Palindrome `12321`.
    *   **Tạo số đối xứng:** Duyệt qua các số $1, 2, 3 \dots$ và coi chúng là "gốc" (nửa) của một số đối xứng. Tạo các số đối xứng độ dài lẻ từ các gốc này.*

3.  **Check Condition:**
    - Check if the generated palindrome $\ge N$ and if it's prime.
    - Return the first one found.
    *   **Kiểm tra điều kiện:** Kiểm tra xem số đối xứng được tạo ra có $\ge N$ và là số nguyên tố hay không. Trả về số đầu tiên tìm thấy.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int primePalindrome(int n) {
    if (8 <= n && n <= 11) return 11;
    for (int len = 1; len <= 5; len++) {
        // odd lengths: 1, 3, 5, 7, 9
        for (int i = (int)Math.pow(10, len-1); i < (int)Math.pow(10, len); i++) {
            String s = Integer.toString(i);
            StringBuilder sb = new StringBuilder(s);
            for (int j = s.length() - 2; j >= 0; j--) sb.append(s.charAt(j));
            int p = Integer.parseInt(sb.toString());
            if (p >= n && isPrime(p)) return p;
        }
    }
    return -1;
}

private boolean isPrime(int x) {
    if (x < 2) return false;
    for (int i = 2; i * i <= x; i++) {
        if (x % i == 0) return false;
    }
    return true;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** Generating palindromes is $O(\sqrt{\text{MAX\_VAL}})$, and prime check is $O(\sqrt{X})$. The search space is small due to the odd-length constraint.
    *   **Độ phức tạp thời gian:** Việc tạo số đối xứng tốn $O(\sqrt{V})$, và kiểm tra số nguyên tố tốn $O(\sqrt{X})$.*
*   **Space Complexity:** $O(1)$ excluding the string conversions.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Always use mathematical shortcuts like the "even-length palindrome" rule to drastically reduce the search space in number theory problems.
*Luôn sử dụng các mẹo toán học như quy tắc "số đối xứng độ dài chẵn" để giảm mạnh không gian tìm kiếm trong các bài toán lý thuyết số.*
