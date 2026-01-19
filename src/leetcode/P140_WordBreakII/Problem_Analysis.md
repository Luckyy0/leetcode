# 140. Word Break II / Phân Tách Từ II

## Problem Description / Mô tả bài toán
Given a string `s` and a dictionary of strings `wordDict`, add spaces in `s` to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in **any order**.
Cho một chuỗi `s` và một danh sách các chuỗi `wordDict`, hãy thêm các dấu cách vào `s` để xây dựng một câu trong đó mỗi từ là một từ hợp lệ trong từ điển. Trả về tất cả các câu có thể có theo **bất kỳ thứ tự nào**.

**Note** that the same word in the dictionary may be reused multiple times in the segmentation.
**Lưu ý** rằng cùng một từ trong từ điển có thể được tái sử dụng nhiều lần trong quá trình phân tách.

### Example 1:
```text
Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]
```

### Example 2:
```text
Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
Explanation: Note that you are allowed to reuse a dictionary word.
```

### Example 3:
```text
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: []
```

## Constraints / Ràng buộc
- `1 <= s.length <= 20`
- `1 <= wordDict.length <= 1000`
- `1 <= wordDict[i].length <= 10`
- `s` and `wordDict[i]` consist of only lowercase English letters.
- All the strings of `wordDict` are **unique**.
- Input is generated in a way that the length of the answer is at most 10^5.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Backtracking with Memoization / Quay lui kết hợp Ghi nhớ
This problem asks for **all possible solutions**, which typically involves **backtracking**. However, since a string can often be split into many subproblems that repeat, **memoization** is crucial to avoid redundant work:
Bài toán này yêu cầu **tất cả các giải pháp có thể**, thường liên quan đến **quay lui**. Tuy nhiên, vì một chuỗi thường có thể được chia thành nhiều bài toán con lặp lại, nên **ghi nhớ** là rất quan trọng để tránh công việc thừa:

- **State**: Calculate all possible sentence completions for a given suffix `s[i...n]`.
- **Memoization**: Store the results of each suffix in a `Map<String, List<String>>`.

---

## Analysis / Phân tích

### Approach: Recursive Backtracking with Memoization / Quay lui Đệ quy kết hợp Ghi nhớ

**Complexity / Độ phức tạp**:
- **Time**: Worst case is exponential in the length of the string, but restricted by constraints and memoization.
- **Space**: O(2^N) in the worst case to store all potential path combinations.

---

## Edge Cases / Các trường hợp biên
1.  **No possible segmentation**: Return an empty list.
2.  **Short string**: Handled correctly by base recursion.
3.  **Large Dictionary**: Using a `HashSet` ensures O(1) word lookup.
