/////////////// use stack //////////////
class Solution {
    public boolean isPalindrome(ListNode head) {
        if( head==null || head.next==null ) return true; // lengths 0 and 1
        if( head.next.next==null ) return head.val == head.next.val; // length 2

        //2.
        // Use stack 
        ArrayDeque<Integer> st = new ArrayDeque<>();
        ListNode curr = head;
        while( curr != null ){
            st.push(curr.val);
            curr = curr.next;
        }
        
        curr = head;
        while( !st.isEmpty() ){
            if( curr.val != st.pop() ){
                return false;
            }
            curr = curr.next;
        }
        return true;
    }
}

////////////// recusrssion //////////////////////

public class Solution {
    public ListNode root;
    public boolean isPalindrome(ListNode head) {
        root = head;
        return (head == null) ? true : _isPalindrome(head);
    }
    
    public boolean _isPalindrome(ListNode head) {
        boolean flag = true;
        if (head.next != null) {
            flag = _isPalindrome(head.next);
        }
        if (flag && root.val == head.val) {
            root = root.next;
            return true;
        }
        return false;
    }
}

////////////// reverse half the list ///////////////////////////

class Solution {
    public boolean isPalindrome(ListNode head) {        
        // Find mid
        // Reverse second half 
        // check first hald and second half 
        // restore second half 
        if(head == null) {
            return true;
        }

        ListNode p2 = head; // fast 

        ListNode p1 = head;  // curr
        ListNode p3 = p1.next; // next
        ListNode pre = p1; // prev 
        //find mid pointer, and reverse head half part
        while(p2.next != null && p2.next.next != null) {
            p2 = p2.next.next;
            pre = p1;
            p1 = p3;
            p3 = p3.next;
            p1.next = pre;
        }

        //odd number of elements, need left move p1 one step
        if(p2.next == null) {
            p1 = p1.next;
        }
        else {   //even number of elements, do nothing
            
        }
        //compare from mid to head/tail
        while(p3 != null) {
            if(p1.val != p3.val) {
                return false;
            }
            p1 = p1.next;
            p3 = p3.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode curr){
        ListNode prev = null, next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev; 
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
