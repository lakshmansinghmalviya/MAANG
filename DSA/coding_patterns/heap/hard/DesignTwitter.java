// https://leetcode.com/problems/design-twitter/

package coding_patterns.heap.hard;

import java.util.HashMap;
import java.util.*;
import java.util.Map;
import java.util.Set;

class Twitter {
    Map<Integer, List<int[]>> tweets;
    Map<Integer, Set<Integer>> following;
    int time;

    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<int[]>());
        tweets.get(userId).add(new int[] { time++, tweetId });
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        if (tweets.containsKey(userId)) {
            for (int tweets[] : tweets.get(userId)) {
                minHeap.offer(tweets);
                if (minHeap.size() > 10) {
                    minHeap.poll();
                }
            }
        }

        if (following.containsKey(userId)) {
            for (int followee : following.get(userId)) {
                if (tweets.containsKey(followee)) {
                    for (int tweets[] : tweets.get(followee)) {
                        minHeap.offer(tweets);
                        if (minHeap.size() > 10) {
                            minHeap.poll();
                        }
                    }
                }
            }
        }

        // System.out.println(minHeap);
        LinkedList<Integer> list = new LinkedList<>();
        while (!minHeap.isEmpty()) {
            list.addFirst(minHeap.poll()[1]);
        }
        return list;
    }

    public void follow(int followerId, int followeeId) {
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).remove(followeeId);
    }
}

public class DesignTwitter {
    public static void main(String[] args) {
      
    }
}