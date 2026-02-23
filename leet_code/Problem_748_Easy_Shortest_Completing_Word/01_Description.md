# Result for Shortest Completing Word
# *Kết quả cho bài toán Từ Hoàn thiện Ngắn nhất*

## Description
## *Mô tả*

Given a string `licensePlate` and an array of strings `words`, find the **shortest completing word** in `words`.
*Cho một chuỗi `licensePlate` và một mảng các chuỗi `words`, hãy tìm **từ hoàn thiện ngắn nhất** trong `words`.*

A **completing word** is a word that contains all the letters in `licensePlate`. **Ignore numbers and spaces** in `licensePlate`, and treat letters as **case-insensitive**. If a letter appears more than once in `licensePlate`, it must appear in the word the same number of times or more.
*Một **từ hoàn thiện** là từ chứa tất cả các chữ cái có trong `licensePlate`. **Bỏ qua số và khoảng trắng** trong `licensePlate`, và coi các chữ cái là **không phân biệt hoa thường**. Nếu một chữ cái xuất hiện nhiều lần trong `licensePlate`, nó phải xuất hiện trong từ đó với số lần bằng hoặc nhiều hơn.*

For example, if `licensePlate` = "aBc 12c", then it contains letters 'a', 'b' (ignoring case), and 'c' twice. Possible completing words are "abccdef", "caaacab", and "cbca".
*Ví dụ, nếu `licensePlate` = "aBc 12c", thì nó chứa các chữ cái 'a', 'b' (bỏ qua hoa thường), và 'c' hai lần. Các từ hoàn thiện có thể là "abccdef", "caaacab", và "cbca".*

Return *the shortest completing word in `words`*. It is guaranteed an answer exists. If there are multiple shortest completing words, return the **first** one that occurs in `words`.
*Hãy trả về *từ hoàn thiện ngắn nhất trong `words`*. Đảm bảo luôn tồn tại câu trả lời. Nếu có nhiều từ hoàn thiện ngắn nhất, trả về từ **đầu tiên** xuất hiện trong `words`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** licensePlate = "1s3 PSt", words = ["step","steps","stripe","stepple"]
**Output:** "steps"
**Explanation:** licensePlate contains letters 's', 'p', 's', 't'.
"step" contains 't', 'e', 'p', 's' so it is missing an 's'.
"steps" contains 't', 'e', 'p', 's', 's'.
"stripe" is missing an 's'.
"stepple" is missing an 's'.
Since "steps" is the only word containing all the letters, that is the answer.

## Example 2:
## *Ví dụ 2:*

**Input:** licensePlate = "1s3 456", words = ["looks","pest","stew","show"]
**Output:** "pest"
**Explanation:** licensePlate contains the letter 's'. All the words contain 's', but among these "pest", "stew", and "show" are shortest. The answer is "pest" because it is the word that appears earliest of the 3.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= licensePlate.length <= 7`
*   `licensePlate` contains digits, letters (uppercase or lowercase), or space `' '`.
*   `1 <= words.length <= 1000`
*   `1 <= words[i].length <= 15`
*   `words[i]` consists of lower case English letters.
