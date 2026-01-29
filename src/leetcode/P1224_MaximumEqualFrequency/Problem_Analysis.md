# 1224. Maximum Equal Frequency / Tần suất Bằng nhau Tối đa

## Problem Description / Mô tả bài toán
Given an array `nums`. Return the length of the longest prefix of `nums` such that it is possible to remove **exactly one** element from this prefix so that every number that has appeared in the prefix will have the same number of occurrences.
If after removing one element there are no numbers left, it is still valid (every number has 0 occurences).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Frequency of Frequencies Analysis
Maintain:
- `count[x]`: frequency of number `x`.
- `freqCount[f]`: number of elements with frequency `f`.
Iterate `nums` with index `i`. Update counts.
Check if current prefix `0..i` is valid.
Valid conditions:
1. All elements appear 1 time. `freqCount[1] == i+1`. (Remove any one, rest have 1? No. If all have 1, remove 1, rest have 1. Or if `i+1` elements size, remove 1, remaining `i` elements have freq 1. Wait. If all freq 1, we remove one, rest still freq 1. Correct. Or remaining is empty.)
   - Actually simpler: `maxFreq == 1`.
2. All elements appear `k` times, except one appears `k+1`. Remove one from the `k+1` to get all `k`.
   - `maxFreq * freqCount[maxFreq] + (maxFreq - 1) * freqCount[maxFreq - 1] == i + 1` AND `freqCount[maxFreq] == 1`.
   - Basically: one element has `maxFreq`, rest have `maxFreq-1`.
3. All elements appear `k` times, except one appears `1` time. Remove the `1`, rest have `k`.
   - `maxFreq * freqCount[maxFreq] + 1 == i + 1` AND `freqCount[1] == 1`.

Algorithm:
- Iterate `i` from 0 to `n-1`.
- Update `count` and `freqCount`. Track `maxFreq`.
- Check conditions. If met, update `res = i + 1`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Frequency Tracking
Iterate through the array while maintaining the frequency of each number (`count`) and the frequency of those frequencies (`freqCount`). Keep track of `maxFreq`. At each step, update these structures. Check if the current prefix satisfies one of the valid conditions:
1. All numbers appear once (`maxFreq == 1`).
2. All numbers appear `maxFreq` times, except one number appearing once (`freqCount[maxFreq] * maxFreq + 1 == total_len` and `freqCount[1] == 1`).
3. All numbers appear `maxFreq - 1` times, except one number appearing `maxFreq` times (`freqCount[maxFreq] == 1` and `maxFreq + freqCount[maxFreq-1] * (maxFreq-1) == total_len`).
If valid, update the maximum valid prefix length.
Lặp lại qua mảng trong khi duy trì tần suất của mỗi số (`count`) và tần suất của các tần suất đó (`freqCount`). Theo dõi `maxFreq`. Ở mỗi bước, cập nhật các cấu trúc này. Kiểm tra xem tiền tố hiện tại có thỏa mãn một trong các điều kiện hợp lệ hay không:
1. Tất cả các số xuất hiện một lần (`maxFreq == 1`).
2. Tất cả các số xuất hiện `maxFreq` lần, ngoại trừ một số xuất hiện một lần (`freqCount[maxFreq] * maxFreq + 1 == total_len` và `freqCount[1] == 1`).
3. Tất cả các số xuất hiện `maxFreq - 1` lần, ngoại trừ một số xuất hiện `maxFreq` lần (`freqCount[maxFreq] == 1` và `maxFreq + freqCount[maxFreq-1] * (maxFreq-1) == total_len`).
Nếu hợp lệ, hãy cập nhật độ dài tiền tố hợp lệ tối đa.

---
