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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode i = headA;
        ListNode j = headB;
        
        int lenA = 0;
        int lenB = 0;
        
        while( i != null ){
            lenA++;
            i = i.next;
        }
        
        while( j != null ){
            lenB++;
            j = j.next;
        }
        
        if( i != j ) return null; // Last elements is not the same, so no intersection
        
        i = headA;
        j = headB;
        while( lenA > lenB ){
            if( i == j ) return i;
            i = i.next;
            lenA--;
        }
        
        while( lenB > lenA ){
            if( i == j ) return i;
            j = j.next;
            lenB--;
        }
        
        //compare
        
        while( i!=null && j!=null && i!=j ){
            i = i.next;
            j = j.next;
        }
        
        if( i==null || j==null ) return null;
        return i;
        
    }
}