class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        int[] arr = new int[26];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        Queue<int[]> coolDown = new LinkedList<>();

        for(char c: tasks)
        {
            arr[c-'A']++;
        }

        for(int i: arr)
        {
            if(i > 0)
            maxHeap.add(i);
        }

        while(!maxHeap.isEmpty() || !coolDown.isEmpty())
        {   
            if(!maxHeap.isEmpty())
            {
                int elementToProcess = maxHeap.poll();
                elementToProcess--;
                if(elementToProcess > 0)
                {
                    coolDown.add(new int[]{n+time+1, elementToProcess});
                }
            }
            time++;
            if(!coolDown.isEmpty() && coolDown.peek()[0] == time){
                maxHeap.add(coolDown.poll()[1]);
            }
          
        }
        return time;
    }
}
