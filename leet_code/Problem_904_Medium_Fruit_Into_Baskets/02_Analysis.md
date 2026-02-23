# Analysis for Fruit Into Baskets
# *Phân tích cho bài toán Trái cây và Giỏ*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find the length of the **longest subarray** that contains at most **2 unique** types of numbers (fruit types).
*Tìm độ dài của **mảng con dài nhất** chứa tối đa **2 loại** số duy nhất (loại trái cây).*

### KEY INSIGHT
### *Nhận xét quan trọng*
- This is a standard **Sliding Window** problem.
- We maintain a window `[left, right]`.
- As we expand `right`, we add the fruit type to our set/map of current fruits.
- If the number of unique fruit types exceeds 2, we must shrink the window from the `left` until we are back to 2 types.
- We track the maximum window size encountered.
*Đây là bài toán **Cửa sổ Trượt** tiêu chuẩn. Duy trì cửa sổ `[left, right]`. Khi mở rộng `right`, thêm loại trái cây vào tập/map. Nếu số loại vượt quá 2, co cửa sổ từ `left` cho đến khi còn 2 loại. Theo dõi kích thước cửa sổ lớn nhất.*

---

## 2. Strategy: Sliding Window with HashMap
## *2. Chiến lược: Cửa sổ Trượt với HashMap*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** `Map<Integer, Integer> count`. `left = 0`, `maxLen = 0`.
    *   **Khởi tạo:** Map đếm tần suất, `left`, `maxLen`.*

2.  **Iterate `right`:** From 0 to `fruits.length - 1`.
    - Add `fruits[right]` to map, increment count.
    - **While** map size > 2:
        - Decrement count of `fruits[left]`.
        - If count becomes 0, remove from map.
        - `left++`.
    - `maxLen = max(maxLen, right - left + 1)`.
    *   **Duyệt `right`:** Thêm vào map. Nếu size > 2: giảm count của `left`, xóa nếu về 0, tăng `left`. Cập nhật `maxLen`.*

3.  **Return `maxLen`.**
    *   **Trả về `maxLen`.**

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int totalFruit(int[] fruits) {
    Map<Integer, Integer> countMap = new HashMap<>();
    int left = 0;
    int maxLen = 0;
    
    for (int right = 0; right < fruits.length; right++) {
        countMap.put(fruits[right], countMap.getOrDefault(fruits[right], 0) + 1);
        
        while (countMap.size() > 2) {
            int leftFruit = fruits[left];
            countMap.put(leftFruit, countMap.get(leftFruit) - 1);
            if (countMap.get(leftFruit) == 0) {
                countMap.remove(leftFruit);
            }
            left++;
        }
        
        maxLen = Math.max(maxLen, right - left + 1);
    }
    
    return maxLen;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Each element is added once and removed at most once. Map operations are $O(1)$.
    *   **Độ phức tạp thời gian:** $O(N)$. Mỗi phần tử được thêm một lần và xóa tối đa một lần.*
*   **Space Complexity:** $O(1)$ effectively, because the map size never exceeds 3.
    *   **Độ phức tạp không gian:** $O(1)$, vì kích thước map không bao giờ vượt quá 3.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

The HashMap approach is robust. For slightly better performance (avoiding Integer object allocation), one could use an array if the range of fruit types was small, but the problem says types can be up to `fruits.length`, so a Map is safer or requires Coordinate Compression (too complex here). A simple HashMap is optimal.
*Cách tiếp cận HashMap là mạnh mẽ. Để có hiệu suất tốt hơn một chút (tránh cấp phát đối tượng Integer), có thể dùng mảng nếu phạm vi loại trái cây nhỏ, nhưng ở đây loại có thể lớn nên Map là an toàn nhất.*
