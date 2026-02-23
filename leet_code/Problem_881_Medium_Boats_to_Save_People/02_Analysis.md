# Analysis for Boats to Save People
# *Phân tích cho bài toán Thuyền để Cứu Người*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
We have an unlimited supply of boats, but each boat has a weight `limit` and can carry at most **two** people. We want to minimize the number of boats used to transport everyone.
*Chúng ta có vô số thuyền, nhưng mỗi thuyền có trọng tải `limit` và chỉ chở tối đa **hai** người. Chúng ta muốn tối thiểu hóa số thuyền cần dùng để chở hết mọi người.*

### KEY CONSTRAINTS
### *Các ràng buộc chính*
- At most 2 people per boat.
- Sum of weights <= limit.
- $N \le 50,000$.
- Weights $\le$ limit.
*- Tối đa 2 người mỗi thuyền. Tổng trọng lượng <= limit. $N \le 50,000$. Trọng lượng $\le$ limit.*

---

## 2. Strategy: Greedy with Two Pointers
## *2. Chiến lược: Tham lam với Hai con trỏ*

### Why Greedy?
### *Tại sao dùng Tham lam?*
The heaviest person is the hardest to fit. If the heaviest person can share a boat with the lightest person, they should do so. If not, the heaviest person cannot share a boat with *anyone* (since everyone else is heavier than the lightest person), so they must take a boat alone. This local optimal choice leads to a global optimum.
*Người nặng nhất là người khó sắp xếp nhất. Nếu người nặng nhất có thể đi cùng người nhẹ nhất, họ nên đi cùng nhau. Nếu không, người nặng nhất không thể đi cùng *bất kỳ ai* (vì những người còn lại đều nặng hơn người nhẹ nhất), nên họ phải đi một mình. Lựa chọn tối ưu cục bộ này dẫn đến tối ưu toàn cục.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Sort the array** in ascending order.
    *   **Sắp xếp mảng** theo thứ tự tăng dần.*

2.  **Initialize Pointers:** `i = 0` (lightest), `j = n - 1` (heaviest).
    *   **Khởi tạo con trỏ:** `i = 0` (nhẹ nhất), `j = n - 1` (nặng nhất).*

3.  **Process:** While `i <= j`:
    - Combine `people[i]` and `people[j]`.
    - If `people[i] + people[j] <= limit`, both can go. Increment `i` and decrement `j`.
    - Otherwise, only the heavy person (`people[j]`) goes (too heavy for the light person). Decrement `j`.
    - Increment boat count.
    *   **Xử lý:** Trong khi `i <= j`: Kết hợp người nhẹ nhất và nặng nhất. Nếu tổng $\le$ limit, cả hai cùng đi (tăng `i`, giảm `j`). Ngược lại, chỉ người nặng đi (giảm `j`). Tăng số lượng thuyền.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    int i = 0, j = people.length - 1;
    int boats = 0;
    
    while (i <= j) {
        boats++;
        if (people[i] + people[j] <= limit) {
            i++;
        }
        j--;
    }
    return boats;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$ due to sorting. The two-pointer pass is $O(N)$.
    *   **Độ phức tạp thời gian:** $O(N \log N)$ do sắp xếp. Vòng lặp hai con trỏ tốn $O(N)$.*
*   **Space Complexity:** $O(\log N)$ or $O(N)$ depending on the sorting algorithm implementation (e.g., Dual-Pivot Quicksort uses minimal stack space).
    *   **Độ phức tạp không gian:** $O(\log N)$ hoặc $O(N)$ tùy thuộc vào thuật toán sắp xếp.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Sorting allows us to easily pair the extremes. Without sorting, finding the best match for the heaviest person would be inefficient.
*Việc sắp xếp cho phép chúng ta ghép các cực trị một cách dễ dàng. Nếu không sắp xếp, việc tìm người ghép đôi tốt nhất cho người nặng nhất sẽ không hiệu quả.*
