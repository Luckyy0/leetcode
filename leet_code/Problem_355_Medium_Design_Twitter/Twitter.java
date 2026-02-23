package leet_code.Problem_355_Medium_Design_Twitter;

import java.util.*;

public class Twitter {

    private static int timestamp = 0;

    private class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id) {
            this.id = id;
            this.time = timestamp++;
            this.next = null;
        }
    }

    private class User {
        int id;
        Set<Integer> followed;
        Tweet tweetsHead;

        User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id); // Follow self
            tweetsHead = null;
        }

        void follow(int id) {
            followed.add(id);
        }

        void unfollow(int id) {
            if (id != this.id) {
                followed.remove(id);
            }
        }

        void post(int id) {
            Tweet t = new Tweet(id);
            t.next = tweetsHead;
            tweetsHead = t;
        }
    }

    private Map<Integer, User> userMap;

    /**
     * Design Twitter.
     * Uses OOP with Linked List for Tweets and Priority Queue for merging news
     * feeds.
     * Time: O(K) for news feed, Space: O(T+U).
     * 
     * Thiết kế Twitter.
     * Sử dụng OOP với Danh sách liên kết cho Tweets và Priority Queue để hợp nhất
     * news feed.
     */
    public Twitter() {
        userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userMap.computeIfAbsent(userId, k -> new User(userId)).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();
        if (!userMap.containsKey(userId))
            return res;

        Set<Integer> followers = userMap.get(userId).followed;
        PriorityQueue<Tweet> q = new PriorityQueue<>((a, b) -> b.time - a.time);

        for (int f : followers) {
            Tweet head = userMap.get(f).tweetsHead;
            if (head != null) {
                q.add(head);
            }
        }

        int n = 0;
        while (!q.isEmpty() && n < 10) {
            Tweet t = q.poll();
            res.add(t.id);
            n++;
            if (t.next != null) {
                q.add(t.next);
            }
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        userMap.computeIfAbsent(followerId, k -> new User(followerId));
        userMap.computeIfAbsent(followeeId, k -> new User(followeeId));
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId == followeeId)
            return;
        userMap.get(followerId).unfollow(followeeId);
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        System.out.println("Feed 1: " + twitter.getNewsFeed(1)); // [5]
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println("Feed 1: " + twitter.getNewsFeed(1)); // [6, 5]
        twitter.unfollow(1, 2);
        System.out.println("Feed 1: " + twitter.getNewsFeed(1)); // [5]
    }
}
