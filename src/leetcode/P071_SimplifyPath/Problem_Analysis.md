# 71. Simplify Path / Đơn Giản Hóa Đường Dẫn

## Problem Description / Mô tả bài toán
Given a string `path`, which is an **absolute path** (starting with a slash `'/'`) to a file or directory in a Unix-style file system, convert it to the simplified **canonical path**.
Cho một chuỗi `path`, là một **đường dẫn tuyệt đối** (bắt đầu bằng dấu gạch chéo `'/'`) tới một tệp hoặc thư mục trong hệ thống tệp kiểu Unix, hãy chuyển đổi nó thành **đường dẫn chính tắc** được đơn giản hóa.

In a Unix-style file system, a period `'.'` refers to the current directory, a double period `'..'` refers to the directory up a level, and any multiple consecutive slashes (i.e. `'//'`) are treated as a single slash `'/'`.
Trong hệ thống tệp kiểu Unix, dấu chấm `'.'` đề cập đến thư mục hiện tại, dấu chấm kép `'..'` đề cập đến thư mục lên một cấp, và bất kỳ dấu gạch chéo liên tiếp nào (tức là `'//'`) đều được coi là một dấu gạch chéo đơn `'/'`.

The canonical path should have the following format:
- The path starts with a single slash `'/'`.
- Any two directories are separated by a single slash `'/'`.
- The path does not end with a trailing `'/'`.
- The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period `'.'` or double period `'..'`).

### Example 1:
```text
Input: path = "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.
```

### Example 2:
```text
Input: path = "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
```

### Example 3:
```text
Input: path = "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
```

## Constraints / Ràng buộc
- `1 <= path.length <= 3000`
- `path` consists of English letters, digits, period `'.'`, slash `'/'` or `'_'`.
- `path` is a valid absolute Unix path.

---

## Analysis / Phân tích

### Approach: Stack / Ngăn Xếp
- **Idea**: Split the path by `'/'` and process each component.
- **Ý tưởng**: Tách đường dẫn bằng `'/'` và xử lý từng thành phần.
- **Logic**:
    - Split input string by `/`.
    - Iterate through tokens:
        - If token is `""` (caused by `//`) or `"."`: Ignore.
        - If token is `".."`: Pop from stack (if stack is not empty).
        - Else: Push to stack.
    - Reconstruct path joining elements with `/`. Handle empty stack -> `/`.
- **Time Complexity**: O(n).
- **Space Complexity**: O(n).

---

## Edge Cases / Các trường hợp biên
1.  **Root Pop**: `/../` -> `/`. Stack empty pop does nothing.
2.  **Multiple Slashes**: `//` -> ignored.
3.  **Root Only**: `/` -> `/`.
4.  **Complex**: `/a/./b/../../c/` -> `/c`.
