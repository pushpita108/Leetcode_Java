/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * 
 */

 /**
  * Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the second node.
  */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        ListNode fast = head , slow = head;
        
        while( true ){
            if( fast == null || fast.next == null || fast.next.next==null) return false;
            fast = fast.next;
            if( fast == slow ) return true;
            fast = fast.next;
            slow = slow.next;
        }        
    }
}