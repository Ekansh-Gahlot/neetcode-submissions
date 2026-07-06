class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    HashSet<Integer> visitedSet = new HashSet<>();
    HashSet<Integer> safeSet = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int p[]: prerequisites){
            if(!map.containsKey(p[0]))
            map.put(p[0], new ArrayList<>());
            map.get(p[0]).add(p[1]);
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

        for(int pre: map.getOrDefault(i, new ArrayList<>())){
            if(!dfs(pre))
            return false;
        }

        visitedSet.remove(i);
        safeSet.add(i);
        return true;
        
        
    }
}
