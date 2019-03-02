/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode firstOcc = head;

        while( firstOcc != null ){
            ListNode node = firstOcc.next;
            while( node!=null && node.val == firstOcc.val){
                node = node.next;
            }
            firstOcc.next = node;
            firstOcc = node;
        }
        return head;
    }
}