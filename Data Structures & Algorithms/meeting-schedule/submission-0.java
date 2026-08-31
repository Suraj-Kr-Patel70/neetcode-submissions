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
//import java.util.*;

class Solution {

    public boolean canAttendMeetings(List<Main.Interval> intervals) {

        // Sort according to start time
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        // Check for conflicts
        for (int i = 1; i < intervals.size(); i++) {

            if (intervals.get(i).start < intervals.get(i - 1).end) {
                return false;
            }
        }

        return true;
    }
}