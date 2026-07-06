/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a,b)->a.start-b.start);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //Jo time nikal gya uss interval ko htado
        for(Interval i: intervals)
        {
            int startTime = i.start;
            int endTime = i.end;
            if(!minHeap.isEmpty() && startTime >= minHeap.peek())
            minHeap.poll();
            minHeap.offer(endTime);
        }
        return minHeap.size();

    }
}
