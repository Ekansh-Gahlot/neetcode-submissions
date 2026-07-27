class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        HashMap<Integer,List<Integer>> map = new HashMap<>();

        for(int i = 0 ; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] p: prerequisites){
            int pre = p[1];
            int course = p[0];
            map.get(pre).add(course);
            inDegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0)
            q.add(i);
        }   

        int completed = 0;

        while(!q.isEmpty()){
            int course = q.poll();
            completed++;
            for(int pre: map.get(course)){
                inDegree[pre]--;
                if(inDegree[pre] == 0)
                q.add(pre);
            }
        }

        return completed == numCourses;
    }
}
