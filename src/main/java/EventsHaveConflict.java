import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventsHaveConflict {
    /**
     *
     * From LeetCode
     * Link: <a href="https://leetcode.com/problems/determine-if-two-events-have-conflict/">Click Here</a>
     *
     *
     * You are given two arrays of strings that represent two inclusive events that happened on the same day,
     * event1 and event2, where:
     *
     * event1 = [startTime1, endTime1] and
     * event2 = [startTime2, endTime2].
     * Event times are valid 24 hours format in the form of HH:MM.
     *
     * A conflict happens when two events have some non-empty intersection (i.e., some moment is common to both events).
     *
     * Return true if there is a conflict between two events. Otherwise, return false.
     *
     *
     * Example 1:
     *
     * Input: event1 = ["01:15","02:00"], event2 = ["02:00","03:00"]
     * Output: true
     * Explanation: The two events intersect at time 2:00.
     *
     * Example 2:
     *
     * Input: event1 = ["01:00","02:00"], event2 = ["01:20","03:00"]
     * Output: true
     * Explanation: The two events intersect starting from 01:20 to 02:00.
     *
     * Example 3:
     *
     * Input: event1 = ["10:00","11:00"], event2 = ["14:00","15:00"]
     * Output: false
     * Explanation: The two events do not intersect.
     * */


        public static boolean haveConflict(String[] event1, String[] event2) throws ParseException {
        /*
        How I solved this

        1. extract and parse the strings representing the events to time formats
        2. compare if the time intersect and return the applicable boolean value
        */
            DateFormat formatter = new SimpleDateFormat("HH:mm");
            Date event1Start = formatter.parse(event1[1]);
            Date event1End = formatter.parse(event1[1]);
            Date event2Start = formatter.parse(event2[0]);
            Date event2End = formatter.parse(event2[1]);


            if (event2Start.equals(event1End) || event2End.equals(event1Start)) {
                return true;
            }
            return event2Start.before(event1End) && (!event2End.before(event1Start));

        }
    public static void main(String[] args) throws ParseException {
        String [] event5 = {"01:15", "22:08"};
        String [] event6 = {"01:15", "22:08"};

        String [] event7 = {"14:13", "22:08"};
        String [] event8 = {"02:40", "08:08"};


        String [] event1 = {"02:40","08:08"};
        String [] event2 = {"02:01","03:00"};

        String [] event3 = {"01:00","02:00"};
        String [] event4 = {"01:20","03:00"};
        System.out.println(haveConflict(event3, event4));

    }
}
