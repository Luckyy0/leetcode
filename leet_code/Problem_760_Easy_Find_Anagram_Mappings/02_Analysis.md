# Analysis for Find Anagram Mappings
# *Phân tích cho bài toán Tìm Ánh xạ Anagram*

## 1. Problem Essence & Hash Map
## *1. Bản chất vấn đề & Bảng băm*

### The Challenge
### *Thách thức*
We need to find "where did each element go?". Specifically, for each element in the first array, find its position in the second array. Since duplicates exist, we need to handle them carefully (though "any" mapping implies simple lookup is fine, typically we assign one-to-one).
*Chúng ta cần tìm "mỗi phần tử đã đi đâu?". Cụ thể, với mỗi phần tử trong mảng đầu tiên, tìm vị trí của nó trong mảng thứ hai. Vì có sự trùng lặp, ta cần xử lý cẩn thận (mặc dù đề bài cho phép "bất kỳ" ánh xạ nào, thường ta sẽ gán một-một).*

---

## 2. Strategy: Map with Stack/Group
## *2. Chiến lược: Map với Ngăn xếp/Nhóm*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Index Map:** Create a `Map<Integer, LinkedList<Integer>>`.
    - Iterate `nums2`. For each value, add its index to the list in the map.
    *   **Bản đồ chỉ số:** Tạo Map ánh xạ giá trị sang danh sách các chỉ số. Duyệt `nums2` và điền vào Map.*

2.  **Mapping:**
    - Iterate `nums1`. For each value `x`:
    - Retrieve the list of indices from the map.
    - Remove/Pop the first index from the list (to ensure 1-to-1 if needed, or just pick any unused one).
    - Store mapping.
    *   **Ánh xạ:** Duyệt `nums1`. Lấy danh sách chỉ số tương ứng, "bốc" một chỉ số ra và ghi vào kết quả.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Two passes.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(N)$ for the map.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**A=[12, 28], B=[28, 12]**
1. Map B: `{28: [0], 12: [1]}`.
2. Scan A:
   - 12: Pop from map[12] -> 1. Res=[1].
   - 28: Pop from map[28] -> 0. Res=[1, 0].
**Result:** `[1, 0]`.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Simplest hashing problem. Using a generic `HashMap` works perfectly.
*Bài toán băm đơn giản nhất. Sử dụng `HashMap` cơ bản là giải pháp hoàn hảo.*
---
*Trong mê cung của sự hoán vị (Anagram), mỗi con số đều tìm lại được vị trí của mình nếu ta có một tấm bản đồ (Mapping). Dữ liệu dạy ta rằng bằng cách ghi nhớ nơi chốn của từng giá trị (Hash Map indices), ta có thể dệt lại mối liên kết ban đầu một cách nhanh chóng và chính xác.*
In the maze of permutation (Anagram), every number finds its place if we have a map (Mapping). Data teaches us that by remembering the location of each value (Hash Map indices), we can re-weave the original connection quickly and accurately.
