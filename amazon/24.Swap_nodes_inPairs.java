/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        
        return swapK( head, 2);
    }
    
    public ListNode swapK(ListNode head, int k){
        if( head == null ) return head;
        
        ListNode curr = head;
        int i = 0;
        while( curr != null && i != k){
            curr = curr.next;
            i++;
        }
        
        if( i == k ){
            curr = swapK( curr, k);
            
            //fix the pointers
            while( i > 0){
                ListNode tmp = head.next;
                head.next = curr;
                curr = head;
                head = tmp;
                i--;
            }
            head = curr;
        }
        return head;
    }
}