# Result for Construct the Rectangle
# *Kết quả cho bài toán Xây dựng Hình chữ nhật*

## Description
## *Mô tả*

A web developer needs to know how to design a web page's size. So, given a specific rectangular web page’s area, your job by now is to design a rectangular web page, whose length L and width W satisfy the following requirements:
*Một nhà phát triển web cần biết cách thiết kế kích thước trang web. Vì vậy, với diện tích trang web hình chữ nhật cụ thể đã cho, công việc của bạn bây giờ là thiết kế một trang web hình chữ nhật, có chiều dài L và chiều rộng W thỏa mãn các yêu cầu sau:*

1.  The area of the rectangular web page you designed must equal to the given target area.
    *Diện tích của trang web hình chữ nhật bạn thiết kế phải bằng diện tích mục tiêu đã cho.*
2.  The width `W` should not be larger than the length `L`, which means `L >= W`.
    *Chiều rộng `W` không được lớn hơn chiều dài `L`, nghĩa là `L >= W`.*
3.  The difference between length `L` and width `W` should be as small as possible.
    *Hiệu giữa chiều dài `L` và chiều rộng `W` phải nhỏ nhất có thể.*

Return *an array `[L, W]` where `L` and `W` are the length and width of the web page you designed in sequence*.
*Trả về *một mảng `[L, W]` trong đó `L` và `W` lần lượt là chiều dài và chiều rộng của trang web bạn thiết kế*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `area = 4`
**Output:** `[2,2]`
**Explanation:** The target area is 4, and all the possible ways to construct it are [1,4], [2,2], [4,1]. 
But according to requirement 2, [1,4] is illegal; according to requirement 3,  [4,1] is not optimal compared to [2,2]. So the length L is 2, and the width W is 2.

## Example 2:
## *Ví dụ 2:*

**Input:** `area = 37`
**Output:** `[37,1]`

## Example 3:
## *Ví dụ 3:*

**Input:** `area = 122122`
**Output:** `[427,286]`

## Constraints:
## *Ràng buộc:*

*   `1 <= area <= 10^7`
