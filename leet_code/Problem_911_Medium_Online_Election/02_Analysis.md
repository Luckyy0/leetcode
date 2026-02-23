# Analysis for Online Election
# *Phân tích cho bài toán Bầu cử Trực tuyến*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Precompute the winner at each timestamp `times[i]` so that we can answer queries for any time `t` efficiently.
*Tính toán trước người chiến thắng tại mỗi mốc thời gian `times[i]` để có thể trả lời các truy vấn cho bất kỳ thời điểm `t` nào một cách hiệu quả.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- The queries ask for the winner at time `t`.
- Since `times` are sorted, we can use **Binary Search** to find the largest timestamp $\le t$.
- The winner status only changes at the discrete time points given in `times`.
- We can precompute the winner for each index `i` in `times`.
  - Maintain vote counts for each candidate.
  - Track the current leader.
  - If a tie occurs, the most recently voted candidate takes the lead.
*Các truy vấn hỏi người thắng tại thời điểm `t`. Vì `times` đã sắp xếp, ta có thể dùng **Tìm kiếm Nhị phân** để tìm mốc thời gian lớn nhất $\le t$. Tr trạng thái người thắng chỉ thay đổi tại các mốc thời gian trong `times`. Ta có thể tính trước người thắng cho mỗi chỉ số `i`. Duy trì số phiếu cho mỗi ứng viên. Theo dõi người dẫn đầu hiện tại. Nếu hòa, người được bầu gần nhất sẽ dẫn đầu.*

---

## 2. Strategy: Precomputation + Binary Search
## *2. Chiến lược: Tính toán trước + Tìm kiếm Nhị phân*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Precomputation:**
    - Initialize `leaders` array of same size as `times`.
    - Map `count` to store votes for each person.
    - `leader = -1`, `maxVotes = 0`.
    - Iterate `i` from 0 to `n-1`:
        - `p = persons[i]`.
        - `count[p]++`.
        - If `count[p] >= maxVotes`:
            - `maxVotes = count[p]`.
            - `leader = p`. (Crucial: `>=` handles the tie-breaking condition automatically because `p` is the *most recent* voter causing the tie or new max).
        - `leaders[i] = leader`.
    *   **Tính toán trước:** Khởi tạo mảng `leaders`. Map đếm phiếu. Duyệt qua từng phiếu bầu, cập nhật `maxVotes` và `leader`. Điều kiện `>=` tự động xử lý trường hợp hòa (người mới nhất thắng).*

2.  **Query `q(t)`:**
    - Use `Arrays.binarySearch` or custom binary search on `times` to find the index `i` such that `times[i] <= t`.
    - If `Arrays.binarySearch` returns negative insertion point, transform it to the correct index.
    - Return `leaders[i]`.
    *   **Truy vấn:** Dùng tìm kiếm nhị phân trên `times` để tìm chỉ số `i` phù hợp. Trả về `leaders[i]`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
class TopVotedCandidate {
    int[] times;
    int[] leaders;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        this.leaders = new int[persons.length];
        
        Map<Integer, Integer> count = new HashMap<>();
        int leader = -1;
        int maxVotes = 0;
        
        for (int i = 0; i < persons.length; i++) {
            int p = persons[i];
            count.put(p, count.getOrDefault(p, 0) + 1);
            
            if (count.get(p) >= maxVotes) {
                maxVotes = count.get(p);
                leader = p;
            }
            
            leaders[i] = leader;
        }
    }
    
    public int q(int t) {
        int idx = Arrays.binarySearch(times, t);
        if (idx < 0) {
            idx = -idx - 2;
        }
        return leaders[idx];
    }
}
```

Wait, `Arrays.binarySearch` returns `-(insertion point) - 1`.
If `t` is found, returns index.
If `t` not found, insertion point is where it would be.
Example: times `[0, 5, 10]`, t=3. Insertion point is 1 (after 0). Returns `-2`.
`-(-2) - 2 = 0`. Correct (time 0).
t=12. Insertion point 3. Returns `-4`.
`-(-4) - 2 = 2`. Correct (time 10).
The logic `-idx - 2` works correctly for `idx < 0`.

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:**
    - Constructor: $O(N)$ to iterate votes.
    - Query: $O(\log N)$ for binary search.
    *   **Độ phức tạp thời gian:** Constructor $O(N)$, Query $O(\log N)$.*
*   **Space Complexity:** $O(N)$ to store counts and leaders.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Preprocessing the winner at every time step allows for extremely fast queries. The tie-breaking rule simplifies to updating the leader whenever the current vote count meets (>=) the max.
*Việc tính toán trước người thắng tại mỗi bước thời gian cho phép thực hiện truy vấn cực nhanh. Quy tắc phá vỡ thế hòa đơn giản hóa thành việc cập nhật người dẫn đầu bất cứ khi nào số phiếu hiện tại đạt (>=) mức tối đa.*
