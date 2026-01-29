# 492. Construct the Rectangle / Thiết Kế Hình Chữ Nhật

## Problem Description / Mô tả bài toán
Specifically, now you need to design a rectangular web page, whose area must be exactly the given target area.
Cụ thể, bây giờ bạn cần thiết kế một trang web hình chữ nhật, có diện tích phải bằng đúng diện tích mục tiêu đã cho.

Your design should satisfy the following three requirements:
Thiết kế của bạn nên thỏa mãn ba yêu cầu sau:
1. The area of the rectangular web page you designed must equal to the given target area. (Diện tích phải bằng diện tích đã cho).
2. The width `W` should not be larger than the length `L`, which means `L >= W`. (Chiều rộng W không được lớn hơn chiều dài L).
3. The difference between length `L` and width `W` should be as small as possible. (Sự khác biệt giữa L và W phải là nhỏ nhất có thể).

Return an array `[L, W]` where `L` and `W` are the length and width of the web page you designed in sequence.
Trả về một mảng `[L, W]` trong đó `L` và `W` lần lượt là chiều dài và chiều rộng của trang web.

### Example 1:
```text
Input: area = 4
Output: [2,2]
```

### Example 2:
```text
Input: area = 122122
Output: [427,286]
```

## Constraints / Ràng buộc
- `1 <= area <= 10^7`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Square Root search / Tìm kiếm căn bậc hai
To satisfy `L >= W` and minimize `L - W`, we should start looking for `W` starting from `sqrt(area)` and going downwards to `1`.
The first `W` we find that divides `area` evenly will result in the smallest `L - W`.

Algorithm:
1. Calculate `w = sqrt(area)`.
2. While `area % w != 0`:
   - Decrement `w`.
3. Set `L = area / w`.
4. Return `[L, w]`.

### Complexity / Độ phức tạp
- **Time**: O(sqrt(area)).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Square-Root-Bottom-Up Check

**Algorithm**:
1.  Initialize `w` as floor of square root.
2.  Iterate downwards.
3.  Check remainder.
4.  Calculate `L` and return.

---
