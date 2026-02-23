# Analysis for Guess the Word
# *Phân tích cho bài toán Đoán Từ*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find a secret 6-letter word from a list of up to 100 words in at most 10 attempts. Each "guess" gives the number of characters that match the secret word in both index and value.
*Tìm một từ bí mật dài 6 ký tự trong danh sách tối đa 100 từ trong không quá 10 lần thử. Mỗi lần "đoán" cho biết số lượng ký tự khớp với từ bí mật ở cả vị trí và giá trị.*

### KEY LOGIC
### *Logic chính*
The secret word is consistent. If guessing "ABCDEF" returns `X` matches with the secret, then the secret word **must** also have exactly `X` matches with "ABCDEF". Any word in our list that does NOT have exactly `X` matches with "ABCDEF" cannot be the secret word.
*Từ bí mật là bất biến. Nếu việc đoán "ABCDEF" trả về `X` điểm khớp, thì từ bí mật **chắc chắn** cũng phải có đúng `X` điểm khớp với "ABCDEF". Bất kỳ từ nào trong danh sách KHÔNG có đúng `X` điểm khớp với "ABCDEF" đều không thể là từ bí mật.*

---

## 2. Strategy: Heuristic Refinement
## *2. Chiến lược: Tinh lọc theo phương pháp Heuristic*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Selection Strategy:** How to pick the next word to guess?
    - **Random:** Surprisingly effective, as it avoids worst-case scenarios on average.
    - **Minimax:** Pick a word that minimizes the maximum possible size of the remaining candidates.
    - **Frequency-based:** Pick the word that is "most similar" to other candidates to maximize information gain.
    *   **Chiến lược lựa chọn:** Làm sao để chọn từ tiếp theo để đoán? Ngẫu nhiên cũng khá hiệu quả, hoặc dùng Minimax để thu hẹp tập ứng viên một cách tối ưu nhất.*

2.  **Refinement Loop:**
    - Pick a word `guessWord` from the current candidate list `L`.
    - Call `matches = master.guess(guessWord)`.
    - If `matches == 6`: Success!
    - Create a new candidate list `L_next` containing all words in `L` that have exactly `matches` character matches with `guessWord`.
    - Set `L = L_next` and repeat.
    *   **Vòng lặp tinh lọc:** Chọn một từ `guessWord` từ danh sách `L`. Gọi `master.guess`. Nếu khớp 6, thành công. Tạo danh sách `L_next` mới chứa các từ có đúng `matches` điểm khớp với `guessWord`. Cập nhật `L` và lặp lại.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public void findSecretWord(String[] wordlist, Master master) {
    List<String> list = new ArrayList<>(Arrays.asList(wordlist));
    for (int i = 0; i < 10; i++) {
        // Simple random pick to avoid targeted test cases
        String guessWord = list.get(new Random().nextInt(list.size()));
        int matches = master.guess(guessWord);
        if (matches == 6) return;
        
        List<String> nextList = new ArrayList<>();
        for (String w : list) {
            if (getMatches(w, guessWord) == matches) {
                nextList.add(w);
            }
        }
        list = nextList;
    }
}

private int getMatches(String a, String b) {
    int count = 0;
    for (int i = 0; i < 6; i++) {
        if (a.charAt(i) == b.charAt(i)) count++;
    }
    return count;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(G \cdot N \cdot L)$, where $G=10$ (guesses), $N=100$ (words), and $L=6$ (length). This is constant time given the constraints.
    *   **Độ phức tạp thời gian:** $O(G \cdot N \cdot L)$, cực kỳ nhanh trong giới hạn cho phép.*
*   **Space Complexity:** $O(N)$ to store the candidate word list.
    *   **Độ phức tạp không gian:** $O(N)$ để lưu danh sách ứng viên.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Randomizing the guess selection is a powerful technique to prevent deterministic "worst-case" inputs from causing failure within the guess limit.
*Việc ngẫu nhiên hóa lựa chọn từ đoán là một kỹ thuật mạnh mẽ để ngăn các trường hợp "xấu nhất" có tính chất định sẵn làm cho thuật toán thất bại trong số lượt cho phép.*
