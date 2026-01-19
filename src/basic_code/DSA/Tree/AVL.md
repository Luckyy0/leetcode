# AVL Tree Rotations
# Các Phép Xoay Cây AVL

AVL Trees satisfy the property that for any node, the difference in height between its left and right subtrees (Balance Factor) is at most 1.
Cây AVL thỏa mãn tính chất là tại bất kỳ nút nào, sụ chênh lệch chiều cao giữa cây con trái và cây con phải (Hệ số cân bằng) tối đa là 1.

When this property is violated after an insertion or deletion, we perform **rotations** to restore balance.
Khi tính chất này bị vi phạm sau khi chèn hoặc xóa, chúng ta thực hiện **các phép xoay** để khôi phục sự cân bằng.

There are 4 scenarios requiring rotation:
Có 4 trường hợp cần xoay:

1.  **Left-Left (LL)** -> Right Rotation
2.  **Right-Right (RR)** -> Left Rotation
3.  **Left-Right (LR)** -> Left Rotation then Right Rotation
4.  **Right-Left (RL)** -> Right Rotation then Left Rotation

---

## 1. Right Rotation (Single Rotation)
## 1. Xoay Phải (Xoay Đơn)

**Trigger:** The imbalance is in the Left child's Left subtree (LL Case).
**Kích hoạt:** Mất cân bằng xảy ra ở cây con Trái của con Trái (Trường hợp LL).

**Diagram / Sơ đồ:**

Before Rotation / Trước khi xoay:
```text
        y (Imbalance / Mất cân bằng)
       /
      x
     /
    z
```

After Right Rotation on 'y' / Sau khi xoay phải tại 'y':
```text
      x
     / \
    z   y
```

**Steps / Các bước:**
1. `x` becomes the new root of this subtree. / `x` trở thành gốc mới của cây con này.
2. `y` becomes the right child of `x`. / `y` trở thành con phải của `x`.
3. If `x` had a right child `T2`, it moves to become the left child of `y`. / Nếu `x` có con phải `T2`, nó chuyển sang làm con trái của `y`.

---

## 2. Left Rotation (Single Rotation)
## 2. Xoay Trái (Xoay Đơn)

**Trigger:** The imbalance is in the Right child's Right subtree (RR Case).
**Kích hoạt:** Mất cân bằng xảy ra ở cây con Phải của con Phải (Trường hợp RR).

**Diagram / Sơ đồ:**

Before Rotation / Trước khi xoay:
```text
    x (Imbalance / Mất cân bằng)
     \
      y
       \
        z
```

After Left Rotation on 'x' / Sau khi xoay trái tại 'x':
```text
      y
     / \
    x   z
```

**Steps / Các bước:**
1. `y` becomes the new root of this subtree. / `y` trở thành gốc mới của cây con này.
2. `x` becomes the left child of `y`. / `x` trở thành con trái của `y`.
3. If `y` had a left child `T2`, it moves to become the right child of `x`. / Nếu `y` có con trái `T2`, nó chuyển sang làm con phải của `x`.

---

## 3. Left-Right Rotation (Double Rotation)
## 3. Xoay Trái-Phải (Xoay Kép)

**Trigger:** The imbalance is in the Left child's Right subtree (LR Case).
**Kích hoạt:** Mất cân bằng xảy ra ở cây con Phải của con Trái (Trường hợp LR).

**Process / Quy trình:**
1. Perform **Left Rotation** on the left child (`x`). / Thực hiện **Xoay Trái** trên con trái (`x`).
2. Perform **Right Rotation** on the current root (`y`). / Thực hiện **Xoay Phải** trên gốc hiện tại (`y`).

**Diagram / Sơ đồ:**

State 1: Imbalance at y (LR Case) / Trạng thái 1: Mất cân bằng tại y
```text
      y
     /
    x
     \
      z
```

State 2: After Left Rotation on x / Trạng thái 2: Sau khi xoay trái tại x
```text
      y
     /
    z
   /
  x
```

State 3: After Right Rotation on y / Trạng thái 3: Sau khi xoay phải tại y
```text
    z
   / \
  x   y
```

---

## 4. Right-Left Rotation (Double Rotation)
## 4. Xoay Phải-Trái (Xoay Kép)

**Trigger:** The imbalance is in the Right child's Left subtree (RL Case).
**Kích hoạt:** Mất cân bằng xảy ra ở cây con Trái của con Phải (Trường hợp RL).

**Process / Quy trình:**
1. Perform **Right Rotation** on the right child (`y`). / Thực hiện **Xoay Phải** trên con phải (`y`).
2. Perform **Left Rotation** on the current root (`x`). / Thực hiện **Xoay Trái** trên gốc hiện tại (`x`).

**Diagram / Sơ đồ:**

State 1: Imbalance at x (RL Case) / Trạng thái 1: Mất cân bằng tại x
```text
    x
     \
      y
     /
    z
```

State 2: After Right Rotation on y / Trạng thái 2: Sau khi xoay phải tại y
```text
    x
     \
      z
       \
        y
```

State 3: After Left Rotation on x / Trạng thái 3: Sau khi xoay trái tại x
```text
      z
     / \
    x   y
```
