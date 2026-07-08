class Solution {
    HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();
    HashSet<Integer> safeSet = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        

        for(int i = 0 ; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }

        for(int p[]: prerequisites)
        {
            map.get(p[1]).add(p[0]);
        }

        for(int i = 0 ; i < numCourses; i++){
            if(!dfs(i))
            return false;
        }
        return true;
    }
    public boolean dfs(int i){
        if(visited.contains(i))
        return false;

        if(safeSet.contains(i))
        return true;

        visited.add(i);
        
        for(int p: map.get(i)){
            if(!dfs(p))
            return false;
        }

        safeSet.add(i);
        visited.remove(i);
        return true;
    }
}
