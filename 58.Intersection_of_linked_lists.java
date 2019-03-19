/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    public int getLength(ListNode node){
        int len = 0;
        while( node != null ){
            len++;
            node = node.next;
        }
        return len;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int lenA = getLength(headA);
        int lenB = getLength(headB); // get the lengths
        
        // move the larger one ahead so they reach equal length
        if( lenA > lenB){
            // move A to same length as B
            while( lenA != lenB){
                headA = headA.next;
                lenA--;
            }
        }else if( lenB > lenA){
            // move B to same length as A
            while( lenA != lenB){
                headB = headB.next;
                lenB--;
            }
        }else{
            //do nothing, its perfect
        }
        
        // find the intersection, if no intersection- both lists will reach null and null==null
        while( headA != headB ){
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
 //////////////////// Approach 2 below - not right //////////////////////////       
        
        
//         // add list2 to the end of list 1 
//         // If they intersect, then there will be a cycle 
        
//         // to check if they intersect or not
//         // if the end of both lists is not same, they dont intersect 
//         // capture the ends to reset the lists later 
        
//         ListNode endA, endB;
//         ListNode pointerA = headA, pointerB = headB;
        
//         while( pointerA.next != null ){
//             pointerA = pointerA.next;
//         }
//         endA = pointerA;
        
//         while( pointerB.next != null ){
//             pointerB = pointerB.next;
//         }
//         endB = pointerB;
        
//         if( endA != endB ) return null; // don't intersect

//         // attch the lists
//         pointerA.next = headB;
        
//         ListNode slow = headA, fast = headA.next;
//         while( slow!=null && fast!=null && fast.next!=null && slow != fast ){
//             System.out.println( slow.val) ;
//             slow = slow.next;
//             fast = fast.next.next;
//         }
        
//         endA.next = null; // reset the lists to original structure 
        
//         return slow == fast ?  slow :  null;
        
    }
}