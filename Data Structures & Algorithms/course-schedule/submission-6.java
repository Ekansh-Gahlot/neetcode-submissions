class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    HashSet<Integer> visitedSet = new HashSet<>();
    HashSet<Integer> safeSet = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        for(int p[]: prerequisites){
            if(!map.containsKey(p[1]))
            map.put(p[1], new ArrayList<>());
            map.get(p[1]).add(p[0]);
        }

        for(int i = 0; i < numCourses; i++){
           if (!dfs(i))
           return false;
        }
        return true;

    }

    public boolean dfs(int i){
        if(safeSet.contains(i))
        return true;
        if(visitedSet.contains(i))
        return false;


        visitedSet.add(i);

        for(int pre: map.get(i)){
            if(!dfs(pre))
            return false;
        }

        visitedSet.remove(i);
        safeSet.add(i);
        return true;
        
        
    }
}
