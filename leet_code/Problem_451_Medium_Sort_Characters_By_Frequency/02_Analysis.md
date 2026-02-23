# Analysis for Sort Characters By Frequency
# *Phân tích cho bài toán Sắp xếp Ký tự theo Tần suất*

## 1. Problem Essence & Sorting Criterion
## *1. Bản chất vấn đề & Tiêu chí Sắp xếp*

### The Challenge
### *Thách thức*
Rearranging a string such that characters with higher occurrences appear first. Identical characters must stay together in the result.

### Strategy: Frequency Mapping + Bucket Sort
### *Chiến lược: Bản đồ Tần suất + Sắp xếp theo Xô*

1.  **Count Frequencies:** Use a `HashMap` or an array (since characters are limited to ASCII/Unicode) to count how many times each character appears.
2.  **Bucket Sort:**
    - Create an array of lists (buckets) where the index represents the frequency.
    - `bucket[i]` contains all characters that appear exactly `i` times.
3.  **Construction:**
    - Iterate through the buckets from the highest index (max frequency) down to 1.
    - For each character in the bucket, append it to the result `frequency` times.

---

## 2. Approach: Optimal Sorting logic
## *2. Hướng tiếp cận: Logic Sắp xếp Tối ưu*

### Logic
### *Logic*
(See above). Using Bucket Sort is $O(N)$ because the maximum frequency is bounded by the string length $N$. This is faster than using a Priority Queue ($O(N \log K)$ where $K$ is number of unique characters).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Complexity:** Linear time for counting and bucket construction.
    *Hiệu quả O(N): Thời gian tuyến tính để đếm và xây dựng xô.*
*   **Intuitive Grouping:** Bucket sort naturally handles the "decreasing order" requirement by iterating backward.
    *Gom nhóm trực quan: Bucket sort xử lý tự nhiên yêu cầu "thứ tự giảm dần" bằng cách duyệt ngược.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the length of the string.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(N)$ for the frequency map and buckets.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `s = "tree"`
1. `Map: {t:1, r:1, e:2}`.
2. `Buckets:`
   - `Bucket[1]: [t, r]`
   - `Bucket[2]: [e]`
3. Iterate buckets backward:
   - From `Bucket[2]`: Append 'e' twice $\to$ `"ee"`.
   - From `Bucket[1]`: Append 'r' once, 't' once $\to$ `"eert"`.
Result: `"eert"`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Bucket Sort for $O(N)$ efficiency.
*Sử dụng Bucket Sort để đạt hiệu quả O(N).*
---
*Trong đám đông hỗn độn (unsorted string), tiếng nói lớn nhất (highest frequency) cần được lắng nghe trước tiên. Bằng cách phân loại mọi người vào những cấp độ (buckets) khác nhau dựa trên tầm ảnh hưởng của họ, ta tạo nên một trật tự hài hòa nơi sự hiện diện đáng kể nhất luôn dẫn đầu.*
In a chaotic crowd (unsorted string), the loudest voice (highest frequency) needs to be heard first. By classifying everyone into different levels (buckets) based on their influence, we create a harmonious order where the most significant presence always leads.
