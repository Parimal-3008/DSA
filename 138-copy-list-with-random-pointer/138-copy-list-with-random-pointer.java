/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> mp = new HashMap<>();
       // Map<Node, Integer> mp = new HashMap<>();
        Node temp = head;
        while(temp!=null)
        {
            mp.put(temp,new Node(temp.val,null,null));
            temp = temp.next;
        }
        temp=head;
        while(temp!=null)
        {
            Node r= mp.get(temp);
            if(temp.next!=null)
            {
            Node s= mp.get(temp.next);
            r.next=s;
            }
            if(temp.random!=null)
            {
                Node s = mp.get(temp.random);
                r.random=s;
            }
           
            temp= temp.next;
        }
//         int a=0;
//         while(temp!=null)
//         {
//             mp2.put(temp,a);a++;
//             if(temp.random!=null)
//                 mp.put(temp,temp.random);
//             else
//                 mp.put(temp,null);
//             temp=temp.next;
//         }
        return mp.get(head);
    }
}