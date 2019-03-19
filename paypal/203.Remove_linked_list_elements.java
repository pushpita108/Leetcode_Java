/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        ListNode curr = head;
        ListNode result = null;
        
        while( curr!= null && curr.val == val ){
            curr = curr.next;  
        }
        result = curr; // remove all elements from start
        
        while( curr!=null && curr.next != null ){
            if( curr.next.val == val ){
                curr.next = curr.next.next; // delink all the nodes with given val
            }else{ //!imp
                curr = curr.next;
            }
        }
        
        return result;
        
    }
}