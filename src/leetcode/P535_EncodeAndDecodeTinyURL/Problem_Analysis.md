# 535. Encode and Decode TinyURL / Mã Hóa và Giải Mã TinyURL

## Problem Description / Mô tả bài toán
TinyURL is a URL shortening service where you enter a URL such as `https://leetcode.com/problems/design-tinyurl` and it returns a short URL such as `http://tinyurl.com/4e9iAk`.
TinyURL là một dịch vụ rút gọn URL, nơi bạn nhập một URL như `https://leetcode.com/problems/design-tinyurl` và nó trả về một URL ngắn như `http://tinyurl.com/4e9iAk`.

Design a class to encode a URL and decode a tiny URL.
Thiết kế một lớp để mã hóa URL và giải mã tiny URL.

There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
Không có giới hạn về cách thuật toán mã hóa/giải mã của bạn hoạt động. Bạn chỉ cần đảm bảo rằng một URL có thể được mã hóa thành tiny URL và tiny URL có thể được giải mã về URL gốc.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Hashing / Random Key Generation / Băm / Tạo khóa ngẫu nhiên
Common strategies:
1. **Counter**: Map ID 1 -> URL1, ID 2 -> URL2. Convert ID to Base62.
2. **Random String**: Generate a random 6-char string. Check collision. Store in Map.
3. **Hash**: MD5/SHA-256 of URL. Take first 6 chars.

Algorithm (Random Approach):
1. `Map<String, String> shortToLong`.
2. Encode:
   - Generate random key `k` (length 6, alphanumeric).
   - If `k` in map, repeat.
   - Map `k` -> `longUrl`.
   - Return `base + k`.
3. Decode:
   - Extract key `k`.
   - Return `shortToLong.get(k)`.

### Complexity / Độ phức tạp
- **Time**: O(1) average.
- **Space**: O(N) to store URLs.

---

## Analysis / Phân tích

### Approach: Random Token Mapping

**Algorithm**:
1.  Generate random alphanumeric key.
2.  Ensure key uniqueness.
3.  Store mapping in HashMap.
4.  Retrieve from map for decoding.

---
