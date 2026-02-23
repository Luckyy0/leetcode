# Analysis for Palindrome Number
# *Phân tích cho bài toán Số Đối Xứng*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Integer `x`. *Số nguyên `x`.*
*   **Output:** Boolean (`true`/`false`). *Kiểu Boolean (`true`/`false`).*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Range: Signed 32-bit integer. *Phạm vi: Số nguyên 32-bit có dấu.*
*   **Edge Cases:**
    *   Negative numbers are NOT palindromes (e.g., `-121` != `121-`). *Số âm KHÔNG phải là số đối xứng.*
    *   Numbers ending in 0 (like `10`) are not palindromes, unless the number is `0`. *Số kết thúc bằng 0 (như `10`) không phải là số đối xứng, trừ khi số đó là `0`.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Revert Half of the Number
### *Hướng tiếp cận: Đảo ngược Một nửa Số*

*   **Intuition:** Instead of converting to string (O(N) space), we can reverse the number mathematically.
    *Ý tưởng: Thay vì chuyển đổi sang chuỗi (O(N) không gian), chúng ta có thể đảo ngược số bằng toán học.*
*   **Optimization:** To avoid overflow issues (even though palindrome check implies it fits), we only need to revert **half** of the number.
    *Tối ưu hóa: Để tránh vấn đề tràn số, chúng ta chỉ cần đảo ngược **một nửa** số.*
    *   Example: `1221`. Reverted half: `12`, Remaining half: `12`. Match!
    *   Example: `121`. Reverted half: `1`, Remaining half: `12`. Wait, loop stops when `x <= revertedNum`.
        *   Step 1: `x=12`, `rev=1`.
        *   Step 2: `x=1`, `rev=12`. Stop. Check `x == rev` or `x == rev/10`.
*   **Algorithm Steps:**
    1.  If `x < 0` or (`x % 10 == 0` and `x != 0`), return `false`.
    2.  `revertedNumber = 0`.
    3.  Loop while `x > revertedNumber`:
        *   `revertedNumber = revertedNumber * 10 + x % 10`.
        *   `x /= 10`.
    4.  Return `x == revertedNumber` (even length) OR `x == revertedNumber / 10` (odd length).
*   **Complexity:**
    *   Time: $O(\log_{10}(x))$. Process half digits. *Thời gian: $O(\log_{10}(x))$. Xử lý một nửa số chữ số.*
    *   Space: $O(1)$. *Không gian: $O(1)$.*

### Dry Run
### *Chạy thử*
`x = 1221`
1.  `rev = 0`. `1221 > 0`.
2.  `rev = 1`. `x = 122`.
3.  `rev = 12`. `x = 12`.
4.  Loop `12 > 12`. False. Stop.
5.  Check `12 == 12`. True.

`x = 12321`
1.  `rev = 1`. `x = 1232`.
2.  `rev = 12`. `x = 123`.
3.  `rev = 123`. `x = 12`.
4.  Loop `12 > 123`. False. Stop.
5.  Check `12 == 123` (False) OR `12 == 123/10` (12 == 12 True).
