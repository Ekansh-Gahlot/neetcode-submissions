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

        for(Interval i: intervals)
        {
            int startTime = i.start;
            int endTime = i.end;

            if(!minHeap.isEmpty() && minHeap.peek() <= startTime)
            {
                minHeap.poll();
            }
            minHeap.add(endTime);
    
        }
        return minHeap.size();

    }
}
