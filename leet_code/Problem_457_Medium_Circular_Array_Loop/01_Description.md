# Result for Circular Array Loop
# *Kết quả cho bài toán Vòng lặp Mảng Vòng*

## Description
## *Mô tả*

You are given a **circular** array `nums` of positive and negative integers. If a number `k` at an index is positive, then move forward `k` steps. Conversely, if it's negative (`-k`), move backward `k` steps. Since the array is circular, you may assume that moving forward from the last element puts you on the first element, and moving backward from the first element puts you on the last element.
*Bạn được cho một mảng **vòng** `nums` gồm các số nguyên dương và âm. Nếu một số `k` tại một chỉ số là dương, hãy tiến lên `k` bước. Ngược lại, nếu nó âm (`-k`), hãy lùi lại `k` bước. Vì mảng là vòng, bạn có thể giả định rằng việc tiến lên từ phần tử cuối cùng sẽ đưa bạn đến phần tử đầu tiên, và lùi lại từ phần tử đầu tiên sẽ đưa bạn đến phần tử cuối cùng.*

A determine if there is a loop (or a cycle) in `nums`. A cycle must start and end at the same index and the cycle's length > 1. Furthermore, movements in a cycle must all follow a **single direction**. In other words, a cycle must not consist of both forward and backward movements.
*Hãy xác định xem có một vòng lặp (hoặc một chu kỳ) trong `nums` hay không. Một chu kỳ phải bắt đầu và kết thúc tại cùng một chỉ số và độ dài chu kỳ > 1. Hơn nữa, các chuyển động trong một chu kỳ phải luôn đi theo **một hướng duy nhất**. Nói cách khác, một chu kỳ không được bao gồm cả chuyển động tiến và lùi.*

Return `true` if there is a cycle in `nums`, or `false` otherwise.

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [2,-1,1,2,2]`
**Output:** `true`
**Explanation:** There is a cycle from index 0 -> 2 -> 3 -> 0. The cycle's length is 3.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [-1,2]`
**Output:** `false`
**Explanation:** The movement from index 1 -> 1 is a cycle of length 1. So it is not a cycle.

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 5000`
*   `-1000 <= nums[i] <= 1000`
*   `nums[i] != 0`
