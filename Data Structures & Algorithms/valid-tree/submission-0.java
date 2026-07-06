class Solution {
    public boolean validTree(int n, int[][] edges) {
        // if(edges.length > n-1)
        // return false;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> set = new HashSet<>();

        if(!dfs(0, -1, set, adj))
        return false;

        return set.size() == n;

    }

    public boolean dfs(int node, int parent, Set<Integer> set,  List<List<Integer>> adj){
        if(set.contains(node))
        return false;

        set.add(node);

        for(int nei: adj.get(node)){
            if(nei == parent)
            continue;

           if(!dfs(nei, node, set, adj)){
            return false;
           }
        }
        return true;
    }
}
