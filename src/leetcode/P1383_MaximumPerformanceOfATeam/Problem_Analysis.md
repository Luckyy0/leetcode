# 1383. Maximum Performance of a Team / Hiệu suất Tối đa của một Đội

## Problem Description / Mô tả bài toán
`n` engineers. `speed` and `efficiency` arrays.
Select at most `k` engineers.
Performance = (sum of speeds) * (min efficiency).
Maximize performance % 10^9 + 7.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy + Priority Queue
Fix the minimum efficiency. Iterate engineers sorted by efficiency DESC.
If we fix engineer `i` as the one with minimum efficiency:
- We must select `i`.
- We can select up to `k-1` other engineers with efficiency >= `efficiency[i]`. (Already guaranteed by sorting).
- To maximize sum of speeds, we should pick `k-1` engineers with highest speeds among those processed so far.
- Use Min-Heap to maintain top `k` speeds. If heap size > k, remove smallest speed.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N + K).

---

## Analysis / Phân tích

### Approach: Sort Efficiency + Min Heap Speeds
Zip speed and efficiency into pairs. Sort engineers by efficiency in descending order. Iterate through the sorted engineers. For each engineer, consider them as having the minimum efficiency in the team. Add their speed to the current sum and push it to a min-heap. If the heap size exceeds `k`, remove the smallest speed from the heap and subtract it from the sum. At each step, calculate `currentSum * currentEfficiency` and update the maximum performance.
Nén tốc độ và hiệu quả thành các cặp. Sắp xếp các kỹ sư theo hiệu quả theo thứ tự giảm dần. Lặp lại qua các kỹ sư đã sắp xếp. Đối với mỗi kỹ sư, hãy coi họ là người có hiệu quả tối thiểu trong đội. Thêm tốc độ của họ vào tổng hiện tại và đẩy nó vào một min-heap. Nếu kích thước heap vượt quá `k`, hãy xóa tốc độ nhỏ nhất khỏi heap và trừ nó khỏi tổng. Tại mỗi bước, tính toán `currentSum * currentEfficiency` và cập nhật hiệu suất tối đa.

---
