# 866. Prime Palindrome / Số nguyên tố Đối xứng

## Problem Description / Mô tả bài toán
Find the smallest palindrome prime greater than or equal to `n`.
Tìm số nguyên tố đối xứng nhỏ nhất lớn hơn hoặc bằng `n`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Palindrome Generation / Tạo số Đối xứng
Checking every number for primality and palindromicity is too slow.
Kiểm tra từng số xem có phải là số nguyên tố và đối xứng hay không thì quá chậm.

Optimization:
1. Generate palindromes sequentially.
2. Check if a palindrome is prime.
3. Crucial observation: All even-length palindromes (except 11) are divisible by 11.
Quan sát quan trọng: Tất cả các số đối xứng có độ dài chẵn (ngoại trừ số 11) đều chia hết cho 11.
4. Therefore, we only need to generate odd-length palindromes for numbers `> 11`.

Algorithm:
- Generate half-lengths `h`.
- Create palindrome `s = h + reverse(h.substring(0, length-1))`.
- Parse to long and check primality.

### Complexity / Độ phức tạp
- **Time**: O(sqrt(R) log R) where R is the resulting prime (roughly 10^8).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Structural Generation
Instead of searching, we construct. By generating palindromes based on their root digits and skipping even-length clusters (which are non-prime), we significantly reduce the candidate pool.
Thay vì tìm kiếm, chúng ta xây dựng. Bằng cách tạo các số đối xứng dựa trên các chữ số gốc của chúng và bỏ qua các cụm có độ dài chẵn (là các số không nguyên tố), chúng ta giảm đáng kể tập hợp các số ứng viên.

---
