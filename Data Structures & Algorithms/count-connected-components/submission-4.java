class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0 ; i < n; i++){
            list.add(new ArrayList<>());
        }

        for(int[] e: edges){
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }  

        int connect = 0;

        boolean[] vis = new boolean[n];

        for(int i = 0 ; i < n; i++){
            if(!vis[i]){
                dfs(i, list, vis);
                connect++;
            }
        }
        return connect;
    }

    public void dfs(int i, List<List<Integer>> list, boolean[] vis){
        if(vis[i])
        return;
        vis[i] = true;

        for(int e: list.get(i)){
            dfs(e, list, vis);
        }
    }
}
