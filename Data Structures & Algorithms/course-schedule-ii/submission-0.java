class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    HashSet<Integer> visiting = new HashSet<>();
    HashSet<Integer> visited = new HashSet<>();
    List<Integer> ans = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // build graph
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            map.get(p[0]).add(p[1]);
        }

        // DFS
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return new int[0]; // cycle -> no valid order
        }

        // reverse because we added post-order
        // Collections.reverse(ans);

        // convert to array
        int[] arr = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            arr[i] = ans.get(i);
        }
        return arr;
    }

    private boolean dfs(int course) {
        if (visiting.contains(course)) return false; // cycle
        if (visited.contains(course)) return true;   // already done

        visiting.add(course);

        for (int pre : map.get(course)) {
            if (!dfs(pre)) return false;
        }

        visiting.remove(course);
        visited.add(course);
        ans.add(course);
        return true;
    }
}
