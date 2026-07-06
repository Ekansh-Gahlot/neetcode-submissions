class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    public int uniquePaths(int m, int n) {
        return dfs(0,0,m,n);
    }

    public int dfs(int i, int j, int m, int n){
        if(i == m-1 && j == n-1)
        return 1;

        if(i >= m || j >= n)
        return 0;
        String key = i + "," + j;
        if(map.containsKey(key))
        return map.get(key);

        int res = dfs(i,j+1, m, n) + dfs(i+1, j, m, n);
        map.put(key, res);
        return res;
    }
}
