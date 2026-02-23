# Result for Relative Ranks
# *Kết quả cho bài toán Xếp hạng Tương đối*

## Description
## *Mô tả*

You are given an integer array `score` of size `n`, where `score[i]` is the score of the `i^th` athlete in a competition. All the scores are guaranteed to be **unique**.
*Bạn được cho một mảng số nguyên `score` có kích thước `n`, trong đó `score[i]` là điểm số của vận động viên thứ `i` trong một cuộc thi. Tất cả các điểm số được đảm bảo là **duy nhất**.*

The athletes are placed based on their scores, where the `1^st` place athlete has the highest score, the `2^nd` place athlete has the `2^nd` highest score, and so on. The placement of each athlete determines their rank:
*Các vận động viên được xếp hạng dựa trên điểm số của họ, trong đó vận động viên xếp thứ `1` có điểm số cao nhất, vận động viên xếp thứ `2` có điểm số cao thứ `2`, v.v. Xếp hạng của mỗi vận động viên xác định thứ hạng của họ:*

*   The `1^st` place athlete's rank is `"Gold Medal"`.
    *Thứ hạng của vận động viên xếp thứ `1` là `"Gold Medal"`.*
*   The `2^nd` place athlete's rank is `"Silver Medal"`.
    *Thứ hạng của vận động viên xếp thứ `2` là `"Silver Medal"`.*
*   The `3^rd` place athlete's rank is `"Bronze Medal"`.
    *Thứ hạng của vận động viên xếp thứ `3` là `"Bronze Medal"`.*
*   For the `4^th` place to the `n^th` place athlete, their rank is their placement number (i.e., the `x^th` place athlete's rank is `"x"`).
    *Đối với các vận động viên từ thứ `4` đến thứ `n`, thứ hạng của họ là số thứ tự xếp hạng (tức là, thứ hạng của vận động viên xếp thứ `x` là `"x"`).*

Return an array `answer` of size `n` where `answer[i]` is the rank of the `i^th` athlete.
*Trả về một mảng `answer` có kích thước `n` trong đó `answer[i]` là thứ hạng của vận động viên thứ `i`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `score = [5,4,3,2,1]`
**Output:** `["Gold Medal","Silver Medal","Bronze Medal","4","5"]`
**Explanation:** The placements are [1st, 2nd, 3rd, 4th, 5th].

## Example 2:
## *Ví dụ 2:*

**Input:** `score = [10,3,8,9,4]`
**Output:** `["Gold Medal","5","Bronze Medal","Silver Medal","4"]`
**Explanation:** The placements are [1st, 5th, 3rd, 2nd, 4th].

## Constraints:
## *Ràng buộc:*

*   `n == score.length`
*   `1 <= n <= 10^4`
*   `0 <= score[i] <= 10^6`
*   All the values in `score` are **unique**.
