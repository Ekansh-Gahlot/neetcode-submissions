class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> vis = new HashSet<>();
    Set<Integer> safeSet = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0 ; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            map.get(pre[0]).add(pre[1]);
        }

        for(int i = 0; i < numCourses; i++){
            if(!dfs(i))
            return false;
        }
        return true;
    }

    public boolean dfs(int i){
        if(vis.contains(i))
        return false;

        if(safeSet.contains(i))
        return true;

        vis.add(i);

        for(int pre: map.get(i))
        {
            if(!dfs(pre))
            return false;
        }

        vis.remove(i);
        safeSet.add(i);
        return true;
    }
}
