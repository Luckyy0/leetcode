# 1177. Can Make Palindrome from Substring / Có thể Tạo Palindrome từ Chuỗi con

## Problem Description / Mô tả bài toán
Given a string `s` and array `queries`, where `queries[i] = [left, right, k]`.
For each query, can we rearrange the substring `s[left...right]` and allow up to `k` changes to make it a palindrome?
Cho một chuỗi `s` và mảng `queries`, trong đó `queries[i] = [left, right, k]`.
Đối với mỗi truy vấn, chúng ta có thể sắp xếp lại chuỗi con `s[left...right]` và cho phép tối đa `k` thay đổi để biến nó thành palindrome không?

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Prefix XOR / Bitmask / XOR Tiền tố / Bitmask
A palindrome allows at most 1 character with odd count.
Rearranging means order doesn't matter, only counts.
We need to count characters with odd occurrences in substring.
Let `odd_counts` be this number.
We can remove `odd_counts` chars? No, we change them.
Changing 1 char can fix up to 2 odd counts (e.g., change one 'a' to 'b' where both were odd, now both even).
Actually, changing 1 char fixes 1 odd count if we pair it with another existing odd.
Basically, we have `odd` characters that don't have pairs.
We can leave 1 (for middle).
We need to pair up `odd - 1` characters.
Each change fixes 2 odds (convert one odd to match another odd).
So we need `(odd_counts / 2)` changes.
Wait, `k` changes.
Each change reduces odd count by 2?
Example: `abcde`, odds=5. Change 'b'->'a', 'd'->'c'. `aacce`. odds=1 ('e'). Palindrome.
We changed 2 chars. `odd` went 5 -> 1.
So we need `k >= odd_counts / 2`.
Algorithm:
1. Compute prefix bitmasks of character counts (parity).
   `mask[i]`: bit `j` is 1 if char `j` has odd count in `s[0...i-1]`.
2. For query `[L, R, K]`:
   `subMask = mask[R+1] ^ mask[L]`.
   `odds = Integer.bitCount(subMask)`.
   `needed = odds / 2`.
   return `needed <= K`.

### Complexity / Độ phức tạp
- **Time**: O(N + Q).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Prefix Parity Bitmask
The ability to form a palindrome depends solely on the number of characters with odd frequencies. Order does not matter. Use a bitmask to track the parity of each character's frequency. Precompute prefix XORs of these masks. For any substring query, XORing the prefix masks at the boundaries yields the parity mask for the substring in O(1). Count the set bits (odd characters). If there are `count` odd characters, we need `count / 2` changes to pair them up (leaving at most one middle character). Check if `k` is sufficient.
Khả năng tạo thành một palindrome chỉ phụ thuộc vào số lượng ký tự có tần suất lẻ. Thứ tự không quan trọng. Sử dụng bitmask để theo dõi tính chẵn lẻ của tần suất mỗi ký tự. Tính toán trước các XOR tiền tố của các mặt nạ này. Đối với bất kỳ truy vấn chuỗi con nào, XOR các mặt nạ tiền tố tại các ranh giới sẽ tạo ra mặt nạ tính chẵn lẻ cho chuỗi con trong O(1). Đếm các bit được thiết lập (ký tự lẻ). Nếu có `count` ký tự lẻ, chúng ta cần `count / 2` thay đổi để ghép đôi chúng (để lại tối đa một ký tự ở giữa). Kiểm tra xem `k` có đủ không.

---
