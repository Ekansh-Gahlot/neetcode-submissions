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
        intervals.sort((a,b) -> Integer.compare(a.start, b.start));
        for(int i = 0; i < intervals.size(); i++){
            int startTime = intervals.get(i).start;
            int endTime = intervals.get(i).end;
            if(!minHeap.isEmpty() && minHeap.peek() <= startTime){
                minHeap.poll();
            }
            minHeap.offer(endTime);
        }
        return minHeap.size();
    }
}
