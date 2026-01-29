# 1166. Design File System / Thiết kế Hệ thống Tập tin

## Problem Description / Mô tả bài toán
Design a data structure that simulates an in-memory file system.
`createPath(path, value)`: Creates a new path and associates a value to it if possible and returns true. Returns false if the path already exists or its parent path doesn't exist.
`get(path)`: Returns the value associated with `path` or -1 if the path doesn't exist.
Paths start with "/" and do not have trailing "/".

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Trie or HashMap / Cây Tiền tố (Trie) hoặc HashMap
HashMap approach:
- Store `path -> value`.
- To create `/a/b`, check if `/a` exists (if path is not root).
- If `/a` exists and `/a/b` not, put `/a/b`.
- Fast lookups.
- Parent path string logic: `path.substring(0, lastIndexOf('/'))`.
  - If parent is empty string (root level like `/a`), valid.
  - Or handle logic: `/a` has parent `/` (not in map usually) or parent is empty string (if valid).
  - Problem says "parent path doesn't exist" -> returns false.
  - For `/a`, parent is root. Root always exists basically?
  - Actually, `/a` can be created if parent is root.
  - `/a/b` needs `/a`.
  - So special case for top-level paths.

### Complexity / Độ phức tạp
- **Time**: O(L) where L is path length (string operation).
- **Space**: O(N * L).

---

## Analysis / Phân tích

### Approach: Hash Map with Parent Check
Use a HashMap to store paths and their values. When creating a path, verify that the parent path exists in the map (unless the path is a top-level directory like "/a"). If the path is valid and unique, store it. The `get` function simply retrieves the value from the map.
Sử dụng HashMap để lưu trữ đường dẫn và giá trị của chúng. Khi tạo đường dẫn, xác minh rằng đường dẫn cha tồn tại trong bản đồ (trừ khi đường dẫn là thư mục cấp cao nhất như "/a"). Nếu đường dẫn hợp lệ và duy nhất, hãy lưu trữ nó. Hàm `get` chỉ đơn giản là lấy giá trị từ bản đồ.

---
