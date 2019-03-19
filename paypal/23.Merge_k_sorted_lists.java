/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if( lists.length == 0) return null;
        
        ListNode result = lists[0];
        for(int i=1; i<lists.length; i++ ){
            result = merge( result, lists[i] );
        }
        return result;
    }
    
    public ListNode merge(ListNode l1 , ListNode l2 ){
        
        ListNode head = new ListNode(0);
        ListNode curr = head;
        
        while( l1 != null && l2 != null){
            if( l1.val <= l2.val ){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        if( l1 != null ){
            curr.next = l1;
        }else{
            curr.next = l2;
        }
        
        return head.next;
        
    }
}