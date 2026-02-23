# Result for Super Washing Machines
# *Kết quả cho bài toán Máy giặt Siêu cấp*

## Description
## *Mô tả*

You have `n` super washing machines on a line. Initially, each washing machine has some dresses or is empty.
*Bạn có `n` máy giặt siêu cấp trên một hàng. Ban đầu, mỗi máy giặt có một số lượng váy hoặc trống rỗng.*

For each move, you could choose **any m** ($1 \le m \le n$) washing machines, and pass **one dress** of each washing machine to one of its adjacent washing machines at the same time.
*Đối với mỗi bước di chuyển, bạn có thể chọn **bất kỳ m** ($1 \le m \le n$) máy giặt nào, và chuyển **một chiếc váy** của mỗi máy giặt sang một trong những máy giặt liền kề cùng một lúc.*

Given an integer array `machines` representing the number of dresses in each washing machine from left to right on the line, return *the minimum number of moves to make all the washing machines have the same number of dresses*. If it is not possible to do it, return `-1`.
*Cho một mảng số nguyên `machines` đại diện cho số lượng váy trong mỗi máy giặt từ trái sang phải trên hàng, hãy trả về *số bước di chuyển tối thiểu để tất cả các máy giặt có cùng số lượng váy*. Nếu không thể làm được điều đó, hãy trả về `-1`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `machines = [1,0,5]`
**Output:** `3`
**Explanation:** 
1st move:    1     0 <-- 5    =>    1     1     4
2nd move:    1 <-- 1 <-- 4    =>    2     1     3
3rd move:    2     1 <-- 3    =>    2     2     2

## Example 2:
## *Ví dụ 2:*

**Input:** `machines = [0,3,0]`
**Output:** `2`
**Explanation:** 
1st move:    0 <-- 3     0    =>    1     2     0
2nd move:    1     2 --> 0    =>    1     1     1

## Example 3:
## *Ví dụ 3:*

**Input:** `machines = [0,2,0]`
**Output:** `-1`
**Explanation:** 
It's impossible to make all three washing machines have the same number of dresses.

## Constraints:
## *Ràng buộc:*

*   `n == machines.length`
*   `1 <= n <= 10^4`
*   `0 <= machines[i] <= 10^5`
