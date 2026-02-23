# Result for Design In-Memory File System
# *Kết quả cho bài toán Thiết kế Hệ thống Tệp tin trong Bộ nhớ*

## Description
## *Mô tả*

Design a data structure that simulates an in-memory file system.
*Thiết kế một cấu trúc dữ liệu mô phỏng một hệ thống tệp tin trong bộ nhớ.*

Implement the FileSystem class:
*Triển khai lớp FileSystem:*

*   `FileSystem()` Initializes the object of the system.
    *   *`FileSystem()` Khởi tạo đối tượng của hệ thống.*
*   `List<String> ls(String path)`
    *   If `path` is a file path, returns a list that only contains this file's name.
    *   If `path` is a directory path, returns the list of file and directory names in this directory. 
    *   The answer should in **lexicographical order**.
    *   *Nếu `path` là đường dẫn tệp, trả về danh sách chỉ chứa tên tệp này. Nếu là đường dẫn thư mục, trả về danh sách tên tệp và thư mục trong đó, sắp xếp theo thứ tự từ điển.*
*   `void mkdir(String path)` Makes a new directory according to given path. The given directory path does not exist. If the middle directories in the path do not exist, you should create them as well.
    *   *`void mkdir(String path)` Tạo thư mục mới theo đường dẫn đã cho. Nếu các thư mục trung gian không tồn tại, bạn cũng phải tạo chúng.*
*   `void addContentToFile(String filePath, String content)`
    *   If `filePath` does not exist, creates that file with given `content`.
    *   If `filePath` already exists, appends the given `content` to original content.
    *   *`void addContentToFile(...)` Nếu tệp không tồn tại, tạo tệp với nội dung đã cho. Nếu đã tồn tại, nối nội dung mới vào nội dung cũ.*
*   `String readContentFromFile(String filePath)` Returns the content in the file at `filePath`.
    *   *`String readContentFromFile(String filePath)` Trả về nội dung của tệp tại đường dẫn đã cho.*

---

## Constraints:
## *Ràng buộc:*

*   `1 <= path.length, filePath.length <= 100`
*   `path` and `filePath` are absolute paths starting with `'/'` and do not end with `'/'`.
*   Directories and file names only contain lowercase English letters.
*   The total number of calls to the functions is at most `300`.
