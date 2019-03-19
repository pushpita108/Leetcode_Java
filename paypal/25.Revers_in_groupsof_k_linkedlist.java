class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode curr = head;
        int count = 0;
        while( curr!=null && count != k){ // move ahead k steps 
            curr = curr.next;
            count++;
        }

        if( count == k ){
            curr = reverseKGroup( curr, k ); // recurse 

            // reverse the k-group now
            while( count != 0){
                //normal reverse 
                ListNode temp = head.next;
                head.next = curr;
                curr = head;
                head = temp;
                count--;
            }

            head = curr;

        }
        return head;

    }

}