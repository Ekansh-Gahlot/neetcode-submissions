class Twitter {
    HashMap<Integer, HashSet<Integer>> followMap;
    HashMap<Integer, List<int[]>> tweetMap;
    int count;
    public Twitter() {
        count = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweetMap.containsKey(userId)){
            tweetMap.put(userId, new ArrayList<>());
        }
        tweetMap.get(userId).add(new int[]{count,tweetId});
        count++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->b[0]-a[0]);
        HashSet<Integer> followSet = followMap.getOrDefault(userId, new HashSet<Integer>());
        followSet.add(userId);
        for(int followId: followSet){
            List<int[]> tweets = tweetMap.getOrDefault(followId, new ArrayList<>());
            for(int[] tweet: tweets)
            maxHeap.offer(tweet);
        }

        while(!maxHeap.isEmpty() && list.size() < 10){
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
