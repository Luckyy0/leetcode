# Analysis for Goat Latin
# *Phân tích cho bài toán Tiếng Latin của Dê*

## 1. Problem Essence & Word-by-Word Processing
## *1. Bản chất vấn đề & Xử lý theo từng từ*

### THE CHALLENGE
### *Thách thức*
We need to transform each word in a sentence based on three specific rules related to vowels, consonants, and word position. This is a straightforward string manipulation problem that requires splitting the sentence and rebuilding it word by word.
*Chúng ta cần biến đổi mỗi từ trong một câu dựa trên ba quy tắc cụ thể liên quan đến nguyên âm, phụ âm và vị trí của từ. Đây là một bài toán xử lý chuỗi trực tiếp đòi hỏi phải tách câu và xây dựng lại từng từ một.*

---

## 2. Strategy: Split and Reconstruct
## *2. Chiến lược: Tách và Tái cấu trúc*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Split the Sentence:** Break the `sentence` into individual words using the space character as a delimiter.
    *   **Tách câu:** Chia `sentence` thành các từ riêng lẻ bằng ký tự khoảng trắng.*

2.  **Define Vowels:** Create a set of vowels (both lowercase and uppercase) for quick lookup: `{a, e, i, o, u, A, E, I, O, U}`.
    *   **Xác định nguyên âm:** Tạo một tập hợp các nguyên âm (cả viết thường và viết hoa) để tra cứu nhanh.*

3.  **Process Each Word:** For each word at index `i` (0-indexed):
    - **Rule 1 & 2:** Check if the first character is a vowel.
        - If yes: Append `"ma"`.
        - If no: Shift the first character to the end and then append `"ma"`.
    - **Rule 3:** Append `'a'` repeated `i + 1` times.
    *   **Xử lý từng từ:** Với mỗi từ tại chỉ số `i`: Kiểm tra ký tự đầu tiên. Nếu là nguyên âm: thêm `"ma"`. Nếu không: chuyển ký tự đầu về cuối rồi thêm `"ma"`. Thêm `i + 1` ký tự `'a'` vào cuối.*

4.  **Join Words:** Concatenate all transformed words back into a single sentence separated by spaces.
    *   **Nối các từ:** Nối tất cả các từ đã biến đổi lại thành một câu duy nhất, cách nhau bởi khoảng trắng.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public String toGoatLatin(String sentence) {
    Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    String[] words = sentence.split(" ");
    StringBuilder result = new StringBuilder();
    StringBuilder suffixA = new StringBuilder("a");
    
    for (int i = 0; i < words.length; i++) {
        String word = words[i];
        char first = word.charAt(0);
        
        if (vowels.contains(first)) {
            result.append(word);
        } else {
            result.append(word.substring(1)).append(first);
        }
        
        result.append("ma").append(suffixA);
        if (i != words.length - 1) result.append(" ");
        
        suffixA.append("a"); // Prepare for next word
    }
    return result.toString();
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N + W^2)$, where $N$ is the total length of the sentence and $W$ is the number of words. The $W^2$ comes from the progressively increasing 'a' suffixes ($1 + 2 + 3 + ... + W$).
    *   **Độ phức tạp thời gian:** $O(N + W^2)$, với $N$ là tổng độ dài của câu và $W$ là số lượng từ.*
*   **Space Complexity:** $O(N + W^2)$, to store the resulting string.
    *   **Độ phức tạp không gian:** $O(N + W^2)$ để lưu chuỗi kết quả.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `"I speak Goat"`
1. **Word 1 ("I"):** Starts with vowel 'I'.
   - Result: `"I" + "ma" + "a" = "Imaa"`
2. **Word 2 ("speak"):** Starts with consonant 's'.
   - Result: `"peak" + "s" + "ma" + "aa" = "peaksmaaa"`
3. **Word 3 ("Goat"):** Starts with consonant 'G'.
   - Result: `"oat" + "G" + "ma" + "aaa" = "oatGmaaaa"`
**Final:** `"Imaa peaksmaaa oatGmaaaa"`

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Using `StringBuilder` for both the result and the growing suffix 'a' is important for efficiency. Splitting the string first makes the word-level logic cleaner and easier to manage.
*Sử dụng `StringBuilder` cho cả kết quả và phần hậu tố 'a' là quan trọng để đạt hiệu quả cao. Việc tách chuỗi trước tiên giúp logic cấp từ sạch sẽ và dễ quản lý hơn.*
