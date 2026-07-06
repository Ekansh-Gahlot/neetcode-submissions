class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();
    HashSet<Integer> safeSet = new HashSet<>();
    List<Integer> ans = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        for(int i = 0 ; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] p: prerequisites){
            map.get(p[0]).add(p[1]);
        }

        for(int i = 0; i < numCourses; i++){
            if(!dfs(i))
            return new int[0];
        }
        int k = 0;
        for(int i: ans){
            res[k] = i;
            k++;
        }
        return res;
    }

    public boolean dfs(int i){
         if (safeSet.contains(i)) return true;       // already processed

        if(visited.contains(i))
        return false;

        visited.add(i);

        for(int p: map.get(i))
        {
            if(!dfs(p))
            return false;
        }

         visited.remove(i);
         safeSet.add(i);
         ans.add(i);
         return true;
    }
}
