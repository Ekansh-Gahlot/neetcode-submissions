class Solution {        
    HashSet<Integer> visited = new HashSet<>();
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0 ; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            // if(!map.containsKey(pre[1]))
            // map.put(pre[1],new ArrayList<>());
            map.get(pre[1]).add(pre[0]);
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
        
        visited.add(i);

        for(int pre: map.get(i)){
            if(!dfs(pre))
            return false;
        }

        visited.remove(i);
        return true;

    }
}
