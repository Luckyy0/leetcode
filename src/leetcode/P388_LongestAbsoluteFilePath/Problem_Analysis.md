# 388. Longest Absolute File Path / Đường Dẫn Tệp Tuyệt Đối Dài Nhất

## Problem Description / Mô tả bài toán
Suppose we have a file system that stores both files and directories. An example of one system is represented in the following picture...
Giả sử chúng ta có một hệ thống tệp...

The string `"dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"` represents:
```
dir
    subdir1
    subdir2
        file.ext
```

The directory `dir` contains an empty sub-directory `subdir1` and a sub-directory `subdir2` containing a file `file.ext`.

Given a string `input` representing the file system in the explained format, return the length of the **longest absolute path** to a **file** in the abstracted file system. If there is no file in the system, return `0`.

### Example 1:
```text
Input: input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"
Output: 20
Explanation: We have only one file, and the absolute path is "dir/subdir2/file.ext" of length 20.
```

### Example 2:
```text
Input: input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
Output: 32
Explanation: We have two files:
"dir/subdir1/file1.ext" of length 21
"dir/subdir2/subsubdir2/file2.ext" of length 32.
We return 32.
```

## Constraints / Ràng buộc
- `1 <= input.length <= 10^4`
- `input` may contain lowercase or uppercase English letters, a new line character `'\n'`, a tab character `'\t'`, a dot `'.'`, a space `' '`, and digits.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Stack / HashMap for Path Lengths
Track path length at each depth.
- `\n` separates entries.
- Count `\t` to determine depth.
- `pathLen[depth] = pathLen[depth-1] + name.length()`.
- If file (contains `.`): Update max.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(D) (depth).

---

## Analysis / Phân tích

### Approach: HashMap or Stack

**Algorithm**:
1.  Split by `\n`.
2.  Map/array `pathLen[depth]`. `pathLen[0] = 0`.
3.  For each part:
    - Count tabs = depth.
    - Name = `part.substring(tabs)`.
    - `pathLen[depth + 1] = pathLen[depth] + name.length() + 1` (for `/`).
    - If file: `max = max(max, pathLen[depth + 1] - 1)` (no trailing `/`).
4.  Return max.

---
