# 1002. Find Common Characters / Tìm các Ký tự Chung

## Problem Description / Mô tả bài toán
Given a string array `words`, return an array of all characters that show up in all strings within the `words` (including duplicates). You may return the answer in any order.
Cho một mảng chuỗi `words`, hãy trả về một mảng gồm tất cả các ký tự xuất hiện trong tất cả các chuỗi trong `words` (bao gồm cả các bản sao). Bạn có thể trả về câu trả lời theo bất kỳ thứ tự nào.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Frequency Intersection / Giao của Tần suất
Algorithm:
1. Initialize `minFreq` array of size 26 with infinity (or frequencies of the first word).
2. For each subsequent word:
   - Be count frequencies of this word (`charFreq`).
   - Update `minFreq[i] = Math.min(minFreq[i], charFreq[i])`.
3. Construct the result list based on `minFreq`.

### Complexity / Độ phức tạp
- **Time**: O(N * L), where N is number of words, L is max length.
- **Space**: O(1) (size 26 arrays).

---

## Analysis / Phân tích

### Approach: Minimum Histogram Overlap
Treat each word as a frequency histogram of characters. The intersection of all words is formed by taking the component-wise minimum across all these histograms. The result represents the count of each character guaranteed to exist in every input string.
Coi mỗi từ như một biểu đồ tần suất của các ký tự. Phần giao của tất cả các từ được hình thành bằng cách lấy giá trị nhỏ nhất theo từng thành phần trên tất cả các biểu đồ này. Kết quả đại diện cho số lượng của mỗi ký tự được đảm bảo tồn tại trong mọi chuỗi đầu vào.

---
