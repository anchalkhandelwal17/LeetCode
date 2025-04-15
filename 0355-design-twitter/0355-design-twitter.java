class Twitter {

    private class Tweet {
        int tweetId;
        int timeStamp;

        public Tweet(int tweetId, int timeStamp){
            this.tweetId = tweetId;
            this.timeStamp = timeStamp;
        }
    }

    static int timeStamp;
    HashMap<Integer, Set<Integer>> followees;
    HashMap<Integer, List<Tweet>> userTweets;

    public Twitter() {
        timeStamp = 0;
        followees = new HashMap<>();
        userTweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (userTweets.get(userId) == null) {
            userTweets.put(userId, new ArrayList<>());
            follow(userId, userId);
        }
        userTweets.get(userId).add(0, new Tweet(tweetId, timeStamp++));
    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweet> feedHeap = new PriorityQueue<Tweet>(new Comparator<Tweet>() {
            public int compare(Tweet t1, Tweet t2) {
                return t1.timeStamp - t2.timeStamp;
            }
        });

        Set<Integer> UserFollowees = followees.get(userId);
        if (UserFollowees != null) {
            for (int user : UserFollowees) {
                List<Tweet> Tweets = userTweets.get(user);
                if (Tweets == null)
                    continue;

                for (Tweet t : Tweets) {
                    if (feedHeap.size() < 10)
                        feedHeap.add(t);
                    else {
                        if (t.timeStamp <= feedHeap.peek().timeStamp)
                            break;
                        else {
                            feedHeap.add(t);
                            feedHeap.poll();
                        }
                    }
                }
            }
        }

        List<Integer> userFeed = new ArrayList<>();
        while (!feedHeap.isEmpty()) {
            userFeed.add(0, feedHeap.poll().tweetId);
        }

        return userFeed;
    }

    public void follow(int followerId, int followeeId) {
        if (!followees.containsKey(followerId)) {
            followees.put(followerId, new HashSet<>());
        }
        followees.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!followees.containsKey(followerId) || followerId == followeeId) {
            return;
        }
        followees.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */