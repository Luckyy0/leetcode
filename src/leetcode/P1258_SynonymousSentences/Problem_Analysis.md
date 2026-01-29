# 1258. Synonymous Sentences / Các câu Đồng nghĩa

## Problem Description / Mô tả bài toán
Given list of `synonyms` pairs and a `text`.
Return all possible synonymous sentences sorted lexicographically.
`text` is space separated words.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Union-Find / Backtracking
1. Group synonyms using Union-Find.
2. Store synonyms in `Map<Root, List<Word>>`. (Collect all words in each component, sort them).
3. Split text into words.
4. Backtracking (or BFS) to generate sentences from left to right.
   - For each word in text, find its root.
   - If no root (not in synonyms), use word itself.
   - If root exists, iterate all words in component.
   - Append and recurse.
   
### Complexity / Độ phức tạp
- **Time**: Exponential in worst case (many options), but reasonable for constraints.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Union-Find and Backtracking
First, use Union-Find to group words that are synonyms (transitive property). For easy retrieval, map each word root (representative) to a sorted list of all words in that component. Split the `text` into words. Use backtracking to generate sentences: for each word in the text, replace it with every synonym from its group (including itself). If a word has no synonyms, keep it as is. Concatenate results to form full sentences. Store results in a sorted list (e.g., TreeSet then to List) to handle lexicographical order naturally.
Đầu tiên, sử dụng Union-Find để nhóm các từ đồng nghĩa (tính chất bắc cầu). Để dễ truy xuất, hãy ánh xạ mỗi gốc từ (đại diện) tới danh sách đã sắp xếp của tất cả các từ trong thành phần đó. Chia `text` thành các từ. Sử dụng quay lui để tạo câu: đối với mỗi từ trong văn bản, thay thế nó bằng mọi từ đồng nghĩa từ nhóm của nó (bao gồm cả chính nó). Nếu một từ không có từ đồng nghĩa, hãy giữ nguyên. Nối các kết quả để tạo thành câu đầy đủ. Lưu trữ kết quả trong danh sách đã sắp xếp (ví dụ: TreeSet sau đó sang List) để xử lý thứ tự từ điển một cách tự nhiên.

---
