# Result for Find Duplicate File in System
# *Kết quả cho bài toán Tìm Tệp trùng lặp trong Hệ thống*

## Description
## *Mô tả*

Given a list of directory info `paths` including directory path, and all the files with contents in this directory, return all the groups of duplicate files in the file system in terms of their paths. You may return the answer in **any order**.
*Cho một danh sách thông tin thư mục `paths` bao gồm đường dẫn thư mục, và tất cả các tệp với nội dung trong thư mục này, hãy trả về tất cả các nhóm tệp trùng lặp trong hệ thống tệp theo đường dẫn của chúng. Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.*

A group of duplicate files consists of at least two files that have the same content.
*Một nhóm tệp trùng lặp bao gồm ít nhất hai tệp có cùng nội dung.*

A single directory info string in the input list has the following format:
*Một chuỗi thông tin thư mục duy nhất trong danh sách đầu vào có định dạng sau:*

`"root/d1/d2/.../dm f1.txt(abcd) f2.txt(efgh) ... fn.txt(ijkl)"`

It means there are `n` files `(f1.txt, f2.txt ... fn.txt)` with content `(abcd, efgh ... ijkl)` respectively in the directory `root/d1/d2/.../dm`. Note that `n >= 1`. The output is a list of groups of duplicate file paths. For each group, it contains all the file paths of the files that have the same content. A file path is a string that has the following format:
`"directory_path/file_name.txt"`
*Nó có nghĩa là có `n` tệp với nội dung tương ứng trong thư mục đó. Đầu ra là một danh sách các nhóm đường dẫn tệp trùng lặp. Đối với mỗi nhóm, nó chứa tất cả các đường dẫn tệp của các tệp có cùng nội dung. Một đường dẫn tệp là một chuỗi có định dạng: `"đường_dẫn_thư_mục/tên_tệp.txt"`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** paths = ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(gjstrm)"]
**Output:** [["root/a/1.txt","root/c/3.txt"],["root/a/2.txt","root/c/d/4.txt"]]

## Example 2:
## *Ví dụ 2:*

**Input:** paths = ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)"]
**Output:** [["root/a/1.txt","root/c/3.txt"],["root/a/2.txt","root/c/d/4.txt"]]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= paths.length <= 2 * 10^4`
*   `1 <= paths[i].length <= 3000`
*   `1 <= sum(paths[i].length) <= 5 * 10^5`
*   `paths[i]` consist of English letters, digits, `'/'`, `'.'`, `'('`, `')'`, and `' '`.
*   You may assume no organization will kind of create a directory name or file name with some parenthesis or others which can be confused with the format content.
