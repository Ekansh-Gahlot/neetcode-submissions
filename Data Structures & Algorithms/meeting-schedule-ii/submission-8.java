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
        for(Interval i: intervals){
            int currStart = i.start;
            int currEnd = i.end;

            if(!minHeap.isEmpty() && currStart >= minHeap.peek()){
               minHeap.poll();
            }
            minHeap.offer(currEnd);
        }
        return minHeap.size();
    }
}
