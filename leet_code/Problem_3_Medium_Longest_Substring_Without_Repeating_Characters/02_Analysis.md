# Analysis for Longest Substring Without Repeating Characters
# *Phân tích cho bài toán Chuỗi Con Dài Nhất Không Lặp Lại Ký Tự*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** String `s`. *Chuỗi `s`.*
*   **Output:** An integer representing the maximum length. *Một số nguyên đại diện cho độ dài tối đa.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `s.length` up to $50,000$. An $O(N^2)$ solution (checking all substrings) would do $\approx 25 \times 10^8$ operations, which is too slow (TLE).
    *Độ dài `s` lên tới $50,000$. Giải pháp $O(N^2)$ (kiểm tra tất cả chuỗi con) sẽ thực hiện xấp xỉ $25 \times 10^8$ phép tính, quá chậm (TLE).*
*   We need an $O(N)$ solution. *Chúng ta cần giải pháp $O(N)$.*
*   Character set: Letters, digits, symbols, spaces. ASCII or extended ASCII (0-127 or 0-255).
    *Bộ ký tự: Chữ cái, số, ký hiệu, khoảng trắng. ASCII hoặc ASCII mở rộng (0-127 hoặc 0-255).*

### Edge Cases
### *Các trường hợp biên*
*   Empty string (`""`): Return 0. *Chuỗi rỗng: Trả về 0.*
*   Single character (`" "`): Return 1. *Một ký tự: Trả về 1.*
*   All same characters (`"aaaa"`): Return 1. *Tất cả ký tự giống nhau: Trả về 1.*

## 2. Data Structure Strategy
## *2. Chiến lược Cấu trúc Dữ liệu*

*   We need to keep track of characters inside the current window.
    *Chúng ta cần theo dõi các ký tự bên trong cửa sổ hiện tại.*
*   Instead of a full Hash Map (`Map<Character, Integer>`), we can use a simple **integer array** of size 128 (standard ASCII) or 256.
    *Thay vì dùng Bảng Băm đầy đủ, chúng ta có thể dùng một **mảng số nguyên** đơn giản kích thước 128 (ASCII chuẩn) hoặc 256.*
*   `index[c]` stores the *last seen index* of character `c`.
    *`index[c]` lưu trữ *chỉ số xuất hiện cuối cùng* của ký tự `c`.*

## 3. Approach & Algorithm
## *3. Giải thuật & Hướng tiếp cận*

### Approach: Sliding Window (Optimal)
### *Hướng tiếp cận: Cửa sổ trượt (Tối ưu)*

*   **Intuition:** Maintain a window `[left, right]` containing unique characters. Extend `right`. If `s[right]` is already in the window, shrink `left` just past the previous occurrence of `s[right]`.
    *Ý tưởng: Duy trì một cửa sổ `[left, right]` chứa các ký tự duy nhất. Mở rộng `right`. Nếu `s[right]` đã có trong cửa sổ, thu hẹp `left` vượt qua lần xuất hiện trước đó của `s[right]`.*
*   **Algorithm Steps:**
    1.  Initialize `left = 0`, `maxLength = 0`.
    2.  Init `lastSeen` array with `-1`. *Khởi tạo mảng `lastSeen` với `-1`.*
    3.  Iterate `right` from `0` to `n-1`:
        *   `char c = s.charAt(right)`.
        *   If `lastSeen[c]` is $\ge$ `left`, move `left` to `lastSeen[c] + 1`. This effectively skips the duplicate.
            *Nếu `lastSeen[c]` $\ge$ `left`, di chuyển `left` đến `lastSeen[c] + 1`. Điều này bỏ qua phần tử trùng lặp một cách hiệu quả.*
        *   Update `lastSeen[c] = right`. *Cập nhật `lastSeen[c] = right`.*
        *   Update `maxLength = max(maxLength, right - left + 1)`.
    4.  Return `maxLength`.
*   **Complexity:**
    *   Time: $O(N)$. Each char touched once. *Thời gian: $O(N)$. Mỗi ký tự được chạm một lần.*
    *   Space: $O(1)$ (Array size is fixed 128). *Không gian: $O(1)$ (Kích thước mảng cố định 128).*

### Dry Run
### *Chạy thử*
String `s = "abcabcbb"`
1.  `r=0, 'a'`: `lastSeen['a']=-1`. `left=0`. `len=1`. `lastSeen['a']=0`.
2.  `r=1, 'b'`: `lastSeen['b']=-1`. `left=0`. `len=2`. `lastSeen['b']=1`.
3.  `r=2, 'c'`: `lastSeen['c']=-1`. `left=0`. `len=3`. `lastSeen['c']=2`.
4.  `r=3, 'a'`: `lastSeen['a']=0 >= left(0)`. **Duplicate!** Set `left = 0 + 1 = 1`. `len=max(3, 3-1+1)=3`. `lastSeen['a']=3`. Window is now "bca".
5.  ...and so on.
