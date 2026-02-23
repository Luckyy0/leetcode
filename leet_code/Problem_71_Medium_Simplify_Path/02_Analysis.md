# Analysis for Simplify Path
# *Phân tích cho bài toán Rút Gọn Đường Dẫn*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Absolute path string `path`. *Chuỗi đường dẫn tuyệt đối `path`.*
*   **Output:** Simplified canonical path string. *Chuỗi đường dẫn chính tắc rút gọn.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Path length up to 3000.
*   Must handle `.` (current), `..` (up), and `//` (extra slashes).
*   Root stays at `/` even if we go up.
*   No trailing slash unless it's the root.
*   *Độ dài đường dẫn lên tới 3000.*
*   *Phải xử lý `.` (hiện tại), `..` (lên trên), và `//` (dấu gạch chéo thừa).*
*   *Gốc vẫn là `/` ngay cả khi chúng ta đi lên.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Using a Stack
### *Hướng tiếp cận: Sử dụng Ngăn xếp*

*   **Intuition:** We can split the path by the delimiter `/`. Each component between slashes can be a directory name, `.`, `..`, or empty string (caused by `//`).
*   *Ý tưởng: Chúng ta có thể chia đường dẫn theo dấu phân cách `/`. Mỗi thành phần giữa các dấu gạch chéo có thể là tên thư mục, `.`, `..`, hoặc chuỗi rỗng (do `//` gây ra).*

*   **Algorithm Steps:**
    1.  Split the input `path` by `/`.
    2.  Initialize a `Stack` (or `Deque`) to store directory names.
    3.  Iterate through each component:
        *   If component is `.` or empty string, ignore it.
        *   If component is `..`, pop from the stack if it's not empty.
        *   Else, it's a valid directory name, push it onto the stack.
    4.  Construct the result string by joining stack elements with `/`, starting with a `/`.
    5.  Handle empty stack by returning `/`.

*   **Complexity:**
    *   Time: $O(N)$ where $N$ is length of path.
    *   Space: $O(N)$ to store split components and stack.

### Dry Run
### *Chạy thử*
`path = "/home//foo/../bar/"`
1. Split: `["", "home", "", "foo", "..", "bar", ""]`
2. Iteration:
   - `""`: skip.
   - `"home"`: stack = `["home"]`.
   - `""`: skip.
   - `"foo"`: stack = `["home", "foo"]`.
   - `".."`: pop -> stack = `["home"]`.
   - `"bar"`: stack = `["home", "bar"]`.
   - `""`: skip.
3. Result: `"/home/bar"`.
---
*Việc sử dụng Stack giúp mô phỏng việc di chuyển giữa các thư mục một cách tự nhiên.*
Using a Stack helps simulate moving between directories naturally.
