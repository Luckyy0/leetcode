# Analysis for Partition Array Into Three Parts With Equal Sum
# *Phân tích cho bài toán Chia mảng thành 3 phần có tổng bằng nhau*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Can we partition an array into $3$ contiguous segments such that the sum of each segment is identical?
*Có thể chẻ một mảng ra thành $3$ khúc liền khối sao cho tổng mỗi khúc đều bằng nhau hay không?*

### KEY INSIGHT
### *Nhận xét quan trọng*
- If the array can be divided into 3 equal parts, it is a hard mathematical fact that the sum of the entire array MUST be divisible by 3.
- If `total_sum % 3 != 0`, then returning `false` is immediate.
- If it is divisible, then our `target_sum` for each part must be `total_sum / 3`. We simply need to sweep through the array from left to right and greedily mark "cuts" every time the running sum hits `target_sum`.
*Đã có thể chia mảng ra 3 phần đều tăm tắp thì BẤT DI BẤT DỊCH tổng cả mảng phải là số chia hết cho 3. Nếu tổng đem mod 3 mà dư, nghỉ chơi, false tức khắc!*
*Còn nếu chia hết, miếng mồi (tổng 1 phần) chắc chắn mang giá trị `mục_tiêu = Tổng / 3`. Cứ đi từ trái qua, cứ lúc nào gom đủ `mục_tiêu`, ta xẻ mảng 1 nhát. Xẻ được 3 khối là mỉm cười chiến thắng.*

---

## 2. Strategy 1: Naive (Nested Loops Simulation)
## *2. Chiến lược 1: Ngây thơ (Chia đoạn lồng nhau)*

### Idea and Weakness
### *Ý tưởng và Điểm yếu*

The naive idea is to set two cut points $i$ and $j$. A double loop selects every possible $(i, j)$ and calculates the sub-array sums explicitly.
*Bố trí hai con trỏ dập $i$ và $j$. Hai vòng lặp duyệt qua mọi khúc cắt có thể có và đếm tổng các khúc đó.*

```java
public class Solution {
    public boolean canThreePartsEqualSumNaive(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int sum1 = getSum(arr, 0, i);
                int sum2 = getSum(arr, i + 1, j);
                int sum3 = getSum(arr, j + 1, n - 1);
                
                if (sum1 == sum2 && sum2 == sum3) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private int getSum(int[] arr, int start, int end) {
        int s = 0;
        for (int i = start; i <= end; i++) s += arr[i];
        return s;
    }
}
```

- **Weakness (Điểm yếu):** We have an $O(N)$ getSum inside a nested loop, pushing complexity to $O(N^3)$. Even optimized using an array prefix sum, choosing points $(i, j)$ still creates an $O(N^2)$ algorithm. $N$ can scale up to $50,000$. Computing an $O(N^2)$ simulation fires off approximately $2.5 \times 10^9$ operations. Unacceptably slow, invoking Time Limit Exceeded (TLE).
  *Vòng lặp kéo tới $O(N^3)$, kể cả cố tối ưu Prefix Sums thì vẫn chôn chân ở mốc lặp 2 vòng $O(N^2)$. Giới hạn $N=50,000$, bình phương lên nảy sinh 2 tỷ rưỡi quy chuẩn. Mức độ duyệt rác rưởi không thể thông qua vòng loại Leetcode (TLE đổ ập vào đầu).*

---

## 3. Strategy 2: Optimal (Greedy Partition Tracking)
## *3. Chiến lược 2: Tối ưu (Đếm điểm chẻ Tham Lam)*

### How it solves the weakness
### *Cách nó giải quyết điểm yếu*

Instead of picking random indices $i$ and $j$, we know EXACTLY what sum to hunt for! `target = Total Sum / 3`.
We greedily traverse the array once:
Every time the accumulated sum equals our `target`, we immediately reset the accumulator and increment our `parts` counter. The trick is: it does not matter if there's subsequent zero-sum noise. As long as we successfully isolate 3 distinct parts (that perfectly match the fraction target), the remaining tail elements are mathematically guaranteed to amount to 0 (because standard sum is intact).
*Thay vì đi vớt 2 cái cọc $i, j$ bừa bãi. Chúng ta biết CHÍNH XÁC chúng ta săn con mồi tổng bao nhiêu (`mục_tiêu = sum / 3`).*
*Ta cày mảng 1 con đường duy nhất, tích chữ dần phần tử. Khi nào rổ đong đủ `mục_tiêu`, ta đổ rổ và vỗ đùi cái bốp đếm "Xong 1 mảnh!". Đủ 3 mảnh là win.*

### Algorithm Steps
### *Các bước thuật toán*

1.  Calculate `total_sum`. If `total_sum % 3 != 0`, return `false`.
    *   *Tính tổng $Total$. Nếu $\% 3 \neq 0$, trả về `false`.*
2.  Set `target = total_sum / 3`, `current_sum = 0`, `partsCount = 0`.
    *   *Khởi tạo mồi ngắm `target`, độ lún `current_sum`, và biến đếm khúc chẻ `partsCount`.*
3.  Iterate through the array. Add `arr[i]` to `current_sum`.
    *   *Duyệt trơn mảng từ đầu.*
4.  If `current_sum == target`:
    - Increment `partsCount`.
    - Reset `current_sum = 0`.
    - If `partsCount == 3` and we are NOT at the end yet, it's still completely valid because whatever elements are left must naturally sum equal to 0! Wait, standard algorithm just requires $\ge 3$ hits to return true. If we hit `target` 3 times, the leftovers will just sum to 0. Since 0 doesn't affect `target = 0`, catching $>3$ parts might happen. That's entirely fine! Just check `partsCount >= 3` at the end.
    *   *Nếu tổng khớp với Đích: Cắt cái Xoẹt! Tăng biến đếm chẻ. Reset rổ gom về chuẩn 0.*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
public class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
        // Điều kiện kiên quyết, chia 3 phải chẵn
        if (totalSum % 3 != 0) {
            return false;
        }
        
        int target = totalSum / 3;
        int currentSum = 0;
        int partsCount = 0;
        
        for (int num : arr) {
            currentSum += num;
            if (currentSum == target) {
                partsCount++;
                currentSum = 0; // Đổ rổ
            }
        }
        
        // Nếu target là 0, partsCount có thể lên 4, 5... (Vì 0 + 0 = 0). Do vậy đếm >= 3 là đủ Pass!
        return partsCount >= 3;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We iterate through the array twice. First time to get `total_sum`, tracking total. Second time to split array elements matching the `target_sum`.
    *   **Độ phức tạp thời gian:** $O(N)$. Quét mảng đúng 2 vòng, siêu tốc.*
*   **Space Complexity:** $O(1)$. Just constants variables without allocating array.
    *   **Độ phức tạp không gian:** $O(1)$. Chỉ kẹp vài biến số theo dõi.*
