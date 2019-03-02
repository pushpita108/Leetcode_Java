/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        // for 2 pass.. pass 1 find lengt, pass 2 go till n and change links 
        
        // for 1 pass.. get 2 pointers, one at start and 1 at nth position 
        // when second pointer reaches end, change links of first -- USE DUMMY before HEAD 
        
        //Ex : { 1,2,3,4,5 } and 2 --> so we remove 4  
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy; // to maintain the prev to position n
        for( int i=0; i<n ; i++){
            fast = fast.next; // fast = 2
        }
        
        if( fast.next == null ) return head.next; // corner case!!!! 
        
        ListNode slow = dummy; // before 1, so diff between them is n = 2
        while( fast.next != null ){
            fast = fast.next; //5
            slow = slow.next; //3
        }
        
        slow.next = slow.next.next; // skip one element
        
        return head;
        
        
    }
}