import java.util.Stack;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.lang.Math;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
};

class Solution {


    public class IntervalComparator implements Comparator<Interval>{
        public int compare(Interval a, Interval b){
            return a.start - b.start;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {

        //sort intervals by start time
        Collections.sort(intervals, new IntervalComparator());

        Stack<Interval> result = new Stack<Interval>();
        for( Interval i : intervals){
            if( result.size()==0 || result.peek().end < i.start){
                result.push(i);
            }
            //else there is overlap 
            Interval newInterval = new Interval();
            newInterval.start = result.peek().start;
            newInterval.end = Math.max(i.end, result.peek().end);
            result.pop();
            result.push(newInterval);
        }

        return result.subList(0, result.size());
    }

    public static void main(String args[]){
        Solution s = new Solution();
        List<Interval> intervals = new LinkedList<Interval>();
        intervals.add(new Interval(1,4));
        intervals.add(new Interval(2,3));
        intervals.add(new Interval(5,7));
        intervals.add(new Interval(8,19));

        intervals = s.merge(intervals);
        for( Interval i : intervals ){
            System.out.print(i.start+","+i.end+"   ");
        }
        System.out.println();
    }
}