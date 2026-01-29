# 588. Design In-Memory File System / Thiết Kế Hệ Thống Tệp Trong Bộ Nhớ

## Problem Description / Mô tả bài toán
Design a data structure that simulates an in-memory file system.
Thiết kế một cấu trúc dữ liệu mô phỏng hệ thống tệp trong bộ nhớ.

Implement the `FileSystem` class:
- `FileSystem()` Initializes the object of the system.
- `List<String> ls(String path)`
  - If `path` is a file path, returns a list that only contains this file's name.
  - If `path` is a directory path, returns the list of file and directory names in this directory.
  - The answer should in **lexicographical order**.
- `void mkdir(String path)` Makes a new directory according to the given `path`. The given directory path does not exist. If the middle directories in the path do not exist, you should create them as well.
- `void addContentToFile(String filePath, String content)`
  - If `filePath` does not exist, creates that file containing given `content`.
  - If `filePath` already exists, appends the given `content` to original content.
- `String readContentFromFile(String filePath)` Returns the content in the file at `filePath`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Trie / Tree Structure / Cấu trúc Trie / Cây
We treat the file system as a Tree where each node is a file or directory.
`Node` class:
- `boolean isFile`
- `Map<String, Node> children`
- `String content` (if file)
- `String name`

Operations:
- **ls**: Traverse to node.
  - If file, return `[name]`.
  - If dir, return `sorted(children.keySet())`.
- **mkdir**: Traverse/Create path. Split path by `/`.
- **addContent**: Traverse/Create path. Append content. Mark as file.
- **readContent**: Traverse to node. Return content.

### Complexity / Độ phức tạp
- **Time**: O(L) where L is path length (depth).
- **Space**: O(Total Content + Tree Structure).

---

## Analysis / Phân tích

### Approach: Directory Tree Simulation

**Algorithm**:
1.  Define FileNode class (dirs map, content string).
2.  Implement `ls`: navigate and list keys or return single file.
3.  Implement `mkdir`: navigate and create missing nodes.
4.  Implement `addContent`: navigate, set flag, append string.
5.  Implement `readContent`: navigate and return string.

---
