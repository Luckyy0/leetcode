# 609. Find Duplicate File in System / Tìm Tệp Trùng Lặp Trong Hệ Thống

## Problem Description / Mô tả bài toán
Given a list of directory info including directory path, and all the files with contents in this directory, you need to find out all the groups of duplicate files in the file system in terms of their **content**.
Cho một danh sách thông tin thư mục bao gồm đường dẫn thư mục và tất cả các tệp có nội dung trong thư mục này, bạn cần tìm ra tất cả các nhóm tệp trùng lặp trong hệ thống tệp về mặt **nội dung** của chúng.

A group of duplicate files consists of at least **two** files that have the same content.
Một nhóm các tệp trùng lặp bao gồm ít nhất **hai** tệp có cùng nội dung.

A single directory info string in the input list has the following format:
`"root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"`
Một chuỗi thông tin thư mục đơn trong danh sách đầu vào có định dạng sau:
`"root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"`

It means there are n files (`f1.txt`, `f2.txt` ... `fn.txt`) with respective content (`f1_content`, `f2_content` ... `fn_content`) in directory `root/d1/d2/.../dm`. Note that n >= 1 and m >= 0.
Nó có nghĩa là có n tệp (`f1.txt`, `f2.txt` ... `fn.txt`) với nội dung tương ứng (`f1_content`, `f2_content` ... `fn_content`) trong thư mục `root/d1/d2/.../dm`. Lưu ý rằng n >= 1 và m >= 0.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### HashMap Grouping / Nhóm HashMap
We need to map `Content -> List of File Paths`.
1. Iterate through input strings.
2. Split string to get directory path and files.
3. For each file part:
   - Extract filename.
   - Extract content (between '(' and ')').
   - Full Path = `Directory + "/" + Filename`.
   - Add to Map: `Map<String, List<String>>`. Key is content.
4. Iterate Map values. Return lists with size > 1.

### Complexity / Độ phức tạp
- **Time**: O(N * S) where N is number of files, S is avg content size (due to string hashing/copying).
- **Space**: O(N * S).

---

## Analysis / Phân tích

### Approach: Content Hashing

**Algorithm**:
1.  Parse input strings to extract path and files.
2.  For each file, extract content string.
3.  Store full paths in a map keyed by content.
4.  Filter map values to return duplicate groups.

---
