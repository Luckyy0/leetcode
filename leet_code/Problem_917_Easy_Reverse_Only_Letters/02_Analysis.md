# Analysis for Reverse Only Letters
# *Phân tích cho bài toán Đảo ngược Chỉ Các Chữ cái*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Reverse the order of letters in a string while keeping non-letters in their original positions.
*Đảo ngược thứ tự các chữ cái trong một chuỗi trong khi giữ nguyên vị trí của các ký tự không phải chữ cái.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- This is a classic **Two Pointer** problem.
- We have a pointer `left` at the start and `right` at the end.
- While `left < right`:
  - If `s[left]` is not a letter, increment `left`.
  - If `s[right]` is not a letter, decrement `right`.
  - If both are letters, swap them and move both pointers inward.
*Đây là bài toán **Hai Con Trỏ** kinh điển. Dùng `left` ở đầu và `right` ở cuối. Nếu `s[left]` không phải chữ, tăng `left`. Nếu `s[right]` không phải chữ, giảm `right`. Nếu cả hai là chữ, hoán đổi và di chuyển cả hai.*

---

## 2. Strategy: Two Pointers
## *2. Chiến lược: Hai Con Trỏ*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** Convert string to char array. `left = 0`, `right = n - 1`.
    *   **Khởi tạo:** Chuyển chuỗi thành mảng ký tự. `left` = 0, `right` = n - 1.*

2.  **Loop:** While `left < right`:
    - Move `left` forward until a letter is found.
    - Move `right` backward until a letter is found.
    - If `left < right`, swap `s[left]` and `s[right]`.
    - Increment `left`, decrement `right`.
    *   **Vòng lặp:** Di chuyển `left` tới chữ cái. Di chuyển `right` lùi về chữ cái. Hoán đổi nếu hợp lệ.*

3.  **Return:** New string from char array.
    *   **Trả về:** Chuỗi mới.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public String reverseOnlyLetters(String s) {
    char[] chars = s.toCharArray();
    int left = 0;
    int right = s.length() - 1;
    
    while (left < right) {
        if (!Character.isLetter(chars[left])) {
            left++;
        } else if (!Character.isLetter(chars[right])) {
            right--;
        } else {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
    
    return new String(chars);
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Single pass.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(N)$ for char array.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Standard two-pointer approach effectively skips non-target characters and swaps target characters.
*Phương pháp hai con trỏ tiêu chuẩn giúp bỏ qua các ký tự không mục tiêu và hoán đổi các ký tự mục tiêu một cách hiệu quả.*
