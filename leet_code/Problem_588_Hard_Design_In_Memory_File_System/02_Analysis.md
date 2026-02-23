# Analysis for Design In-Memory File System
# *Phân tích cho bài toán Thiết kế Hệ thống Tệp tin trong Bộ nhớ*

## 1. Problem Essence & Hierarchical Data Representation
## *1. Bản chất vấn đề & Đại diện Dữ liệu Phân cấp*

### The Challenge
### *Thách thức*
We need to model a hierarchical file system where directories contain other directories or files, and files contain string data.
*Chúng ta cần mô hình hóa một hệ thống tệp tin phân cấp, trong đó các thư mục chứa các thư mục khác hoặc các tệp tin, và các tệp tin chứa dữ liệu chuỗi.*

The primary obstacle is efficiently navigating paths (e.g., `/a/b/c`) and handling the dual nature of nodes (Files vs. Directories).
*Trở ngại chính là việc điều hướng các đường dẫn một cách hiệu quả (ví dụ: `/a/b/c`) và xử lý bản chất kép của các nút (Tệp tin và Thư mục).*

---

## 2. Strategy: Trie-based Node Structure
## *2. Chiến lược: Cấu trúc Nút dựa trên Trie*

A file system is naturally a **Trie (Prefix Tree)** where each level of the path represents a depth in the tree.
*Một hệ thống tệp tin tự nhiên là một **Trie (Cây tiền tố)**, trong đó mỗi cấp độ của đường dẫn đại diện cho một độ sâu trong cây.*

### Object-Oriented Design
### *Thiết kế Hướng đối tượng*

1.  **Node Class:** Define a class (e.g., `Node`) to represent both files and directories.
    * **Lớp Node:** Định nghĩa một lớp (ví dụ: `Node`) để đại diện cho cả tệp tin và thư mục.*
    - `Map<String, Node> children`: For directories, to store sub-entries.
    - *`Map<String, Node> children`: Đối với thư mục, để lưu trữ các mục nhập con.*
    - `StringBuilder content`: For files, to store the text.
    - *`StringBuilder content`: Đối với tệp tin, để lưu trữ văn bản.*
    - `boolean isFile`: A flag to distinguish between types.
    - *`boolean isFile`: Một cờ để phân biệt giữa các loại.*

### Functional Logic
### *Logic Chức năng*

1.  **Path Navigation:** Create a helper method to traverse the tree using a path split by `/`.
    * **Điều hướng Đường dẫn:** Tạo một phương thức bổ trợ để duyệt cây bằng cách sử dụng đường dẫn được chia tách bởi `/`.*
2.  **`ls` Logic:** If the target is a file, return its name. If a directory, return sorted keys of its `children`.
    * **Logic `ls`:** Nếu mục tiêu là tệp, trả về tên của nó. Nếu là thư mục, trả về các khóa đã sắp xếp của `children`.*
3.  **`mkdir` Logic:** Traverse the path level by level, creating new `Node` objects for any missing directories.
    * **Logic `mkdir`:** Duyệt qua các cấp độ đường dẫn, tạo các đối tượng `Node` mới cho bất kỳ thư mục nào còn thiếu.*
4.  **`addContent` Logic:** Navigate to the path, create the node if missing (as a file), and append to the `StringBuilder`.
    * **Logic `addContent`:** Điều hướng đến đường dẫn, tạo nút nếu thiếu (dưới dạng tệp) và nối vào `StringBuilder`.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Unified Model:** Using the same `Node` class for both files and folders simplifies the traversal logic.
    * **Mô hình Thống nhất:** Việc sử dụng cùng một lớp `Node` cho cả tệp và thư mục giúp đơn giản hóa logic duyệt cây.*
*   **Path Splitting:** Be careful with the root `/`. Splitting `/a/b` by `/` often yields an empty string as the first element in many languages (like Java), which should be handled or skipped.
    * **Chia tách Đường dẫn:** Hãy cẩn thận với thư mục gốc `/`. Việc chia tách `/a/b` theo dấu `/` thường tạo ra một chuỗi rỗng làm phần tử đầu tiên trong nhiều ngôn ngữ (như Java), điều này cần được xử lý hoặc bỏ qua.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:**
    *   `ls`: $O(L + K \log K)$ where $L$ is path length and $K$ is number of items in the directory.
    *   `mkdir` / `addContent`: $O(L)$ to traverse the depth.
    *   `readContent`: $O(L + S)$ where $S$ is the content size.
    * *Độ phức tạp thời gian: `ls` tốn $O(L + K \log K)$, `mkdir`/`addContent` tốn $O(L)$, `readContent` tốn $O(L + S)$.*
*   **Space Complexity:** $O(\text{Total names} + \text{Total content})$. We store everything in memory.
    * **Độ phức tạp không gian:** $O(\text{Tổng tên} + \text{Tổng nội dung})$. Chúng ta lưu trữ mọi thứ trong bộ nhớ.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Operation:** `mkdir("/a/b")`
1. Root Map: check "a". Not exists. Create Node("a").
2. Node "a" Map: check "b". Not exists. Create Node("b").
**Operation:** `addContentToFile("/a/b/c", "hello")`
1. Navigate to Node "b".
2. Check "c". Not exists. Create Node("c", isFile=true).
3. "c".content.append("hello").

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Treat hierarchical structures as trees where path segments are edge labels. String manipulation and Map lookups are the primary tools for such designs.
*Hãy coi các cấu trúc phân cấp như những cái cây nơi các phân đoạn đường dẫn là nhãn cạnh. Thao tác chuỗi và tra cứu Map là những công cụ chính cho những thiết kế như vậy.*
---
*Hệ thống tệp tin (File System) là sự phản chiếu của tư duy trật tự. Mọi dữ liệu (Content) đều cần một địa chỉ (Path) để trú ngụ, và mọi địa chỉ đều bắt đầu từ một gốc rễ (Root) duy nhất. Sự phân cấp (Hierarchy) giúp ta quản lý sự phức tạp, biến biển thông tin vô tận thành những ngăn tủ (Directories) tinh tươm.*
The File System (File System) is a reflection of orderly thinking. Every piece of data (Content) needs an address (Path) to reside, and every address starts from a single root (Root). Hierarchy helps us manage complexity, turning an endless sea of information into neat compartments (Directories).
