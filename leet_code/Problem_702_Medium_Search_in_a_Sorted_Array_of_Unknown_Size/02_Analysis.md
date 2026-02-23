# Analysis for Search in a Sorted Array of Unknown Size
# *Phân tích cho bài toán Tìm kiếm trong Mảng đã sắp xếp có Kích thước Không xác định*

## 1. Problem Essence & Strategy
## *1. Bản chất vấn đề & Chiến lược*

### The Challenge
### *Thách thức*
We have a sorted array but don't know where it ends. Standard binary search needs a `high` boundary. Therefore, we must first "discover" an appropriate upper bound before performing the search.
*Chúng ta có một mảng đã sắp xếp nhưng không biết nó kết thúc ở đâu. Tìm kiếm nhị phân tiêu chuẩn cần một biên `high`. Do đó, trước tiên ta phải "khám phá" một biên trên thích hợp.*

---

## 2. Strategy: Exponential Range Expansion
## *2. Chiến lược: Mở rộng Phạm vi theo Số mũ*

### Step 1: Find the Bounds
Start with a small range $[0, 1]$. While the `target` is greater than the value at the `right` boundary, double the `right` boundary (`right = right * 2`).
*Bắt đầu với phạm vi $[0, 1]$. Chỉ cần `target` còn lớn hơn giá trị tại biên `right`, hãy gấp đôi biên `right`.*

### Step 2: Binary Search
Once we have a range $[left, right]$ such that `reader.get(right)` is either the target or greater than it (or out of bounds), perform a standard binary search within this fixed range.
*Khi đã có phạm vi $[left, right]$ mà `reader.get(right)` lớn hơn hoặc bằng mục tiêu, hãy thực hiện tìm kiếm nhị phân tiêu chuẩn trong phạm vi này.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log T)$, where $T$ is the index of the target. Finding the bounds takes $O(\log T)$ steps, and binary search takes another $O(\log T)$.
    * **Độ phức tạp thời gian:** $O(\log T)$.*
*   **Space Complexity:** $O(1)$.
    * **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Summary Recommendation
## *4. Khuyến nghị Tổng kết*

This is a classic "unbounded search" problem. The technique of doubling the range (also called exponential search) is the standard way to find a boundary in logarithmic time.
*Đây là bài toán "tìm kiếm không giới hạn" kinh điển. Kỹ thuật gấp đôi phạm vi (tìm kiếm số mũ) là cách tiêu chuẩn để tìm biên trong thời gian logarit.*
---
*Sự vô hạn (Unknown size) chỉ là một ảo ảnh đối với một tư duy có hệ thống. Trong một không gian không biên giới, ta tìm kiếm điểm dừng bằng cách khuếch đại tầm nhìn (Exponential expansion). Dữ liệu dạy ta rằng bằng cách nhân đôi nỗ lực (Double the range) cho đến khi bao trùm được sự thực (Target), ta có thể áp đặt một trật tự (Binary search) lên cả những gì dường như là khôn cùng.*
Infinity (Unknown size) is just an illusion to a systematic mind. In a space without borders, we search for a stopping point by magnifying our vision (Exponential expansion). Data teaches us that by doubling our efforts (Double the range) until the truth is embraced (Target), we can impose an order (Binary search) even on what seems infinite.
