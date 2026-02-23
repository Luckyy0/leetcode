# Analysis for Minimum Domino Rotations For Equal Row
# *Phân tích cho bài toán Số lần quay Domino tối thiểu*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find the minimum swaps between two arrays at the same indices so that either the top array or the bottom array has all uniform elements.
*Tìm số tráo đổi bé nhất ở chung chỉ số mảng giữa 2 mảng sao cho mảng trên hoặc mảng dưới thành tập đồng nhất (một số duy nhất).*

---

## 2. Strategy 1: Naive (Check all 1 to 6)
## *2. Chiến lược 1: Ngây thơ (Kiểm tra hết từ 1 đến 6)*

### Idea and Weakness
### *Ý tưởng và Điểm yếu*

The naive idea is to assume the target uniform number is `1`, `2`, `3`, `4`, `5`, or `6`. We run a loop target from `1` to `6`, and for each target, check if it's possible to make the whole top row or bottom row equal to it.
*Chiến lược ngây thơ là giả định số mục tiêu chung để đồng nhất là các số từ `1` đến `6`. Chạy vòng lặp `target` bằng `1` đến `6`, duyệt cả hàng để đếm sửa đổi và tìm min.*

```java
public class Solution {
    public int minDominoRotationsNaive(int[] tops, int[] bottoms) {
        int minRotations = Integer.MAX_VALUE;
        
        for (int target = 1; target <= 6; target++) {
            // Count for top
            int swapsTop = check(tops, bottoms, target);
            if (swapsTop != -1) {
                minRotations = Math.min(minRotations, swapsTop);
            }
            // Count for bottom
            int swapsBottom = check(bottoms, tops, target);
            if (swapsBottom != -1) {
                minRotations = Math.min(minRotations, swapsBottom);
            }
        }
        
        return minRotations == Integer.MAX_VALUE ? -1 : minRotations;
    }
    
    private int check(int[] A, int[] B, int target) {
        int swaps = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != target && B[i] != target) return -1;
            if (A[i] != target) swaps++;
        }
        return swaps;
    }
}
```

- **Weakness (Điểm yếu):** While $O(N)$ is practically fine, checking all 6 numbers requires iterating through the arrays up to 12 times! We do lots of redundant parses on impossibilities.
  *Kể cả khi $O(N)$ đủ tốt, việc kiểm tra toàn bộ 6 số sẽ phải lặp mảng đi lặp lại 12 vòng (Mỗi số gọi hàm 2 lần)! Làm điều thừa thãi với những giá trị bị loại từ đầu.*

---

## 3. Strategy 2: Optimal (Check only the first domino targets)
## *3. Chiến lược 2: Tối ưu (Kiểm tra duy nhất domino đầu tiên)*

### How it solves the weakness
### *Cách nó giải quyết điểm yếu*

If a target uniform number is even possible, it *must exist on either the top or bottom of the FIRST domino* (`tops[0]` or `bottoms[0]`). If neither `tops[0]` nor `bottoms[0]` can form the full row, then no other number can, because the first domino essentially restricts the candidates! So we only need to check at most 2 targets.
*Nếu một giá trị mục tiêu chung là khả thi, MÙA VÀO ĐÂU ĐI NỮA thì nó BẮT BUỘC phải là nửa trên hoặc nửa dưới của CON DOMINO ĐẦU TIÊN (bởi vì hàng đó không thể thiếu domino đầu). Lợi dụng điều đó, ta chỉ việc bốc `tops[0]` và `bottoms[0]` làm tham chiếu (target), lược bỏ một đống quá trình duyệt ảo! Cắt giảm phép lặp thừa thãi.*

### Algorithm Steps
### *Các bước thuật toán*

1.  Create a helper function `check(target)` that counts swaps needed to make `tops` all `target` or `bottoms` all `target`.
    *   *Tạo hàm phụ `check(target)` đếm số hoán vị tối thiểu cần để hàng Top toàn `target` hoặc hàng Bot toàn `target`.*
2.  Call `check(tops[0])`. If valid, it returns the number of swaps.
    *   *Gọi `check(tops[0])`. Nếu hợp lệ nó nhả số swap ra.*
3.  If `check(tops[0])` failed (returned -1), call `check(bottoms[0])`.
    *   *Nếu gọi bằng giá trị Top đầu thất bại, bốc tiếp giá trị Bot đầu ra tính thử.*
4.  Return the min result, if both failed return `-1`.
    *   *Trả kết quả min, nếu test bằng cả 2 giá trị domino mồi này đều liệt, chắc chắn bất lực (-1).*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
public class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int res = check(tops, bottoms, tops[0]);
        if (res != -1 || tops[0] == bottoms[0]) return res;
        return check(tops, bottoms, bottoms[0]);
    }

    private int check(int[] A, int[] B, int x) {
        int rotationsA = 0;
        int rotationsB = 0;
        for (int i = 0; i < A.length; i++) {
            // Cannot form x on either side
            if (A[i] != x && B[i] != x) return -1;
            
            // Need to rotate to make A[i] = x
            if (A[i] != x) rotationsA++;
            
            // Need to rotate to make B[i] = x
            else if (B[i] != x) rotationsB++;
        }
        // Return the minimum of forming a row of x's on top or bottom
        return Math.min(rotationsA, rotationsB);
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We make at most 2 passes over the arrays (one for top candidate, one for bottom candidate).
    *   **Độ phức tạp thời gian:** $O(N)$. Tối đa 2 cuộc rà soát xuyên suốt mảng.*
*   **Space Complexity:** $O(1)$. Just tracking counts perfectly without using arrays.
    *   **Độ phức tạp không gian:** $O(1)$. Chỉ dùng vài bộ toán học đếm đơn giản.*
