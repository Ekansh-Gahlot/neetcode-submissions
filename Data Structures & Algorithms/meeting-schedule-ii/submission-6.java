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
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        intervals.sort((a,b)->a.start-b.start);

        for(Interval i: intervals)
        {
            int startTime = i.start;
            int endTime = i.end;
            if(!minHeap.isEmpty() && minHeap.peek() <= startTime)
            {
                minHeap.poll();
            }
            minHeap.offer(endTime);
        }
        return minHeap.size();
    }
}
