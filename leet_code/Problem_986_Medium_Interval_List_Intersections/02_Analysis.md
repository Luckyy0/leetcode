# Analysis for Interval List Intersections
# *Phân tích cho bài toán Giao của Danh sách Đoạn*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find all overlapping areas between two sorted lists of disjoint intervals.
*Tìm tất cả các khu vực chồng chéo giữa hai danh sách các đoạn rời rạc đã được sắp xếp.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- The input lists are already sorted and self-disjoint.
- Use a **Two-Pointer** approach, one for `firstList` (`i`) and one for `secondList` (`j`).
- For any two intervals `A = firstList[i]` and `B = secondList[j]`:
  - Their overlap boundary `start` is the maximum of their starts: `max(A[0], B[0])`.
  - Their overlap boundary `end` is the minimum of their ends: `min(A[1], B[1])`.
  - If `start <= end`, they intersect. We append `[start, end]` to the result.
- Which pointer to advance?
  - Advance the pointer of the interval that ends *earlier*.
  - Because if `A[1] < B[1]`, then interval `A` cannot possibly intersect with `secondList[j+1]` (since `B[1]` is already beyond `A`, and `secondList` is sorted disjoint). So we must advance `i`.
  - Alternatively, if `A[1] > B[1]`, advance `j`.
  - If `A[1] == B[1]`, we can advance both (or just one, next iteration will naturally advance the other without adding a new overlap since it's disjoint).
*Kỹ thuật hai con trỏ. Tìm vùng giao (max start, min end). Tiến con trỏ thuộc về đoạn kết thúc sớm hơn.*

---

## 2. Strategy: Two Pointers
## *2. Chiến lược: Hai Con trỏ*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** `i = 0`, `j = 0`, and a list to store results `ans`.
    *   **Khởi tạo:** Hai con trỏ `i`, `j` và danh sách kết quả.*

2.  **Iterate:** While `i < firstList.length` and `j < secondList.length`.
    - Let `start = max(firstList[i][0], secondList[j][0])`.
    - Let `end = min(firstList[i][1], secondList[j][1])`.
    - If `start <= end`, we have a valid intersection. Add `[start, end]` to `ans`.
    - Compare ends:
      - If `firstList[i][1] < secondList[j][1]`, increment `i`.
      - Else, increment `j`.
    *   **Vòng lặp:** Tìm giao điểm và tiến con trỏ có điểm kết thúc nhỏ hơn.*

3.  **Return:** `ans` converted to an array.
    *   **Trả về:** Mảng kết quả.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList<>();
        int i = 0, j = 0;
        
        while (i < firstList.length && j < secondList.length) {
            // Find the intersection start and end points
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            
            // If the start is <= end, they actually overlap
            if (start <= end) {
                ans.add(new int[]{start, end});
            }
            
            // Move the pointer that finishes its interval first
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        
        return ans.toArray(new int[ans.size()][]);
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M + N)$, where $M$ and $N$ are the lengths of the two lists. Each interval is processed at most once.
    *   **Độ phức tạp thời gian:** $O(M + N)$.*
*   **Space Complexity:** $O(M + N)$ to store the answer (which is exactly what is needed for the output). The auxiliary space is $O(1)$ if the result array is ignored.
    *   **Độ phức tạp không gian:** $O(1)$ không gian phụ.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

This is the most optimal and standard approach to find intersections of sorted and disjoint interval lists.
*Đây là cách tiếp cận phổ biến và tối ưu nhất cho bài toán giao nhau của hai danh sách đoạn đã sắp xếp.*
