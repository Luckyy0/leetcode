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

---

## 5. Deletion Cases in AVL Tree
## 5. Các Trường Hợp Xóa Nút trong Cây AVL

When a node is deleted from an AVL tree, the height of its ancestor nodes may decrease, which can lead to a violation of the AVL property (Balance Factor becomes > 1 or < -1). We check the balance coming up from the deleted node to the root. If a node becomes unbalanced, there are exactly 4 possible cases based on the balance factor of the newly unbalanced node (`N`) and its child.
Khi một nút bị xóa khỏi cây AVL, chiều cao của các nút tổ tiên của nó có thể giảm xuống, dẫn đến việc vi phạm tính chất của cây AVL (Hệ số cân bằng trở thành > 1 hoặc < -1). Chúng ta kiểm tra sự cân bằng ngược lên từ nút bị xóa tới gốc. Nếu một nút trở nên mất cân bằng, có chính xác 4 trường hợp có thể xảy ra phân loại dựa trên hệ số cân bằng của nút bị mất cân bằng (`N`) và nút con của nó.

### 5.1 Left Left Case (LL) / Trường hợp Trái Trái
**Condition / Điều kiện:** `balance(N) > 1` and `balance(N.left) >= 0`

**Explanation / Giải thích:**
The left subtree of `N` is taller than the right subtree by at least 2, and the left child of `N` is perfectly balanced (`balance = 0`) or left-heavy (`balance > 0`). This typically happens when a node is deleted from the right subtree of `N`, causing the left side to become relatively too heavy. We fix this with a **Right Rotation** on `N`.
Cây con bên trái của `N` cao hơn cây con bên phải ít nhất là 2, và nút con trái của `N` hoàn toàn cân bằng (`hệ số cân bằng = 0`) hoặc lệch trái (`hệ số cân bằng > 0`). Điều này thường xảy ra khi một nút bị xóa khỏi cây con bên phải của `N`, làm cho phía bên trái trở nên quá nặng một cách tương đối. Chúng ta khắc phục bằng cách **Xoay Phải** tại `N`.

### 5.2 Left Right Case (LR) / Trường hợp Trái Phải
**Condition / Điều kiện:** `balance(N) > 1` and `balance(N.left) < 0`

**Explanation / Giải thích:**
The left subtree of `N` is taller than the right subtree by at least 2, but the left child of `N` is right-heavy (`balance < 0`). This means the extra height making `N` unbalanced comes from the right child of `N`'s left child. We first do a **Left Rotation** on `N.left`, turning it into a Left Left case, and then a **Right Rotation** on `N`.
Cây con bên trái của `N` cao hơn cây con bên phải ít nhất là 2, nhưng nút con trái của `N` lại lệch phải (`hệ số cân bằng < 0`). Điều này có nghĩa là chiều cao dư thừa làm `N` mất cân bằng xuất phát từ nút con phải của nút con trái của `N`. Đầu tiên ta thực hiện **Xoay Trái** tại `N.left`, đưa nó về trường hợp Trái Trái, sau đó **Xoay Phải** tại `N`.

### 5.3 Right Right Case (RR) / Trường hợp Phải Phải
**Condition / Điều kiện:** `balance(N) < -1` and `balance(N.right) <= 0`

**Explanation / Giải thích:**
The right subtree of `N` is taller than the left subtree by at least 2, and the right child of `N` is balanced (`balance = 0`) or right-heavy (`balance < 0`). This happens when a node is deleted from the left subtree of `N`. We fix this with a **Left Rotation** on `N`.
Cây con bên phải của `N` cao hơn cây con bên trái ít nhất là 2, và nút con phải của `N` đang cân bằng (`hệ số cân bằng = 0`) hoặc lệch phải (`hệ số cân bằng < 0`). Điều này xảy ra khi một nút bị xóa khỏi cây con bên trái của `N`. Chúng ta khắc phục bằng cách **Xoay Trái** tại `N`.

### 5.4 Right Left Case (RL) / Trường hợp Phải Trái
**Condition / Điều kiện:** `balance(N) < -1` and `balance(N.right) > 0`

**Explanation / Giải thích:**
The right subtree of `N` is taller than the left subtree by at least 2, but the right child of `N` is left-heavy (`balance > 0`). The extra height comes from the left child of `N`'s right child. To resolve this, we perform a **Right Rotation** on `N.right` to make it a Right Right case, followed by a **Left Rotation** on `N`.
Cây con bên phải của `N` cao hơn cây con bên trái ít nhất là 2, nhưng nút con phải của `N` lệch trái (`hệ số cân bằng > 0`). Chiều cao dư thừa làm mất cân bằng xuất phát từ nút con trái của nút con phải của `N`. Để giải quyết, chúng ta thực hiện **Xoay Phải** tại `N.right` để biến nó thành trường hợp Phải Phải, tiếp theo là **Xoay Trái** tại `N`.
