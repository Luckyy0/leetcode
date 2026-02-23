# Result for Longest Absolute File Path
# *Kết quả cho bài toán Đường dẫn Tệp Tuyệt đối Dài nhất*

## Description
## *Mô tả*

Suppose we represent our file system by a string in the following manner:
*Giả sử chúng ta đại diện cho hệ thống tệp của mình bằng một chuỗi theo cách sau:*

The string `"dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"` represents:
```
dir
    subdir1
    subdir2
        file.ext
```
The directory `dir` contains an empty sub-directory `subdir1` and a sub-directory `subdir2` containing a file `file.ext`.
The string `"dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"` represents:
```
dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
```
The directory `dir` contains two sub-directories `subdir1` and `subdir2`. `subdir1` contains a file `file1.ext` and an empty second-level sub-directory `subsubdir1`. `subdir2` contains a second-level sub-directory `subsubdir2` containing a file `file2.ext`.

We are interested in finding the longest (number of characters) absolute path to a **file** within our file system. For example, in the second example above, the longest absolute path is `"dir/subdir2/subsubdir2/file2.ext"`, and its length is `32` (not including the double quotes).

Return *the length of the longest absolute path to a **file** in the abstracted file system*. If there is no file in the system, return `0`.

## Example 1:
## *Ví dụ 1:*

**Input:** `input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"`
**Output:** `20`
**Explanation:** We have only one file, and the absolute path is "dir/subdir2/file.ext" of length 20.

## Example 2:
## *Ví dụ 2:*

**Input:** `input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"`
**Output:** `32`

## Constraints:
## *Ràng buộc:*

*   `1 <= input.length <= 10^4`
*   `input` may contain lowercase or uppercase English letters, a newline character `\n`, a tab character `\t`, a dot `.`, a space ` `, and digits.
*   All the file and directory names are guaranteed to be non-empty.
