# 1044. Longest Duplicate Substring / Chuỗi con Trùng lặp Dài nhất

## Problem Description / Mô tả bài toán
Given a string `s`, consider all duplicated substrings: (contiguous) substrings of `s` that occur 2 or more times. The occurrences may overlap.
Cho một chuỗi `s`, hãy xem xét tất cả các chuỗi con trùng lặp: các chuỗi con (liên tiếp) của `s` xuất hiện 2 lần trở lên. Các lần xuất hiện có thể chồng chéo.

Return any duplicated substring that has the longest possible length.
Trả về bất kỳ chuỗi con trùng lặp nào có độ dài dài nhất có thể.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Binary Search + Rolling Hash (Rabin-Karp) / Tìm kiếm Nhị phân + Băm Lăn (Rabin-Karp)
Length of substring can be from 0 to `n-1`.
If there is a duplicate substring of length `L`, there is definitely a duplicate substring of length `L-1`.
So valid lengths are monotonic. We can binary search for `L`.

Check(L):
- Use Rolling Hash to find if any hash value appears twice for length `L`.
- Store hashes in a Set (or HashMap mapping hash -> index).
- Since collisions are possible, double check string equality or use double hashing.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Parametric Search with Hashing
Binary search for the length of the duplicate substring. For a specific length L, use Rabin-Karp (Rolling Hash) to rapidly detect duplicates in linear time. To mitigate hash collisions, verify candidate matches or employ a robust double-hash strategy.
Tìm kiếm nhị phân cho độ dài của chuỗi con trùng lặp. Đối với độ dài cụ thể L, sử dụng Rabin-Karp (Rolling Hash) để phát hiện nhanh các bản sao trong thời gian tuyến tính. Để giảm thiểu xung đột băm, hãy xác minh các kết quả khớp ứng viên hoặc sử dụng chiến lược băm kép mạnh mẽ.

---
