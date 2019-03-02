/*
1->2->3->4
Dummy->1->2->3->4
2->1->D->3->4

2->1->d->4->3
2->1->4->3->d

Ans: 2->1->4->3

prev null  curr  1 next 2

1 -> 2 

1 3 4 


*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import java.util.*;

class Main {
  
  public ListNode swapPairs(ListNode head) {
    if(head == null || head.next == null)
      return head;
    ListNode n = head.next;
    head.next = swapPairs(head.next.next);
    n.next = head;
    return n;
  }
  
  
  public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode current = dummy;
    while(current.next != null && current.next.next != null) {
      ListNode first = current.next;// 1
      ListNode second = current.next.next; //2
      first.next = second.next; // 1->3
      current.next = second; // d->2
      current.next.next = first; // d->2->1->3
      current = current.next.next; // d = 1
    }
    return dummy.next;
  }
  
  
  static public void main( String args[] ) {
  }
}
