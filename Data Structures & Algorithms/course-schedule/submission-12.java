class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    HashSet<Integer> safeSet = new HashSet<>();
    HashSet<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0 ; i < numCourses; i++){
            map.put(i,new ArrayList<>());
        }

        for(int[] preq: prerequisites){
            map.get(preq[0]).add(preq[1]);
        }

        for(int i = 0 ; i < numCourses; i++){
            if(!dfs(i))
            return false;
        }
        return true;
    }

    public boolean dfs(int i){
        if(safeSet.contains(i))
        return true;

        if(visited.contains(i))
        return false;

        visited.add(i);

        for(int j: map.get(i))
        {
            if(!dfs(j))
            return false;
        }
        visited.remove(i);
        safeSet.add(i);
        return true;
    }
}
