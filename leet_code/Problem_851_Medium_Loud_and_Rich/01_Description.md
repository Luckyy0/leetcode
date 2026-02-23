# Result for Loud and Rich
# *Kết quả cho bài toán Ồn ào và Giàu có*

## Description
## *Mô tả*

There is a group of `n` people labeled from `0` to `n - 1` where each person has a different amount of money and a different level of quietness.
*Có một nhóm `n` người được gắn nhãn từ `0` đến `n - 1`, trong đó mỗi người có một số tiền khác nhau và mức độ yên lặng khác nhau.*

You are given an array `richer` where `richer[i] = [ai, bi]` indicates that person `ai` actually has more money than person `bi`. Note that `richer` may only contain some of the true relationships of who has more money.
*Bạn được cho một mảng `richer`, trong đó `richer[i] = [ai, bi]` cho biết người `ai` thực sự có nhiều tiền hơn người `bi`. Lưu ý rằng `richer` có thể chỉ chứa một số mối quan hệ thực sự về việc ai có nhiều tiền hơn.*

You are also given an integer array `quiet` where `quiet[i]` is the quietness of person `i`. All the values of `quiet` are **unique**.
*Bạn cũng được cho một mảng số nguyên `quiet`, trong đó `quiet[i]` là mức độ yên lặng của người `i`. Tất cả các giá trị của `quiet` là **duy nhất**.*

Return *an integer array `answer` where `answer[x] = y` such that person `y` has least amount of money greater than or equal to person `x` (that is, person `y` is among the people who have more money than or equal to person `x`), and person `y` is the quietest among such people.*
*Trả về *một mảng số nguyên `answer`, trong đó `answer[x] = y` sao cho người `y` có số tiền lớn hơn hoặc bằng người `x` (nghĩa là người `y` nằm trong số những người có nhiều tiền hơn hoặc bằng người `x`), và người `y` là người ít ồn ào nhất (yên lặng nhất) trong số những người đó.*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** richer = [[1,2],[3,2],[1,3],[2,0],[0,4],[0,5],[0,6],[0,7]], quiet = [3,2,5,4,6,1,7,0]
**Output:** [5,5,2,4,5,5,5,5]
**Explanation:** 
- answer[0] = 5. Person 5 has more money than 3, who has more money than 1, who has more money than 2, who has more money than 0. The only person who is quieter than 5 (quietness 1) is person 7 (quietness 0), but person 7 has less money than person 0.
- answer[7] = 7. Person 7 is the only person who has 0 quietness and he has money greater than or equal to himself.

## Example 2:
## *Ví dụ 2:*

**Input:** richer = [], quiet = [0]
**Output:** [0]

---

## Constraints:
## *Ràng buộc:*

*   `n == quiet.length`
*   `1 <= n <= 500`
*   `0 <= quiet[i] < n`
*   All the values of `quiet` are **unique**.
*   `0 <= richer.length <= n * (n - 1) / 2`
*   `0 <= ai, bi < n`
*   `ai != bi`
*   The `richer` graph is a Directed Acyclic Graph (DAG).
