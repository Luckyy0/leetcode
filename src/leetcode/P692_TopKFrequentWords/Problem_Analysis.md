# 692. Top K Frequent Words / Top K Từ phổ biến nhất

## Problem Description / Mô tả bài toán
Given an array of strings `words` and an integer `k`, return the `k` most frequent strings.
Cho một mảng các chuỗi `words` và một số nguyên `k`, hãy trả về `k` chuỗi xuất hiện thường xuyên nhất.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
Trả về câu trả lời được sắp xếp theo tần suất từ cao đến thấp. Sắp xếp các từ có cùng tần suất theo thứ tự từ điển.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Priority Queue and HashMap / Hàng đợi Ưu tiên và HashMap
1. Count the frequency of each word using a HashMap.
2. Use a Priority Queue (Min-Heap) to keep track of the top k elements.
3. Define a custom comparator:
   - Primary: Higher frequency wins.
   - Secondary (if frequencies tie): Lexicographically smaller word wins.
Actually, in a Min-Heap of size K:
   - Lesser frequency is at the top (to be removed).
   - If frequencies are equal, lexicographically larger word is at the top (to be removed).

### Complexity / Độ phức tạp
- **Time**: O(N log K) to maintain a heap of size K.
- **Space**: O(N) to store frequencies in the map.

---

## Analysis / Phân tích

### Approach: K-size Min-Heap
This approach ensures that after processing all words, only the top `k` elements remain in the heap. We then extract them and reverse the list for the final answer.
Cách tiếp cận này đảm bảo rằng sau khi xử lý tất cả các từ, chỉ có `k` phần tử hàng đầu còn lại trong heap. Sau đó, chúng ta trích xuất chúng và đảo ngược danh sách để có câu trả lời cuối cùng.

---
