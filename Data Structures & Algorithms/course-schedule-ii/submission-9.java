class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        List<Integer> ans = new ArrayList<>();

        for (int[] p : prerequisites) {
            int prerequisite = p[1]; // 0
            int course = p[0]; // 1
            map.get(prerequisite).add(course);
            inDegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                q.add(i);
        }
        int completed = 0;

        while (!q.isEmpty()) {
            int course = q.poll();
            completed++;

            ans.add(course);
            for (int c : map.get(course)) {
                inDegree[c]--;
                if (inDegree[c] == 0)
                    q.add(c);
            }
        }

        if (completed != numCourses) {
            return new int[0];
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
