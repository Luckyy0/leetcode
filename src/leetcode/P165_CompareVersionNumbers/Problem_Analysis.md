# 165. Compare Version Numbers / So Sánh Số Phiên Bản

## Problem Description / Mô tả bài toán
Given two version numbers, `version1` and `version2`, compare them.
Cho hai số phiên bản `version1` và `version2`, hãy so sánh chúng.

A version number consists of one or more **revisions** joined by a dot `'.'`. Each revision consists of **digits** and may contain leading **zeros**. Every revision contains at least one character. Revisions are **0-indexed from left to right**, with the leftmost revision being revision 0, the next revision being revision 1, and so on. For example `2.5.33` and `0.1` are valid version numbers.
Một số phiên bản bao gồm một hoặc nhiều **lần sửa đổi (revision)** được nối với nhau bằng dấu chấm `'.'`. Mỗi lần sửa đổi bao gồm các **chữ số** và có thể chứa các **số 0 ở đầu**. Mỗi lần sửa đổi chứa ít nhất một ký tự. Các lần sửa đổi được **đánh chỉ số từ 0 từ trái sang phải**. Ví dụ `2.5.33` và `0.1` là các số phiên bản hợp lệ.

To compare version numbers, compare their revisions in order from left to right. Revisions are compared using their **integer value ignoring any leading zeros**. This means revisions `1` and `001` are considered equal. If a version number does not specify a revision at an index, then treat the revision as `0`. For example, version `1.0` is less than version `1.1` because their revision 0 are the same, but their revision 1 are `0` and `1` respectively, and `0 < 1`.
Để so sánh các số phiên bản, hãy so sánh các lần sửa đổi của chúng theo thứ tự từ trái sang phải. Các lần sửa đổi được so sánh bằng **giá trị số nguyên của chúng, bỏ qua mọi số 0 ở đầu**. Điều này có nghĩa là revision `1` và `001` được coi là bằng nhau. Nếu một số phiên bản không chỉ định revision tại một chỉ số, hãy coi revision đó là `0`.

Return:
- If `version1 < version2`, return `-1`.
- If `version1 > version2`, return `1`.
- Otherwise, return `0`.

### Example 1:
```text
Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
```

### Example 2:
```text
Input: version1 = "1.0", version2 = "1.1"
Output: -1
Explanation: version1's revision 0 is "1", version2's revision 0 is "1". Both are equal. But version1's revision 1 is "0", version2's revision 1 is "1". 0 < 1, so version1 < version2.
```

## Constraints / Ràng buộc
- `1 <= version1.length, version2.length <= 500`
- `version1` and `version2` only contain digits and `'.'`.
- `version1` and `version2` are **valid version numbers**.

---

## Theoretical Foundation / Cơ sở lý thuyết

### String Tokenization / Phân tách Chuỗi
We need to split the version strings by `.` and convert each segment into an integer.
Chúng ta cần tách các chuỗi phiên bản bằng dấu `.` và chuyển đổi từng đoạn thành số nguyên.

**Regex Note**: In Java/Regex, `.` is a special character meaning "any character". To split by a literal dot, use `split("\\.")`.

### Alignment / Căn chỉnh
If the versions have different numbers of revisions (e.g., `1.0` vs `1.0.0.0`), we pad the shorter one with `0`s implicitly or explicitly.
Nếu các phiên bản có số lượng revision khác nhau, chúng ta coi các revision thiếu là `0`.

---

## Analysis / Phân tích

### Approach: Two Pointer or Split Strategy

**Algorithm**:
1. Split `version1` into `v1_revisions` and `version2` into `v2_revisions`.
2. Find the maximum length of the two revision arrays.
3. Iterate from `0` to `maxLen - 1`:
    - Get revision `val1` from `v1_revisions` (if index exists, else `0`).
    - Get revision `val2` from `v2_revisions` (if index exists, else `0`).
    - Compare `val1` and `val2`.
    - Return `-1` or `1` if they differ.
4. Return `0` if all revisions are equal.

### Complexity / Độ phức tạp
- **Time**: O(N + M + max(Revisions1, Revisions2)) -> O(max(N, M)).
- **Space**: O(N + M) to store the result of splitting.

---

## Edge Cases / Các trường hợp biên
1.  **Leading zeros**: Handled by `Integer.parseInt()`.
2.  **Different lengths**: `1` vs `1.0.0` should be equal.
3.  **Many revisions**.
