/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node n) {
       
        Node arr1[]= new Node[101];
        int arr2[]= new int[102];
         if(n==null)
            return arr1[0];
        
        Queue<Node> q = new LinkedList<>();
        q.add(n);
        arr1[n.val]=new Node(n.val, new ArrayList<Node>());
        arr2[n.val]=1;
        while(!q.isEmpty())
        {
            Node e = q.poll();
            
            for(Node i:e.neighbors)
            {
                //System.out.println(i.val +" "+i.neighbors);
                if(arr2[i.val]==0)
                {
                   arr1[i.val]=new Node(i.val, new ArrayList<Node>());
                    q.add(i);
                    arr2[i.val]=1;
                }
                
                arr1[e.val].neighbors.add(arr1[i.val]);
            }
           
            
        }    
            
        return arr1[1];
    }
}