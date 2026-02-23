# Analysis for Largest Time for Given Digits
# *Phân tích cho bài toán Thời gian Lớn nhất cho các Chữ số đã cho*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Form the largest valid "HH:MM" time using 4 given digits.
*Tạo thời gian "HH:MM" hợp lệ lớn nhất bằng 4 chữ số đã cho.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Since there are only 4 digits, the number of permutations is very small ($4! = 24$).
- We can generate all permutations.
- For each permutation $(h1, h2, m1, m2)$, check if $10*h1 + h2 < 24$ and $10*m1 + m2 < 60$.
- Keep track of the maximum valid time (as minutes from 00:00).
- If no valid time found, return "".
*Vì chỉ có 4 chữ số, số lượng hoán vị rất nhỏ (24). Tạo tất cả hoán vị, kiểm tra tính hợp lệ và tìm giá trị lớn nhất.*

---

## 2. Strategy: Permutations
## *2. Chiến lược: Hoán vị*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Iterate:** All permutations of indices `(i, j, k, l)`.
    *   **Duyệt:** Tất cả hoán vị của các chỉ số.*

2.  **Construct Time:**
    - `hours = arr[i] * 10 + arr[j]`
    - `minutes = arr[k] * 10 + arr[l]`
    *   **Xây dựng thời gian:** Tính giờ và phút.*

3.  **Check Validity:**
    - `hours < 24`
    - `minutes < 60`
    *   **Kiểm tra hợp lệ:** Giờ < 24, Phút < 60.*

4.  **Maximize:** Store the max valid time found. Since we comparing times, converting to minutes `hours * 60 + minutes` makes comparison easy.
    *   **Tối đa hóa:** Lưu thời gian hợp lệ lớn nhất.*

5.  **Return:** Format as "HH:MM".
    *   **Trả về:** Định dạng chuỗi.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    public String largestTimeFromDigits(int[] arr) {
        int maxTime = -1;
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (i == j || i == k || j == k) continue;
                    
                    int l = 6 - i - j - k; // The remaining index (0+1+2+3 = 6)
                    
                    int hours = arr[i] * 10 + arr[j];
                    int minutes = arr[k] * 10 + arr[l];
                    
                    if (hours < 24 && minutes < 60) {
                        maxTime = Math.max(maxTime, hours * 60 + minutes);
                    }
                }
            }
        }
        
        if (maxTime == -1) {
            return "";
        }
        
        return String.format("%02d:%02d", maxTime / 60, maxTime % 60);
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$. Specifically $4^3 = 64$ iterations.
    *   **Độ phức tạp thời gian:** $O(1)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Checking all permutations is feasible and easiest due to small input size.
*Kiểm tra tất cả các hoán vị là khả thi và dễ nhất do kích thước đầu vào nhỏ.*
