# 898. Bitwise ORs of Subarrays / Các phép OR Bit của các Mảng con

## Problem Description / Mô tả bài toán
We have an array `arr`. For every possible contiguous subarray, we calculate the bitwise OR of all its elements.
Chúng ta có một mảng `arr`. Đối với mọi mảng con liên tiếp có thể, chúng ta tính toán phép OR bit của tất cả các phần tử của nó.

Return the number of unique OR results.
Trả về số lượng kết quả OR duy nhất.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Subarray DP / Set Tracking / Lấy mảng con DP / Theo dõi tập hợp
The number of subarrays is $O(N^2)$, but the number of unique OR values ending at index `i` is at most 32 (since each OR increases the count of set bits).
Số lượng mảng con là $O(N^2)$, nhưng số lượng giá trị OR duy nhất kết thúc tại chỉ số `i` tối đa là 32 (vì mỗi phép OR sẽ làm tăng số lượng các bit được thiết lập).

Algorithm:
1. `ans`: a set of all unique results found so far.
2. `cur`: a set of unique OR results of subarrays ending at index `i-1`.
3. For each `x` in `arr`:
   - `next`: a new set containing `x` and `x | y` for all `y` in `cur`.
   - Add all elements of `next` to `ans`.
   - `cur = next`.

### Complexity / Độ phức tạp
- **Time**: O(32 * N).
- **Space**: O(32 * N) in worst case (though many overlap).

---

## Analysis / Phân tích

### Approach: Frontier Propagation
Maintain a set of active bitwise patterns. By OR-ing the current element with all patterns from the previous step, we generate all possible results ending at the current position. The limited number of bits in an integer naturally caps the growth of the active set at each step.
Duy trì một tập hợp các mẫu bitwise đang hoạt động. Bằng cách thực hiện phép OR giữa phần tử hiện tại với tất cả các mẫu từ bước trước, chúng ta tạo ra tất cả các kết quả có thể kết thúc tại vị trí hiện tại. Số lượng bit giới hạn trong một số nguyên sẽ tự nhiên giới hạn sự phát triển của tập hợp hoạt động tại mỗi bước.

---
