class Solution {
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    List<List<Integer>> list;
    boolean[][] pac;
    boolean[][] atl;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        list = new ArrayList<>();
        pac = new boolean[heights.length][heights[0].length];
        atl = new boolean[heights.length][heights[0].length];

        for (int j = 0; j < heights[0].length; j++) {
            check(0, j, pac, heights);
            check(heights.length - 1, j, atl, heights);
        }

        for (int i = 0; i < heights.length; i++) {
            check(i, 0, pac, heights);
            check(i, heights[0].length - 1, atl, heights);
        }

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pac[i][j] && atl[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    list.add(temp);
                }  
            }
        }
        return list;
    }

    public void check(int i, int j, boolean[][] ocean, int[][] heights) {
        ocean[i][j] = true;

        for (int[] d : dir) {
            int r = d[0];
            int c = d[1];
            int nr = i + r;
            int nc = j + c;

            if (nr < 0 || nc < 0 || nr >= heights.length || nc >= heights[0].length
                || heights[nr][nc] < heights[i][j] || ocean[nr][nc])
                continue;

            check(nr, nc, ocean, heights);
        }
    }
}
