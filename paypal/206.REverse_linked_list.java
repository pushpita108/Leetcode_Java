/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        
        while( curr != null ){
            next = curr.next; // Think simple 
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev; // TA-DA 
        
    }

    ListNode head;
    public ListNode reverseRecursive(ListNode curr, ListNode prev){

        if( cuur.next == null ) { //reached last 
            head = curr; // set the head to last element now 
            curr.next = prev; // make the last link and return 
            return head;
        }
        ListNode next = curr.next;
        curr.next = prev;

        reverseRecursive( next, curr );
        return head;
    }
}