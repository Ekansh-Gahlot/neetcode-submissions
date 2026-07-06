class Solution {
    public int leastInterval(char[] tasks, int n) {
        Queue<int[]> coolDown = new LinkedList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b - a);
        int arr[] = new int[26];
        for(char c: tasks){
            arr[c-'A']++;
        }

        for(int i: arr){
            if(i>0){
                maxHeap.add(i);
            }
        }
        int time = 0;
        while(!maxHeap.isEmpty() || !coolDown.isEmpty()){
            if(!coolDown.isEmpty() && coolDown.peek()[1] == time){
                maxHeap.add(coolDown.poll()[0]);
            }
            if(!maxHeap.isEmpty()){
                int elementToProcess = maxHeap.poll();
                elementToProcess--;
                if(elementToProcess != 0){
                    coolDown.add(new int[]{elementToProcess, time+n+1});
                }
            }
            
            time++;
        }
        return time;

    }
}
