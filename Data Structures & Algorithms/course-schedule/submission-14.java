class Solution {
    HashMap<Integer,List<Integer>> map = new HashMap<>();
    HashSet<Integer> vis = new HashSet<>();
    HashSet<Integer> safeSet = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for(int i = 0 ; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }

        for(int p[]: prerequisites){
            map.get(p[0]).add(p[1]);
        }

        for(int i = 0; i < numCourses; i++){
            if(!dfs(i))
            return false;
        }
        return true;
    }

    public boolean dfs(int i){
        if(safeSet.contains(i))
        return true;
        if(vis.contains(i))
        return false;

        vis.add(i);

        for(int p: map.get(i)){
            if(!dfs(p))
            return false;
        }
        vis.remove(i);
        safeSet.add(i);
        return true;
    }
}
