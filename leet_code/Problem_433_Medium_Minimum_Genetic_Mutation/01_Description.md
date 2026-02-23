# Result for Minimum Genetic Mutation
# *Kết quả cho bài toán Đột biến Gen tối thiểu*

## Description
## *Mô tả*

A gene string can be represented by an 8-character long string, with choices from `'A'`, `'C'`, `'G'`, and `'T'`.
*Một chuỗi gen có thể được đại diện bởi một chuỗi dài 8 ký tự, với các lựa chọn từ `'A'`, `'C'`, `'G'`, và `'T'`.*

Suppose we need to investigate a mutation from a gene string `startGene` to a gene string `endGene`, where one mutation is defined as one single character changed in the gene string.
*Giả sử chúng ta cần điều tra một đột biến từ một chuỗi gen `startGene` sang một chuỗi gen `endGene`, trong đó một đột biến được định nghĩa là một ký tự duy nhất được thay đổi trong chuỗi gen.*

For example, `"AACCGGTT" --> "AACCGGTA"` is one mutation.
*Ví dụ, `"AACCGGTT" --> "AACCGGTA"` là một đột biến.*

There is also a gene bank `bank` that records all the valid gene mutations. A gene must be in the bank to make it a valid mutation.
*Cũng có một ngân hàng gen `bank` ghi lại tất cả các đột biến gen hợp lệ. Một gen phải có trong ngân hàng để trở thành một đột biến hợp lệ.*

Given the two gene strings `startGene` and `endGene` and the gene bank `bank`, return *the minimum number of mutations needed to mutate from `startGene` to `endGene`*. If there is no such a mutation, return `-1`.
*Cho hai chuỗi gen `startGene` và `endGene` và ngân hàng gen `bank`, hãy trả về *số lượng đột biến tối thiểu cần thiết để đột biến từ `startGene` sang `endGene`*. Nếu không có đột biến như vậy, hãy trả về `-1`.*

Note that the starting point is assumed to be valid, so it might not be included in the bank.
*Lưu ý rằng điểm bắt đầu được coi là hợp lệ, vì vậy nó có thể không được bao gồm trong ngân hàng.*

## Example 1:
## *Ví dụ 1:*

**Input:** `startGene = "AACCGGTT", endGene = "AACCGGTA", bank = ["AACCGGTA"]`
**Output:** `1`

## Example 2:
## *Ví dụ 2:*

**Input:** `startGene = "AACCGGTT", endGene = "AAACGGTA", bank = ["AACCGGTA","AAACGGTA","AACCCTA"]`
**Output:** `2`

## Constraints:
## *Ràng buộc:*

*   `0 <= bank.length <= 10`
*   `startGene.length == endGene.length == bank[i].length == 8`
*   `startGene`, `endGene`, and `bank[i]` consist of characters from the set `{'A', 'C', 'G', 'T'}`.
