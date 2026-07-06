class Twitter {
    HashMap<Integer, List<int[]>> tweetMap;
    HashMap<Integer, HashSet<Integer>> followMap;
    int count;
    public Twitter() {
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
        count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweetMap.containsKey(userId))
        {
            tweetMap.put(userId, new ArrayList<>());
        }
        tweetMap.get(userId).add(new int[]{count, tweetId});
        count++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->b[0]-a[0]);

        HashSet<Integer> followingListSet = followMap.getOrDefault(userId, new HashSet<Integer>());
        followingListSet.add(userId);
        for(int followingListUser : followingListSet)
        {
            List<int[]> tweets = tweetMap.getOrDefault(followingListUser, new ArrayList<int[]>());
            for(int[] tweet: tweets)
            maxHeap.add(tweet);
        }

        while(!maxHeap.isEmpty() && list.size() < 10)
        {
            list.add(maxHeap.poll()[1]);
        }
        return list;

    }
    
    public void follow(int followerId, int followeeId) {
        if(!followMap.containsKey(followerId))
        {
            followMap.put(followerId, new HashSet<>());
        }
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId))
        followMap.get(followerId).remove(followeeId);
    }
}
