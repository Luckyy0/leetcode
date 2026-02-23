# Analysis for Implement Magic Dictionary
# *Phân tích cho bài toán Cài đặt Từ điển Ma thuật*

## 1. Problem Essence & Fuzzy Matching
## *1. Bản chất vấn đề & Khớp mờ*

### The Challenge
### *Thách thức*
We need to build a system that tells us if a given word is almost in the dictionary - meaning it's exactly one character away from a valid word.
*Chúng ta cần xây dựng một hệ thống cho biết liệu một từ cho trước có "gần giống" một từ trong từ điển hay không - nghĩa là nó chỉ khác đúng một ký tự so với một từ hợp lệ.*

---

## 2. Strategy: Direct Comparison (Given Constraints)
## *2. Chiến lược: So sánh Trực tiếp (Dựa trên ràng buộc)*

The constraints for this problem are quite small:
- Number of dictionary words: 100.
- Length of words: 100.
- Number of search calls: 100.
*Ràng buộc của bài toán này khá nhỏ:*

Given these limits, the simplest and most robust approach is to iterate through every word in the dictionary for each search query.
*Với các giới hạn này, cách tiếp cận đơn giản và mạnh mẽ nhất là duyệt qua từng từ trong từ điển cho mỗi truy vấn tìm kiếm.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **`buildDict`:** Store the array of strings in a list or another collection.
    * **`buildDict`:** Lưu mảng các chuỗi vào một danh sách.*

2.  **`search(searchWord)`:**
    - Iterate through each word `word` in our stored dictionary.
    - If `word.length()` is not equal to `searchWord.length()`, skip it (changing one character doesn't change length).
    - If lengths match, compare `word` and `searchWord` character by character.
    - Count the number of positions where characters differ.
    - If the total difference count is **exactly 1**, return `true`.
    - If after checking all words no match is found, return `false`.
    * **`search(searchWord)`:** Duyệt qua từng từ trong từ điển. Nếu độ dài bằng nhau, đếm số ký tự khác biệt. Nếu khác biệt đúng bằng 1, trả về `true`.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Complexity Check:** Total comparisons per search = $100 \times 100 = 10,000$. Total for all searches = $100 \times 10,000 = 10^6$. This is well within the typical 1-second execution limit ($10^8$ operations).
    * **Kiểm tra độ phức tạp:** Tổng số phép so sánh cho tất cả các lần tìm kiếm là $10^6$. Điều này hoàn toàn nằm trong giới hạn thực thi 1 giây.*
*   **Implementation Simplicity:** Avoiding complex data structures like Tries makes the code easier to maintain and less prone to off-by-one errors in fuzzy searching.
    * **Sự đơn giản:** Tránh các cấu trúc dữ liệu phức tạp giúp mã dễ bảo trì hơn.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** 
    - `buildDict`: $O(D \times L)$, where $D$ is Number of words and $L$ is Average length.
    - `search`: $O(D \times L)$ per call.
    * **Độ phức tạp thời gian:** $O(D \times L)$ cho mỗi lần tìm kiếm.*
*   **Space Complexity:** $O(D \times L)$ to store the dictionary.
    * **Độ phức tạp không gian:** $O(D \times L)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Dictionary:** ["hello", "leetcode"]
**Search: "hhllo"**
1. "hello": Length 5. Difference at index 1 ('e' vs 'h'). Count = 1.
2. Count is 1. Return **true**.

**Search: "hello"**
1. "hello": Length 5. Difference count = 0. (Needs to be **exactly** 1).
2. "leetcode": Length 8. Skip.
3. Return **false**.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Always evaluate constraints before over-engineering. While a Trie with backtracking could solve this more efficiently for a large dictionary, a clean $O(N)$ iteration is superior for small data sets like this one.
*Luôn đánh giá các ràng buộc trước khi thiết kế quá mức. Mặc dù Trie có thể hiệu quả hơn cho từ điển lớn, nhưng việc duyệt $O(N)$ sạch sẽ là ưu việt cho các tập dữ liệu nhỏ.*
---
*Điều kỳ diệu (Magic) của một từ điển không nằm ở sự chính xác tuyệt đối, mà ở khả năng nhận diện sự tương đồng (Fuzzy matching). Trong không gian của các ký tự, mỗi sự thay đổi (Single change) là một cánh cửa dẫn đến một ý nghĩa mới. Dữ liệu dạy ta rằng bằng cách so sánh từng nhịp đập của các ký tự, ta có thể tìm thấy sự kết nối ẩn giấu giữa cái chưa biết (Search word) và những gì đã thuộc về quá khứ (Dictionary).*
The magic (Magic) of a dictionary lies not in absolute precision, but in the ability to recognize similarity (Fuzzy matching). In the space of characters, every change (Single change) is a door leading to a new meaning. Data teaches us that by comparing every beat of characters, we can find the hidden connection between the unknown (Search word) and what has belonged to the past (Dictionary).
