class Solution {

    class comp implements Comparator<Node>{
     
      public int compare(Node a, Node b){
      int res = a.str.compareTo(b.str);
        if(res==0)
          res = Integer.compare(a.ind,b.ind);
        return res;
      }
      
    }
  class Node
  {
    String str;int ind;
    public Node(int ind,String str)
    {
      this.ind=ind;
      this.str=str;
    }
  }
    public int[] smallestTrimmedNumbers(String[] str, int[][] q) {
      
      int ans[] = new int[q.length];
        for(int j1=0;j1<q.length;j1++)
        {
          int i[]= q[j1];
          PriorityQueue<Node> pq = new PriorityQueue<>(new comp());
            for(int j2=0;j2<str.length;j2++)
            {
              String j= str[j2];
              String p = j.substring(j.length()-i[1]);
             // if(pq)
              Node ob= new Node(j2,p);
              pq.add(ob);
            }
         
          while(!pq.isEmpty() &&  i[0]-->0)
          { ans[j1] = pq.poll().ind;}
          
        }
      return ans;
    }
}