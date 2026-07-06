class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int res = 0;
        boolean[] visit = new boolean[n];
        for(int i = 0 ; i < n; i++){
            if(!visit[i]){
                dfs(visit, i, adj);
                res++;
            }
        }
        return res;
    }

    public void dfs(boolean[] visit, int node, List<List<Integer>> adj){
        visit[node] = true;
    
        
        for(int nei: adj.get(node)){
           if(!visit[nei])

            dfs(visit, nei, adj);
        }
    }
}
