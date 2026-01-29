# Problem Analysis: Design Movie Rental System

## Problem Description
Manage movie rentals.
`search(movie)`: Cheapest unrented copies.
`rent(shop, movie)`: Mark rented.
`drop(shop, movie)`: Return.
`report()`: Cheapest rented copies.

## Analysis

1.  **Data Structures**:
    -   Need to look up copies by `(shop, movie)` to get price (for rent/drop).
        -   `Map<Pair<Integer, Integer>, Integer> prices`.
    -   Need to look up cheapest unrented copies for a movie.
        -   `Map<Integer, TreeSet<Entry>> unrented`.
        -   Entry implements `Comparable`: Sort by `price`, then `shop`.
        -   `search` returns top 5 from the TreeSet.
    -   Need to look up cheapest rented copies globally.
        -   `TreeSet<Entry> rented`.
        -   Entry: Sort by `price`, then `shop`, then `movie`.
        -   `report` returns top 5.
        
2.  **Operations**:
    -   `Constructor`: Fill maps.
    -   `search`: Access `unrented.get(movie)`. Get first 5.
    -   `rent`: Find price. Remove from `unrented`. Add to `rented`.
    -   `drop`: Find price. Remove from `rented`. Add to `unrented`.
    -   `report`: Get top 5 from `rented`.

3.  **Complexity**:
    -   All operations $O(\log N)$ or $O(5 \log N)$.
    -   Efficient.

## Implementation Details
-   Helper class `Entry`.
-   `TreeSet` or `PriorityQueue`. TreeSet supports removal efficiently.
