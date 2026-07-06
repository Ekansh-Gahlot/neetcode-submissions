class Solution {        
    HashSet<Integer> visited = new HashSet<>();
    HashSet<Integer> safeSet = new HashSet<>();
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0 ; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            map.get(pre[0]).add(pre[1]);
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

        for(int pre: map.get(i)){
            if(!dfs(pre))
            return false;
        }

        visited.remove(i);
        safeSet.add(i);
        return true;

    }
}
