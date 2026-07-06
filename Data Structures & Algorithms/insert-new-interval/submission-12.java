class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        List<int[]> ans = new ArrayList<>();
        for(int[] interval: intervals){
            list.add(interval);
        }
        list.add(newInterval);
        list.sort((a,b)->Integer.compare(a[0],b[0]));
        int start = list.get(0)[0];
        int end = list.get(0)[1];

        for(int i = 1; i < list.size(); i++){
            int currStart = list.get(i)[0];
            int currEnd = list.get(i)[1];
            if(currStart <= end){
                end = Math.max(end, currEnd);
                continue;
            }
            
                ans.add(new int[]{start,end});
                start = currStart;
                end = currEnd;       
                  
        }
        ans.add(new int[]{start, end});
        return ans.toArray(new int[ans.size()][]);
    }
}
