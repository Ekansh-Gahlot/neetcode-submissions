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
        // int startTime =
        for(Interval interval: intervals)
        {
            int currStart = interval.start;
            int currEnd = interval.end;

            if(!minHeap.isEmpty() && minHeap.peek() <= currStart)
            {
                minHeap.poll();
            }
            minHeap.offer(currEnd);
        }
        return minHeap.size();
    }
}
