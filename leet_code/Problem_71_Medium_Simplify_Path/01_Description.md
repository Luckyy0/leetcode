# Result for Simplify Path
# *Kết quả cho bài toán Rút Gọn Đường Dẫn*

## Description
## *Mô tả*

Given an absolute path for a Unix-style file system, which begins with a slash `'/'`, transform this path into its **simplified canonical path**.
*Cho một đường dẫn tuyệt đối cho hệ thống tệp kiểu Unix, bắt đầu bằng dấu gạch chéo `'/'`, hãy chuyển đổi đường dẫn này thành **đường dẫn chính tắc rút gọn** của nó.*

In a Unix-style file system:
*   A period `'.'` refers to the current directory.
*   A double period `'..'` refers to the directory up a level.
*   Any multiple consecutive slashes (i.e. `'//'`) are treated as a single slash `'/'`.
*   Any other format of periods such as `'...'` are treated as file/directory names.

The **canonical path** should have the following format:
*   The path starts with a single slash `'/'`.
*   Any two directories are separated by a single slash `'/'`.
*   The path does not end with a trailing `'/'`.
*   The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period `'.'` or double period `'..'`)

Return the simplified canonical path.
*Trả về đường dẫn chính tắc đã rút gọn.*

## Example 1:
## *Ví dụ 1:*

**Input:** `path = "/home/"`
**Output:** `"/home"`
**Explanation:** Note that there is no trailing slash after the last directory name.

## Example 2:
## *Ví dụ 2:*

**Input:** `path = "/../"`
**Output:** `"/"`
**Explanation:** Going one level up from the root directory is a no-op, as the root level is the highest level you can go.

## Example 3:
## *Ví dụ 3:*

**Input:** `path = "/home//foo/"`
**Output:** `"/home/foo"`
**Explanation:** In the canonical path, multiple consecutive slashes are replaced by a single one.

## Constraints:
## *Ràng buộc:*

*   `1 <= path.length <= 3000`
*   `path` consists of English letters, digits, periods `'.'`, slashes `'/'` or `'_'`.
*   `path` is a valid absolute Unix path.
