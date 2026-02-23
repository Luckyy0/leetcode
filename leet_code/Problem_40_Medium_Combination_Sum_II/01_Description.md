# Result for Combination Sum II
# *Kết quả cho bài toán Tổng Các Tổ Hợp II*

## Description
## *Mô tả*

Given a collection of candidate numbers `candidates` and a target number `target`, find all unique combinations in `candidates` where the candidate numbers sum to `target`.
*Cho một tập hợp các số ứng viên `candidates` và một số mục tiêu `target`, hãy tìm tất cả các tổ hợp duy nhất trong `candidates` mà tổng các số ứng viên bằng `target`.*

Each number in `candidates` may only be used **once** in the combination.
*Mỗi số trong `candidates` chỉ có thể được sử dụng **một lần** trong tổ hợp.*

**Note:** The solution set must not contain duplicate combinations.
***Lưu ý:** Tập hợp lời giải không được chứa các tổ hợp trùng lặp.*

## Example 1:
## *Ví dụ 1:*

**Input:** `candidates = [10,1,2,7,6,1,5]`, `target = 8`
**Output:** 
```
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
```

## Example 2:
## *Ví dụ 2:*

**Input:** `candidates = [2,5,2,1,2]`, `target = 5`
**Output:** 
```
[
[1,2,2],
[5]
]
```

## Constraints:
## *Ràng buộc:*

*   `1 <= candidates.length <= 100`
*   `1 <= candidates[i] <= 50`
*   `1 <= target <= 30`
