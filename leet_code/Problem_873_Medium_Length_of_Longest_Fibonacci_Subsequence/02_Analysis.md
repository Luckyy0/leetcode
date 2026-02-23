# Analysis for Length of Longest Fibonacci Subsequence
# *Phân tích cho bài toán Độ dài của Dãy con Fibonacci Dài nhất*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find the longest subsequence that follows the rule $A + B = C$. Since the input array is strictly increasing, once we pick the first two numbers $(A, B)$, the rest of the Fibonacci sequence is uniquely determined if those numbers exist in the array.
*Tìm dãy con dài nhất tuân theo quy tắc $A + B = C$. Vì mảng đầu vào tăng dần nghiêm ngặt, một khi chúng ta chọn hai số đầu tiên $(A, B)$, phần còn lại của dãy Fibonacci sẽ được xác định duy nhất nếu những số đó tồn tại trong mảng.*

---

## 2. Strategy: Dynamic Programming or Set Lookup
## *2. Chiến lược: Quy hoạch động hoặc Tra cứu Tập hợp*

### Why $O(N^2)$ works?
### *Tại sao $O(N^2)$ khả thi?*
The array length is up to 1000. $O(N^2)$ operations ($1000^2 = 10^6$) are well within time limits. 
*Độ dài mảng lên tới 1000. $O(N^2)$ hoạt động ($10^6$) nằm trong giới hạn thời gian.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Use a Set for Fast Lookup:** Store all elements of `arr` in a `HashSet` to check for existence in $O(1)$.
    *   **Sử dụng Tập hợp để tra cứu nhanh:** Lưu trữ tất cả các phần tử của `arr` trong một `HashSet` để kiểm tra sự tồn tại trong $O(1)$.*

2.  **Iterate Through All Starting Pairs:** Use two nested loops to pick `arr[i]` and `arr[j]` as the first two elements.
    *   **Duyệt qua tất cả các cặp bắt đầu:** Sử dụng hai vòng lặp lồng nhau để chọn `arr[i]` và `arr[j]` làm hai phần tử đầu tiên.*

3.  **Simulate Sequence:**
    - Let $a = arr[i], b = arr[j]$.
    - While the set contains $a + b$:
        - New element $c = a + b$.
        - Update $a = b, b = c$.
        - Increment local length.
    - If local length $\ge 3$, update global `maxLen`.
    *   **Mô phỏng dãy:** Gọi $a = arr[i], b = arr[j]$. Trong khi tập hợp còn chứa $a + b$: đặt $c = a + b$, cập nhật $a = b, b = c$, tăng độ dài. Nếu độ dài $\ge 3$, cập nhật `maxLen`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int lenLongestFibSubseq(int[] arr) {
    int n = arr.length;
    Set<Integer> set = new HashSet<>();
    for (int x : arr) set.add(x);
    
    int maxLen = 0;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            int a = arr[i], b = arr[j], curLen = 2;
            while (set.contains(a + b)) {
                int c = a + b;
                a = b;
                b = c;
                curLen++;
            }
            if (curLen >= 3) maxLen = Math.max(maxLen, curLen);
        }
    }
    return maxLen;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2 \cdot \log (\text{maxVal}))$. The inner while loop runs at most $\log(\text{maxVal})$ times because Fibonacci numbers grow exponentially. Since $maxVal = 10^9$, $\log(10^9) \approx 45$.
    *   **Độ phức tạp thời gian:** $O(N^2 \cdot \log (\text{giá\_trị\_lớn\_nhất}))$. Vòng lặp while bên trong chạy nhiều nhất khoảng 45 lần vì các số Fibonacci tăng trưởng theo hàm mũ.*
*   **Space Complexity:** $O(N)$ to store the indices in a set.
    *   **Độ phức tạp không gian:** $O(N)$ để lưu trữ các chỉ số trong tập hợp.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Because the Fibonacci sequence grows so quickly, "brute forcing" the sequence from every possible pair of starting numbers is actually highly efficient.
*Vì dãy Fibonacci tăng trưởng rất nhanh, việc "vét cạn" dãy từ mọi cặp số bắt đầu khả dĩ thực sự rất hiệu quả.*
