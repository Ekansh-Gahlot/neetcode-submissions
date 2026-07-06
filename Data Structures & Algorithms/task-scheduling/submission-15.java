class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        for(char c: tasks)
        {
            freq[c-'A']++;
        }

        for(int i: freq)
        {
            if(i > 0)
            maxHeap.add(i);
        }

        Queue<int[]> q  = new LinkedList<>();
        int time = 0;
        while(!maxHeap.isEmpty() || !q.isEmpty()){

            if(!maxHeap.isEmpty()){
                int element = maxHeap.poll();
                element--;
                if(element!=0)
                {
                    q.add(new int[]{time+n+1, element});
                }
            }
            time++;
            if(!q.isEmpty())
            {
                if(time == q.peek()[0])
                {
                    maxHeap.add(q.poll()[1]);
                }
            }
        }
        return time;
    }
}
