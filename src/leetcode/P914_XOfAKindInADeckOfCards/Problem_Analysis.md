# 914. X of a Kind in a Deck of Cards / Bộ bài có các phần tử giống nhau

## Problem Description / Mô tả bài toán
Determine if the cards in a deck can be partitioned into groups such that each group contains `X` cards of the same value, where `X >= 2`.
Xác định xem các lá bài trong bộ bài có thể được chia thành các nhóm sao cho mỗi nhóm chứa `X` lá bài có cùng giá trị, với `X >= 2`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greatest Common Divisor (GCD) / Ước chung Lớn nhất (UCLN)
For all unique values, their frequencies must share a common factor `X >= 2`.
Đối với tất cả các giá trị duy nhất, tần suất của chúng phải có một ước chung `X >= 2`.

Algorithm:
1. Count the frequency of each number in the deck.
2. Find the GCD of all these frequencies.
3. If `GCD >= 2`, return `true`.

### Complexity / Độ phức tạp
- **Time**: O(N + V log V) where N is deck size and V is number of unique values.
- **Space**: O(V).

---

## Analysis / Phân tích

### Approach: Collective Divisibility
The task requires a universal divisor for all frequency counts. By calculating the GCD cumulatively across all groups, we can verify if a viable group size `X` exists that leaves no remainder for any card type.
Nhiệm vụ yêu cầu một số chia chung cho tất cả các số lượng tần suất. Bằng cách tính GCD tích lũy trên tất cả các nhóm, chúng ta có thể xác minh xem liệu có tồn tại kích thước nhóm `X` khả thi nào mà không để lại số dư cho bất kỳ loại thẻ nào hay không.

---
