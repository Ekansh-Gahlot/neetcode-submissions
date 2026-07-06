class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    public int uniquePaths(int m, int n) {
        int result = 0;

        result = dfs(0,0,m,n);
        return result;
    }

    public int dfs(int i, int j, int m, int n){
        if(i >= m || j >= n)
        return 0;

        if(i == m-1 && j == n-1)
        return 1;
        String key = i + "," + j;
        if(map.containsKey(key))
        return map.get(key);
        int res = dfs(i+1, j, m, n) + dfs(i, j+1, m, n);
        map.put(key, res);
        return res;
    }
}
