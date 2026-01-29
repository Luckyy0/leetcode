# Problem Analysis: Throne Inheritance

## Problem Description
Implement `ThroneInheritance`:
-   `ThroneInheritance(string kingName)`
-   `void birth(string parentName, string childName)`
-   `void death(string name)`
-   `List<String> getInheritanceOrder()` - return order excluding dead people.
Order: King first. Then King's children in birth order (recursively). Pre-order traversal.

## Analysis

1.  **Data Structure**:
    -   We need to store the family tree.
    -   `Map<String, Node>` to access any person by name (for birth/death).
    -   `Node`: `name`, `List<Node> children`, `isDead`.

2.  **Operations**:
    -   `birth(p, c)`: Look up `p` node. Add `c` to its children. Store `c` in map.
    -   `death(name)`: Look up `name` node. Set `isDead = true`.
    -   `getInheritanceOrder()`: Perform DFS (pre-order) starting from King. Add name to list if `!isDead`.

3.  **Complexity**:
    -   Birth/Death: $O(1)$.
    -   GetOrder: $O(N)$ where N is total people generated. (10^5 calls max).

## Implementation Details
-   `HashMap`.
-   Recursive DFS helper.
