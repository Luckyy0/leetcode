# 355. Design Twitter / Thiết Kế Tiện Ích Twitter

## Problem Description / Mô tả bài toán
Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see the `10` most recent tweets in the user's news feed.
Thiết kế phiên bản đơn giản của Twitter...

Implement the `Twitter` class:
- `Twitter()` Initializes your twitter object.
- `void postTweet(int userId, int tweetId)` Composes a new tweet with ID `tweetId` by the user `userId`. Each call to this function will be unique (i.e., no two tweets will have the same ID).
- `List<Integer> getNewsFeed(int userId)` Retrieves the `10` most recent tweet IDs in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user themself. Tweets must be ordered from most recent to least recent.
- `void follow(int followerId, int followeeId)` The user with ID `followerId` started following the user with ID `followeeId`.
- `void unfollow(int followerId, int followeeId)` The user with ID `followerId` started unfollowing the user with ID `followeeId`.

### Example 1:
```text
Input
["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
[[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
Output
[null, null, [5], null, null, [6, 5], null, [5]]
```

## Constraints / Ràng buộc
- `1 <= userId, followerId, followeeId <= 500`
- `0 <= tweetId <= 10^4`
- All the tweets have unique IDs.
- At most `3 * 10^4` calls will be made to `postTweet`, `getNewsFeed`, `follow`, and `unfollow`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Object-Oriented Design + Priority Queue / Heap
Entities:
- `User`: ID, Set of followed IDs, List of Tweets (head of linked list or actual list).
- `Tweet`: ID, Timestamp (global counter), Next Tweet (pointer).

Operations:
- `postTweet`: Create Tweet, prepend to User's tweet list. Update timestamp.
- `follow`: Add ID to set.
- `unfollow`: Remove ID from set.
- `getNewsFeed`:
    - Gather latest tweets from User and all Followees.
    - Since each user's tweets are already sorted (by time, due to prepend), we have `K` sorted lists (K = 1 + num_followed).
    - Use Merge K Sorted Lists pattern.
    - Max Heap (by timestamp) of size 10 (or Min Heap size 10? No, we need top 10 most recent. So pull from K lists).
    - Actually, use a Max Heap to pick the absolute MAX timestamp among the heads of the K lists. Poll and advance pointer. Repeat 10 times.

### Complexity / Độ phức tạp
- **Time**:
    - `postTweet`: O(1).
    - `follow/unfollow`: O(1).
    - `getNewsFeed`: O(F log F) or O(10 log F) where F is number of followees. F is bounded by total users (500). 10 is const.
- **Space**: O(Tweets + Relations).

---

## Analysis / Phân tích

### Approach: Pull Model + MaxHeap

**Algorithm**:
1.  Global `timestamp` counter.
2.  `Map<userId, User>` userMap.
3.  `User` class: `id`, `followed` (Set), `tweetHead` (Tweet).
4.  `Tweet` class: `id`, `time`, `next`.
5.  `getNewsFeed`:
    - PriorityQueue of Tweets (compare by time desc).
    - Add `tweetHead` of self and all followees to PQ.
    - Extract max 10. When extracting `t`, add `t.next` to PQ if exists.

---
