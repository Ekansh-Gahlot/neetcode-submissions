class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        return dfs(n);
    }

    public int dfs(int n) {
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;
        if(map.containsKey(n))
        return map.get(n);
        int res = dfs(n - 1) + dfs(n - 2);
        map.put(n, res);
        return res;
    }
}
