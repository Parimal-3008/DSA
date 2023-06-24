class StockSpanner {
      class Edge
      {
          int price; int curr;
          public Edge(int price, int curr)
          {
              this.price = price;
              this.curr = curr;
          }
      }
    Stack<Edge> st = new Stack<>();
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int ans = 1;
        while(!st.isEmpty() && st.peek().price<=price)
        {
            ans+=st.pop().curr;
        }
        st.push(new Edge(price,ans));
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */