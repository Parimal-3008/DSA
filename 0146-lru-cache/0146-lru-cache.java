class LRUCache {
    class Node
    {
        Node prev;Node next;int key; int val;
        public Node(Node prev,Node next, int key, int val)
        {
            this.prev = prev;this.next=next;
            this.key = key;
            this.val= val;
        }
    }
    Node head = null;
    Node tail = null;
    int cap;
    Map<Integer,Node> mp=null;
    public LRUCache(int capacity) {
        cap = capacity;
        mp = new HashMap<>();
    }
    
    public int get(int k) {
        if(!mp.containsKey(k))
            return -1;
        Node e = mp.get(k);
        if(head.key==k)
            return head.val;
        System.out.println(k);
        if(tail.key == k)
        {
            Node pre= tail.prev;
            if(pre!=null)
                pre.next = null;
            tail = pre;
            e.next = head;
            head.prev = e;
            head = e;
            return head.val;
            
        }
        Node pre= e.prev;Node nex= e.next;
        pre.next = nex;
        nex.prev  =pre;
        e.prev = null;e.next = head;
        head.prev = e;
        head = e;
        return head.val;
    }
    
    public void put(int k, int v) {
         // System.out.println(tail!=null?tail.key:(" "+k+" "+v));
       
        if(mp.containsKey(k))
        {
            Node e = mp.get(k);
        if(head.key==k)
        {
            head.val = v;
            return;
        }
        if(tail.key == k)
        {
            e.val = v;
            Node pre= tail.prev;
            if(pre!=null)
                pre.next = null;
            tail = pre;
            e.next = head;
            head.prev = e;
            head = e;
            return;
            
        }
             e.val = v;
        Node pre= e.prev;Node nex= e.next;
        pre.next = nex;
        nex.prev  =pre;
        e.prev = null;e.next = head;
        head.prev = e;
        head = e;
            return;
        }
        if(cap>0)
        {
            cap--;
            Node e = new Node(null,head,k,v);
            if(head!=null)
            {
                head.prev = e;                
            }
            else
            {
                tail = e;
            }
            
            head = e;
            mp.put(k,e);
            return;
        }
        if(tail!=null)
       {
            mp.remove(tail.key);
            tail = tail.prev;
       }
        Node e = new Node(null,head,k,v);
       head.prev = e;
       head = e;
        if(tail==null)
            tail=e;
            mp.put(k,e);
        
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */