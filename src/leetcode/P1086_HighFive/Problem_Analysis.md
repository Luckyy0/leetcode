# 1086. High Five / High Five

## Problem Description / Mô tả bài toán
Given a list of the scores of different students, `items`, where `items[i] = [ID_i, score_i]`, calculate the average score of the top 5 scores for each student.
Cho một danh sách điểm của các học sinh khác nhau, `items`, trong đó `items[i] = [ID_i, score_i]`, hãy tính điểm trung bình của 5 điểm cao nhất cho mỗi học sinh.

Return the answer as an array of pairs `[ID, average]` sorted by ID.
Trả về câu trả lời là một mảng các cặp `[ID, average]` được sắp xếp theo ID.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Priority Queue / Sorting Map / Hàng đợi Ưu tiên / Bản đồ Sắp xếp
Use `TreeMap<Integer, PriorityQueue<Integer>>` or similar structure.
Map ID to a Min-Heap of size 5 (or Max-Heap then extract 5).
Actually, since we want TOP 5, we can maintain a Min-Heap of size 5. If size > 5, remove smallest. This keeps the largest 5.

Algorithm:
1. Iterate items.
2. For each ID, add score to its Min-Heap.
3. If heap size > 5, poll.
4. Iterate map keys (sorted).
5. For each ID, sum heap elements and divide by 5.

### Complexity / Độ phức tạp
- **Time**: O(N log N) or O(N log 5) = O(N). Formatting output takes sorting IDs O(M log M).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Grouped Heap Selection
Group scores by student ID using a HashMap or TreeMap. For each student, maintain a Min-Heap of size 5 to track their highest scores (evicting the smallest when the heap exceeds size 5). Finally, compute the average of these top 5 scores.
Nhóm điểm số theo ID học sinh bằng cách sử dụng HashMap hoặc TreeMap. Đối với mỗi học sinh, hãy duy trì Min-Heap có kích thước 5 để theo dõi điểm số cao nhất của họ (loại bỏ điểm nhỏ nhất khi heap vượt quá kích thước 5). Cuối cùng, tính trung bình của 5 điểm cao nhất này.

---
