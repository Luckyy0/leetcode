# 1231. Divide Chocolate / Chia Sô cô la

## Problem Description / Mô tả bài toán
You have one chocolate bar that consists of some chunks. Each chunk has its own sweetness given by the array `sweetness`.
You want to share the chocolate with your `K` friends so you start cutting the chocolate bar into `K+1` pieces using `K` cuts, each piece consists of some **consecutive** chunks.
Being generous, you will eat the piece with the **minimum total sweetness** and give the other pieces to your friends.
Find the **maximum total sweetness** of the piece you can get by cutting the chocolate bar optimally.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Binary Search on Answer / Tìm kiếm Nhị phân trên Kết quả
We want to maximize the minimum sum of partitioned subarrays.
This is "Max-Min" problem.
Binary search range `[min(sweetness), sum(sweetness)]`.
For a given `target` minimum sweetness, check if we can form at least `K+1` chunks such that each has sum `>= target`.
`check(target)`: Iterate array, accumulate sum. If sum `>= target`, count++; reset sum. Return `count >= K+1`.

### Complexity / Độ phức tạp
- **Time**: O(N * log(Sum)).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Binary Search on Values
The problem asks to maximize the minimum subarray sum (your share). The possible values range from the minimum sweetness chunk to the total sum. Use binary search on this range. For a candidate value `mid`, check if it's possible to divide the chocolate into at least `K + 1` pieces where each piece has a total sweetness of at least `mid`. If possible, try a larger value (`mid` might be too small); otherwise, try a smaller value.
Bài toán yêu cầu tối đa hóa tổng mảng con tối thiểu (phần của bạn). Các giá trị có thể nằm trong khoảng từ phần mảng sô cô la có độ ngọt tối thiểu đến tổng độ ngọt. Sử dụng tìm kiếm nhị phân trên phạm vi này. Đối với giá trị ứng viên `mid`, hãy kiểm tra xem có thể chia sô cô la thành ít nhất `K + 1` miếng mà mỗi miếng có tổng độ ngọt ít nhất là `mid` hay không. Nếu có thể, hãy thử giá trị lớn hơn (`mid` có thể quá nhỏ); nếu không, hãy thử giá trị nhỏ hơn.

---
