# Analysis for Unique Morse Code Words
# *Phân tích cho bài toán Các từ mã Morse duy nhất*

## 1. Problem Essence & String Mapping
## *1. Bản chất vấn đề & Ánh xạ chuỗi*

### The Challenge
### *Thách thức*
We need to convert each word into its Morse code representation and then count how many unique representations exist.
*Chúng ta cần chuyển đổi mỗi từ thành biểu diễn mã Morse của nó và đếm xem có bao nhiêu biểu diễn duy nhất.*

---

## 2. Strategy: HashSet
## *2. Chiến lược: HashSet*

### Algorithm
### *Thuật toán*

1.  **Define Morse Mapping:** Create an array of strings representing the Morse code for characters 'a' to 'z'.
    *   **Định nghĩa Ánh xạ Morse:** Tạo một mảng chuỗi lưu trữ mã Morse cho các ký tự từ 'a' đến 'z'.*

2.  **Transformation Process:**
    - For each word in `words`:
      - For each character in the word, find its Morse representation.
      - Concatenate these representations into a single string.
    *   **Quy trình chuyển đổi:** Với mỗi từ, nối mã Morse của từng ký tự để tạo ra một chuỗi duy nhất.*

3.  **Count Unique:**
    - Insert each transformed string into a `HashSet`.
    - The size of the `HashSet` at the end will be the answer.
    *   **Đếm duy nhất:** Đưa các chuỗi đã chuyển đổi vào một `HashSet`. Kích thước của `HashSet` chính là kết quả.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(S)$, where $S$ is the sum of lengths of all words in the input array.
    *   **Độ phức tạp thời gian:** $O(S)$, với $S$ là tổng độ dài của tất cả các từ trong dãy.*
*   **Space Complexity:** $O(S)$, to store the unique transformations in the `HashSet`.
    *   **Độ phức tạp không gian:** $O(S)$, để lưu các chuyển đổi duy nhất trong `HashSet`.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Input:** `["gin", "zen"]`
1. "gin": 'g'("--."), 'i'(".."), 'n'("-."). Concatenated: "--...-."
2. "zen": 'z'("--.."), 'e'("."), 'n'("-."). Concatenated: "--...-."
3. HashSet: `{"--...-."}`. Size = 1.
**Result:** 1 (if only these two were checked).

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

A `HashSet` is the perfect tool for counting unique items. The mapping array makes the conversion straightforward.
*HashSet là công cụ hoàn hảo để đếm các phần tử duy nhất. Mảng ánh xạ giúp việc chuyển đổi trở nên trực tiếp.*
