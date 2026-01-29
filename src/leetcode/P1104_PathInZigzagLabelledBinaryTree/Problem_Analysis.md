# 1104. Path In Zigzag Labelled Binary Tree / Đường dẫn trong Cây Nhị phân được Dán nhãn Zigzag

## Problem Description / Mô tả bài toán
In an infinite binary tree where:
- Root is at row 1, label 1.
- For odd numbered rows (1, 3, 5...), labeling is left to right.
- For even numbered rows (2, 4, 6...), labeling is right to left.
Given the `label` of a node, return the path from the root to that node.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Tree math / Toán học Cây
Level `d` has values from `2^(d-1)` to `2^d - 1`.
If not zigzag, parent of `label` is `label / 2`.
With zigzag, the position is inverted.
Specifically, at level `d`, the node at offset `x` (from start of level) actually corresponds to offset `max_offset - x` in the "standard" layout if the level is inverted.
Or simply, `parent(label)` in zigzag logic:
In standard tree: `parent_label = label / 2`.
In zigzag tree: The values at previous level are reversed relative to the standard parent mapping.
Formula: `parent = (min_val(level-1) + max_val(level-1) - label/2)`.
Correction: `label/2` gives the parent in standard mapping.
Let `standard_parent = label / 2`.
The actual parent in zigzag is the symmetric counterpart of `standard_parent` in the logical level.
`actual_parent = start_prev + end_prev - standard_parent`.

Algorithm:
1. Find level of `label`.
2. Compute path upwards.
3. At each step up:
   - `level--`.
   - `label = label / 2`.
   - `label = (1 << (level-1)) + (1 << level) - 1 - label`.
   - Or basically invert `label` within its level boundaries.
   - Wait, logic: `label/2` is the node index in the layer above IF the layer above was "aligned" correctly to `label`'s layer.
   - Due to zigzag, `parent = Complement(label/2, level-1)`.

### Complexity / Độ phức tạp
- **Time**: O(log Label).
- **Space**: O(log Label).

---

## Analysis / Phân tích

### Approach: Inversion Logic
Calculate the depth (level) of the tarage label. Traverse upwards to the root. In a standard binary tree, the parent is `label/2`. Due to the zigzag labeling, the actual parent at the previous level is the "mirror image" of `label/2`. The mirror value $v'$ of value $v$ in a level range $[min, max]$ is $min + max - v$. Apply this inversion at every step.
Tính toán độ sâu (cấp) của nhãn mục tiêu. Duyệt ngược lên gốc. Trong cây nhị phân tiêu chuẩn, cha mẹ là `label/2`. Do dán nhãn zigzag, cha mẹ thực tế ở cấp trước đó là "hình ảnh phản chiếu" của `label/2`. Giá trị phản chiếu $v'$ của giá trị $v$ trong phạm vi cấp $[min, max]$ là $min + max - v$. Áp dụng sự đảo ngược này ở mỗi bước.

---
