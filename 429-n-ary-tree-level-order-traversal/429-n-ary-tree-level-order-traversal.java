/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new LinkedList<>();
        Queue<Node> q1 = new LinkedList<>();
         Queue<Node> q2 = new LinkedList<>();
        if(root==null)
            return list;
        q1.add(root);
        while(q1.size()>0||q2.size()>0)
        {
            List<Integer> tm= new LinkedList<>();
            while(q1.size()>0)
            {
                Node e= q1.poll();
                for(Node i: e.children)
                    q2.add(i);
                tm.add(e.val);
            }
             if(tm.size()>0)
            list.add(new LinkedList<>(tm));
            tm.clear();
            while(q2.size()>0)
            {
                Node e= q2.poll();
                for(Node i: e.children)
                    q1.add(i);
                tm.add(e.val);
            }
            if(tm.size()>0)
            list.add(new LinkedList<>(tm));
        }
        return list;
        
    }
}