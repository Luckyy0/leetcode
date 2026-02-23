# Analysis for Buddy Strings
# *Phân tích cho bài toán Chuỗi Bạn bè*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
We need to determine if swapping **exactly two** characters in string `s` can result in `goal`. Note that you *must* perform a swap, even if `s` is already equal to `goal`.
*Chúng ta cần xác định xem việc tráo đổi **đúng hai** ký tự trong chuỗi `s` có thể tạo ra `goal` hay không. Lưu ý rằng bạn *phải* thực hiện một phép tráo đổi, ngay cả khi `s` đã bằng `goal`.*

---

## 2. Strategy: Case-by-Case Check
## *2. Chiến lược: Kiểm tra theo từng trường hợp*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Length Check:** If `s.length() != goal.length()`, return `false`.
    *   **Kiểm tra độ dài:** Nếu `s.length() != goal.length()`, trả về `false`.*

2.  **Case 1: `s` equals `goal`**
    - To satisfy the "exactly one swap" rule, there must be at least one character in `s` that appears at least twice (e.g., swapping 'a' with 'a' in "aa" results in "aa").
    - Use a Set or count array to check for duplicates.
    *   **Trường hợp 1: `s` bằng `goal`** Để thỏa mãn quy tắc "đúng một phép tráo đổi", phải có ít nhất một ký tự trong `s` xuất hiện ít nhất hai lần (ví dụ: tráo 'a' với 'a' trong "aa" vẫn được "aa"). Sử dụng Set hoặc mảng đếm để kiểm tra các ký tự bị trùng.*

3.  **Case 2: `s` does not equal `goal`**
    - Traverse the strings and collect the indices where `s[i] != goal[i]`.
    - If there are exactly **two** such indices (`i` and `j`):
        - Check if `s[i] == goal[j]` and `s[j] == goal[i]`.
    - If there is any other number of mismatches (1, 3, 4...), return `false`.
    *   **Trường hợp 2: `s` không bằng `goal`** Duyệt qua các chuỗi và thu thập các chỉ số mà `s[i] != goal[i]`. Nếu có đúng **hai** chỉ số như vậy (`i` và `j`): Kiểm tra xem `s[i] == goal[j]` và `s[j] == goal[i]` hay không. Nếu có bất kỳ số lượng sai lệch nào khác (1, 3, 4...), trả về `false`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public boolean buddyStrings(String s, String goal) {
    if (s.length() != goal.length()) return false;
    
    if (s.equals(goal)) {
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            if (++count[ch - 'a'] > 1) return true;
        }
        return false;
    }
    
    List<Integer> diffs = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) != goal.charAt(i)) diffs.add(i);
    }
    
    return diffs.size() == 2 && 
           s.charAt(diffs.get(0)) == goal.charAt(diffs.get(1)) &&
           s.charAt(diffs.get(1)) == goal.charAt(diffs.get(0));
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the length of the strings. We traverse the strings a constant number of times.
    *   **Độ phức tạp thời gian:** $O(N)$, vì chúng ta duyệt qua các chuỗi một số lần không đổi.*
*   **Space Complexity:** $O(1)$ if we consider the constant alphabet size (26) or ignore the diff list of size 2.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Understanding the "must swap" requirement for equal strings is the most common mistake.
*Hiểu yêu cầu "phải tráo đổi" đối với các chuỗi bằng nhau là lỗi phổ biến nhất.*
