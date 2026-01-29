# 822. Card Flipping Game / Trò chơi Lật thẻ

## Problem Description / Mô tả bài toán
There are `n` cards, with a number on the front and a number on the back.
Có `n` tấm thẻ, với một con số ở mặt trước và một con số ở mặt sau.

A number is **good** if it is on one of the cards and it does NOT have both its front and back being the same number.
Một con số là **tốt** nếu nó nằm trên một trong các thẻ và nó KHÔNG có cả mặt trước và mặt sau đều là cùng một số.

Return the minimum good number. If no such number exists, return 0.
Trả về số tốt nhỏ nhất. Nếu không có số nào như vậy, hãy trả về 0.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Property Analysis / Phân tích Thuộc tính
Crucial observation: If a card has the same number `X` on both sides, `X` can **never** be the answer, because no matter how we flip other cards, `X` will always be showing on that specific card.
Quan sát quan trọng: Nếu một thẻ có cùng số `X` ở cả hai mặt, `X` **không bao giờ** có thể là câu trả lời, vì dù chúng ta có lật các thẻ khác như thế nào, `X` vẫn sẽ luôn hiển thị trên thẻ đó.

For any other number `Y` that appears on any side of any card, as long as it never appears on both sides of the *same* card, we can always flip cards such that `Y` is never showing when it's not the chosen value.
Đối với bất kỳ số `Y` nào khác xuất hiện ở bất kỳ mặt nào của bất kỳ thẻ nào, miễn là nó không bao giờ xuất hiện ở cả hai mặt của *cùng một* thẻ, chúng ta luôn có thể lật các thẻ sao cho `Y` không bao giờ hiển thị khi nó không phải là giá trị được chọn.

Algorithm:
1. Find all numbers $x$ such that `front[i] == back[i] == x`. Store these in a `HashSet` called `banned`.
2. Iterate through all numbers in `front` and `back`.
3. If a number is not in `banned`, it is a candidate.
4. Return the minimum candidate.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Disqualification logic
A number is disqualified if it is "locked" into the display (i.e., appears on both sides of a card). Any other number present on the cards is potentially valid.
Một con số bị loại nếu nó bị "khóa" vào màn hình (nghĩa là xuất hiện ở cả hai mặt của một thẻ). Mọi con số khác có mặt trên các thẻ đều có khả năng hợp lệ.

---
