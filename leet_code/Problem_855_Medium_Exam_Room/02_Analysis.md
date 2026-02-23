# Analysis for Exam Room
# *Phân tích cho bài toán Phòng thi*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
We need to manage student seating in a row of $N$ seats. Each new student picks a seat that maximizes their distance to the nearest person (with ties broken by choosing the smaller index). This is a dynamic resource management problem where we should efficiently find the largest "gap" between occupied seats.
*Chúng ta cần quản lý việc xếp chỗ cho sinh viên trong một hàng gồm $N$ ghế. Mỗi sinh viên mới sẽ chọn một chiếc ghế giúp tối đa hóa khoảng cách của họ đến người gần nhất (ưu tiên chỉ số nhỏ hơn nếu có sự trùng lặp). Đây là một bài toán quản lý tài nguyên động, trong đó chúng ta nên tìm "khoảng trống" lớn nhất giữa các ghế có người ngồi một cách hiệu quả.*

---

## 2. Strategy: Ordered Collection (TreeSet)
## *2. Chiến lược: Tập hợp có thứ tự (TreeSet)*

### Why TreeSet?
### *Tại sao dùng TreeSet?*
Since $N$ is huge ($10^9$) but the number of calls is small ($10^4$), we cannot store the whole room. We only need to store the indices of **occupied seats**. A `TreeSet` keeps these indices sorted, allowing us to traverse current gaps.
*Vì $N$ rất lớn ($10^9$) nhưng số lượng cuộc gọi nhỏ ($10^4$), chúng ta không thể lưu trữ toàn bộ phòng. Chúng ta chỉ cần lưu trữ chỉ số của các **ghế có người ngồi**. Một `TreeSet` giúp giữ cho các chỉ số này được sắp xếp, cho phép chúng ta duyệt qua các khoảng trống hiện tại.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** Store the capacity `N` and a `TreeSet<Integer>` of occupied seats.
    *   **Khởi tạo:** Lưu trữ dung lượng `N` và một `TreeSet<Integer>` các ghế có người ngồi.*

2.  **`seat()` function:**
    - If the room is empty, return 0 and add to set.
    - Check the distance to the first student (gap at the beginning): `dist = set.first()`.
    - Traverse through gaps between consecutive students `[prev, curr]`. The best seat is at `prev + (curr - prev) / 2` with distance `(curr - prev) / 2`.
    - Check the distance after the last student (gap at the end): `dist = (N - 1) - set.last()`.
    - Compare these distances to find the maximum. In case of a tie, the logic must prioritize the smaller index.
    *   **Hàm `seat()`:** Nếu phòng trống, trả về 0 và thêm vào tập hợp. Kiểm tra khoảng cách đến sinh viên đầu tiên (khoảng trống ở đầu). Duyệt qua các khoảng trống giữa các sinh viên liên tiếp `[prev, curr]`. Ghế tốt nhất là tại `prev + (curr - prev) / 2`. Kiểm tra khoảng cách sau sinh viên cuối cùng (khoảng trống ở cuối). So sánh các khoảng cách này để tìm giá trị lớn nhất. Trong trường hợp bằng nhau, logic phải ưu tiên chỉ số nhỏ hơn.*

3.  **`leave(p)` function:** Simply remove `p` from the `TreeSet`.
    *   **Hàm `leave(p)`:** Chỉ cần xóa `p` khỏi `TreeSet`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
class ExamRoom {
    int N;
    TreeSet<Integer> seats;
    
    public ExamRoom(int n) {
        this.N = n;
        this.seats = new TreeSet<>();
    }
    
    public int seat() {
        if (seats.isEmpty()) {
            seats.add(0);
            return 0;
        }
        
        int bestSeat = 0;
        int maxDist = seats.first(); // initial gap at index 0
        
        Integer prev = null;
        for (int s : seats) {
            if (prev != null) {
                int d = (s - prev) / 2;
                if (d > maxDist) {
                    maxDist = d;
                    bestSeat = prev + d;
                }
            }
            prev = s;
        }
        
        if (N - 1 - seats.last() > maxDist) {
            bestSeat = N - 1;
        }
        
        seats.add(bestSeat);
        return bestSeat;
    }
    
    public void leave(int p) {
        seats.remove(p);
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** 
    - `seat()`: $O(M)$, where $M$ is the number of students currently sitting. We iterate through the set.
    - `leave()`: $O(\log M)$ to remove from the `TreeSet`.
    *   **Độ phức tạp thời gian:** `seat()` tốn $O(M)$, trong đó $M$ là số sinh viên đang ngồi. `leave()` tốn $O(\log M)$.*
*   **Space Complexity:** $O(M)$ to store the occupied seats.
    *   **Độ phức tạp không gian:** $O(M)$ để lưu trữ các ghế có người ngồi.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Using a `TreeSet` is efficient for $10^4$ operations. For even larger datasets, a `PriorityQueue` of intervals could be used to make `seat()` $O(\log M)$.
*Sử dụng `TreeSet` là hiệu quả đối với $10^4$ thao tác. Đối với các tập dữ liệu lớn hơn nữa, một `PriorityQueue` các khoảng (intervals) có thể được sử dụng để làm cho `seat()` đạt $O(\log M)$.*
