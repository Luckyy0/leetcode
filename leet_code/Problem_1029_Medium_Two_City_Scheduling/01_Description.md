# Result for Two City Scheduling
# *Kết quả bài toán Xếp lịch Hai Thành Phố*

## Description
## *Mô tả*

A company is planning to interview `2n` people. Given the array `costs` where `costs[i] = [aCosti, bCosti]`, the cost of flying the `i-th` person to city `a` is `aCosti`, and the cost of flying the `i-th` person to city `b` is `bCosti`.
*Một công ty dự định phỏng vấn `2n` người. Cho mảng chi phí `costs` trong đó `costs[i] = [aCosti, bCosti]`, chi phí để mua vé máy bay cho người thứ `i` bay đến thành phố `A` là `aCosti`, và chi phí để người đó bay đến thành phố `B` là `bCosti`.*

Return *the minimum cost to fly every person to a city* such that exactly `n` people arrive in each city.
*Trả về tổng chi phí tối thiểu để mua vé cho tất cả mọi người bay đến một trong hai thành phố, sao cho **chính xác mỗi thành phố nhận đúng `n` người** (chia đều số lượng).*

---

## Example 1:
## *Ví dụ 1:*

**Input:** costs = [[10,20],[30,200],[400,50],[30,20]]
**Output:** 110
**Explanation:** 
- The first person goes to city A for a cost of 10.
- The second person goes to city A for a cost of 30.
- The third person goes to city B for a cost of 50.
- The fourth person goes to city B for a cost of 20.
The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
*Giải thích:*
*- Người 1 bay đến A (vé 10).*
*- Người 2 bay đến A (vé 30).*
*- Người 3 bay đến B (vé 50).*
*- Người 4 bay đến B (vé 20).*
*Tổng chi phí tối ưu là $10 + 30 + 50 + 20 = 110$. Quan trọng: Có chính xác 2 người ở A và 2 người ở B (trọn vẹn bộ $n=2$ / tổng $2n=4$).*

## Example 2:
## *Ví dụ 2:*

**Input:** costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
**Output:** 1859
*Giải thích: Mọi người phân chia làm sao có đủ 3 hành khách ghé A và 3 hành khách ghé B với tổng vé thấp nhất.*

## Example 3:
## *Ví dụ 3:*

**Input:** costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]
**Output:** 3086

---

## Constraints:
## *Ràng buộc:*

*   `2 * n == costs.length`
*   `2 <= costs.length <= 100`
*   `costs.length` is even.
*   `1 <= aCosti, bCosti <= 1000`
