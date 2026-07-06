class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i< n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        if(!dfs(0,-1,adj))
        return false;
        return set.size() == n;

    }


    public boolean dfs(int node, int parent, List<List<Integer>> adj){
        if(set.contains(node)){
            return false;
        }

        set.add(node);

        for(int nei: adj.get(node)){
            if(nei == parent)
            continue;

            if(!dfs(nei, node, adj))
            return false;
        }

        return true;
    }
}
