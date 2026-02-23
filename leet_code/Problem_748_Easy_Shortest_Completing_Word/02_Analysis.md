# Analysis for Shortest Completing Word
# *Phân tích cho bài toán Từ Hoàn thiện Ngắn nhất*

## 1. Problem Essence & Frequency Matching
## *1. Bản chất vấn đề & Khớp Tần suất*

### The Challenge
### *Thách thức*
We need to find a word that is a "superset" of the letters found in `licensePlate`. The comparison must be case-insensitive, and we want to minimize the length of the result (ties broken by original order).
*Chúng ta cần tìm một từ là "tập cha" của các chữ cái tìm thấy trong `licensePlate`. Việc so sánh phải không phân biệt hoa thường, và ta muốn tối thiểu hóa độ dài của kết quả (nếu hòa thì chọn theo thứ tự ban đầu).*

---

## 2. Strategy: Count Arrays
## *2. Chiến lược: Mảng Đếm*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Parse License Plate:** Create a frequency array (size 26) for the `licensePlate`. Iterate through its characters, ignore non-letters, convert letters to lowercase, and increment the count.
    *   **Phân tích Biển số:** Tạo mảng tần suất (kích thước 26) cho `licensePlate`. Duyệt qua các ký tự, bỏ qua ký tự không phải chữ, chuyển chữ thường và tăng biến đếm.*

2.  **Iterate Words:** Loop through the `words` array.
    *   **Duyệt Từ:** Lặp qua mảng `words`.*

3.  **Check Validity:** For each word, create its own frequency array. Check if `wordCount[char] >= plateCount[char]` for all 'a'-'z'.
    *   **Kiểm tra Hợp lệ:** Với mỗi từ, tạo mảng tần suất riêng. Kiểm tra xem tần suất của từ có lớn hơn hoặc bằng tần suất của biển số với mọi ký tự hay không.*

4.  **Track Best Match:** Maintain `minLen` and `bestWord`. If a word is valid and `len < minLen`, update. Since we iterate in order, this automatically handles the tie-breaking rule (first shortest).
    *   **Theo dõi Kết quả Tốt nhất:** Duy trì độ dài nhỏ nhất và từ tốt nhất. Nếu từ hợp lệ và ngắn hơn mức hiện tại, cập nhật. Vì lặp theo thứ tự, quy tắc phá vỡ thế hòa (chọn từ đầu tiên) được tự động thỏa mãn.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot L + K)$, where $N$ is number of words, $L$ is average length of words (up to 15), and $K$ is length of license plate (up to 7). Very fast.
    *   **Độ phức tạp thời gian:** $O(N \cdot L + K)$.*
*   **Space Complexity:** $O(1)$ (fixed size array of 26).
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Plate: "1s3 PSt", words: ["step", "steps"]**
1. Plate counts: s:2, p:1, t:1.
2. Word "step": s:1, t:1, e:1, p:1.
   - s: 1 < 2. Invalid.
3. Word "steps": s:2, t:1, e:1, p:1.
   - s: 2 >= 2, t: 1 >= 1, p: 1 >= 1. Valid.
   - Update best: "steps", minLen=5.
**Result:** "steps".

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Simple frequency counting is sufficient given the small constraints on word length and alphabet size.
*Đếm tần suất đơn giản là đủ dùng với các ràng buộc nhỏ về độ dài từ và kích thước bảng chữ cái.*
---
*Một mảnh ghép hoàn thiện (Completing word) không chỉ cần đủ chất liệu (Frequency match) mà còn phải gọn gàng nhất (Shortest length). Giữa những lựa chọn dư thừa, sự tối giản (Min length) luôn mang lại vẻ đẹp của sự chính xác. Dữ liệu dạy ta rằng bằng cách đo lường cẩn thận (Counting chars) và loại bỏ những gì thiếu sót, ta sẽ tìm thấy mảnh ghép vừa vặn nhất cho bức tranh còn dang dở.*
A completing piece (Completing word) requires not only sufficient material (Frequency match) but also maximum conciseness (Shortest length). Amidst redundant choices, minimalism (Min length) always brings the beauty of precision. Data teaches us that by carefully measuring (Counting chars) and eliminating deficiencies, we will find the most fitting piece for the unfinished picture.
