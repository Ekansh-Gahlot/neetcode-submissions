class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public int countComponents(int n, int[][] edges) {
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }

        for(int[] e: edges){
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }

        boolean[] vis = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++){
            if(!vis[i]){
                dfs(vis, n, i);
                count++;
            }
        }
        return count;
    }

    public void dfs(boolean[] vis, int n, int i){
        if(vis[i])
        return;

        vis[i] = true;

        for(int e: list.get(i)){
            dfs(vis, n, e);
        }
    }
}
