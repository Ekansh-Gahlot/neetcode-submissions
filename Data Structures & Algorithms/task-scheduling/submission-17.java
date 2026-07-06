class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[256];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        for(char c: tasks){
            arr[c-'A']++;
        }

        for(int i: arr){
            if(i!=0){
               maxHeap.add(i);
            }
        }
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        while(!maxHeap.isEmpty() || !q.isEmpty()){

            if(!maxHeap.isEmpty()){
            int elementToProcess = maxHeap.poll();
            elementToProcess--;
            if(elementToProcess > 0)
            {
                q.add(new int[]{elementToProcess, time+n+1});
            }}
            time++;
            if(!q.isEmpty()){
                if(time >= q.peek()[1])
                maxHeap.add(q.poll()[0]);
            }
        }
        return time;
    }
}
