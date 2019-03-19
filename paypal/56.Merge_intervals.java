/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        
        // sort ascending by start time
        Collections.sort(intervals, (a,b)->a.start-b.start );
        
        //put in stack(and merge) by end time
        Stack<Interval> stack = new Stack<>();
        for( Interval i : intervals ){
            if( stack.size() == 0 || i.start > stack.peek().end  ) {
                stack.push(i);
            }else{ // merge the intervals
                    Interval old = stack.pop();
                    Interval newI = new Interval( old.start, Math.max(old.end, i.end) );
                    stack.push(newI);
            }
        }
        return stack.subList(0, stack.size());
    }
}