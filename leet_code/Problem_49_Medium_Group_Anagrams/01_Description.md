# Result for Group Anagrams
# *Kết quả cho bài toán Nhóm Các Từ Đảo Chữ*

## Description
## *Mô tả*

Given an array of strings `strs`, group the anagrams together. You can return the answer in **any order**.
*Cho một mảng các chuỗi `strs`, hãy nhóm các từ đảo chữ lại với nhau. Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.*

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
*Một **Từ Đảo Chữ (Anagram)** là một từ hoặc cụm từ được tạo thành bằng cách sắp xếp lại các chữ cái của một từ hoặc cụm từ khác, thông thường sử dụng tất cả các chữ cái ban đầu chính xác một lần.*

## Example 1:
## *Ví dụ 1:*

**Input:** `strs = ["eat","tea","tan","ate","nat","bat"]`
**Output:** `[["bat"],["nat","tan"],["ate","eat","tea"]]`

## Example 2:
## *Ví dụ 2:*

**Input:** `strs = [""]`
**Output:** `[[""]]`

## Example 3:
## *Ví dụ 3:*

**Input:** `strs = ["a"]`
**Output:** `[["a"]]`

## Constraints:
## *Ràng buộc:*

*   `1 <= strs.length <= 10^4`
*   `0 <= strs[i].length <= 100`
*   `strs[i]` consists of lowercase English letters.
