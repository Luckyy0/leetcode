# 1096. Brace Expansion II / Mở rộng Dấu ngoặc nhọn II

## Problem Description / Mô tả bài toán
Under the grammar given below, return the set of all strings that can be formed from the given expression.
Theo ngữ pháp được đưa ra bên dưới, hãy trả về tập hợp tất cả các chuỗi có thể được tạo thành từ biểu thức đã cho.

Grammar:
- Single letters represent a singleton set containing that letter.
- `{A,B,C}` represents the union of sets A, B, C.
- `A B` (concatenation) represents the set of words formed by concatenating a word from A and a word from B.

Examples:
- `{a,b}{c,{d,e}}` -> `ac, ad, ae, bc, bd, be`
- `{{a,z},a{b,c},{ab,z}}` -> `a, ab, ac, z`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Recursive Descent Parser / Parsing Stack / Phân tích Cú pháp Đệ quy Xuống
This is an expression parsing problem with Union (`,`) and Concatenation (implicit or adjacent).
Precedence: Concatenation > Union.
Or actually, `{a, b}` is a group. Inside group, `,` separates alternatives. Adjacent items are concatenated.

Rules:
1. `parse(expression)` returns `Set<String>`.
2. Stack-based approach:
   - Level 1: Comma-separated groups (Union).
   - Level 2: Inside each comma-group, simplify adjacent items (Concatenation).

Recursive Structure:
- Identify top-level commas to split unions.
- Inside each union part, identify concatenated blocks.
- Concatenate blocks (Cross Product).
- Union results.

Or simpler:
Recurse.
If we see `{`, find matching `}`. That block is a sub-problem.
Basically handling `term` (concatenation of factors) and `expr` (union of terms).

### Complexity / Độ phức tạp
- **Time**: Exponential in worst case (nested braces cross product).
- **Space**: Output size.

---

## Analysis / Phân tích

### Approach: Recursive Composition
Treat the expression as a recursive structure of unions and concatenations. Use recursion to evaluate nested brace expressions. For any given level, split by the top-level commas (union operator) and process each segment. Within a segment, adjacent components (sets of strings) undergo a cross-product concatenation. Collect all results into a sorted set of unique strings.
Coi biểu thức như một cấu trúc đệ quy của các hợp và phép nối. Sử dụng đệ quy để đánh giá các biểu thức ngoặc lồng nhau. Đối với bất kỳ cấp độ nào, hãy chia theo dấu phẩy cấp cao nhất (toán tử hợp) và xử lý từng phân đoạn. Trong một phân đoạn, các thành phần liền kề (bộ chuỗi) trải qua phép nối tích chéo. Thu thập tất cả các kết quả thành một tập hợp các chuỗi duy nhất được sắp xếp.

---
