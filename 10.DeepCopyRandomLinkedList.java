
  //Definition for singly-linked list with a random pointer.
import java.util.HashMap;
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}

class Solution {
    // public RandomListNode copyRandomList(RandomListNode head) {

    //     RandomListNode tempHead = head;
                
    //     RandomListNode newHead = null;
    //     HashMap<RandomListNode, RandomListNode> map= new HashMap<>();

    //     while( tempHead != null ){ // create the copies
    //         RandomListNode n = new RandomListNode(tempHead.label);
    //         if(newHead == null){
    //             newHead = n;
    //         }
    //         map.put( tempHead, n);
    //         tempHead = tempHead.next;
    //     }

    //     tempHead = head;
    //     while( tempHead!= null ){ // re fix the links
    //         RandomListNode tempHeadnew = map.get(tempHead);
    //         tempHeadnew.next = tempHead.next;
    //         tempHeadnew.random = tempHead.random;
    //     }

    //     return newHead;

    // }

    HashMap<RandomListNode, RandomListNode> map = new HashMap<>(); // keep track of copies
    public RandomListNode copyRandomList(RandomListNode head) { 
        //stop conditions 
        if( head == null ) return null;
        if( map.containsKey(head)) return map.get(head);

        RandomListNode newNode = new RandomListNode(head.label); 
        map.put(head, newNode);
        newNode.next = copyRandomList(head.next);// First all next links are set

        // Then it comes here to set all random links
        newNode.random = copyRandomList(head.random);
        return head;

    }






// class Solution {

    // public RandomListNode copyRandomList(RandomListNode head) {
    //     if( head == null ){
    //         return head;
    //     }
    //     RandomListNode tempHead = head;
    //     HashMap<Integer, RandomListNode[]> map = new HashMap<>();
        
    //     while( tempHead != null ){
    //         RandomListNode[] arr = new RandomListNode[2];
    //         arr[0] = tempHead.next;
    //         arr[1] = tempHead.random;
    //         map.put( tempHead.label, arr);
    //         System.out.println("In map : "+ tempHead.label + " : " + arr[0] + " : " + arr[1]);
    //         tempHead = tempHead.next;
    //     }
        
    //     HashMap<Integer, RandomListNode> map2 = new HashMap<>();
    //     RandomListNode headnew = new RandomListNode( head.label );
    //     map2.put(head.label, headnew);
    //     RandomListNode r = headnew;
    //     while(map.size()!= 0){
    //         System.out.println("label : " + map.get(r.label));
    //         RandomListNode nextLabel = map.get(r.label)[0];
    //         RandomListNode randomLabel = map.get(r.label)[1];
    //         if(  nextLabel!=null  ) {
    //             System.out.println("process next");
    //             if( !map2.containsKey( nextLabel.label ) ){
    //                 r.next = new RandomListNode(  nextLabel.label );
    //                 map2.put( nextLabel.label, r.next );
    //             } else {
    //                 r.next = map2.get( nextLabel.label );
    //             }
    //             System.out.println("process next : "+r.next);
    //         }
    //         if( randomLabel!=null  ) {
    //             System.out.println("process random");
    //             if( !map2.containsKey( randomLabel.label ) ){
    //                 r.random = new RandomListNode( randomLabel.label );
    //                 map2.put( randomLabel.label, r.random );
    //             } else {
    //                 r.random = map2.get( randomLabel.label );
    //             }
    //             System.out.println("process random : "+r.random);
    //         }
    //         r = r.next;
    //         map.remove( r.label );
    //     }
    //     return headnew; 
    // }

    public static void main(String args[]){
        Solution s = new Solution();

        RandomListNode a = new RandomListNode(2);
        RandomListNode b = new RandomListNode(3);
        RandomListNode c = new RandomListNode(7);
        RandomListNode d = new RandomListNode(8);

        a.next = b; b.next = c; c.next=d; d.next=null;
        a.random = d; b.random = null; c.random=null; d.random=b;

        RandomListNode aa = a;
        while( aa != null ){
            System.out.println(aa.label + " : " + aa);
            aa = aa.next;
        }
        System.out.println("-----------------------------");
        RandomListNode e = s.copyRandomList(a);
        while( e != null ){
            System.out.println(e.label + " : " + e);
            e = e.next;
        }



    }
}