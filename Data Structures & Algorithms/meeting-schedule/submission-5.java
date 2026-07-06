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
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a,b)->Integer.compare(a.start,b.start));
        for(int i = 0; i < intervals.size()-1; i++){
            int end = intervals.get(i).end;
            int nextStart = intervals.get(i+1).start;
            if(nextStart < end)
            return false;
        }
        return true;
    }
}
