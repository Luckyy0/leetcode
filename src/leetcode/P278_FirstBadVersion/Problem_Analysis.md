# 278. First Bad Version / Phiên Bản Lỗi Đầu Tiên

## Problem Description / Mô tả bài toán
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
Bạn là người quản lý sản phẩm và hiện đang lãnh đạo một nhóm phát triển một sản phẩm mới. Thật không may, phiên bản mới nhất của sản phẩm của bạn không vượt qua kiểm tra chất lượng. Vì mỗi phiên bản được phát triển dựa trên phiên bản trước đó, tất cả các phiên bản sau một phiên bản lỗi cũng đều bị lỗi.

Suppose you have `n` versions `[1, 2, ..., n]` and you want to find out the first bad one, which causes all the following ones to be bad.
Giả sử bạn có `n` phiên bản `[1, 2, ..., n]` và bạn muốn tìm ra phiên bản lỗi đầu tiên, nguyên nhân khiến tất cả các phiên bản sau đó đều bị lỗi.

You are given an API `bool isBadVersion(version)` which returns whether `version` is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
Bạn được cung cấp một API `bool isBadVersion(version)` trả về liệu `version` có bị lỗi hay không. Triển khai một hàm để tìm phiên bản lỗi đầu tiên. Bạn nên giảm thiểu số lượng cuộc gọi đến API.

### Example 1:
```text
Input: n = 5, bad = 4
Output: 4
Explanation:
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.
```

### Example 2:
```text
Input: n = 1, bad = 1
Output: 1
```

## Constraints / Ràng buộc
- `1 <= bad <= n <= 2^31 - 1`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Binary Search / Tìm Kiếm Nhị Phân
The sequence of versions looks like `[G, G, G, ..., B, B, B]`.
We want to find the **leftmost** `B`.
- If `mid` is Bad, it could be the first one, or there's one to the left. `high = mid`.
- If `mid` is Good, the first bad must be to the right. `low = mid + 1`.

**Algorithm**:
1.  `low = 1`, `high = n`.
2.  While `low < high`:
    - `mid = low + (high - low) / 2`.
    - If `isBadVersion(mid)`: `high = mid`.
    - Else: `low = mid + 1`.
3.  Return `low`.

### Complexity / Độ phức tạp
- **Time**: O(log N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Binary Search

**Edge Cases**:
1.  `n=1`, bad=1.
2.  `n` is large (Integer.MAX_VALUE). Calculation `low + high` might overflow if using `(low+high)/2`. Must use `low + (high-low)/2`.

---
