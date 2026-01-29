# 1181. Before and After Puzzle / Câu đố Trước và Sau

## Problem Description / Mô tả bài toán
Given a list of `phrases`, generate a list of strings where each string is a concatenation of two phrases where the *last word* of the first phrase is the same as the *first word* of the second phrase.
Return the distinct strings sorted lexicographically.
Cho một danh sách các `phrases`, hãy tạo danh sách các chuỗi trong đó mỗi chuỗi là sự ghép nối của hai cụm từ, trong đó *từ cuối cùng* của cụm từ đầu tiên giống với *từ đầu tiên* của cụm từ thứ hai.
Trả về các chuỗi phân biệt được sắp xếp theo thứ tự từ điển.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### HashMap Grouping / Nhóm HashMap
1. Parse phrases. For each phrase, extract first word and last word.
   - Careful: "a" -> first="a", last="a".
2. Store map `firstWord -> List of phrase indices`.
   - Or `firstWord -> List of (phrase itself without first word)`. Wait, we need full phrase info.
3. For each phrase `p` (assumed first phrase):
   - Get last word `L`.
   - Find all phrases `q` starting with `L`.
   - Combine `p` + `q.substring(firstWordLen)`.
   - Handle overlapping cases (if same index, we can't use same phrase twice? Problem says "two phrases". If duplicate phrases exist in list, we can use distinct indices. `i != j`.)
4. Add to Set to ensure uniqueness.
5. Sort.

### Complexity / Độ phức tạp
- **Time**: O(N^2 * L).
- **Space**: O(N * L).

---

## Analysis / Phân tích

### Approach: Hash Map Matching
Extract the first and last words of each phrase. Store phrases in a map keyed by their first word to allow quick lookups. Iterate through each phrase (considering it as the "first" part), identify its last word, and look up all phrases that begin with that word. Concatenate compatible pairs (handling the overlap correctly and ensuring distinct indices) and store them in a set to remove duplicates. Finally, sort the results.
Trích xuất từ đầu tiên và từ cuối cùng của mỗi cụm từ. Lưu trữ các cụm từ trong bản đồ được khóa bởi từ đầu tiên của chúng để cho phép tra cứu nhanh. Lặp lại qua từng cụm từ (coi nó là phần "đầu tiên"), xác định từ cuối cùng của nó và tra cứu tất cả các cụm từ bắt đầu bằng từ đó. Nối các cặp tương thích (xử lý phần chồng chéo một cách chính xác và đảm bảo các chỉ số riêng biệt) và lưu trữ chúng trong một tập hợp để loại bỏ các bản sao. Cuối cùng, sắp xếp kết quả.

---
