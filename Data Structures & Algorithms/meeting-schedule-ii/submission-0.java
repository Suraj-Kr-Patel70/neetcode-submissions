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

    public int minMeetingRooms(List<Main.Interval> intervals) {

        if (intervals == null || intervals.size() == 0) {
            return 0;
        }

        // Start times and end times separately store karo
        int n = intervals.size();

        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        // Dono arrays ko sort karo
        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 0;
        int endIndex = 0;

        // Har meeting ka start check karo
        for (int i = 0; i < n; i++) {

            // Agar new meeting previous meeting ke end hone se
            // pehle start ho rahi hai -> new room chahiye
            if (start[i] < end[endIndex]) {
                rooms++;
            } 
            else {
                // Room free ho gaya
                endIndex++;
            }
        }

        return rooms;
    }
}