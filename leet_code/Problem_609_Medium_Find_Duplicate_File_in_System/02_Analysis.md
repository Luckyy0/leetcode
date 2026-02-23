# Analysis for Find Duplicate File in System
# *Phân tích cho bài toán Tìm Tệp trùng lặp trong Hệ thống*

## 1. Problem Essence & Grouping by Content
## *1. Bản chất vấn đề & Phân nhóm theo Nội dung*

### The Challenge
### *Thách thức*
We are given directory strings containing file names and their contents. The goal is to identify all sets of files that share the exact same content.
*Chúng ta được cung cấp các chuỗi thư mục chứa tên tệp và nội dung của chúng. Mục tiêu là xác định tất cả các tập hợp tệp có chung nội dung chính xác.*

This is a classic inverse mapping problem: instead of `Path -> Content`, we need `Content -> List of Paths`.
*Đây là một bài toán ánh xạ ngược kinh điển: thay vì `Đường dẫn -> Nội dung`, chúng ta cần `Nội dung -> Danh sách các Đường dẫn`.*

---

## 2. Strategy: HashMap for Content Inversion
## *2. Chiến lược: HashMap cho việc Đảo ngược Nội dung*

A `HashMap<String, List<String>>` is the most effective structure here, where the key is the file content and the value is a list of its full paths.
*Bảng băm `HashMap<String, List<String>>` là cấu trúc hiệu quả nhất ở đây, trong đó khóa là nội dung tệp và giá trị là danh sách các đường dẫn đầy đủ của nó.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Iterate and Split:** For each string in the `paths` array:
    * **Duyệt và Chia tách:** Đối với mỗi chuỗi trong mảng `paths`:*
    - Split the string by a single space. The first element is the `directoryPath`.
    - *Chia chuỗi theo khoảng trắng đơn. Phần tử đầu tiên là `directoryPath`.*
    - The subsequent elements are strings in the format `filename(content)`.
    - *Các phần tử tiếp theo là các chuỗi có định dạng `tên_tệp(nội dung)`.*

2.  **Parse File Segments:** For each file segment:
    * **Phân tích phân đoạn Tệp:** Đối với mỗi phân đoạn tệp:*
    - Extract the `content` (between `(` and `)`).
    - Extract the `fileName` (before `(`).
    - Construct the full path: `directoryPath + "/" + fileName`.
    - *Trích xuất `nội dung` (giữa `(` và `)`). Trích xuất `tên_tệp` (trước `(`). Xây dựng đường dẫn đầy đủ: `đường_dẫn_thư_mục + "/" + tên_tệp`.*

3.  **Populate Map:** Use `map.computeIfAbsent(content, k -> new ArrayList<>()).add(fullPath)`.
    * **Đưa dữ liệu vào Map:** Sử dụng `map.computeIfAbsent(content, k -> new ArrayList<>()).add(fullPath)`.*

4.  **Final Filter:** Iterate through the map's values and add any list with a size greater than 1 to the final result.
    * **Bộ lọc Cuối cùng:** Duyệt qua các giá trị của map và thêm bất kỳ danh sách nào có kích thước lớn hơn 1 vào kết quả cuối cùng.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Linear Scan:** We process each character of the input exactly once, ensuring optimal performance.
    * **Quét Tuyến tính:** Chúng ta xử lý mỗi ký tự của đầu vào chính xác một lần, đảm bảo hiệu năng tối ưu.*
*   **Memory Trade-off:** We store all unique contents as keys. Using cryptographic hashes (like MD5 or SHA) as keys would be more space-efficient in a real file system where file contents are large, but for this problem's constraints, storing raw strings is fine.
    * **Đánh đổi Bộ nhớ:** Chúng ta lưu trữ tất cả các nội dung duy nhất làm khóa. Việc sử dụng băm mã hóa (như MD5 hoặc SHA) làm khóa sẽ tiết kiệm không gian hơn trong một hệ thống tệp thực sự nơi nội dung tệp lớn, nhưng đối với các ràng buộc của bài toán này, việc lưu trữ các chuỗi thô là ổn.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(C)$, where $C$ is the total number of characters across all input strings. Every character is scanned and parsed.
    * **Độ phức tạp thời gian:** $O(C)$, trong đó $C$ là tổng số ký tự trên tất cả các chuỗi đầu vào. Mỗi ký tự đều được quét và phân tích.*
*   **Space Complexity:** $O(C)$. In the worst case, every file is stored in the map with its full path and content.
    * **Độ phức tạp không gian:** $O(C)$. Trong trường hợp xấu nhất, mọi tệp đều được lưu trữ trong map với đường dẫn và nội dung đầy đủ.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)"]`
1. Segment `root/a`:
   - File 1.txt: content="abcd", path="root/a/1.txt". Map: {"abcd": ["root/a/1.txt"]}
   - File 2.txt: content="efgh", path="root/a/2.txt". Map: {"abcd": [...], "efgh": ["root/a/2.txt"]}
2. Segment `root/c`:
   - File 3.txt: content="abcd", path="root/c/3.txt". Map: {"abcd": ["root/a/1.txt", "root/c/3.txt"], ...}
3. Result: [["root/a/1.txt", "root/c/3.txt"]]. (efgh has only 1 file, discarded).

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For grouping problems, always think of a `Map`. When the input has a complex internal structure, break the parsing into clear steps: whole-string-split, then segment-analysis.
*Đối với các bài toán phân nhóm, hãy luôn nghĩ đến `Map`. Khi đầu vào có cấu trúc nội bộ phức tạp, hãy chia việc phân tích thành các bước rõ ràng: chia tách toàn bộ chuỗi, sau đó là phân tích từng phân đoạn.*
---
*Nội dung (Content) là chân lý cuối cùng để xác định sự tương đồng. Trong một hệ thống rộng lớn (File system), đường dẫn (Path) có thể khác biệt, nhưng nếu tâm hồn (Content) là một, chúng thuộc về cùng một nhóm. Sự trùng lặp (Duplicate) dạy ta cách nhận diện giá trị cốt lõi đằng sau những nhãn dán bề ngoài.*
Content (Content) is the ultimate truth to define similarity. In a large system (File system), the path (Path) may be different, but if the soul (Content) is one, they belong to the same group. Redundancy (Duplicate) teaches us how to identify the core value behind external labels.
