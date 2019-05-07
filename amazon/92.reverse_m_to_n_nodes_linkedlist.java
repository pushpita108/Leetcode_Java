/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //1->2->3->4->5
        if( m==n ) return head;
        
        ListNode temp = head, prev = null;
        int i=1;
        while( temp!=null && i < m ){ // jump till 2
            prev = temp;
            temp = temp.next;
            i++;
        }
        
        
        ListNode start = prev; //1 to connect 1.next to reversed list -> line 37
        ListNode end = temp; //2 to connect with remaining list later -> line 38
        
        // simple reverse till m 
        prev = null;
        ListNode next = null;
        while( temp!=null && i>=m && i<=n ){
            //reverseLinks
            next = temp.next; 
            temp.next = prev;
            prev = temp;
            temp = next;
            i++;
        }
        
        if( m!=1 ) start.next = prev; // rejoin the reversed list
        end.next = next;
        
        return m==1 ? prev : head; // check as if reverse starts from head, rest of list will be empty
    }
}