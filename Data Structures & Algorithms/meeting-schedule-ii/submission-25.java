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

        int[] arr = new int[intervals.size()];
        int[] dep = new int[intervals.size()];
        int k = 0;
        for(Interval i: intervals){
            int start = i.start;
            int end = i.end;
            arr[k] = start;
            dep[k] = end;
            k++;
        }
        Arrays.sort(arr);
        Arrays.sort(dep);

        int arrPointer = 0;
        int depPointer = 0;
        int maxRoom = 0;
        int room = 0;

        for(int i = 0 ; i < arr.length; i++){
            if(arr[arrPointer] < dep[depPointer]){
                room++;
                arrPointer++;
                maxRoom = Math.max(maxRoom,room);
            }
            else{
                room--;
                depPointer++;
            }
        }
        return maxRoom;

    }
}
