# Result for Design Twitter
# *Kết quả cho bài toán Thiết kế Twitter*

## Description
## *Mô tả*

Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see the `10` most recent tweets in the user's news feed.
*Thiết kế một phiên bản đơn giản của Twitter nơi người dùng có thể đăng tweet, theo dõi/hủy theo dõi người dùng khác và có thể xem `10` tweet gần đây nhất trong bảng tin (news feed) của người dùng.*

Implement the `Twitter` class:
*Thực hiện lớp `Twitter`:*

*   `Twitter()` Initializes your twitter object.
    *`Twitter()` Khởi tạo đối tượng twitter của bạn.*
*   `void postTweet(int userId, int tweetId)` Composes a new tweet with ID `tweetId` by the user `userId`. Each call to this function will be made with a unique `tweetId`.
    *`void postTweet(int userId, int tweetId)` Đăng một tweet mới với ID `tweetId` bởi người dùng `userId`. Mỗi lần gọi hàm này sẽ đi kèm với một `tweetId` duy nhất.*
*   `List<Integer> getNewsFeed(int userId)` Retrieves the `10` most recent tweet IDs in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user themself. Tweets must be **ordered from most recent to least recent**.
    *`List<Integer> getNewsFeed(int userId)` Lấy `10` ID tweet gần đây nhất trong bảng tin của người dùng. Mỗi mục trong bảng tin phải được đăng bởi những người dùng mà chính người đó theo dõi hoặc bởi chính người đó. Các tweet phải được **sắp xếp từ mới nhất đến cũ nhất**.*
*   `void follow(int followerId, int followeeId)` The user with ID `followerId` started following the user with ID `followeeId`.
    *`void follow(int followerId, int followeeId)` Người dùng có ID `followerId` bắt đầu theo dõi người dùng có ID `followeeId`.*
*   `void unfollow(int followerId, int followeeId)` The user with ID `followerId` started unfollowing the user with ID `followeeId`.
    *`void unfollow(int followerId, int followeeId)` Người dùng có ID `followerId` bắt đầu hủy theo dõi người dùng có ID `followeeId`.*

## Example 1:
## *Ví dụ 1:*

**Input:**
`["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]`
`[[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]`
**Output:**
`[null, null, [5], null, null, [6, 5], null, [5]]`

**Explanation:**
```java
Twitter twitter = new Twitter();
twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
twitter.getNewsFeed(1);  // User 1's news feed should return [5]. return [5]
twitter.follow(1, 2);    // User 1 follows user 2.
twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
twitter.getNewsFeed(1);  // User 1's news feed should return [6, 5]. return [6, 5]
twitter.unfollow(1, 2);  // User 1 unfollows user 2.
twitter.getNewsFeed(1);  // User 1's news feed should return [5]. return [5]
```

## Constraints:
## *Ràng buộc:*

*   `1 <= userId, followerId, followeeId <= 500`
*   `0 <= tweetId <= 10^4`
*   All the tweets have **unique** IDs.
*   At most `3 * 10^4` calls will be made to `postTweet`, `getNewsFeed`, `follow`, and `unfollow`.
