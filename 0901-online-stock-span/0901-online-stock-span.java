class StockSpanner {
   class Edge
   {
       int val;int freq;
       public Edge(int val,int freq)
       {
           this.val=val;
           this.freq= freq;
       }
   }
    Stack<Edge> st = null;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
          Edge e = new Edge(price,1);
        while(!st.isEmpty())
        {
            if(st.peek().val>price)
                break;
            else
            {
                e.freq+=st.peek().freq;
                st.pop();
            }
        }
        st.push(e);
        return e.freq;
      
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */