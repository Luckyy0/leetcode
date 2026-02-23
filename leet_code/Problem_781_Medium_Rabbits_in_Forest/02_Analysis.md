# Analysis for Rabbits in Forest
# *Phân tích cho bài toán Những chú thỏ trong rừng*

## 1. Problem Essence & Grouping
## *1. Bản chất vấn đề & Nhóm hóa*

### The Challenge
### *Thách thức*
Rabbits answering `x` mean there are `x+1` rabbits of that color group (including themselves).
If multiple rabbits answer `x`, they might belong to the same group, or different groups (if the first group is already full).
*Những con thỏ trả lời `x` nghĩa là có `x+1` con thỏ thuộc nhóm màu đó (bao gồm cả chính nó). Nếu nhiều con thỏ trả lời `x`, chúng có thể thuộc cùng một nhóm, hoặc các nhóm khác nhau (nếu nhóm đầu tiên đã đầy).*

We want to minimize the total number of rabbits. This means we should try to group rabbits answering the same number together as much as possible.
*Chúng ta muốn tối thiểu hóa tổng số thỏ. Điều này có nghĩa là chúng ta nên cố gắng nhóm những con thỏ có cùng câu trả lời lại với nhau càng nhiều càng tốt.*

---

## 2. Strategy: Greedy Counting
## *2. Chiến lược: Đếm Tham lam*

### Algorithm
### *Thuật toán*

1.  **Frequency Map:** Count how many rabbits said specific numbers. Map `answer -> count`.
    *   **Bản đồ Tần suất:** Đếm xem bao nhiêu con thỏ đã nói những số cụ thể. Map `answer -> count`.*

2.  **Process Counts:**
    - For a group answering `x`, the size of one color group is `x + 1`.
    - If `count` rabbits answered `x`, how many groups of size `x + 1` do we need?
    - We can fit `x + 1` rabbits into one group.
    - If `count <= x + 1`, we need 1 group. Total rabbits = `x + 1`.
    - If `count > x + 1`, we fill one group, and the remaining start a new group.
    - Number of groups = `Math.ceil(count / (x + 1))`.
    - Total rabbits for this answer = `Number of groups * (x + 1)`.
    *   **Xử lý Tần suất:** Với một nhóm trả lời `x`, kích thước của một nhóm màu là `x + 1`. Số nhóm cần thiết = `Math.ceil(count / (x + 1))`. Tổng số thỏ = `Số nhóm * (x + 1)`.*
    
    Formula using integer arithmetic:
    `groups = (count + x) / (x + 1)` (integer division performs floor, so adding x simulates ceil).
    *Công thức dùng số học nguyên: `groups = (count + x) / (x + 1)`.*

### Code Logic Preview
### *Xem trước Logic Mã*

```java
public int numRabbits(int[] answers) {
    Map<Integer, Integer> counts = new HashMap<>();
    for (int ans : answers) {
        counts.put(ans, counts.getOrDefault(ans, 0) + 1);
    }
    
    int result = 0;
    for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
        int x = entry.getKey();
        int count = entry.getValue();
        
        int groupSize = x + 1;
        // Calculate number of groups needed
        int numGroups = (count + x) / groupSize;
        result += numGroups * groupSize;
    }
    return result;
}
```

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ to iterate answers and map.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(N)$ to store counts.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**In:** `[1, 1, 2]`
- Map: `{1: 2, 2: 1}`.
- Process `1`:
  - `x=1`, `count=2`. `groupSize=2`.
  - `numGroups = (2 + 1) / 2 = 1`.
  - `total = 1 * 2 = 2`. (2 rabbits of Color A).
- Process `2`:
  - `x=2`, `count=1`. `groupSize=3`.
  - `numGroups = (1 + 2) / 3 = 1`.
  - `total = 1 * 3 = 3`. (3 rabbits of Color B).
**Total Result:** `2 + 3 = 5`.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Using a HashMap to count frequencies and then applying the ceiling division formula `(count + x) / (x + 1)` is optimal and clean.
*Sử dụng HashMap để đếm tần suất và sau đó áp dụng công thức chia trần `(count + x) / (x + 1)` là tối ưu và gọn gàng.*
