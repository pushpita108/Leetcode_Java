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
     
    public int minMeetingRooms(Interval[] intervals) {
        
        //Sort intervals by start time
        Arrays.sort(intervals, (a, b)->a.start-b.start );
        
        // //WRONG to use STACK 
        // ArrayDeque<Interval> s = new ArrayDeque<>();
        // for( Interval i : intervals ) {
        //     if( s.size()==0 || s.peek().end > i.start){
        //         //push the interval as a new room required 
        //         s.push(i);
        //     }else {
        //         // merge the intervals
        //         Interval newI = new Interval();
        //         newI.start = s.peek().start;
        //         newI.end = Math.max( s.pop().end, i.end);
        //         s.push(newI);
        //     }
        // }
        
        // USE PQ to push intervals by end time 
        PriorityQueue<Interval> pq = new PriorityQueue<>( (a,b)->a.end-b.end );
        for( Interval i : intervals){
            if( pq.size()==0 || pq.peek().end > i.start){
                pq.add(i);
            } else {
                // merge the intervals
                Interval newI = new Interval();
                newI.start = pq.peek().start;
                newI.end = Math.max( pq.remove().end, i.end);
                pq.add(newI);
            }
        }
        
        
        return pq.size();
    }
}