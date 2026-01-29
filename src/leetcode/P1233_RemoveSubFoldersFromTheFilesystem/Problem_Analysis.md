# 1233. Remove Sub-Folders from the Filesystem / Xóa Thư mục con khỏi Hệ thống Tệp

## Problem Description / Mô tả bài toán
Given a list of folders, remove all sub-folders in those folders and return in any order.
A folder `/a/b` is a sub-folder of `/a`. `/a/b/c` is sub sub.
If `/a` and `/a/b` exist, remove `/a/b`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sorting / Trie
Approach 1: Sort strings.
If `folder[i]` starts with `folder[i-1] + "/"`, it's a sub-folder.
Sort ensures parent comes before children.
Approach 2: Trie. Insert paths. If node marks end of folder, assume children are invalid?
Usually simpler with sorting.

### Complexity / Độ phức tạp
- **Time**: O(N log N * L).
- **Space**: O(N * L).

---

## Analysis / Phân tích

### Approach: Sorting and filtering
Sort the folder paths lexicographically. This places parent folders immediately before their sub-folders (e.g., `/a`, `/a/b`, `/a/b/c`, `/b`). Iterate through the sorted list. Maintain the current "parent" folder. For each path, check if it starts with the current parent followed by a slash (`/`). If it does, it's a sub-folder; skip it. If not, it's a new parent; add it to the result and update the current parent.
Sắp xếp các đường dẫn thư mục theo thứ tự từ điển. Điều này đặt các thư mục cha ngay trước các thư mục con của chúng (ví dụ: `/a`, `/a/b`, `/a/b/c`, `/b`). Lặp qua danh sách đã sắp xếp. Duy trì thư mục "cha" hiện tại. Đối với mỗi đường dẫn, hãy kiểm tra xem nó có bắt đầu bằng cha hiện tại theo sau là dấu gạch chéo (`/`) hay không. Nếu có, đó là thư mục con; bỏ qua nó. Nếu không, đó là cha mới; thêm nó vào kết quả và cập nhật cha hiện tại.

---
