# 1410. HTML Entity Parser / Trình Phân tích Thực thể HTML

## Problem Description / Mô tả bài toán
String `text`. Replace HTML entities:
`&quot;` -> `"`
`&apos;` -> `'`
`&amp;` -> `&`
`&gt;` -> `>`
`&lt;` -> `<`
`&frasl;` -> `/`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### String Replacement
Careful with order. E.g. `&amp;gt;` -> `&gt;` -> `>`? No, normally one pass.
Replace specific strings.
Since Java Strings are immutable and we want single pass or efficient replacement:
Use `text.replace` calls? Constraints `10^5`. Chained replace is O(N*6) = O(N).
Wait. `&amp;` should be replaced to `&`. If input is `&amp;gt;`, replacing `&amp;` first yields `&gt;`. Does this trigger another replacement? usually parser decodes entities once.
In standard HTML, decoding `&amp;gt;` gives `&gt;`. It stops.
So simple `.replace()` chain works if done carefully? But `replace` creates new strings.
Given specific list, iterating and building `StringBuilder` might be cleaner.
Or `replaceAll` but regex overhead.
Or Map `&quot;` -> `"`...
Iterate string, detect `&`. Check if following chars match entity.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: StringBuilder and Check
Iterate through the string. If `&` is encountered, check if it matches any known entity. If yes, append the replacement. Else append `&`.
Use a Map for entities. Or hardcode checks.
Actually, the standard library might not handle `&frasl;` (it's not standard XML but HTML specific).
Careful with `&amp;` being a prefix of others? No, all start with `&` end with `;`.
Simply replacing using `String.replace` is easiest to implement and efficient enough for 6 entities.
Order matters? `&amp;` -> `&`. Is it possible `&amp;quot;` becomes `"`? No. Parser should be one pass.
Wait. If we use `replace("&amp;", "&")`, then `replace("&lt;", "<")`.
If input `&amp;lt;`. Pass 1: `&lt;`. Pass 2: `<`.
Is this correct behavior? Usually HTML decoding is NOT recursive.
If input `&amp;lt;`, it means `&lt;`. It should remain `&lt;` as text `<`.
If we just chain `replace`, it becomes recursive (potentially).
Example: Input `&amp;gt;`. Output should be `&gt;`.
Chained `replace` might produce `>`.
So `replace` is wrong if applied sequentially on result of previous replace.
BUT `String.replace` processes the whole string.
We must perform replacements such that we don't re-process replaced content.
Map approach:
Iterate chars. Finds `&`. Look ahead for `;`. If substring matches entity, replace. Else keep.
Lặp lại qua chuỗi. Nếu gặp `&`, hãy kiểm tra xem nó có khớp với bất kỳ thực thể đã biết nào không. Nếu có, hãy thêm phần thay thế. Nếu không, hãy thêm `&`.
Thực hiện thay thế một lần (không đệ quy).
Sử dụng bản đồ các thực thể.

---
