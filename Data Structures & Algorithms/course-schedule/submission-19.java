class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    HashSet<Integer> safeSet = new HashSet<>();
    HashSet<Integer> visiting = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0 ; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] c: prerequisites)
        {
            int course = c[0];
            int preq = c[1];
            map.get(preq).add(course);
        }

        for(int i = 0 ; i < numCourses; i++){
            if(!dfs(i))
            return false;
        }
        return true;
    }

    public boolean dfs(int i){
        if(visiting.contains(i))
        return false;

        if(safeSet.contains(i))
        return true;

        visiting.add(i);

        for(int c: map.get(i)){
            if(!dfs(c))
            return false;
        }

        visiting.remove(i);
        safeSet.add(i);
        return true;
    }
}
