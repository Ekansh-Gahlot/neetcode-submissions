class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        int time = 0;
        for(char c: tasks){
            arr[c-'A']++;
        }


        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b)->b-a);
        Queue<int[]> coolDown = new LinkedList<>();

        for(int i: arr){
            if(i>0)
            maxHeap.add(i);
        }

        while(!maxHeap.isEmpty() || !coolDown.isEmpty())
        {
            if(!coolDown.isEmpty() && coolDown.peek()[1] == time){
                maxHeap.add(coolDown.poll()[0]);
            }
            if(!maxHeap.isEmpty())
            {
                int taskToProcess = maxHeap.poll();
                taskToProcess--;
                if(taskToProcess > 0)
                {
                    coolDown.add(new int[]{taskToProcess, n+time+1});
                }
            }
            time++;
        }
        return time;
    }
}
