class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];


        for(char c: tasks){
            arr[c-'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->(b-a));
        Queue<int[]> coolDownQueue = new LinkedList<>();
        for(int i: arr){
            if(i > 0)
            maxHeap.add(i);
        }

        int time = 0;
        while(!maxHeap.isEmpty() || !coolDownQueue.isEmpty())
        {

            if(!maxHeap.isEmpty())
            {
                int element = maxHeap.poll();
                element--;
                if(element > 0)
                {
                    coolDownQueue.add(new int[]{n+time+1, element});  
                }
            }
            time++;
            if(!coolDownQueue.isEmpty())
            {
                if(coolDownQueue.peek()[0] == time)
                {
                    maxHeap.add(coolDownQueue.poll()[1]);
                }
            }
        }
        return time;
    }
}
