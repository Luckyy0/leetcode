# 1516. Move Sub-Tree of N-Ary Tree / Di chuyển Cây con của Cây N-Ary

## Problem Description / Mô tả bài toán
N-ary tree. Move node `p` (and subtree) to become child of node `q`.
If `node` in `p`'s subtree is `q`, then handle edge case (make `p` child of `q`, but `q`'s original parent needs handling? No.
Cases:
1. `q` is in `p`'s subtree.
2. `q` is NOT in `p`'s subtree.
Tree constraints: connected, no cycles.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Tree Manipulation
Find parents of `p` and `q`.
Case 1: `p` is ancestor of `q`.
- Need to disconnect `p` from its parent.
- Connect `p` to `q`.
- Wait. If `q` is descendant of `p`, moving `p` under `q` disconnects `q` from root (since `q` reachable via `p`).
- We must reparent `q`? No.
- Standard "Move Subtree" rules usually imply just adjusting pointers. But if cycle created, problem statement usually clarifies.
- Clarification: "Move `p` to be a direct child of `q`. If `p` is already a direct child of `q`, do nothing."
- "If `q` is in the subtree of `p`, disconnect `p` from its parent, make `p` a child of `q`. BUT `q` was reachable from `p`. So `q`'s part of subtree must be preserved? No."
- Typically: If `q` is in `p`'s subtree, we must detach `q` (or the child of `p` that leads to `q`) from its parent, and attach it to `p`'s original parent? No.
- Re-read: "Move node `p`... to become a direct child of node `q`."
- If `q` is in `p`'s subtree:
  Connect `p`'s original parent to `q`? No.
  Problem might specify special handling.
  Usually: Find child of `p` that is ancestor of `q`. Let's call it `childP`. Reparent `childP` to `p`'s original parent. Then move `p` to `q`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Checking Ancestry
DFS to get parent pointers and depths/times to check ancestry in O(1).
Or just simple traversal.
Condition: `q` in subtree of `p`.
Check if `p` is ancestor of `q`.
If NOT:
- Remove `p` from `p.parent`.
- Add `p` to `q.children`.
If YES (`q` inside `p`):
- `p` moves under `q`.
- But `q` (and its parent chain up to `p`) is currently under `p`.
- We need to prevent cycle and disconnect.
- The node `X` which is child of `p` and ancestor of `q` (or `q` itself) must take `p`'s place?
- Problem statement says: "Node `p` is in the sub-tree of `root`".
- Actually usually:
  If `q` is in `p`'s subtree, let `p`'s parent be `parentP`.
  We move `p` to `q`.
  BUT `q` is descendant of `p`. So `q` becomes parent of `p`.
  Cycle: `q -> ... -> p -> q`.
  To fix: The edge leading from `p` towards `q` must be broken?
  No, usually "Disconnect `p` from parent. Attach to `q`. If `q` was in `p`'s subtree, `p`'s original position is filled by ...?"
  Wait. The problem says "Move Sub-Tree".
  Special rule from similar problems: If `q` is in `p`'s subtree, node `p` becomes child of `q`. The original parent of `p` becomes parent of the child of `p` that contains `q`.
  Let child of `p` on path to `q` be `S`.
  `parent(p).children` remove `p`, add `S`.
  `p` becomes child of `q`.
  `S` becomes child of `parent(p)`.
  Correct.

### Logic
1. Find `parent` of each node.
2. Check if `p` is ancestor of `q`.
   - Iterate up from `q`. If finding `p`, then yes. Also track the child of `p` on this path (`node_under_p`).
3. If no:
   - `parent[p].children.remove(p)`.
   - `q.children.add(p)`.
4. If yes:
   - `parent[p].children.remove(p)`.
   - `parent[p].children.add(node_under_p)`. (Replace p with node_under_p).
   - `node_under_p` is child of `p`. `p.children.remove(node_under_p)`.
   - `q.children.add(p)`.
   - Handle root case if `p` was root.

---
