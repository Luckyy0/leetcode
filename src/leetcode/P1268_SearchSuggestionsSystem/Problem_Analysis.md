# 1268. Search Suggestions System / Hệ thống Đề xuất Tìm kiếm

## Problem Description / Mô tả bài toán
Given `products` array and `searchWord`. For each character typed in `searchWord`, suggest up to 3 lexicographically minimum products that have common prefix.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Trie / Sorting + Binary Search
Method 1: Trie with top 3 suggestions stored at each node.
- Insert all products. At each node, maintain list of up to 3 best words.
- Traverse trie with `searchWord`.

Method 2: Sort `products` + Binary Search (Lower Bound).
- Sort `products`.
- For each prefix `P`, find first index `i` such that `products[i]` starts with `P`.
- Check `i, i+1, i+2`. Add if they match prefix.
- Optimization: `start` index for binary search can be `previous start`, because as prefix grows, start index moves right. Two Pointers.

### Complexity / Độ phức tạp
- **Time**: O(N log N + M * log N) or O(N log N + M).
- **Space**: O(N * L) for Trie or O(log N) sort.

---

## Analysis / Phân tích

### Approach: Sorting with Two Pointers
Sort the `products` list lexicographically. Then, iterate through each character of the `searchWord`. Maintain a range `[left, right]` in the products list that matches the current prefix. Update `left` and `right` by narrowing down to products whose character at the current index matches the prefix character. Once the range is identified, take the first 3 products within `[left, right]` (if available) as suggestions. Since the list is sorted and the prefix grows, `left` only moves forward, making it efficient.
Sắp xếp danh sách `products` theo thứ tự từ điển. Sau đó, lặp qua từng ký tự của `searchWord`. Duy trì phạm vi `[left, right]` trong danh sách sản phẩm khớp với tiền tố hiện tại. Cập nhật `left` và `right` bằng cách thu hẹp các sản phẩm có ký tự tại chỉ số hiện tại khớp với ký tự tiền tố. Sau khi xác định phạm vi, hãy lấy 3 sản phẩm đầu tiên trong `[left, right]` (nếu có) làm đề xuất. Vì danh sách đã được sắp xếp và tiền tố tăng lên, `left` chỉ di chuyển về phía trước, giúp nó hiệu quả.

---
