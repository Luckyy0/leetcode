# Analysis for Degree of an Array
# *Phân tích cho bài toán Bậc của một Mảng*

## 1. Problem Essence & Degree Identification
## *1. Bản chất vấn đề & Xác định Bậc*

### The Challenge
### *Thách thức*
The "degree" of an array is the maximum number of times any element appears. To find the shortest subarray with the same degree, we need to find the shortest segment that contains *all* occurrences of at least one of the elements that define that degree.
*"Bậc" của mảng là số lần xuất hiện nhiều nhất của bất kỳ phần tử nào. Để tìm mảng con ngắn nhất có cùng bậc, ta cần tìm đoạn ngắn nhất chứa *tất cả* các lần xuất hiện của ít nhất một phần tử tạo nên bậc đó.*

---

## 2. Strategy: Tracking Frequencies and Bounds
## *2. Chiến lược: Theo dõi Tần suất và Biên độ*

A single pass through the array can collect all the information needed to solve this.
*Chỉ cần một lần duyệt qua mảng là có thể thu thập đủ thông tin cần thiết.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Collect Metadata:** For each unique number `x` in the array, record:
    - `count`: How many times `x` appears.
    - `first`: The index of its first occurrence.
    - `last`: The index of its last occurrence.
    * **Thu thập Siêu dữ liệu:** Với mỗi số `x`, ghi lại số lần xuất hiện, chỉ số đầu tiên và chỉ số cuối cùng.*

2.  **Determine Degree:** The degree of the array is the maximum `count` found in the metadata.
    * **Xác định Bậc:** Bậc của mảng là giá trị `count` lớn nhất.*

3.  **Minimize Length:** For every number `x` whose `count` equals the degree:
    - Calculate the length of the span: `last[x] - first[x] + 1`.
    - Keep track of the minimum such length.
    * **Tối thiểu hóa Độ dài:** Với mỗi số `x` có `count` bằng bậc của mảng, tính độ dài đoạn chứa nó và tìm giá trị nhỏ nhất.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Linear Pass:** By using HashMaps (or arrays for small values), we achieve competitive time complexity without nested loops.
    * **Duyệt Tuyến tính:** Sử dụng Map giúp đạt hiệu suất cao mà không cần vòng lặp lồng nhau.*
*   **Completeness:** We handle cases where multiple elements define the degree (e.g., [1, 1, 2, 2]). The algorithm checks all candidates to find the globally shortest span.
    * **Tính đầy đủ:** Xử lý tốt trường hợp có nhiều phần tử cùng đạt bậc tối đa.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the length of the array. One pass to fill maps, one pass through the keys (maximum $N$ unique keys).
    * **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(N)$ to store frequency and index maps.
    * **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**nums = [1, 2, 2, 3, 1]**
1. Metadata:
   - 1: count=2, first=0, last=4. Span = 5.
   - 2: count=2, first=1, last=2. Span = 2.
   - 3: count=1, first=3, last=3. Span = 1.
2. Degree: 2 (from 1 and 2).
3. Candidate Spans:
   - For 1: length = 5.
   - For 2: length = 2.
4. Min Length: 2.
**Result:** 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Problems involving "shortest subarray with X frequency" almost always require tracking the first and last occurrence of elements. Storing these in HashMaps allows for a clean transition from statistical data (counts) to spatial data (spans).
*Các bài toán về "mảng con ngắn nhất với tần suất X" luôn yêu cầu theo dõi lần xuất hiện đầu tiên và cuối cùng. Lưu trữ chúng trong Map giúp chuyển đổi dữ liệu thống kê thành dữ liệu không gian một cách dễ dàng.*
---
*Bậc (Degree) của một mảng là đỉnh cao của sự lặp lại, nhưng mảng con ngắn nhất là chứng nhân cho sự tập trung (Concentration). Trong sự trải dài của các con số, bí mật nằm ở khoảng cách giữa khởi đầu (First) và kết thúc (Last). Dữ liệu dạy ta rằng bằng cách đo lường biên giới của sự hiện diện (Metadata tracking), ta có thể thu hẹp tầm nhìn để tìm thấy bản chất cô đọng nhất của một quy luật.*
The degree (Degree) of an array is the peak of repetition, but the shortest subarray is a witness to concentration (Concentration). In the stretch of numbers, the secret lies in the distance between the beginning (First) and the end (Last). Data teaches us that by measuring the boundaries of presence (Metadata tracking), we can narrow our vision to find the most condensed essence of a rule.
