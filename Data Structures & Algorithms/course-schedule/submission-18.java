class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int completed = 0;
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for (int[] c : prerequisites) {
            int course = c[0];
            int preq = c[1];
            map.get(preq).add(course);
            inDegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int preq = q.poll();
            completed++;
            for (int course : map.get(preq)) {
                inDegree[course]--;
                if (inDegree[course] == 0)
                    q.add(course);
            }
        }
        if (completed == numCourses)
            return true;
        return false;
    }
}
