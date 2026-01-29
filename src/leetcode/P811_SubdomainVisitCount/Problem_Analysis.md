# 811. Subdomain Visit Count / Số lượng Truy cập Tên miền con

## Problem Description / Mô tả bài toán
You are given an array of strings `cpdomains` where each string is in the format `"count domain"`.
Bạn được cấp một mảng các chuỗi `cpdomains` trong đó mỗi chuỗi có định dạng `"count domain"`.

A domain like `discuss.leetcode.com` consists of subdomains: `discuss.leetcode.com`, `leetcode.com`, and `com`.
Một tên miền như `discuss.leetcode.com` được cấu thành từ các tên miền con: `discuss.leetcode.com`, `leetcode.com` và `com`.

For each domain, you should count the number of visits to each of its subdomains. Return a list of strings in the same format.
Đối với mỗi tên miền, bạn nên đếm số lần truy cập vào từng tên miền con của nó. Trả về một danh sách các chuỗi theo cùng định dạng.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### String Parsing and HashMap / Xử lý chuỗi và HashMap
We need to extract the count and then split the domain into its subdomains.
Chúng ta cần trích xuất số lượng và sau đó chia nhỏ tên miền thành các tên miền con của nó.

Algorithm:
1. Initialize a `Map<String, Integer>` to store counts.
2. For each string:
   - Split by space to get `count` and `fullDomain`.
   - For `fullDomain`, generate all suffixes (subdomains).
   - Update the map with the count for each subdomain.
3. Convert map to list of format `"count domain"`.

### Complexity / Độ phức tạp
- **Time**: O(N * L) where N is number of domains and L is max domain length.
- **Space**: O(N * L).

---

## Analysis / Phân tích

### Approach: Suffix Expansion
Process each domain by identifying all legal suffix segments. A domain string like `a.b.c` yields three entries: `a.b.c`, `b.c`, and `c`.
Xử lý từng tên miền bằng cách xác định tất cả các phân đoạn hậu tố hợp lệ. Một chuỗi tên miền như `a.b.c` tạo ra ba mục: `a.b.c`, `b.c` và `c`.

---
