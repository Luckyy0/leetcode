# 1250. Check If It Is a Good Array / Kiểm tra xem đó có phải là Mảng Tốt không

## Problem Description / Mô tả bài toán
Given an array `nums` of positive integers.
Check if you can select a subsequence of `nums` such that sum of `a_i * x_i` (where `x_i` are integers) equals 1.
Subsequence sum logic is actually: can `gcd(subsequence) == 1`?
Wait. The question is linear combination equal to 1.
By Bezout's identity, linear combination equals 1 iff `gcd(elements) == 1`.
Since we can pick a subsequence, picking the whole array is best because GCD only decreases or stays same with more elements.
So check if `gcd(all elements) == 1`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Bezout's Identity / Đẳng thức Bezout
GCD of a set of numbers is the smallest positive integer that can be expressed as a linear combination of these numbers.
If we want combination sum to be 1, we need GCD to be 1.

### Complexity / Độ phức tạp
- **Time**: O(N * log(MinVal)).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: GCD Calculation
According to Bezout's identity, a linear combination of a set of numbers can equal 1 if and only if the greatest common divisor (GCD) of the entire set is 1. Iterate through the array, computing the cumulative GCD. If the GCD becomes 1 at any point, return true immediately. If the loop completes and the final GCD is 1, return true; otherwise false.
Theo đẳng thức Bezout, một tổ hợp tuyến tính của một tập hợp số có thể bằng 1 khi và chỉ khi ước chung lớn nhất (GCD) của toàn bộ tập hợp là 1. Lặp qua mảng, tính GCD tích lũy. Nếu GCD trở thành 1 tại bất kỳ thời điểm nào, hãy trả về true ngay lập tức. Nếu vòng lặp hoàn tất và GCD cuối cùng là 1, hãy trả về true; ngược lại là false.

---
