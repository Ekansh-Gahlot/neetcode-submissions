class Solution {
    public int leastInterval(char[] tasks, int n) {
        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b,a));

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < tasks.length; i++){
            map.put(tasks[i], map.getOrDefault(tasks[i],0)+1);
        }

        maxHeap.addAll(map.values());

        int globalTimer = 0;

        while(maxHeap.size() > 0 || q.size() > 0){
            while(!q.isEmpty() && q.peek()[1] <= globalTimer){
                maxHeap.add(q.poll()[0]);
            }
            if(!maxHeap.isEmpty())
            {
                int task = maxHeap.poll();
                task--;
                if(task != 0)
                {
                    int coolDownTime = globalTimer + n + 1;
                    q.add(new int[]{task, coolDownTime});
                }
            }
            globalTimer++;
        }
        return globalTimer;
    }
}
