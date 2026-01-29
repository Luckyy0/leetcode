# 1477. Find Two Non-overlapping Sub-arrays Each With Target Sum / Tìm Hai Mảng con Không chồng chéo Mỗi Mảng có Tổng Mục tiêu

## Problem Description / Mô tả bài toán
Array `arr`, integer `target`.
Find two non-overlapping sub-arrays with sum equal to `target`.
Minimize sum of their lengths. If impossible, return -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Prefix Sum Map + DP
Find all subarrays with sum `target`.
For each end index `i`, we can find start index `j` if `prefix[i] - prefix[j-1] == target`.
Use Map `prefixSum -> index`.
Let `min_len[i]` = min length of a valid subarray ending AT or BEFORE `i`.
When we find a valid subarray `[j, i]` of length `len = i - j + 1`:
- Update `min_len[i] = min(min_len[i-1], len)`.
- If we have a valid subarray ending at `i`, we can pair it with best valid from `j-1`. i.e., `min_len[j-1]`.
- Minimize `len + min_len[j-1]`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: 1-Pass with MinLen Array
Maintain `minLen[i]` array (size `n`). Initialize with Infinity.
Use a map to store `prefixSum -> index`.
Iterate `i`:
- Update `currSum`.
- Check if `currSum - target` exists in map. If found at `prevIdx`:
  `len = i - prevIdx`.
  Check if `prevIdx > 0` and `minLen[prevIdx] != Inf`:
    `ans = min(ans, len + minLen[prevIdx])`.
  Update `current_best_len = min(current_best_len, len)`.
- `minLen[i+1]` or similar logic to propagate best length forward.
Wait. `minLen[x]` should store min length of valid subarray ending at or before `x`.
Actually, indices are tricky.
Use `best[i]` = min length of valid subarray ending before or at index `i`.
When valid subarray ending at `i` (start `s`) found:
Current length `l = i - s + 1`.
If `s > 0`, pair with `best[s-1]`.
Update `best[i]` with `min(best[i-1], l)`.

Duy trì mảng `minLen[i]`. Sử dụng bản đồ `prefixSum -> index`.
Khi tìm thấy mảng con hợp lệ `[s, i]`:
- Độ dài `l = i - s + 1`.
- Nếu `s > 0`, ghép với `minLen[s-1]`.
- Cập nhật `minLen[i] = min(minLen[i-1], l)`.

---
