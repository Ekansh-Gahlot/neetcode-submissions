class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        int[] freq = new int[26];

        for(char c: tasks)
        {
            freq[c-'A']++;
        }


        for(int i: freq){
            if(i>0)
            maxHeap.add(i);
        }

        Queue<int[]> waitQ = new LinkedList<>();
        int time = 0;

        while(!maxHeap.isEmpty() || !waitQ.isEmpty()){
            if(!maxHeap.isEmpty())
            {
                int element = maxHeap.poll();
                element--;
                if(element!=0)
                waitQ.add(new int[]{time+n+1, element});
            }
            time++;
            if(!waitQ.isEmpty())
            {
                int[] ele = waitQ.peek();
                if(time == ele[0]){
                    maxHeap.add(waitQ.poll()[1]);
                }
            }
        }
        return time;
    }
}
