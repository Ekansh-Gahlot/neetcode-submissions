class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    HashSet<Integer> visitedSet = new HashSet<>();
    HashSet<Integer> safeSet = new HashSet<>();
    List<Integer> ans = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] arr = new int[numCourses];
        for(int i = 0; i < numCourses ; i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] p: prerequisites){
            map.get(p[0]).add(p[1]);
        }

        for(int i = 0 ; i < numCourses; i++){
            if(!dfs(i))
            return new int[0];
        }
        int k = 0;
        for(int i: ans){
            arr[k] = i;
            k++;
        }
        return arr;
    }

    public boolean dfs(int i){
        if(visitedSet.contains(i))
        return false;
        if(safeSet.contains(i))
        return true;

        visitedSet.add(i);
        for(int pre: map.get(i)){
            if(!dfs(pre))
            return false;
        }
        visitedSet.remove(i);
        safeSet.add(i);
        ans.add(i);
        return true;
    }
}
