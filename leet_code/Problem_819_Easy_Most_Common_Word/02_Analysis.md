# Analysis for Most Common Word
# *Phân tích cho bài toán Từ phổ biến nhất*

## 1. Problem Essence & String Cleaning
## *1. Bản chất vấn đề & Làm sạch chuỗi*

### THE CHALLENGE
### *Thách thức*
We need to count the frequency of each word in a paragraph, ignoring case and punctuation, and then find the word with the highest frequency that is not in a given banned list.
*Chúng ta cần đếm tần suất xuất hiện của mỗi từ trong một đoạn văn, bỏ qua chữ hoa chữ thường và dấu câu, sau đó tìm từ có tần suất cao nhất mà không nằm trong danh sách bị cấm.*

---

## 2. Strategy: HashMap & Set
## *2. Chiến lược: HashMap & Set*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Normalize Input:**
    - Convert the `banned` array into a `HashSet` for $O(1)$ lookups.
    - Convert the `paragraph` to lowercase.
    - Replace all non-alphabetic characters (punctuation) with spaces.
    *   **Chuẩn hóa đầu vào:** Chuyển mảng `banned` thành `HashSet` để tra cứu nhanh. Chuyển đoạn văn sang chữ thường và thay thế tất cả dấu câu bằng khoảng trắng.*

2.  **Extract Words:**
    - Split the modified paragraph string by spaces.
    - This will give us individual words.
    *   **Tách từ:** Tách chuỗi đoạn văn đã chỉnh sửa bằng khoảng trắng để lấy các từ riêng lẻ.*

3.  **Count Frequencies:**
    - Use a `HashMap<String, Integer>` to store the count of each non-banned word.
    - Iterate through the words, skipping those that are empty or banned.
    *   **Đếm tần suất:** Sử dụng `HashMap` để lưu số lần xuất hiện của các từ không bị cấm. Duyệt qua các từ, bỏ qua từ trống hoặc bị cấm.*

4.  **Find Maximum:**
    - Track the word with the highest count during frequencies counting.
    *   **Tìm cực đại:** Theo dõi từ có số lượng cao nhất trong quá trình đếm.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public String mostCommonWord(String paragraph, String[] banned) {
    // 1. Prepare banned set
    Set<String> bannedSet = new HashSet<>();
    for (String s : banned) bannedSet.add(s);
    
    // 2. Clean and split paragraph
    // Replace non-word characters with spaces and split
    String[] words = paragraph.toLowerCase().split("[^a-z]+");
    
    // 3. Count frequencies
    Map<String, Integer> counts = new HashMap<>();
    String result = "";
    int maxCount = 0;
    
    for (String word : words) {
        if (!word.isEmpty() && !bannedSet.contains(word)) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
            if (counts.get(word) > maxCount) {
                maxCount = counts.get(word);
                result = word;
            }
        }
    }
    return result;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(P + B)$, where $P$ is the length of the paragraph and $B$ is the size of the banned list. We process the paragraph string a few times (replace, split, iterate).
    *   **Độ phức tạp thời gian:** $O(P + B)$, với $P$ là độ dài đoạn văn và $B$ là kích thước danh sách cấm.*
*   **Space Complexity:** $O(P + B)$, to store the counts and the set of banned words.
    *   **Độ phức tạp không gian:** $O(P + B)$, để lưu trữ bản đồ tần suất và tập hợp từ cấm.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Paragraph:** "Bob hit a ball, the hit..." **Banned:** ["hit"]
1. Clean string: "bob hit a ball the hit..."
2. Words: ["bob", "hit", "a", "ball", "the", "hit"]
3. Process:
   - "bob": count 1 (max=1, res="bob")
   - "hit": banned, skip.
   - "a": count 1
   - "ball": count 1
   - "the": count 1
   - ... (assume "ball" appears again later)
**Result:** "ball"

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Regular expressions are a powerful tool for cleaning strings with mixed punctuation. Using a `HashSet` for banned words ensures the solution is efficient even with many constraints.
*Biểu thức chính quy (Regex) là công cụ mạnh mẽ để làm sạch chuỗi có lẫn dấu câu. Sử dụng `HashSet` cho các từ bị cấm đảm bảo giải pháp hiệu quả ngay cả khi có nhiều ràng buộc.*
