# Result for Encode and Decode TinyURL
# *Kết quả cho bài toán Mã hóa và Giải mã TinyURL*

## Description
## *Mô tả*

Note: This is a companion problem to the [System Design](https://leetcode.com/discuss/interview-question/system-design/) problem: [Design TinyURL](https://leetcode.com/discuss/interview-question/124658/Design-a-URL-Shortener-(-TinyURL-)-System/).
*Lưu ý: Đây là bài toán đi kèm với bài toán [Thiết kế Hệ thống](https://leetcode.com/discuss/interview-question/system-design/): [Thiết kế TinyURL](https://leetcode.com/discuss/interview-question/124658/Design-a-URL-Shortener-(-TinyURL-)-System/).*

TinyURL is a URL shortening service where you enter a URL such as `https://leetcode.com/problems/design-tinyurl` and it returns a short URL such as `http://tinyurl.com/4e9iAk`.
*TinyURL là một dịch vụ rút gọn URL, nơi bạn nhập URL như `https://leetcode.com/problems/design-tinyurl` và nó trả về URL ngắn như `http://tinyurl.com/4e9iAk`.*

Design the `encode` and `decode` methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
*Thiết kế các phương thức `encode` và `decode` cho dịch vụ TinyURL. Không có giới hạn về cách thuật toán mã hóa/giải mã của bạn hoạt động. Bạn chỉ cần đảm bảo rằng một URL có thể được mã hóa thành URL ngắn và URL ngắn có thể được giải mã thành URL ban đầu.*

Implement the `Solution` class:

*   `Solution()` Initializes the object of the system.
*   `String encode(String longUrl)` Returns a tiny URL for the given `longUrl`.
*   `String decode(String shortUrl)` Returns the original long URL for the given `shortUrl`.

## Example 1:
## *Ví dụ 1:*

**Input:** `url = "https://leetcode.com/problems/design-tinyurl"`
**Output:** `"https://leetcode.com/problems/design-tinyurl"`
**Explanation:**
`Solution obj = new Solution();`
`String tiny = obj.encode(url); // returns the encoded tiny url.`
`String ans = obj.decode(tiny); // returns the original url.`

## Constraints:
## *Ràng buộc:*

*   `1 <= url.length <= 10^4`
*   `url` is guranteed to be a valid URL.
