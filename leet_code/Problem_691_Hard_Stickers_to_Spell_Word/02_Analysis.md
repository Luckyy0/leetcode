# Analysis for Stickers to Spell Word
# *Phân tích cho bài toán Nhãn dán để tạo Từ*

## 1. Problem Essence & Combinatorial Search
## *1. Bản chất vấn đề & Tìm kiếm Tổ hợp*

### The Challenge
### *Thách thức*
We need to form a target string using letters from a set of infinite stickers. The goal is to minimize the total number of stickers used. Since the order of letters in the target doesn't matter (we are cutting them individualy), we can treat the target as a "bag of characters."
*Chúng ta cần tạo ra chuỗi mục tiêu bằng cách sử dụng các chữ cái từ một tập hợp các nhãn dán vô hạn. Mục tiêu là tối thiểu hóa tổng số nhãn dán. Vì thứ tự các chữ cái trong mục tiêu không quan trọng (ta cắt rời từng chữ), ta có thể coi mục tiêu là một "túi các chữ cái".*

The constraints are small: $target.length \le 15$ and $stickers.length \le 50$. This suggests a solution using dynamic programming or memoized recursion.
*Ràng buộc khá nhỏ ($target.length \le 15$). Điều này gợi ý một giải pháp sử dụng quy hoạch động hoặc đệ quy có nhớ.*

---

## 2. Strategy: Memoized Recursion with Character Frequency
## *2. Chiến lược: Đệ quy có nhớ với Tần suất Chữ cái*

### Preprocessing
### *Tiền xử lý*
Convert each sticker into a frequency map (count of each character 'a'-'z'). This allows us to quickly determine how a sticker can reduce the remaining target.
*Chuyển đổi mỗi nhãn dán thành một bản đồ tần suất (đếm số lượng mỗi ký tự 'a'-'z'). Điều này cho phép chúng ta nhanh chóng xác định một nhãn dán có thể đáp ứng bao nhiêu phần của mục tiêu còn lại.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **State Definition:** `solve(remainingTarget)` returns the minimum stickers needed to form the string `remainingTarget`.
    * **Định nghĩa Trạng thái:** `solve(remainingTarget)` trả về số nhãn dán tối thiểu cần thiết.*

2.  **Memoization:** Use a `Map<String, Integer>` to store results of previously calculated target strings.
    * **Ghi nhớ:** Sử dụng một `Map` để lưu trữ kết quả của các chuỗi mục tiêu đã tính.*

3.  **Heuristic Selection:** To reduce the search space, for any state, pick the first character of the `remainingTarget`. We **must** pick a sticker that contains this character. This significantly prunes the recursion tree because we avoid trying every sticker at every step.
    * **Lựa chọn Quy nạp:** Để giảm không gian tìm kiếm, với bất kỳ trạng thái nào, hãy chọn ký tự đầu tiên của mục tiêu còn lại. Chúng ta **bắt buộc** phải chọn nhãn dán chứa ký tự này. Điều này giúp cắt tỉa cây đệ quy đáng kể.*

4.  **Recursive Step:**
    - From the chosen character, iterate through all stickers that contain it.
    - Subtract the characters of the sticker from the `remainingTarget` to get a `newTarget`.
    - `result = 1 + solve(newTarget)`.
    - Keep track of the minimum `result`.

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Pruning:** By focusing on the first character of the current target string, we ensure that every recursive branch eventually reaches the empty string.
    * **Cắt tỉa:** Bằng cách tập trung vào ký tự đầu tiên, chúng ta đảm bảo rằng mọi nhánh đệ quy cuối cùng đều dẫn tới chuỗi rỗng.*
*   **Target Representation:** Representing the `remainingTarget` as a sorted string (e.g., "aaabbc") makes it easy to use as a key in the memoization map.
    * **Biểu diễn Mục tiêu:** Biểu diễn mục tiêu còn lại dưới dạng chuỗi đã sắp xếp giúp dễ dàng làm khóa cho bản đồ ghi nhớ.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** Worst case is $O(2^L \times S \times L)$, where $L$ is the target length (15) and $S$ is the number of stickers (50). The $2^L$ comes from the number of possible subsets of target characters.
    * **Độ phức tạp thời gian:** $O(2^L \times S \times L)$.*
*   **Space Complexity:** $O(2^L)$ to store the memoization table.
    * **Độ phức tạp không gian:** $O(2^L)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Target:** "thehat", **Stickers:** ["with", "example"]
1. Target: "thehat". First char 't'.
2. Use "with":
   - Remaining: "eha" (removed t, h, i, w). Wait, 'i' and 'w' are extra.
   - New Target sorted: "aeh".
3. Next step: Target "aeh". First char 'a'.
4. Use "example":
   - Remaining: "h" (removed a, e, x, m, p, l).
   - New Target: "h".
5. Next step: Target "h". Use "with". New target: "".
**Total Stickers:** 3.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

In combinatorial search problems with small constraints, top-down recursion with memoization is often more intuitive than bottom-up DP. The key optimization in this specific problem is the "Mandatory Character" heuristic, which avoids redundant combinations.
*Trong các bài toán tìm kiếm tổ hợp với ràng buộc nhỏ, đệ quy từ trên xuống với ghi nhớ thường trực quan hơn. Chìa khóa tối ưu ở đây là kỹ thuật "Ký tự bắt buộc".*
---
*Mỗi chữ cái là một mảnh ghép của ý nghĩa (Target). Trong thế giới của những nhãn dán (Stickers), chúng ta đôi khi phải hy sinh sự phong phú (Extra letters) để đạt được sự cô đọng tối ưu (Minimum stickers). Dữ liệu dạy ta rằng bằng cách tập trung vào nút thắt khó khăn nhất (First character) và ghi lại những hành trình đã qua (Memoization), ta có thể giải quyết được những bài toán phức tạp nhất của sự sắp đặt.*
Each letter is a piece of meaning (Target). In the world of stickers (Stickers), we sometimes have to sacrifice abundance (Extra letters) to achieve optimal condensation (Minimum stickers). Data teaches us that by focusing on the most difficult knot (First character) and recording journeys taken (Memoization), we can solve the most complex problems of arrangement.
