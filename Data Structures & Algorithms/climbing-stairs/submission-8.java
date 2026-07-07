class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        int ans = dfs(n);
        return ans;
    }

    public int dfs(int n){
        if(n == 0)
        return 1;

        if(n < 0)
        return 0;

        if(map.containsKey(n))
        return map.get(n);

        int ans = dfs(n-1) + dfs(n-2);
        map.put(n, ans);
        return ans;
    }
}
