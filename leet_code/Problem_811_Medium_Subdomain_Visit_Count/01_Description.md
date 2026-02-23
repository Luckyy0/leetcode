# Result for Subdomain Visit Count
# *Kết quả cho bài toán Đếm lượt truy cập tên miền phụ*

## Description
## *Mô tả*

A website domain `"discuss.leetcode.com"` consists of various subdomains. At the top level, we have `"com"`, at the next level, we have `"leetcode.com"`, and at the lowest level, `"discuss.leetcode.com"`. When we visit a domain like `"discuss.leetcode.com"`, we also implicitly visit the parent domains `"leetcode.com"` and `"com"`.
*Một tên miền website `"discuss.leetcode.com"` bao gồm nhiều tên miền phụ. Ở cấp cao nhất, chúng ta có `"com"`, ở cấp tiếp theo là `"leetcode.com"`, và ở cấp thấp nhất là `"discuss.leetcode.com"`. Khi chúng ta truy cập một tên miền như `"discuss.leetcode.com"`, chúng ta cũng gián tiếp truy cập các tên miền cha của nó là `"leetcode.com"` và `"com"`.*

A **count-paired domain** is a domain that has a specific count of visits, represented as a string `"count domain"`.
*Một **tên miền đi kèm số lượng** là một tên miền có số lượt truy cập cụ thể, được biểu diễn dưới dạng chuỗi `"số_lượng tên_miền"`.*

*   For example, `"9001 discuss.leetcode.com"` is a count-paired domain that indicates that the domain `discuss.leetcode.com` was visited `9001` times.
*   *Ví dụ, `"9001 discuss.leetcode.com"` là một tên miền đi kèm số lượng cho biết tên miền `discuss.leetcode.com` đã được truy cập `9001` lần.*

Given an array of **count-paired domains** `cpdomains`, return *an array of the **count-paired domains** of each subdomain in the input*. You may return the answer in **any order**.
*Cho một mảng các tên miền kèm số lượng `cpdomains`, trả về *một mảng các tên miền kèm số lượng của từng tên miền phụ trong dữ liệu đầu vào*. Bạn có thể trả về kết quả theo **thứ tự bất kỳ**.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** cpdomains = ["9001 discuss.leetcode.com"]
**Output:** ["9001 leetcode.com","9001 discuss.leetcode.com","9001 com"]
**Explanation:** We only have one website domain: "discuss.leetcode.com". As discussed above, the subdomain "leetcode.com" and "com" will also be visited. So they will all be visited 9001 times.

## Example 2:
## *Ví dụ 2:*

**Input:** cpdomains = ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
**Output:** ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
**Explanation:** We will visit "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" 1 time and "wiki.org" 5 times.
For the subdomains, we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= cpdomains.length <= 100`
*   `1 <= cpdomains[i].length <= 100`
*   `cpdomains[i]` follows either the `"rep d1.d2.d3"` or `"rep d1.d2"` format.
*   `rep` is an integer in the range `[1, 10^4]`.
*   `d1`, `d2`, and `d3` consist of lowercase English letters.
